/**
 * 
 */
package demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Certificate;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * @author ankita
 *
 */
public class readCer {

	/**
	 * @param args
	 * @throws CertificateException
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 */
	public static void main(String[] args)
			throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
		 
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		// Use BufferedInputStream (which supports mark and reset) so that each 
		// generateCertificate call consumes one certificate.
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
		while (in.available() > 0) {
		    Certificate cert = (Certificate) cf.generateCertificate(in);
		    System.out.println("Cert:\n===================\n" + cert.toString() + "\n");
		}
		in.close();
		  }
	
}
