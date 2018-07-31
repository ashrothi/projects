
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
public class HBaseOperations {
	public static void main(String args[]) {
		Configuration config = null;
		Connection connection = null;
		Admin admin = null;
		String tableName = "employee";
		try {
			// Checking HBase connection
			// Instantiating Configuration class
			config = HBaseConfiguration.create();
			config.set("hbase.zookeeper.quorum", "127.0.0.1");
			HBaseAdmin.checkHBaseAvailable(config);
			System.out.println("HBase is running!");

			connection = ConnectionFactory.createConnection(config);
			admin = connection.getAdmin();
			HBaseAdmin hbaseAdmin = null;
			
			/** Check for "employee" table existence in HBase 
			 * If the table is not present in HBase it creates table 
			 * with personal, professional column families
			 * 
			 * If the table exists it add's a new column family "details"  
			 */
			
			if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
				config = new HBaseConfiguration().create();
				hbaseAdmin = new HBaseAdmin(config);
				HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
				tableDescriptor.addFamily(new HColumnDescriptor("personal"));
				tableDescriptor.addFamily(new HColumnDescriptor("professional"));
				hbaseAdmin.createTable(tableDescriptor);
				System.out.println("table created");
			} else {
				System.out.println("table already exists in hbase");
				HColumnDescriptor columnDescriptor = new HColumnDescriptor("details");
				admin.addColumn(TableName.valueOf(tableName),columnDescriptor);
				System.out.println("New column family added");
				
				// delete "details" column family from "employee" table in HBase
				admin.deleteColumn(TableName.valueOf(tableName),Bytes.toBytes("details"));
				System.out.println("column deleted successfully");
				
				// delete table "employee" 
				admin.disableTable(TableName.valueOf(tableName));
				admin.deleteTable(TableName.valueOf(tableName));
				System.out.println("table deleted successfully");
				
				// Insert data into HBase table
				insertData(config, tableName);
				/** Read data in "employee" table in two different ways:
				 *  1. Reading by using row key
				 *  2. Reading entire table using ResultScanner
				 */
				rowKeyRead(config, tableName);
				scanTable(config, tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (admin != null) {
					admin.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	private static void insertData(Configuration config, String tableName) {
		HTable hTable;
		try {
			// Instantiating HTable class
			hTable = new HTable(config, tableName);
			// Instantiating Put class
		    // It accepts a row name
			Put p = new Put(Bytes.toBytes("row1"));
			// adding values using add() method
			p.add(Bytes.toBytes("personal"), Bytes.toBytes("Fname"),Bytes.toBytes("A"));
			p.add(Bytes.toBytes("personal"), Bytes.toBytes("Lname"),Bytes.toBytes("Bimarian"));
			p.add(Bytes.toBytes("professional"),Bytes.toBytes("designation"),Bytes.toBytes("software Engineer"));
			
			System.out.println("data inserted");
		    // Updating a cell value
			p.add(Bytes.toBytes("personal"), Bytes.toBytes("Fname"),Bytes.toBytes("B"));
			System.out.println("updated a record");
			hTable.put(p);
			// Deleting the data
			Delete delete = new Delete(Bytes.toBytes("row1"));
			delete.deleteColumn(Bytes.toBytes("professional"), Bytes.toBytes("designation"));
			System.out.println("deleted column qualifier");
			
			delete.deleteFamily(Bytes.toBytes("professional"));
			System.out.println("deleted column family");
			
			hTable.delete(delete);
			// closing HTable
			hTable.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
private static void scanTable(Configuration config, String tableName) {
		
		try {
			@SuppressWarnings("deprecation")
			HTable table = new HTable(config,tableName);
			Scan scan = new Scan();
			scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("Fname"));
			scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("Lname"));
			
			ResultScanner resultScanner = table.getScanner(scan);
			
			for(Result result : resultScanner) {
				for(org.apache.hadoop.hbase.KeyValue keyValue : result.raw()) {
					System.out.println("value "+Bytes.toString(keyValue.getValue()));
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private static void rowKeyRead(Configuration config, String tableName) {
		try {
			 HTable table = new HTable(config, tableName);
			Get g = new Get(Bytes.toBytes("row1"));
			  Result result = table.get(g);
			  byte[] value1 = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("Fname"));
			  byte[] value2 = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("Lname"));
			  System.out.println("values are:"+ Bytes.toString(value1) + " " + Bytes.toString(value2));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}