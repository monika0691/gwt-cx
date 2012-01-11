/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Singleton;

@Singleton
@SuppressWarnings("serial")
public class MailServlet extends HttpServlet {

  private final Object lock = new Object();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.processRequest(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.processRequest(request, response);
  }

  public void init(ServletConfig config) throws ServletException {
      super.init(config);

    Log.debug("Mail Servlet");

    getInitParameters();
  }

  private static final String MAIL_NAME = "MAIL-NAME";

  protected static String mailName = "mail/GmailSmtpServer";

  protected void getInitParameters() {
    ServletContext context = getServletContext();
    mailName = context.getInitParameter(MAIL_NAME);

    Log.debug("mailName: " + mailName);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Log.info("Mail Servlet");

    String from = "serendipity.gwtcx@gmail.com";
    String to = "rob.ferguson@upick.com.au";
    // String host = "smtp.gmail.com";
    String msgText = "This is a message body.\nHere's the second line.";

    Session session = null;

    try {
      synchronized(lock) {
        Context initialContext = new InitialContext();
        Context localContext = (Context) initialContext.lookup("java:comp/env");
        session = (Session) localContext.lookup(mailName);
      }

      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(from));

      InternetAddress[] address = {new InternetAddress(to)};
      msg.setRecipients(Message.RecipientType.TO, address);
      msg.setSubject("JavaMail APIs Test");
      msg.setSentDate(new Date());
      // If the desired charset is known, you can use
      // setText(text, charset)
      msg.setText(msgText);

      Transport.send(msg);
    }
    catch (Exception e) {
      // display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      response.getOutputStream().print(stringWriter.toString());
    }
    // finally {
    // }
  }
}
