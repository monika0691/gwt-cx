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
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.client.presenter.AbstractMainPagePresenter;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtcx.smartgwt.client.widgets.NavigationPane;
import com.gwtcx.smartgwt.client.widgets.NavigationPaneHeader;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class MainPagePresenter extends
     AbstractMainPagePresenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> implements
  MainPageUiHandlers {

  public static NavigationPaneHeader navigationPaneHeader = null;
  public static NavigationPane navigationPane = null;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.mainPage)
  @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<MainPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageUiHandlers> {
    NavigationPaneHeader getNavigationPaneHeader();
    NavigationPane getNavigationPane();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public MainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    getView().setUiHandlers(this);

    MainPagePresenter.navigationPaneHeader = getView().getNavigationPaneHeader();
    MainPagePresenter.navigationPane = getView().getNavigationPane();
  }

  @Override
  public void prepareFromRequest(PlaceRequest placeRequest) {
    super.prepareFromRequest(placeRequest);

    Log.debug("prepareFromRequest()");

    String nameToken = placeRequest.getParameter(SignInPagePresenter.REDIRECT, NameTokens.dashboards);

    Log.debug("nameToken: " + nameToken);

    // expand the first Navigation Pane section
    // getView().getNavigationPane().expandSection(I18nUtil.getConstant().salesStackSectionName());

    // reveal the nested Presenter
    PlaceRequest nestedPlaceRequest = new PlaceRequest(nameToken);
    getPlaceManager().revealPlace(nestedPlaceRequest);
  }

  public static NavigationPaneHeader getNavigationPaneHeader() {
    return navigationPaneHeader;
  }

  public static NavigationPane getNavigationPane() {
    return navigationPane;
  }
}