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
import com.gwtcx.client.presenter.AbstractImportsPresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.smartgwt.client.SmartGwtCx;
import com.gwtcx.client.uihandlers.ImportsUiHandlers;
import com.gwtcx.smartgwt.client.widgets.toolbar.StatusBar;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ImportsPresenter extends
    AbstractImportsPresenter<ImportsPresenter.MyView, ImportsPresenter.MyProxy> implements
  ImportsUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.imports)
  @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ImportsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ImportsUiHandlers> {
    StatusBar getStatusBar();
    void refreshStatusBar();
    void setNumberOfElements(int numberOfElements);
    void setPageNumber(int pageNumber);
  }

  @Inject
  public ImportsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
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

    MainPagePresenter.getNavigationPaneHeader().setContextAreaHeaderLabelContents(SmartGwtCx.getConstant().importsMenuItemName());
    MainPagePresenter.getNavigationPane().selectRecord(NameTokens.imports);
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