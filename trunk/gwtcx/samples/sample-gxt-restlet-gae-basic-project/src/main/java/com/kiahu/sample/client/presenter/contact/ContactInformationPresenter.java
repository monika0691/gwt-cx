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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtcx.shared.dto.CountriesDto;
// import com.gwtcx.shared.dto.ContactsRepresentation;
import com.kiahu.sample.client.presenter.MainPagePresenter;
import com.kiahu.sample.client.restlet.ContactResourceProxy;
import org.restlet.client.resource.Result;

public class ContactInformationPresenter extends
    Presenter<ContactInformationPresenter.MyView, ContactInformationPresenter.MyProxy> implements
  ContactInformationUiHandlers {

  public static final String ID = "id";
  public static final String ACTIVITY = "activity";
  public static final String EDIT = "edit";

  private String activity;
  private String id;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  // @NameToken(NameTokens.contactInformation)
  @NameToken(NameTokens.queues)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<ContactInformationPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ContactInformationUiHandlers> {
    void setResult(ContactRepresentation contact);
    // void setResult(CountriesDto countries);
    // void setResult(AddressTypesDto addresses);

    // void setId(String id);
  }

  @Inject
  public ContactInformationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);
  }

  @Override
  protected void onBind() {
    super.onBind();

    // activity = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ACTIVITY));
    // id = GwtCxEntryPoint.decodeBase64(Window.Location.getParameter(ID));

    activity = EDIT;
    id = "3";

    Log.debug("Activity: " + activity + " id: " + id);

    if (activity.equals(EDIT)) {
      try {
        retrieveContact(id);
      }
      catch (Exception e) {
        Log.warn("Unable to retrieve contact: " + e);
      }
    }
  }

  @Override
  protected void revealInParent() {
    // RevealContentEvent.fire(this, ContactPagePresenter.TYPE_SetContextAreaContent, this);

    Log.debug("revealInParent() - " + NameTokens.queues);

    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal() - " + NameTokens.contactInformation);

    // NavigationPaneUpdateEvent.fire(getEventBus(), NameTokens.contactInformation, "");
    NavigationPaneUpdateEvent.fire(getEventBus(), NameTokens.queues, "");
  }

  // public void createOrUpdateAccount(AccountDto accountDto) { }

  // public void createAccount(AccountDto accountDto) { }

  // public void updateAccount(AccountDto accountDto) { }

  // private static final String urlPattern = "/RESTfulAPI/1.0/*";
  private static final String contactsPath = "/RESTfulAPI/1.0/contacts";
  // private static final String contactPath = contactsPath + "/{id}";

  protected void retrieveContact(String id) {

    Log.debug("retrieveContact()");

    // Remotely retrieve the contact in GWT serialization format
    ContactResourceProxy client = GWT.create(ContactResourceProxy.class);
    client.getClientResource().setReference(contactsPath + "/" + id);
    client.retrieve(new Result<ContactRepresentation>() {

      @Override
      public void onSuccess(ContactRepresentation result) {

        Log.debug("onSuccess()");

        getView().setResult(result);
      }

      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }
    });

  }

}


/*


  // Remotely retrieve the contacts list in GWT serialization format
  ContactResourceProxy client = GWT.create(ContactResourceProxy.class);
  client.getClientResource().setReference(contactsPath);
  client.retrieve(new Result<ContactsRepresentation>() {

    @Override
    public void onSuccess(ContactsRepresentation result) {

      Log.debug("onSuccess()");

      getView().setResultSet(result.getContacts());
    }

    @Override
    public void onFailure(Throwable caught) {
      Log.debug("onFailure() - " + caught.getLocalizedMessage());
    }
  });



public void onSaveButtonClicked(AccountDto accountDto) {
  createOrUpdateAccount(accountDto);
}

public void onSaveAndCloseButtonClicked(AccountDto accountDto) {
  createOrUpdateAccount(accountDto);
  close();
}

public void createOrUpdateAccount(AccountDto accountDto) {

  if (Long.parseLong(accountDto.getAccountId()) == -1) {
    createAccount(accountDto);
  } else {
    updateAccount(accountDto);
  }
}

public void createAccount(AccountDto accountDto) {

  dispatcher.execute(new CreateAccountAction(accountDto),
      new AsyncCallback<CreateAccountResult>() {
    @Override
    public void onFailure(Throwable caught) {
      Log.debug("onFailure() - " + caught.getLocalizedMessage());
    }

    @Override
    public void onSuccess(CreateAccountResult result) {
      Log.debug("onSuccess() - accountId: " + result.getId());
      getView().setAccountId(result.getId());
    }
  });
}

public void updateAccount(AccountDto accountDto) {

  dispatcher.execute(new UpdateAccountAction(accountDto),
      new AsyncCallback<UpdateAccountResult>() {
    @Override
    public void onFailure(Throwable caught) {
      Log.debug("onFailure() - " + caught.getLocalizedMessage());
    }

    @Override
    public void onSuccess(UpdateAccountResult result) {
      Log.debug("onSuccess()");
    }
  });
}

protected void retrieveAccount(Long accountId) {

  dispatcher.execute(new RetrieveAccountAction(Long.toString(accountId)),
      new AsyncCallback<RetrieveAccountResult>() {
    @Override
    public void onFailure(Throwable caught) {
      Log.debug("onFailure() - " + caught.getLocalizedMessage());
    }

    @Override
    public void onSuccess(RetrieveAccountResult result) {
      Log.debug("onSuccess()");
      getView().setResultSet(result.getDto());
    }
  });
}

*/



