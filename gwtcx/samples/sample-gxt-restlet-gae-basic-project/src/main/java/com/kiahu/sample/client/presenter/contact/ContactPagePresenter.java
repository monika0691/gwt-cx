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

package com.kiahu.sample.client.presenter.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.AbstractContactPagePresenter;
import com.gwtcx.client.uihandlers.ContactPageUiHandlers;
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
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;


public class ContactPagePresenter extends
    AbstractContactPagePresenter<ContactPagePresenter.MyView, ContactPagePresenter.MyProxy> implements
  ContactPageUiHandlers {

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyStandard
  @NameToken(NameTokens.contactPage)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ContactPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ContactPageUiHandlers> {
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public ContactPagePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    Log.debug("ContactPagePresenter()");

    getView().setUiHandlers(this);
  }

  @Override
  public void prepareFromRequest(PlaceRequest placeRequest) {
    super.prepareFromRequest(placeRequest);

    Log.debug("prepareFromRequest()");

    // AbstractSignInPagePresenter.REDIRECT
    String nameToken = placeRequest.getParameter("redirect", NameTokens.contactInformation);

    Log.debug("nameToken: " + nameToken);

    // reveal the nested Presenter
    PlaceRequest nestedPlaceRequest = new PlaceRequest(nameToken);
    getPlaceManager().revealPlace(nestedPlaceRequest);
  }

  @Override
  protected void revealInParent() {

    Log.debug("revealInParent() - RevealRootLayoutContentEvent.fire(this, this)");

    // RevealRootContentEvent.fire(this, this);
    RevealRootLayoutContentEvent.fire(this, this);
  }

  public void onSaveButtonClicked() {

    // fire event to notify the nested Presenters

  }

  public static native void close() /*-{ $wnd.close(); }-*/;

  public void onSaveAndCloseButtonClicked() {
    close();
  }
}
