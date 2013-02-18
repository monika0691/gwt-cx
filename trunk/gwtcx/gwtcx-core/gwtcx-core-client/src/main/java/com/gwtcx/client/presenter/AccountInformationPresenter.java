/**
 * (C) Copyright 2010-2013 Kiahu
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

package com.gwtcx.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.user.client.Window;
// import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.uihandlers.AccountInformationUiHandlers;
/*
import com.gwtcx.shared.action.CreateAccountAction;
import com.gwtcx.shared.action.CreateAccountResult;
import com.gwtcx.shared.action.RetrieveAccountAction;
import com.gwtcx.shared.action.RetrieveAccountResult;
import com.gwtcx.shared.action.UpdateAccountAction;
import com.gwtcx.shared.action.UpdateAccountResult;
import com.gwtcx.shared.dto.AccountDto;
import com.gwtplatform.dispatch.shared.DispatchAsync;
*/
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class AccountInformationPresenter extends
    Presenter<AccountInformationPresenter.MyView, AccountInformationPresenter.MyProxy> implements
      AccountInformationUiHandlers {

  // AccountsRecord.ACCOUNT_ID
  public static final String ACCOUNT_ID = "accountId";

  private static final String ACTIVITY = "activity";
  // private static final String DEFAULT_ACTIVITY = "edit";
  private static final String EDIT = "edit";
  // private static final String NEW = "new";

  // private final DispatchAsync dispatcher;

  private String activity;
  private String accountId;

  @ProxyCodeSplit
  @NameToken(NameTokens.accountInformation)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<AccountInformationPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<AccountInformationUiHandlers> {
    // void setResultSet(AccountDto account);
    void setAccountId(String accountId);
  }

  @Inject
  // public AccountInformationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
  //     PlaceManager placeManager, DispatchAsync dispatcher) {
  public AccountInformationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    // this.dispatcher = dispatcher;
  }

  @Override
  protected void onBind() {
    super.onBind();

    // activity = Window.Location.getParameter(ACTIVITY);
    // accountId = Window.Location.getParameter(AccountsRecord.ACCOUNT_ID);

    activity = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ACTIVITY));
    accountId = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ACCOUNT_ID));

    if (activity.equals(EDIT)) {
      Long id = -1L;

      try {
        id = Long.valueOf(accountId);
      }
      catch (NumberFormatException nfe) {
        Log.debug("NumberFormatException: " + nfe.getLocalizedMessage());
        return;
      }

      try {
        // retrieveAccount(id);
      }
      catch (Exception e) {
        Log.warn("Unable to retrieve account: " + e);
      }
    }
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    // AccountPagePresenter.getNavigationPane().selectRecord(NameTokens.accountInformation);
  }

  @Override
  protected void onReset() {
    super.onReset();
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, AccountPagePresenter.TYPE_SetContextAreaContent, this);
  }

  public static native void close() /*-{ $wnd.close(); }-*/;

  /*

  public void onSaveButtonClicked(AccountDto accountDto) {
    createOrUpdateAccount(accountDto);
  }

  public void onSaveAndCloseButtonClicked(AccountDto accountDto) {
    createOrUpdateAccount(accountDto);
    close();
  }

  public void createOrUpdateAccount(AccountDto accountDto) {

    if (Long.parseLong(accountDto.getAccountId()) == -1) {
      createAccount(accountDto);
    } else {
      updateAccount(accountDto);
    }
  }

  public void createAccount(AccountDto accountDto) {

    dispatcher.execute(new CreateAccountAction(accountDto),
        new AsyncCallback<CreateAccountResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(CreateAccountResult result) {
        Log.debug("onSuccess() - accountId: " + result.getId());
        getView().setAccountId(result.getId());
      }
    });
  }

  public void updateAccount(AccountDto accountDto) {

    dispatcher.execute(new UpdateAccountAction(accountDto),
        new AsyncCallback<UpdateAccountResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(UpdateAccountResult result) {
        Log.debug("onSuccess()");
      }
    });
  }

  protected void retrieveAccount(Long accountId) {

    dispatcher.execute(new RetrieveAccountAction(Long.toString(accountId)),
        new AsyncCallback<RetrieveAccountResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(RetrieveAccountResult result) {
        Log.debug("onSuccess()");
        getView().setResultSet(result.getDto());
      }
    });
  }

  */
}
