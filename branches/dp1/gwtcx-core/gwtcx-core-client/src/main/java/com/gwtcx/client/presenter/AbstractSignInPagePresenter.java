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
import com.gwtcx.client.uihandlers.SignInPageUiHandlers;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public abstract class AbstractSignInPagePresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> implements SignInPageUiHandlers {

  public static final String REDIRECT = "redirect";

  // private final EventBus eventBus;
  private final DispatchAsync dispatcher;
  private final PlaceManager placeManager;

  @Inject
  public AbstractSignInPagePresenter(EventBus eventBus, V view, Proxy_ proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy);

    // getView().setUiHandlers(this);

    // this.eventBus = eventBus;
    this.dispatcher = dispatcher;
    this.placeManager = placeManager;
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
 }

  @Override
  public void onSignInButtonClicked() {
    sendCredentialsToServer();
  }

  protected void sendCredentialsToServer() {
    Log.warn("Don't forget to @Override sendCredentialsToServer()");
  }

  protected DispatchAsync getDispatcher() {
    return dispatcher;
  }

  protected PlaceManager getPlaceManager()  {
    return placeManager;
  }
}

/*

  // String salt = Security.randomCharString();
  // String hash = Security.sha256(password);

  Log.debug("login: " + login + ", password: " + password);

  In JavaScript. most of the Java produced exceptions (such as NullPointerException or
  MemoryOverflowException) are replaced by JavaScriptException.

  This means that when running in development mode, a NullPointerException will be thrown,
  so you will need to catch (NullPointerException) but in compiled mode, you need to
  catch (JavaScriptException).

  catch (Exception e) {
    if (e instanceof JavaScriptException) {
      Log.warn("JavaScriptException - ", e);
    } else if (e instanceof NullPointerException) {
      Log.warn("NullPointerException", e);
    }
  }

*/
