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

import org.restlet.client.resource.Result;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.kiahu.sample.client.presenter.MainPagePresenter;
import com.kiahu.sample.client.restlet.ContactResourceProxy;
import com.sencha.gxt.widget.core.client.info.Info;

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
    // TODO: setCommonData()
    // void setCountry(EntityTypeDto country);
    // void setAddressType(EntityTypeDto addressType);
    // void setId(String id);

    void setParentCustomer(String parentCustomer);
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

  native JavaScriptObject openWindow(String url) /*-{
    return $wnd.open(url, 'blank');
  }-*/;

  @Override
  public void onParentCustomerButtonClicked() {

    Info.display("LookupField", "You clicked the lookup button.");

    getView().setParentCustomer("Kiahu Pty Limited");
  }
}


/*

  public static final int DEFAULT_MAX_RESULTS = 50;

  public static final String ID = "id";
  public static final String ACTIVITY = "activity";
  public static final String NEW = "new";
  public static final String EDIT = "edit";
  public static final String PARAMETER_SEPERATOR = "&";
  public static final String NAME = "_blank";
  public static final String FEATURES = "width=880, height=540, location=no";

  public static void openHostFile(String filename, String queryString, String id, String features) {

    StringBuilder url = new StringBuilder();
    url.append(filename).append("?");

    String arg0Name = URL.encodeQueryString(ID);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(id);
    url.append(GwtCxEntryPoint.encodeBase64(arg0Value));
    Log.debug("Window.open() arg0Value: " + arg0Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg0Value));
    url.append(PARAMETER_SEPERATOR);

    String arg1Name = URL.encodeQueryString(ACTIVITY);
    url.append(arg1Name);
    url.append("=");
    String arg1Value = URL.encodeQueryString(queryString);
    url.append(GwtCxEntryPoint.encodeBase64(arg1Value));
    Log.debug("Window.open() arg1Value: " + arg1Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg1Value));

    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, features);
  }










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



