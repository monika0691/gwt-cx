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

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.presenter.AbstractReportsPresenter;
import com.gwtcx.client.uihandlers.ReportsUiHandlers;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ReportsPresenter extends
    AbstractReportsPresenter<ReportsPresenter.MyView, ReportsPresenter.MyProxy> implements
    ReportsUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.reports)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ReportsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ReportsUiHandlers> {
    // StatusBar getStatusBar();
    // void refreshStatusBar();
    // void setNumberOfElements(int numberOfElements);
    // void setPageNumber(int pageNumber);
    // void setResultSet(List<ReportsDto> resultSet);
  }

  @Inject
  public ReportsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    NavigationPaneUpdateEvent.fire(this.getEventBus(), NameTokens.reports, ExtGwtCx.getConstant().reportsMenuItemName());
  }

  protected void retrieveResultSet() {

    /*

    getDispatcher().execute(new RetrieveReportsAction(getMaxResults(), getFirstResult()),
        new AsyncCallback<RetrieveReportsResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(RetrieveReportsResult result) {

        setNumberOfElements(result.getReportDtos().size());

        // update Selected label e.g "0 of 50 selected"
        getView().setNumberOfElements(getNumberOfElements());
        getView().setPageNumber(getPageNumber());
        getView().refreshStatusBar();

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
        getView().setResultSet(result.getReportDtos());
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