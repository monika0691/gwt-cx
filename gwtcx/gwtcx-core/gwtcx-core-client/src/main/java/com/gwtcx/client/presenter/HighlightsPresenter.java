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

package com.gwtcx.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.smartgwt.view.handlers.HighlightsUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

// public class HighlightsPresenter extends
//     Presenter<HighlightsPresenter.MyView, HighlightsPresenter.MyProxy> {

public abstract class HighlightsPresenter<V extends View, Proxy_ extends Proxy<?>> extends
    Presenter<V, Proxy_> implements HighlightsUiHandlers {

  // private final DispatchAsync dispatcher;
  // private final PlaceManager placeManager;

  @Inject
  public HighlightsPresenter(EventBus eventBus, V view, Proxy_ proxy) {
    super(eventBus, view, proxy);
  }

  protected void retrieveResultSet() { }

  @Override
  protected void revealInParent() {

    Log.warn("Don't forget to @Override revealInParent()");

    // For example:
    // RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  /*

  protected DispatchAsync getDispatcher() {
    return dispatcher;
  }

  protected PlaceManager getPlaceManager() {
    return placeManager;
  }

  */
}
