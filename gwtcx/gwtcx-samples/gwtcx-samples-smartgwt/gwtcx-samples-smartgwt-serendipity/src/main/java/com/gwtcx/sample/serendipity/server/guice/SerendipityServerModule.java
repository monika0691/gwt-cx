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

package com.gwtcx.sample.serendipity.server.guice;

import com.gwtcx.server.handler.CreateAccountHandler;
import com.gwtcx.server.handler.DeleteAccountHandler;
import com.gwtcx.server.handler.LoginHandler;
import com.gwtcx.server.handler.RetrieveAccountHandler;
import com.gwtcx.server.handler.RetrieveAccountsHandler;
import com.gwtcx.server.handler.RetrieveReportsHandler;
import com.gwtcx.server.handler.SendEmailHandler;
import com.gwtcx.server.handler.UpdateAccountHandler;
import com.gwtcx.server.handler.validator.LoggedInActionValidator;
import com.gwtcx.shared.action.CreateAccountAction;
import com.gwtcx.shared.action.DeleteAccountAction;
import com.gwtcx.shared.action.LoginAction;
import com.gwtcx.shared.action.RetrieveAccountAction;
import com.gwtcx.shared.action.RetrieveAccountsAction;
import com.gwtcx.shared.action.RetrieveReportsAction;
import com.gwtcx.shared.action.SendEmailAction;
import com.gwtcx.shared.action.UpdateAccountAction;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class SerendipityServerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {

    // Bind Action to Action Handler
    bindHandler(LoginAction.class, LoginHandler.class);

    // Bind Action to Action Handler and Action Validator
    // bindHandler(RetrieveAccountsAction.class, RetrieveAccountsHandler.class);
    bindHandler(RetrieveAccountsAction.class, RetrieveAccountsHandler.class, LoggedInActionValidator.class);

    bindHandler(CreateAccountAction.class, CreateAccountHandler.class, LoggedInActionValidator.class);
    bindHandler(RetrieveAccountAction.class, RetrieveAccountHandler.class, LoggedInActionValidator.class);
    bindHandler(UpdateAccountAction.class, UpdateAccountHandler.class, LoggedInActionValidator.class);
    bindHandler(DeleteAccountAction.class, DeleteAccountHandler.class, LoggedInActionValidator.class);

    bindHandler(SendEmailAction.class, SendEmailHandler.class, LoggedInActionValidator.class);

    bindHandler(RetrieveReportsAction.class, RetrieveReportsHandler.class, LoggedInActionValidator.class);

    // bind(Log.class).toProvider(LogProvider.class).in(Singleton.class);
  }
}
