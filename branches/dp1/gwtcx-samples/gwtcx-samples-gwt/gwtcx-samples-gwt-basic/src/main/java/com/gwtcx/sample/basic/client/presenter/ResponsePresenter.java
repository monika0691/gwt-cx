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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtcx.client.NameTokens;
import com.gwtcx.sample.basic.shared.SendTextToServer;
import com.gwtcx.sample.basic.shared.SendTextToServerResult;

public class ResponsePresenter extends
    Presenter<ResponsePresenter.MyView, ResponsePresenter.MyProxy> {

  public static final String nameToken = "response";
  public static final String textToServerParam = "textToServer";

  private final DispatchAsync dispatcher;
  private final PlaceManager placeManager;

  private String textToServer;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(nameToken)
  public interface MyProxy extends Proxy<ResponsePresenter>, Place {
  }

  public interface MyView extends View {
    Button getCloseButton();
    void setServerResponse(String serverResponse);
    void setTextToServer(String textToServer);
  }

  @Inject
  public ResponsePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager, DispatchAsync dispatcher) {
    super(eventBus, view, proxy);

    this.placeManager = placeManager;
    this.dispatcher = dispatcher;
  }

  @Override
  public void prepareFromRequest(PlaceRequest request) {
    super.prepareFromRequest(request);

    textToServer = request.getParameter(textToServerParam, null);
  }

  @Override
  protected void onBind() {
    super.onBind();

    registerHandler(getView().getCloseButton().addClickHandler(
        new ClickHandler() {
          @Override
          public void onClick(ClickEvent event) {
            placeManager.revealPlace(new PlaceRequest(
                    NameTokens.mainPage));
        }
    }));
  }

  @Override
  protected void onReset() {
    super.onReset();

    getView().setTextToServer(textToServer);
    getView().setServerResponse("Waiting for response...");

    dispatcher.execute(new SendTextToServer(textToServer),
        new AsyncCallback<SendTextToServerResult>() {
          @Override
          public void onFailure(Throwable caught) {
            getView().setServerResponse(
                "An error occured: " + caught.getMessage());
          }

          @Override
          public void onSuccess(SendTextToServerResult result) {
            getView().setServerResponse(result.getResponse());
          }
        });
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }
}
