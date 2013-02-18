/**
 * (C) Copyright 2010-2013 Kiahu
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

package com.gwtcx.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.uihandlers.ErrorPageUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public abstract class AbstractErrorPagePresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> implements ErrorPageUiHandlers {

  private final PlaceManager placeManager;

  @Inject
  public AbstractErrorPagePresenter(EventBus eventBus, V view, Proxy_ proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy);

    // getView().setUiHandlers(this);

    this.placeManager = placeManager;
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  public PlaceManager getPlaceManager() {
    return placeManager;
  }

  public void onOkButtonClicked() {

    Log.warn("Don't forget to @Override onOkButtonClicked()");

    // For example:
    // PlaceRequest placeRequest = new PlaceRequest(NameTokens.mainPage);
    // placeManager.revealPlace(placeRequest);
  }
}
