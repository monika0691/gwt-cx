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

package com.gwtcx.sample.serendipity.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.AbstractAccountsPresenter;
import com.gwtcx.client.uihandlers.AccountsUiHandlers;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class AccountsPresenter extends
    AbstractAccountsPresenter<AccountsPresenter.MyView, AccountsPresenter.MyProxy> implements
  AccountsUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.accounts)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<AccountsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<AccountsUiHandlers> {
    // StatusBar getStatusBar();
    // void refreshStatusBar();
    // void setNumberOfElements(int numberOfElements);
    // void setPageNumber(int pageNumber);
    // void setResultSet(List<AccountsDto> resultSet);
    // void removeSelectedData();
  }

  @Inject
  public AccountsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {

    Log.debug("revealInParent()");

    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal() - " + NameTokens.accounts);

    // MainPagePresenter.getNavigationPaneHeader().setContextAreaHeaderLabelContents(SmartGwtCx.getConstant().accountsMenuItemName());
    // MainPagePresenter.getNavigationPane().selectRecord(NameTokens.accounts);
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");
  }

  @Override
  protected void retrieveResultSet() {

    /*

    getDispatcher().execute(new RetrieveAccountsAction(getMaxResults(), getFirstResult()),
        new AsyncCallback<RetrieveAccountsResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(RetrieveAccountsResult result) {

        setNumberOfElements(result.getAccountDtos().size());

        // update Selected label e.g "0 of 50 selected"
        getView().setNumberOfElements(getNumberOfElements());
        getView().setPageNumber(getPageNumber());
        getView().refreshStatusBar();

        // Log.debug("onSuccess() - firstResult: " + firstResult +
        //     " pageNumber: " + pageNumber + " numberOfElements: " + numberOfElements);

        // enable/disable the pagination widgets
        if (getPageNumber() == 1) {
          getView().getStatusBar().getResultSetFirstButton().disable();
          getView().getStatusBar().getResultSetPreviousButton().disable();
        }

        // enable/disable the pagination widgets
        if (getNumberOfElements() < getMaxResults()) {
          getView().getStatusBar().getResultSetNextButton().disable();
        }
        else {
          getView().getStatusBar().getResultSetNextButton().enable();
        }

        // pass the result set to the View
        getView().setResultSet(result.getAccountDtos());
      }
    });

    */
  }

  @Override
  public void onDeleteButtonClicked(String accountId) {

    /*

    Long id = -1L;

    try {
      id = Long.valueOf(accountId);
    }
    catch (NumberFormatException nfe) {
      Log.debug("NumberFormatException: " + nfe.getLocalizedMessage());
      return;
    }

    getDispatcher().execute(new DeleteAccountAction(id),
        new AsyncCallback<DeleteAccountResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(DeleteAccountResult result) {
        Log.debug("onSuccess()");
        getView().removeSelectedData();
      }
    });

    */
  }

  @Override
  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();

    // getView().getStatusBar().getResultSetFirstButton().disable();
  }

  @Override
  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();

    // getView().getStatusBar().getResultSetFirstButton().enable();
    // getView().getStatusBar().getResultSetPreviousButton().enable();
  }
}
