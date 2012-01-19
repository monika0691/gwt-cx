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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.uihandlers.EmailInformationUiHandlers;
import com.gwtcx.shared.action.SendEmailAction;
import com.gwtcx.shared.action.SendEmailResult;
import com.gwtcx.shared.dto.EmailDto;
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

public class EmailInformationPresenter extends
    Presenter<EmailInformationPresenter.MyView, EmailInformationPresenter.MyProxy> implements
  com.gwtcx.client.uihandlers.EmailInformationUiHandlers {

  private final DispatchAsync dispatcher;

  @ProxyCodeSplit
  @NameToken(NameTokens.emailInformation)
  public interface MyProxy extends Proxy<EmailInformationPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<EmailInformationUiHandlers> {
    void setResultSet(EmailDto dto);
    void setId(Long id);
  }

  @Inject
  public EmailInformationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager, DispatchAsync dispatcher) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    this.dispatcher = dispatcher;
  }

  @Override
  protected void onBind() {
    super.onBind();

  }

  @Override
  protected void onReveal() {
    super.onReveal();

  }

  @Override
  protected void onReset() {
    super.onReset();

  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, EmailPagePresenter.TYPE_SetContextAreaContent, this);
  }

  public void onSaveButtonClicked(EmailDto dto) {
    createOrUpdateEmail(dto);
  }


  public void onSaveAndCloseButtonClicked(EmailDto dto) {
    createOrUpdateEmail(dto);
    close();
  }

  @Override
  public void onEmailButtonClicked(EmailDto dto) {
    createOrUpdateEmail(dto);
    // sendEmail(dto); // commented out for DEMO
    // close();
  }

  public static native void close() /*-{ $wnd.close(); }-*/;

  public void createOrUpdateEmail(EmailDto dto) {

    if (Long.parseLong(dto.getEmailId()) == -1) {
      createEmail(dto);
    } else {
      updateEmail(dto);
    }
  }

  public void createEmail(EmailDto dto) {

  }

  public void updateEmail(EmailDto dto) {

  }

  protected void retrieveEmail(Long id) {

  }

  public void sendEmail(EmailDto dto) {

    dispatcher.execute(new SendEmailAction(dto),
        new AsyncCallback<SendEmailResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Log.debug("onFailure() - " + caught.getLocalizedMessage());
      }

      @Override
      public void onSuccess(SendEmailResult result) {
        // Log.debug("onSuccess() - accountId: " + result.getId());
        // getView().setId(result.getId());
        Log.debug("onSuccess()");
        close();
      }
    });
  }
}
