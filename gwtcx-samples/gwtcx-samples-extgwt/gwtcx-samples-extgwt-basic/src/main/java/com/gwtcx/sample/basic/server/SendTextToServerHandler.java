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

package com.gwtcx.sample.basic.server;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtcx.sample.basic.shared.FieldVerifier;
import com.gwtcx.sample.basic.shared.SendTextToServer;
import com.gwtcx.sample.basic.shared.SendTextToServerResult;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class SendTextToServerHandler implements
    ActionHandler<SendTextToServer, SendTextToServerResult> {

  private Provider<HttpServletRequest> requestProvider;
  private ServletContext servletContext;

  @Inject
  SendTextToServerHandler(ServletContext servletContext,
      Provider<HttpServletRequest> requestProvider) {
    this.servletContext = servletContext;
    this.requestProvider = requestProvider;
  }

  @Override
  public SendTextToServerResult execute(SendTextToServer action,
      ExecutionContext context) throws ActionException {

    String input = action.getTextToServer();

    if (!FieldVerifier.isValidName(input)) {
      throw new ActionException("Name must be at least 4 characters long");
    }

    String serverInfo = servletContext.getServerInfo();
    String userAgent = requestProvider.get().getHeader("User-Agent");
    return new SendTextToServerResult("Hello, " + input
        + "!<br><br>I am running " + serverInfo
        + ".<br><br>It looks like you are using:<br>" + userAgent);
  }

  @Override
  public Class<SendTextToServer> getActionType() {
    return SendTextToServer.class;
  }

  @Override
  public void undo(SendTextToServer action, SendTextToServerResult result,
      ExecutionContext context) throws ActionException {
    // Not undoable
  }
}
