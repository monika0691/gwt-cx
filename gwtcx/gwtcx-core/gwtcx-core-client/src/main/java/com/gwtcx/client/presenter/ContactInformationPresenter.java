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
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ContactInformationPresenter extends
    Presenter<ContactInformationPresenter.MyView, ContactInformationPresenter.MyProxy> implements
    ContactInformationUiHandlers {

  public static final String ID = "id";

  private static final String ACTIVITY = "activity";
  private static final String EDIT = "edit";

  private final DispatchAsync dispatcher;

  private String activity;
  private String id;

  @ProxyCodeSplit
  @NameToken(NameTokens.contactInformation)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ContactInformationPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ContactInformationUiHandlers> {
    // void setResultSet(AccountDto account);
    void setId(String id);
  }

  @Inject
  public ContactInformationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager, DispatchAsync dispatcher) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    this.dispatcher = dispatcher;
  }

  @Override
  protected void onBind() {
    super.onBind();

    activity = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ACTIVITY));
    id = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ID));

    Log.debug("Activity: " + activity + " id: " + id);

    if (activity.equals(EDIT)) {

      try {
        // retrieveAccount(id);
      }
      catch (Exception e) {
        Log.warn("Unable to retrieve contact: " + e);
      }
    }
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, ContactPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal() - " + NameTokens.contactInformation);

    // NavigationPaneUpdateEvent.fire(getEventBus(), NameTokens.information, NameTokens.information);
  }

  // public void createOrUpdateAccount(AccountDto accountDto) { }

  // public void createAccount(AccountDto accountDto) { }

  // public void updateAccount(AccountDto accountDto) { }

  // protected void retrieveAccount(Long accountId) { }

  public DispatchAsync getDispatcher() {
    return dispatcher;
  }
}
