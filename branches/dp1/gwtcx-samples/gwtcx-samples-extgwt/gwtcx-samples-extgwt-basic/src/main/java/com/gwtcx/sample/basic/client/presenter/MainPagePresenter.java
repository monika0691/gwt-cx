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

package com.gwtcx.sample.basic.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.sample.basic.client.view.MainPageUiHandlers;
import com.gwtcx.sample.basic.shared.FieldVerifier;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class MainPagePresenter extends
    Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> implements MainPageUiHandlers {

  private final PlaceManager placeManager;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyStandard
  @NameToken(NameTokens.mainPage)
  public interface MyProxy extends Proxy<MainPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<MainPageUiHandlers> {
    String getName();
    void resetAndFocus();
    void setError(String errorText);
  }

  @Inject
  public MainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    this.placeManager = placeManager;
  }

  @Override
  protected void onBind() {
    super.onBind();

    Log.debug("onBind()");
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");

    getView().resetAndFocus();
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  public void onSendButtonClicked() {
    sendNameToServer();
  }

  protected void sendNameToServer() {

    getView().setError("");
    String textToServer = getView().getName();

    if (! FieldVerifier.isValidName(textToServer)) {
      getView().setError("Please enter at least four characters");
      return;
    }

    getPlaceManager().revealPlace(new PlaceRequest(ResponsePagePresenter.nameToken).with(
        ResponsePagePresenter.textToServerParam, textToServer));
  }

  protected PlaceManager getPlaceManager()  {
    return placeManager;
  }
}

