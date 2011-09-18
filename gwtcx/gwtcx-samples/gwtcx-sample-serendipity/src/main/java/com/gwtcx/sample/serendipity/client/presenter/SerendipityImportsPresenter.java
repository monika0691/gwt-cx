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
import com.gwtcx.client.GwtCx;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.ImportsPresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.client.smartgwt.view.handlers.ImportsUiHandlers;
import com.gwtcx.client.smartgwt.widgets.toolbar.StatusBar;
import com.gwtplatform.dispatch.client.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class SerendipityImportsPresenter extends
    ImportsPresenter<SerendipityImportsPresenter.MyView, SerendipityImportsPresenter.MyProxy> implements
  ImportsUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.imports)
  @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<SerendipityImportsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ImportsUiHandlers> {
    StatusBar getStatusBar();
    void refreshStatusBar();
    void setNumberOfElements(int numberOfElements);
    void setPageNumber(int pageNumber);
  }

  @Inject
  public SerendipityImportsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, SerendipityMainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    SerendipityMainPagePresenter.getNavigationPaneHeader().setContextAreaHeaderLabelContents(GwtCx.getConstant().importsMenuItemName());
    SerendipityMainPagePresenter.getNavigationPane().selectRecord(NameTokens.imports);
  }

  @Override
  protected void retrieveResultSet() { }

  @Override
  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();

    getView().getStatusBar().getResultSetFirstButton().disable();
  }

  @Override
  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();

    getView().getStatusBar().getResultSetFirstButton().enable();
    getView().getStatusBar().getResultSetPreviousButton().enable();
  }
}