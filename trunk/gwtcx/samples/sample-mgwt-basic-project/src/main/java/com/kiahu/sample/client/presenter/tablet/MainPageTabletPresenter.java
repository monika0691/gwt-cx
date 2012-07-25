/**
 * (C) Copyright 2012 Kiahu
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

package com.kiahu.sample.client.presenter.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtcx.client.NameTokens;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;
import com.kiahu.sample.client.uihandlers.MainPageTabletUiHandlers;

public class MainPageTabletPresenter extends
    Presenter<MainPageTabletPresenter.MyView, MainPageTabletPresenter.MyProxy> implements
        MainPageTabletUiHandlers {

  private final PlaceManager placeManager;

  //
  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  // @ProxyCodeSplit
  @ProxyStandard
  @NameToken(NameTokens.mainPage)
  public interface MyProxy extends Proxy<MainPageTabletPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageTabletUiHandlers> {
  }

  @Inject
  public MainPageTabletPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
      final PlaceManager placeManager) {
    super(eventBus, view, proxy);

    Log.debug("MainPageTabletPresenter()");

    this.placeManager = placeManager;

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {

	Log.debug("revealInParent()");

    RevealAnimatableDisplayContentEvent.fire(this, MgwtRootPresenter.TYPE_SetNavigationPaneContent, this, getAnimation());

    PlaceRequest placeRequest = new PlaceRequest(com.kiahu.sample.client.NameTokens.about);
    getPlaceManager().revealPlace(placeRequest, false);
  }

  private Animation getAnimation(){
    return Animation.SLIDE;
  }

  @Override
  public void onNavigationPaneClicked(String place) {

    Log.debug("onNavigationPaneClicked(): " + place);

    if (place.length() != 0) {
      PlaceRequest placeRequest = new PlaceRequest(place);
      getPlaceManager().revealPlace(placeRequest);
    }
  }

  public PlaceManager getPlaceManager() {
    return placeManager;
  }
}