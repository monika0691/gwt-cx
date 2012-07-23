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
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtcx.client.NameTokens;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
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
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<MainPageTabletPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageTabletUiHandlers> {
    // HasClickHandlers creation();
    // HasTapHandlers goBack();
    void reset();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetNavigationPaneContent = new Type<RevealContentHandler<?>>();

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

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

    // RevealRootContentEvent.fire(this, this);
    // RevealRootLayoutContentEvent.fire(this, this);
    // RevealAnimatableDisplayContentEvent.fire(this, this, getAnimation());

    RevealAnimatableDisplayContentEvent.fire(this, this, getAnimation());
  }

  private Animation getAnimation(){
    return Animation.SLIDE;
  }

  @Override
  protected void onBind() {
    super.onBind();

    Log.debug("onBind()");
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal()");
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");

    // getView().reset();
  }

  @Override
  protected void onHide() {
    super.onHide();

    Log.debug("onHide()");
  }

  @Override
  protected void onUnbind() {
    super.onHide();

    Log.debug("onUnbind()");
  }

  @Override
  public void onNavigationPaneClicked(String place) {

    Log.debug("onNavigationPaneClicked(): " + place);

    // if (place.length() != 0) {
    //   PlaceRequest placeRequest = new PlaceRequest(place);
    //   getPlaceManager().revealPlace(placeRequest);
    // }

    PlaceRequest placeRequest = new PlaceRequest(com.kiahu.sample.client.NameTokens.animations);
    getPlaceManager().revealPlace(placeRequest);
  }

  public PlaceManager getPlaceManager() {
    return placeManager;
  }
}
