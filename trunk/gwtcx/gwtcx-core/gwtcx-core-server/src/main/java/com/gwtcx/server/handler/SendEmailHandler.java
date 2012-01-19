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

package com.gwtcx.server.handler;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtcx.shared.action.SendEmailAction;
import com.gwtcx.shared.action.SendEmailResult;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

// don't forget to update bindHandler() in ServerModule

public class SendEmailHandler implements
    ActionHandler<SendEmailAction, SendEmailResult> {

  private static final String MAIL_NAME = "MAIL-NAME";

  protected static String mailName = "mail/GmailSmtpServer";

  // private final ServletContext servletContext;

  @Inject
  SendEmailHandler(final ServletContext servletContext,
      final Provider<HttpServletRequest> requestProvider) {

    // this.servletContext = servletContext;

    mailName = servletContext.getInitParameter(MAIL_NAME);

    Log.debug("mailName: " + mailName);
  }

  @Override
  public SendEmailResult execute(final SendEmailAction action,
      final ExecutionContext context) throws ActionException {

    SendEmailResult result = null;

    String from = "serendipity.gwtcx@gmail.com";
    String to = "rob.ferguson@upick.com.au";
    // String host = "smtp.gmail.com";
    String msgText = "This is a message body.\nHere's the second line.";

    Session session = null;


    Log.info("Send Email");

    try {
      // synchronized(lock) {
       Context initialContext = new InitialContext();
       Context localContext = (Context) initialContext.lookup("java:comp/env");
       session = (Session) localContext.lookup(mailName);
      // }
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

        result = new SendEmailResult("1");

        Log.info("Email message sent");

    }
    catch (Exception e) {
      Log.warn("Unable to send Email", e);

      throw new ActionException(e);
    }

    return result;
  }

  @Override
  public Class<SendEmailAction> getActionType() {
    return SendEmailAction.class;
  }

  @Override
  public void undo(SendEmailAction action, SendEmailResult result,
      ExecutionContext context) throws ActionException {
  }
}
