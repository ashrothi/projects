import java.util.LinkedHashMap;
import java.util.Map;



public class sendEmail {
	public static void main(String[] args) {
		try {
			// boolean flag = SendEmail.email(Username, Password, Socket
			// Port, Socket Class, AuthEmail, EmailHost, EmailPort,
			// builder, To, CC, BCC, Attachment, Subject, Message,
			// Message From Status, Message From, Message To, null);
			/**
			 * To send Email
			 */

			String[] toEmailUser = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co")
					.split(",");
			String[] ccEmailUser = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co")
					.split(",");
			String[] bccEmailUser = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co")
					.split(",");
			/**
			 * To set email template
			 */
			TemplateSwagger templateReport = new TemplateSwagger();

			boolean flag = false;
			boolean flag1 = false;
			StringBuilder builder = new StringBuilder();

			// mail.smtp.detail=smtp.office365.com
			// mail.smtp.port=587
			// mail.smtp.username=Cargoceltruck@celebiaviation.in
			// mail.smtp.password=Welcome@1
			// mail.smtp.from=Cargoceltruck@celebiaviation.in
			// mail.socket.port=25
			// mail.socket.class=javax.net.ssl.SSLSocketFactory
			// mail.smtp.auth=true
			// mail.smtp.email.title=Notification Center
			// mail.smtp.email.cc=YKHATOR@teramatrix.co,puneet.khandelwal@teramatrix.in
			// mail.smtp.email.bcc=ankita.shrothi@teramatrix.in
			// mail.smtp.email.subject.sos=Booking Confirmed Successfully
			// mail.smtp.email.subject.deleiver=Booking Delivered
			// mail.smtp.email.status=Cargocel Truck
			// mail.smtp.email.subject.alert=Booking Received
			// mail.smtp.email.subject.query=Query Received
			// mail.smtp.email.contact.admin=ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co
			String responsedata = "﻿\n"
					+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
					+ "<html>\n" + "    <head>\n"
					+ "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
					+ "        \n" + "       \n" + "        <meta property=\"og:title\" content=\"*|MC:SUBJECT|*\" />\n"
					+ "        \n" + "        <title>*|MC:SUBJECT|*</title>\n" + "		<style type=\"text/css\">\n"
					+ "		 \n" + "			#outlook a{padding:0;}  \n"
					+ "			body{width:100% !important;} .ReadMsgBody{width:100%;} .ExternalClass{width:100%;}  \n"
					+ "			body{-webkit-text-size-adjust:none;}  \n" + "\n" + "			 \n"
					+ "			body{margin:0; padding:0;}\n"
					+ "			img{border:0; height:auto; line-height:100%; outline:none; text-decoration:none;}\n"
					+ "			table td{border-collapse:collapse;}\n"
					+ "			#backgroundTable{height:100% !important; margin:0; padding:0; width:100% !important;}\n"
					+ "\n" + "		 \n" + "			body, #backgroundTable{\n"
					+ "				  background-color:#FAFAFA;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#templateContainer{\n" + "				  border: 1px solid #DDDDDD;\n" + "			}\n"
					+ "\n" + "		 \n" + "			h1, .h1{\n" + "				  color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:34px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h2, .h2{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:30px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h3, .h3{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:26px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h4, .h4{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:22px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#templatePreheader{\n"
					+ "				 background-color:#FAFAFA;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.preheaderContent div{\n" + "				 color:#505050;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:10px;\n"
					+ "				 line-height:100%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "		 \n"
					+ "			.preheaderContent div a:link, .preheaderContent div a:visited,   .preheaderContent div a .yshortcuts  {\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n" + "		 \n" + "\n"
					+ "			 \n" + "			#templateHeader{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border-bottom:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.headerContent{\n" + "				 color:#202020;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:34px;\n"
					+ "				 font-weight:bold;\n" + "				 line-height:100%;\n"
					+ "				 padding:0;\n" + "				 text-align:center;\n"
					+ "				 vertical-align:middle;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.headerContent a:link, .headerContent a:visited,   .headerContent a .yshortcuts  {\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n" + "			#headerImage{\n"
					+ "				height:auto;\n" + "				max-width:600px !important;\n" + "			}\n"
					+ "\n" + "			 \n" + "			#templateContainer, .bodyContent{\n"
					+ "				 background-color:#FFFFFF;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.bodyContent div{\n" + "				 color:#505050;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:14px;\n"
					+ "				 line-height:150%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "			 \n"
					+ "			.bodyContent div a:link, .bodyContent div a:visited, /* Yahoo! Mail Override */ .bodyContent div a .yshortcuts /* Yahoo! Mail Override */{\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n"
					+ "			.bodyContent img{\n" + "				display:inline;\n"
					+ "				height:auto;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#templateFooter{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border-top:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.footerContent div{\n" + "				 color:#707070;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:12px;\n"
					+ "				 line-height:125%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "			 \n"
					+ "			.footerContent div a:link, .footerContent div a:visited, /* Yahoo! Mail Override */ .footerContent div a .yshortcuts /* Yahoo! Mail Override */{\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n"
					+ "			.footerContent img{\n" + "				display:inline;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#social{\n" + "				 background-color:#FAFAFA;\n"
					+ "				 border:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#social div{\n" + "				 text-align:center;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#utility{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#utility div{\n" + "				 text-align:center;\n" + "			}\n" + "\n"
					+ "			#monkeyRewards img{\n" + "				max-width:190px;\n" + "			}\n"
					+ "			\n" + "			\n" + "			.data-table{}\n"
					+ "			.data-table tr th{ background:#f1f1f1; color:#000; width:150px}\n"
					+ "			.data-table tr td{ color:#000}\n" + "			\n" + "			\n" + "		</style>\n"
					+ "	</head>\n"
					+ "    <body leftmargin=\"0\" marginwidth=\"0\" topmargin=\"0\" marginheight=\"0\" offset=\"0\">\n"
					+ "    	<center>\n"
					+ "        	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"backgroundTable\">\n"
					+ "            	<tr>\n" + "                	<td align=\"center\" valign=\"top\">\n"
					+ "                        \n"
					+ "                        <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"600\" id=\"templatePreheader\">\n"
					+ "                            <tr>\n"
					+ "                                <td valign=\"top\" class=\"preheaderContent\">\n"
					+ "                                \n" + "                                	\n"
					+ "                                \n" + "                                </td>\n"
					+ "                            </tr>\n" + "                        </table>\n"
					+ "                        \n"
					+ "                    	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateContainer\" style=\"border:1px #ccc solid\">\n"
					+ "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                    \n" + "                                 \n"
					+ "                                    <table border=\"0\" id=\"templateHeader\" cellpadding=\"10\" style=\"background:#0077be;\" bgcolor=\"#0077be\"  cellspacing=\"0\" width=\"100%\">\n"
					+ "                                    	<tr>\n"
					+ "                                        	<td valign=\"top\">\n"
					+ "                                            	<div mc:edit=\"std_preheader_content\">\n"
					+ "                                                	<a href=\"http://www.teramatrix.in/\" style=\"color:#ffffff;  font-size:24px; line-height:40px; text-decoration:none; font-family:Arial, Helvetica, sans-serif\">CargoCEL Truck</a>\n"
					+ "                                                </div>\n"
					+ "                                            </td>\n"
					+ "                                          \n"
					+ "											<td valign=\"top\" width=\"190\" align=\"right\">\n"
					+ "                                            	<div mc:edit=\"std_preheader_links\">\n"
					+ "                                                	<a href=\"#\" target=\"_blank\"><img width=\"70\" src=\"http://www.celebicargo.com.tr/sites/default/files/logolar/celebi-kanatli-logo-renkli-kullanim.png\" /></a>.\n"
					+ "                                                </div>\n"
					+ "                                            </td>\n"
					+ "											 \n" + "                                        </tr>\n"
					+ "                                    </table>\n" + "                                	 \n"
					+ "                                    \n" + "                                </td>\n"
					+ "                            </tr>\n" + "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                     \n"
					+ "                                	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateBody\">\n"
					+ "                                    	<tr>\n"
					+ "                                            <td valign=\"top\" class=\"bodyContent\">\n"
					+ "                                   \n"
					+ "                                                <table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" width=\"100%\">\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td valign=\"top\">\n"
					+ "                                                            <div> \n"
					+ "                                                          \n"
					+ "                                                            <strong>Dear User</strong> <br/>\n"
					+ "                                                          \n"
					+ "                                                             <p><strong>Greetings from  CELEBI!!</strong></p>\n"
					+ "                                                               \n"
					+ "                                                               <p>Thanks for Contacting with  CELEBI. Your complain is register we will contact you for futher Refrances ASAP</p>\n"
					+ "                                                               \n"
					+ "                                                           \n"
					+ "                                                                                                                              \n"
					+ "\n" + "				\n" + "\n"
					+ "							<p>If you have any questions, please contact us. We’ll be happy to help.</p>\n"
					+ "\n"
					+ "															<p><strong>Thanks,</strong></p>\n"
					+ "															<p>CELEBI</p>\n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "														<div style=\"text-align:left; font-size:11px;\">\n"
					+ "														<p><div><em><strong style=\"text-align:left; font-size:11px;\"> Note :-</strong> </em></div>\n"
					+ "														<div style=\"text-align:left; font-size:11px;\">\n"
					+ "														<em>This is System genreted Mail Please do not reply to this mail. \n"
					+ "														for more information mail us on <a href=\"mailto:info@celebiaviation.in\">info@celebiaviation.in</a> </em></div></p>\n"
					+ "														</div>\n"
					+ "														\n"
					+ "                                                     \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                            </div>\n"
					+ "														</td>\n"
					+ "														</tr>\n"
					+ "														\n"
					+ "                                                </table>\n"
					+ "                                               \n"
					+ "                                                \n"
					+ "                                            </td>\n"
					+ "                                        </tr>\n"
					+ "                                    </table>\n" + "                                    \n"
					+ "                                </td>\n" + "                            </tr>\n"
					+ "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                   \n"
					+ "                                	<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"600\" id=\"templateFooter\" style=\"background:#0077be\" bgcolor=\"#0077be\">\n"
					+ "                                    	<tr>\n"
					+ "                                        	<td valign=\"top\" class=\"footerContent\">\n"
					+ "                                            \n"
					+ "                                                \n"
					+ "                                                <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"100%\">\n"
					+ "                                                    <!--<tr>\n"
					+ "                                                        <td colspan=\"2\" valign=\"middle\" id=\"social\" bgcolor=\"#fff\" style=\"text-align:center;  background:#fff;\" >\n"
					+ "                                                            <div mc:edit=\"std_social\">\n"
					+ "                                                                &nbsp;<a href=\"https://www.facebook.com/teramatrixtechnologies/\">follow on Facebook</a> | <a href=\"https://twitter.com/teramatrixtech\">find us on Twitter</a> | &nbsp;<a href=\"https://www.linkedin.com/company/teramatrix-technologies-pvt-ltd-\">Find us on Linkedin</a>\n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>-->\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td valign=\"top\" width=\"400\" style=\"color:#fff;\">\n"
					+ "                                                            <div style=\"color:#fff;\">\n"
					+ "																<em style=\"color:#fff;\">Copyright &copy; 2018 CargoCEL Truck Terminal Management India Pvt. Ltd.</em>\n"
					+ "																<br />\n"
					+ "																 <strong style=\"color:#fff;\">Address :- <br/></strong>\n"
					+ "																 Room No.CE-05, First Floor, Import Building – II,<br/> International Cargo Terminal, IGI Airport,\n"
					+ "																	New Delhi – 110037 INDIA<br/>\n"
					+ "																	Tel: <a style=\"color:#fff;\" href=\"callto:+91-11-25601310/1300\">+91-11-25601310/1300</a>\n"
					+ "																	<br/>\n"
					+ "																	Fax: <a style=\"color:#fff;\" href=\"callto:+91-11-25601320\">++91-11-25601320</a>\n"
					+ "																	<br/>\n"
					+ "																	Email: <a style=\"color:#fff;\" href=\"mailto:info@celebiaviation.in\">info@celebiaviation.in</a>\n"
					+ "\n" + "\n" + "																\n"
					+ "																 \n"
					+ "																 \n"
					+ "																  \n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                        <td valign=\"top\" width=\"100\" id=\"monkeyRewards\">\n"
					+ "                                                            <div mc:edit=\"monkeyrewards\">\n"
					+ "                                                              \n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td colspan=\"2\" valign=\"middle\" id=\"utility\" style=\"text-align:center;  background:#fff;\" bgcolor=\"#fff\">\n"
					+ "                                                            <div mc:edit=\"std_utility\">\n"
					+ "                                                                <a href=\"#\">unsubscribe from this list</a>\n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>\n"
					+ "                                                </table>\n"
					+ "                                                \n"
					+ "                                            \n"
					+ "                                            </td>\n"
					+ "                                        </tr>\n"
					+ "                                    </table>\n" + "                                     \n"
					+ "                                </td>\n" + "                            </tr>\n"
					+ "                        </table>\n" + "                        <br />\n"
					+ "                    </td>\n" + "                </tr>\n" + "            </table>\n"
					+ "        </center>\n" + "    </body>\n" + "</html>";
			flag = SendEmail.email(String.valueOf("Cargoceltruck@celebiaviation.in"), String.valueOf("Welcome@1"),
					String.valueOf("25"), String.valueOf("javax.net.ssl.SSLSocketFactory"), String.valueOf("true"),
					String.valueOf("smtp.office365.com"), String.valueOf("587"), builder, toEmailUser, ccEmailUser,
					bccEmailUser, null, String.valueOf("Query Received"), responsedata,
					String.valueOf("Cargocel Truck "), "Cargoceltruck@celebiaviation.in",
					"ankita.shrothi@teramatrix.in", null);

			Map<String, String> map = new LinkedHashMap<>();

			map.put("name", "Ankita");
			map.put("email", "ashrothi09@gmail.com");
			map.put("contact_number", "7895657489");
			map.put("query", "Unable to login after signUP");
			String responsedata1 = "﻿\n"
					+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
					+ "<html>\n" + "    <head>\n"
					+ "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
					+ "        \n" + "       \n" + "        <meta property=\"og:title\" content=\"*|MC:SUBJECT|*\" />\n"
					+ "        \n" + "        <title>*|MC:SUBJECT|*</title>\n" + "		<style type=\"text/css\">\n"
					+ "		 \n" + "			#outlook a{padding:0;}  \n"
					+ "			body{width:100% !important;} .ReadMsgBody{width:100%;} .ExternalClass{width:100%;}  \n"
					+ "			body{-webkit-text-size-adjust:none;}  \n" + "\n" + "			 \n"
					+ "			body{margin:0; padding:0;}\n"
					+ "			img{border:0; height:auto; line-height:100%; outline:none; text-decoration:none;}\n"
					+ "			table td{border-collapse:collapse;}\n"
					+ "			#backgroundTable{height:100% !important; margin:0; padding:0; width:100% !important;}\n"
					+ "\n" + "		 \n" + "			body, #backgroundTable{\n"
					+ "				  background-color:#FAFAFA;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#templateContainer{\n" + "				  border: 1px solid #DDDDDD;\n" + "			}\n"
					+ "\n" + "		 \n" + "			h1, .h1{\n" + "				  color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:34px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h2, .h2{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:30px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h3, .h3{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:26px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			h4, .h4{\n" + "				 color:#202020;\n"
					+ "				display:block;\n" + "				 font-family:Arial;\n"
					+ "				 font-size:22px;\n" + "				 font-weight:bold;\n"
					+ "				 line-height:100%;\n" + "				margin-top:0;\n"
					+ "				margin-right:0;\n" + "				margin-bottom:10px;\n"
					+ "				margin-left:0;\n" + "				 text-align:left;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#templatePreheader{\n"
					+ "				 background-color:#FAFAFA;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.preheaderContent div{\n" + "				 color:#505050;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:10px;\n"
					+ "				 line-height:100%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "		 \n"
					+ "			.preheaderContent div a:link, .preheaderContent div a:visited,   .preheaderContent div a .yshortcuts  {\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n" + "		 \n" + "\n"
					+ "			 \n" + "			#templateHeader{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border-bottom:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.headerContent{\n" + "				 color:#202020;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:34px;\n"
					+ "				 font-weight:bold;\n" + "				 line-height:100%;\n"
					+ "				 padding:0;\n" + "				 text-align:center;\n"
					+ "				 vertical-align:middle;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.headerContent a:link, .headerContent a:visited,   .headerContent a .yshortcuts  {\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n" + "			#headerImage{\n"
					+ "				height:auto;\n" + "				max-width:600px !important;\n" + "			}\n"
					+ "\n" + "			 \n" + "			#templateContainer, .bodyContent{\n"
					+ "				 background-color:#FFFFFF;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.bodyContent div{\n" + "				 color:#505050;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:14px;\n"
					+ "				 line-height:150%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "			 \n"
					+ "			.bodyContent div a:link, .bodyContent div a:visited, /* Yahoo! Mail Override */ .bodyContent div a .yshortcuts /* Yahoo! Mail Override */{\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n"
					+ "			.bodyContent img{\n" + "				display:inline;\n"
					+ "				height:auto;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#templateFooter{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border-top:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			.footerContent div{\n" + "				 color:#707070;\n"
					+ "				 font-family:Arial;\n" + "				 font-size:12px;\n"
					+ "				 line-height:125%;\n" + "				 text-align:left;\n" + "			}\n"
					+ "\n" + "			 \n"
					+ "			.footerContent div a:link, .footerContent div a:visited, /* Yahoo! Mail Override */ .footerContent div a .yshortcuts /* Yahoo! Mail Override */{\n"
					+ "				 color:#336699;\n" + "				 font-weight:normal;\n"
					+ "				 text-decoration:underline;\n" + "			}\n" + "\n"
					+ "			.footerContent img{\n" + "				display:inline;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#social{\n" + "				 background-color:#FAFAFA;\n"
					+ "				 border:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#social div{\n" + "				 text-align:center;\n" + "			}\n" + "\n"
					+ "			 \n" + "			#utility{\n" + "				 background-color:#FFFFFF;\n"
					+ "				 border:0;\n" + "			}\n" + "\n" + "			 \n"
					+ "			#utility div{\n" + "				 text-align:center;\n" + "			}\n" + "\n"
					+ "			#monkeyRewards img{\n" + "				max-width:190px;\n" + "			}\n"
					+ "			\n" + "			\n" + "			.data-table{}\n"
					+ "			.data-table tr th{ background:#f1f1f1; color:#000; width:150px}\n"
					+ "			.data-table tr td{ color:#000}\n" + "			\n" + "			\n" + "		</style>\n"
					+ "	</head>\n"
					+ "    <body leftmargin=\"0\" marginwidth=\"0\" topmargin=\"0\" marginheight=\"0\" offset=\"0\">\n"
					+ "    	<center>\n"
					+ "        	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"backgroundTable\">\n"
					+ "            	<tr>\n" + "                	<td align=\"center\" valign=\"top\">\n"
					+ "                        \n"
					+ "                        <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"600\" id=\"templatePreheader\">\n"
					+ "                            <tr>\n"
					+ "                                <td valign=\"top\" class=\"preheaderContent\">\n"
					+ "                                \n" + "                                	\n"
					+ "                                \n" + "                                </td>\n"
					+ "                            </tr>\n" + "                        </table>\n"
					+ "                        \n"
					+ "                    	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateContainer\" style=\"border:1px #ccc solid\">\n"
					+ "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                    \n" + "                                 \n"
					+ "                                    <table border=\"0\" id=\"templateHeader\" cellpadding=\"10\" style=\"background:#0077be;\" bgcolor=\"#0077be\"  cellspacing=\"0\" width=\"100%\">\n"
					+ "                                    	<tr>\n"
					+ "                                        	<td valign=\"top\">\n"
					+ "                                            	<div mc:edit=\"std_preheader_content\">\n"
					+ "                                                	<a href=\"http://www.teramatrix.in/\" style=\"color:#ffffff;  font-size:24px; line-height:40px; text-decoration:none; font-family:Arial, Helvetica, sans-serif\">CargoCEL Truck</a>\n"
					+ "                                                </div>\n"
					+ "                                            </td>\n"
					+ "                                          \n"
					+ "											<td valign=\"top\" width=\"190\" align=\"right\">\n"
					+ "                                            	<div mc:edit=\"std_preheader_links\">\n"
					+ "                                                	<a href=\"#\" target=\"_blank\"><img width=\"70\" src=\"http://www.celebicargo.com.tr/sites/default/files/logolar/celebi-kanatli-logo-renkli-kullanim.png\" /></a>.\n"
					+ "                                                </div>\n"
					+ "                                            </td>\n"
					+ "											 \n" + "                                        </tr>\n"
					+ "                                    </table>\n" + "                                	 \n"
					+ "                                    \n" + "                                </td>\n"
					+ "                            </tr>\n" + "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                     \n"
					+ "                                	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateBody\">\n"
					+ "                                    	<tr>\n"
					+ "                                            <td valign=\"top\" class=\"bodyContent\">\n"
					+ "                                   \n"
					+ "                                                <table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" width=\"100%\">\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td valign=\"top\">\n"
					+ "                                                            <div> \n"
					+ "                                                          \n"
					+ "                                                            <strong>Dear User</strong> <br/>\n"
					+ "                                                          \n"
					+ "                                                             <p><strong>Greetings from  CELEBI!!</strong></p>\n"
					+ "                                                               \n"
					+ "                                                               <p>Thanks for Contacting with  CELEBI. Your complain is register we will contact you for futher Refrances ASAP</p>\n"
					+ "                                                               \n"
					+ "                                                           \n"
					+ "                                                                                                                              \n"
					+ "\n" + "				\n" + "\n"
					+ "							<p>If you have any questions, please contact us. We’ll be happy to help.</p>\n"
					+ "\n"
					+ "															<p><strong>Thanks,</strong></p>\n"
					+ "															<p>CELEBI</p>\n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "														<div style=\"text-align:left; font-size:11px;\">\n"
					+ "														<p><div><em><strong style=\"text-align:left; font-size:11px;\"> Note :-</strong> </em></div>\n"
					+ "														<div style=\"text-align:left; font-size:11px;\">\n"
					+ "														<em>This is System genreted Mail Please do not reply to this mail. \n"
					+ "														for more information mail us on <a href=\"mailto:info@celebiaviation.in\">info@celebiaviation.in</a> </em></div></p>\n"
					+ "														</div>\n"
					+ "														\n"
					+ "                                                     \n"
					+ "                                                                \n"
					+ "                                                                \n"
					+ "                                                            </div>\n"
					+ "														</td>\n"
					+ "														</tr>\n"
					+ "														\n"
					+ "                                                </table>\n"
					+ "                                               \n"
					+ "                                                \n"
					+ "                                            </td>\n"
					+ "                                        </tr>\n"
					+ "                                    </table>\n" + "                                    \n"
					+ "                                </td>\n" + "                            </tr>\n"
					+ "                        	<tr>\n"
					+ "                            	<td align=\"center\" valign=\"top\">\n"
					+ "                                   \n"
					+ "                                	<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"600\" id=\"templateFooter\" style=\"background:#0077be\" bgcolor=\"#0077be\">\n"
					+ "                                    	<tr>\n"
					+ "                                        	<td valign=\"top\" class=\"footerContent\">\n"
					+ "                                            \n"
					+ "                                                \n"
					+ "                                                <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"100%\">\n"
					+ "                                                    <!--<tr>\n"
					+ "                                                        <td colspan=\"2\" valign=\"middle\" id=\"social\" bgcolor=\"#fff\" style=\"text-align:center;  background:#fff;\" >\n"
					+ "                                                            <div mc:edit=\"std_social\">\n"
					+ "                                                                &nbsp;<a href=\"https://www.facebook.com/teramatrixtechnologies/\">follow on Facebook</a> | <a href=\"https://twitter.com/teramatrixtech\">find us on Twitter</a> | &nbsp;<a href=\"https://www.linkedin.com/company/teramatrix-technologies-pvt-ltd-\">Find us on Linkedin</a>\n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>-->\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td valign=\"top\" width=\"400\" style=\"color:#fff;\">\n"
					+ "                                                            <div style=\"color:#fff;\">\n"
					+ "																<em style=\"color:#fff;\">Copyright &copy; 2018 CargoCEL Truck Terminal Management India Pvt. Ltd.</em>\n"
					+ "																<br />\n"
					+ "																 <strong style=\"color:#fff;\">Address :- <br/></strong>\n"
					+ "																 Room No.CE-05, First Floor, Import Building – II,<br/> International Cargo Terminal, IGI Airport,\n"
					+ "																	New Delhi – 110037 INDIA<br/>\n"
					+ "																	Tel: <a style=\"color:#fff;\" href=\"callto:+91-11-25601310/1300\">+91-11-25601310/1300</a>\n"
					+ "																	<br/>\n"
					+ "																	Fax: <a style=\"color:#fff;\" href=\"callto:+91-11-25601320\">++91-11-25601320</a>\n"
					+ "																	<br/>\n"
					+ "																	Email: <a style=\"color:#fff;\" href=\"mailto:info@celebiaviation.in\">info@celebiaviation.in</a>\n"
					+ "\n" + "\n" + "																\n"
					+ "																 \n"
					+ "																 \n"
					+ "																  \n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                        <td valign=\"top\" width=\"100\" id=\"monkeyRewards\">\n"
					+ "                                                            <div mc:edit=\"monkeyrewards\">\n"
					+ "                                                              \n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>\n"
					+ "                                                    <tr>\n"
					+ "                                                        <td colspan=\"2\" valign=\"middle\" id=\"utility\" style=\"text-align:center;  background:#fff;\" bgcolor=\"#fff\">\n"
					+ "                                                            <div mc:edit=\"std_utility\">\n"
					+ "                                                                <a href=\"#\">unsubscribe from this list</a>\n"
					+ "                                                            </div>\n"
					+ "                                                        </td>\n"
					+ "                                                    </tr>\n"
					+ "                                                </table>\n"
					+ "                                                \n"
					+ "                                            \n"
					+ "                                            </td>\n"
					+ "                                        </tr>\n"
					+ "                                    </table>\n" + "                                     \n"
					+ "                                </td>\n" + "                            </tr>\n"
					+ "                        </table>\n" + "                        <br />\n"
					+ "                    </td>\n" + "                </tr>\n" + "            </table>\n"
					+ "        </center>\n" + "    </body>\n" + "</html>";
			String[] toEmail = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co").split(",");
			String[] ccEmail = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co").split(",");
			String[] bccEmail = String.valueOf("ankita.shrothi@teramatrix.in,abhishek.ginani@teramatrix.co").split(",");
			flag1 = SendEmail.email(String.valueOf("Cargoceltruck@celebiaviation.in"), String.valueOf("Welcome@1"),
					String.valueOf("25"), String.valueOf("javax.net.ssl.SSLSocketFactory"), String.valueOf("true"),
					String.valueOf("smtp.office365.com"), String.valueOf("587"), builder, toEmail, ccEmail, bccEmail,
					null, String.valueOf("Query Received"), responsedata1, String.valueOf("Cargocel Truck "),
					"Cargoceltruck@celebiaviation.in", "ankita.shrothi@teramatrix.in", null);

			if (flag1) {
				System.out.println("yay mail sent :) ");
			} else {
				System.out.println(" mail not sent :( ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
