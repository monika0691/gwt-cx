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

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gwtcx.shared.action.LoginAction;
import com.gwtcx.shared.action.LoginResult;
import com.gwtcx.shared.exception.LoginException;
import com.gwtcx.server.dao.UserDao;
import com.gwtcx.server.domain.User;
import com.gwtcx.server.util.Security;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

// don't forget to update bindHandler() in ServerModule

/**
 * Handler for the Login action {@link LoginAction}.
 * <p />
 * <b>Note:</b> Action handlers must be thread safe since they will be
 * bound as singletons. For details, see <a href=
 * "http://code.google.com/p/google-guice/wiki/Scopes#Scopes_and_Concurrency">
 * http://code.google.com/p/google-guice/wiki/Scopes#Scopes_and_Concurrency</a>.
 *
 * @param <LoginAction> The type of the action {@link LoginAction}.
 * @param <LoginResult> The type of the result {@link LoginResult}.
 *
 * @author Rob Ferguson
 */
public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {

  private final Provider<HttpServletRequest> requestProvider;
  // private final ServletContext servletContext;

  @Inject
  LoginHandler(final ServletContext servletContext,
      final Provider<HttpServletRequest> requestProvider) {
    this.requestProvider = requestProvider;
    // this.servletContext = servletContext;
  }

  /**
   * Handles the Login action. If you want to build a compound action that
   * can rollback automatically upon failure, call
   * {@link ExecutionContext#execute(Action)}. See <a
   * href="http://code.google.com/p/gwt-dispatch/wiki/CompoundActions" >here</a>
   * for details.
   *
   * @param action The Login action.
   * @param context The {@link ExecutionContext}.
   * @return The {@link LoginResult}.
   * @throws LoginException if there is a problem performing the specified
   *           action.
   */
  @Override
  public LoginResult execute(final LoginAction action,
      final ExecutionContext context) throws ActionException {

    LoginResult result = null;
    UserDao userDao = new UserDao();

    try {
      User user = userDao.retrieveUser(action.getLogin());

      if (user != null && isValidLogin(action, user)) {

        HttpSession session = requestProvider.get().getSession();
        session.setAttribute("login.authenticated", action.getLogin());

        result = new LoginResult(session.getId());

        Log.debug(action.getLogin() + " has logged in");
        Log.debug("Session key: " + result.getSessionKey());
      }
      else {
        // GWTP only includes the exception type and it's message?
        // Looks like it needs only a small change on the DispatchServiceImpl class,
        // on the execute() method:
        // Instead of calling logger.warning(message), use logger.log(level, message, throwable).
        throw new LoginException("Invalid User name or Password.");
      }
    }
    catch (Exception e) {

      // log the stack trace
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);

      Log.debug("Exception e: " + stringWriter.toString());
      // Log.debug("e: " + e);

      throw new ActionException(e);
    }

    return result;
  }

  private Boolean isValidLogin(LoginAction action, User user) {
    // String hash = Security.sha256(user.getSalt() + action.getPassword());
    String hash = Security.md5(user.getSalt() + action.getPassword());

    Log.debug("LoginHandler - hash: " + hash + " password: " + user.getPassword());

    return hash.equals(user.getPassword());
  }

  /**
   * @return The type of {@link Action} supported by this handler.
   */
  @Override
  public Class<LoginAction> getActionType() {
    return LoginAction.class;
  }

  /**
   * Undoes the specified action. If you want to build a compound action that
   * can rollback automatically upon failure, call
   * {@link ExecutionContext#undo(Action, Result)}. See <a
   * href="http://code.google.com/p/gwt-dispatch/wiki/CompoundActions" >here</a>
   * for details.
   *
   * @param action The Login action.
   * @param result The {@link LoginResult}.
   * @param context The {@link ExecutionContext}.
   * @throws ActionException if there is a problem performing the specified
   *           action.
   */
  @Override
  public void undo(LoginAction action, LoginResult result,
      ExecutionContext context) throws ActionException {
  }
}