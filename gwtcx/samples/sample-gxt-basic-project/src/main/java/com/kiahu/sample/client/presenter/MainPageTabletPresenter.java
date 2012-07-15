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

package com.kiahu.sample.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;

public class MainPageTabletPresenter extends
    Presenter<MainPageTabletPresenter.MyView, MainPageTabletPresenter.MyProxy>  implements
    MainPageUiHandlers {

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

  public interface MyView extends View, HasUiHandlers<MainPageUiHandlers> {
    // HasClickHandlers creation();
    // HasTapHandlers goBack();
  }

  @Inject
  public MainPageTabletPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
      final PlaceManager placeManager) {
    super(eventBus, view, proxy);

    Log.debug("MainPagePresenter()");

    this.placeManager = placeManager;

    // getView().setUiHandlers(this);
  }


  @Override
  protected void revealInParent() {

    Log.debug("revealInParent() - RevealAnimatableDisplayContentEvent.fire(this, this,getAnimation())");

    // RevealRootContentEvent.fire(this, this);
    // RevealRootLayoutContentEvent.fire(this, this);
    RevealAnimatableDisplayContentEvent.fire(this, this, getAnimation());
  }

  private Animation getAnimation(){
    return Animation.FLIP;
  }

  @Override
  protected void onBind() {
    super.onBind();

  }


@Override
public void onNavigationPaneSectionHeaderClicked(String name) {
    // TODO Auto-generated method stub

}


@Override
public void onNavigationPaneSectionClicked(String name) {
    // TODO Auto-generated method stub

}


@Override
public void onNewActivityClicked(String name) {
    // TODO Auto-generated method stub

}


@Override
public void onNewRecordClicked(String name) {
    // TODO Auto-generated method stub

}


@Override
public void onGoToMenuItemClicked(String name) {
    // TODO Auto-generated method stub

}
}
