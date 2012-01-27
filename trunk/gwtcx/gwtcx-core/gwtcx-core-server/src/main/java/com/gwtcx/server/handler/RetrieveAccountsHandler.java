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

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.server.dao.AccountDao;
import com.gwtcx.server.domain.Account;
import com.gwtcx.shared.action.RetrieveAccountsAction;
import com.gwtcx.shared.action.RetrieveAccountsResult;
import com.gwtcx.shared.dto.AccountsDto;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

// don't forget to update bindHandler() in ServerModule
public class RetrieveAccountsHandler implements
    ActionHandler<RetrieveAccountsAction, RetrieveAccountsResult> {

  /*

  private final Provider<HttpServletRequest> requestProvider;
  // private final ServletContext servletContext;

  @Inject
  RetrieveAccountsHandler(final ServletContext servletContext,
      final Provider<HttpServletRequest> requestProvider) {
    this.requestProvider = requestProvider;
    // this.servletContext = servletContext;
  }

  */

  @Override
  public RetrieveAccountsResult execute(RetrieveAccountsAction action,
      ExecutionContext context) throws ActionException {

    RetrieveAccountsResult result = null;
    AccountDao accountDao = new AccountDao();

    Log.debug("Retrieve Accounts");

    // if (! isLoggedIn(requestProvider)) {
    //   Log.debug("User has not logged in.");
    //   throw new ActionException("User has not logged in - Retrieve Accounts");
    // }

    try {
      List<Account> accounts = accountDao.retrieveAccounts(action.getMaxResults(),
          action.getFirstResult());

      if (accounts != null) {
        List<AccountsDto> accountsDtos = new ArrayList<AccountsDto>(accounts.size());

        for (Account account : accounts) {
          accountsDtos.add(toDto(account));
        }

        result = new RetrieveAccountsResult(accountsDtos);
      }
    }
    catch (Exception e) {
      Log.warn("Unable to retrieve Accounts - ", e);

      throw new ActionException(e);
    }

    return result;
  }

  /*

  private Boolean isLoggedIn(Provider<HttpServletRequest> requestProvider) {
    Boolean result = true;

    HttpSession session = requestProvider.get().getSession();

    Object authenticated = session.getAttribute("login.authenticated");

    if (authenticated == null) {
      result = false;
    }

    return result;
  }

  */

  private AccountsDto toDto(Account account) {
    return new AccountsDto(account.getAccountIdAsString(), account.getAccountName(), account.getMainPhone(),
        account.getLocation(), account.getPrimaryContact(), account.getEmailPrimaryContact());
  }

  @Override
  public Class<RetrieveAccountsAction> getActionType() {
    return RetrieveAccountsAction.class;
  }

  @Override
  public void undo(RetrieveAccountsAction action, RetrieveAccountsResult result,
      ExecutionContext context) throws ActionException {
  }
}