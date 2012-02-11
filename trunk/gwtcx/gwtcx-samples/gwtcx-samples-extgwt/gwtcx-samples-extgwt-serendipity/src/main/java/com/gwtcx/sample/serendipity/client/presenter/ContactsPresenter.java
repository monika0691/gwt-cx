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
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.presenter.AbstractContactsPresenter;
import com.gwtcx.client.uihandlers.ContactsUiHandlers;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ContactsPresenter extends
    AbstractContactsPresenter<ContactsPresenter.MyView, ContactsPresenter.MyProxy> implements
  ContactsUiHandlers {

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.contacts)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ContactsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ContactsUiHandlers> {
  }

  @Inject
  public ContactsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {

    Log.debug("revealInParent() - " + NameTokens.contacts);

    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal() - " + NameTokens.contacts);

    NavigationPaneUpdateEvent.fire(getEventBus(), NameTokens.contacts, ExtGwtCx.getConstant().contactsMenuItemName());
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset() - " + NameTokens.contacts);
  }

  @Override
  protected void retrieveResultSet() {

  }

  @Override
  public void onNewButtonClicked() {

    Log.debug("onNewButtonClicked()");
    // newContact();
  }

  @Override
  public void onDeleteButtonClicked(String accountId) {

  }

  @Override
  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();

    // getView().getStatusBar().getResultSetFirstButton().disable();
  }

  @Override
  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();

    // getView().getStatusBar().getResultSetFirstButton().enable();
    // getView().getStatusBar().getResultSetPreviousButton().enable();
  }
}
