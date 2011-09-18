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
import com.gwtcx.client.presenter.MainPagePresenter;
import com.gwtcx.client.smartgwt.view.handlers.MainPageUiHandlers;
import com.gwtcx.client.smartgwt.widgets.NavigationPane;
import com.gwtcx.client.smartgwt.widgets.NavigationPaneHeader;
import com.gwtcx.client.util.I18nUtil;
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

public class SerendipityMainPagePresenter extends
     MainPagePresenter<SerendipityMainPagePresenter.MyView, SerendipityMainPagePresenter.MyProxy> implements
  MainPageUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.mainPage)
  @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<SerendipityMainPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageUiHandlers> {
    NavigationPaneHeader getNavigationPaneHeader();
    NavigationPane getNavigationPane();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public SerendipityMainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    getView().setUiHandlers(this);

    SerendipityMainPagePresenter.navigationPaneHeader = getView().getNavigationPaneHeader();
    SerendipityMainPagePresenter.navigationPane = getView().getNavigationPane();
  }

  @Override
  protected void onBind() {
    super.onBind();

    Log.debug("onBind()");

    // expand the first Navigation Pane section
    getView().getNavigationPane().expandSection(I18nUtil.getConstant().salesStackSectionName());

    // reveal the first nested Presenter
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.activities);
    getPlaceManager().revealPlace(placeRequest);
  }
}