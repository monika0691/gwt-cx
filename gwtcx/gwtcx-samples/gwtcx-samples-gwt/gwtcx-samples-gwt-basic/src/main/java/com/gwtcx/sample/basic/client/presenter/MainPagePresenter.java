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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtcx.client.NameTokens;
import com.gwtcx.sample.basic.shared.FieldVerifier;

public class MainPagePresenter extends
    Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> {

  private final PlaceManager placeManager;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyStandard
  @NameToken(NameTokens.mainPage)
  public interface MyProxy extends Proxy<MainPagePresenter>, Place {
  }

  public interface MyView extends View {
    String getName();
    Button getSendButton();
    void resetAndFocus();
    void setError(String errorText);
  }

  @Inject
  public MainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    this.placeManager = placeManager;
  }

  @Override
  protected void onBind() {
    super.onBind();

    registerHandler(getView().getSendButton().addClickHandler(
        new ClickHandler() {
          @Override
          public void onClick(ClickEvent event) {
            sendNameToServer();
        }
    }));
  }

  @Override
  protected void onReset() {
    super.onReset();

    getView().resetAndFocus();
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  private void sendNameToServer() {

    getView().setError("");
    String textToServer = getView().getName();

    if (! FieldVerifier.isValidName(textToServer)) {
      getView().setError("Please enter at least four characters");
      return;
    }

    placeManager.revealPlace(new PlaceRequest(ResponsePresenter.nameToken).with(
        ResponsePresenter.textToServerParam, textToServer));
  }
}
