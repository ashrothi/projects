/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /flint/saved/open/ticket/insert API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintSavedOpenTicketInsertSwagger {
	private String description;
	/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
	/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		private List<FlintSavedOpenTicketInsert> object;

		/**
		 * @return the object
		 */
		public List<FlintSavedOpenTicketInsert> getObject() {
			return object;
		}
	/**
		 * To set object
		 * 
		 * @param object
		 */
		public void setObject(List<FlintSavedOpenTicketInsert> object) {
			this.object = object;
		}

		private boolean valid;

		/**
		 * To get if object is Valid
		 * 
		 * @return
		 */
		public boolean isValid() {
			return valid;
		}
	/**
		 * To set Object Valid
		 * 
		 * @param valid
		 */
		public void setValid(boolean valid) {
			this.valid = valid;
		}
}

class FlintSavedOpenTicketInsert {
	private String msg;
	private String is_added;    
	private String open_tickets_id;
	private String ticket_id;
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the is_added
	 */
	public String getIs_added() {
		return is_added;
	}
	/**
	 * @param is_added the is_added to set
	 */
	public void setIs_added(String is_added) {
		this.is_added = is_added;
	}
	/**
	 * @return the open_tickets_id
	 */
	public String getOpen_tickets_id() {
		return open_tickets_id;
	}
	/**
	 * @param open_tickets_id the open_tickets_id to set
	 */
	public void setOpen_tickets_id(String open_tickets_id) {
		this.open_tickets_id = open_tickets_id;
	}
	/**
	 * @return the ticket_id
	 */
	public String getTicket_id() {
		return ticket_id;
	}
	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	} 
	
}