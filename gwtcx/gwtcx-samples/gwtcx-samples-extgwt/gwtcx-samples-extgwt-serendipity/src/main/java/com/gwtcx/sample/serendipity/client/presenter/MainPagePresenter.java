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
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.event.NavigationPaneUpdateEventHandler;
import com.gwtcx.client.presenter.AbstractMainPagePresenter;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtcx.extgwt.client.widgets.NavigationPane;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class MainPagePresenter extends
    AbstractMainPagePresenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> implements
  MainPageUiHandlers {

  public static ContentPanel navigationPaneHeader = null;
  public static NavigationPane navigationPane = null;

  //
  // don't forget to update your Ginjector & GinModule
  //
  // @ProxyCodeSplit
  @ProxyStandard
  @NameToken(NameTokens.mainPage)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<MainPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageUiHandlers> {
    ContentPanel getNavigationPaneHeader();
    NavigationPane getNavigationPane();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public MainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    Log.debug("MainPagePresenter()");

    getView().setUiHandlers(this);

    MainPagePresenter.navigationPaneHeader = getView().getNavigationPaneHeader();
    MainPagePresenter.navigationPane = getView().getNavigationPane();

    // TO DO: move event handler to NavigationPane
    getEventBus().addHandler(NavigationPaneUpdateEvent.getType(), new NavigationPaneUpdateEventHandler() {
      @Override
      public void onUpdateNavigationPane(NavigationPaneUpdateEvent event) {
        getNavigationPane().selectRecord(event.getName());
        getNavigationPaneHeader().setHeadingText(event.getDisplayName());
      }
    });
  }

  @Override
  public void prepareFromRequest(PlaceRequest placeRequest) {
    super.prepareFromRequest(placeRequest);

    Log.debug("prepareFromRequest()");

    // SerendipitySignInPagePresenter.REDIRECT
    String nameToken = placeRequest.getParameter("redirect", NameTokens.accounts);

    Log.debug("nameToken: " + nameToken);

    // expand the first Navigation Pane section
    // getView().getNavigationPane().expandSection(I18nUtil.getConstant().salesStackSectionName());
    // getNavigationPane().setWidget(getNavigationPane().getWidget(0));

    // reveal the nested Presenter
    PlaceRequest nestedPlaceRequest = new PlaceRequest(nameToken);
    getPlaceManager().revealPlace(nestedPlaceRequest);
  }

  public static ContentPanel getNavigationPaneHeader() {
    return navigationPaneHeader;
  }

  public static NavigationPane getNavigationPane() {
    return navigationPane;
  }
}

