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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.sample.basic.client.view.ResponsePageUiHandlers;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class ResponsePagePresenter extends
    Presenter<ResponsePagePresenter.MyView, ResponsePagePresenter.MyProxy> implements ResponsePageUiHandlers {

  public static final String nameToken = "response";
  public static final String textToServerParam = "textToServer";

  private static PlaceManager placeManager = null;

  private final DispatchAsync dispatcher;
  // private final PlaceManager placeManager;

  private String textToServer;

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(nameToken)
  public interface MyProxy extends Proxy<ResponsePagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ResponsePageUiHandlers> {
    // void setServerResponse(String serverResponse);
    // void setTextToServer(String textToServer);
  }

  private final ResponseDialogPresenterWidget dialogBox;

  @Inject
  public ResponsePagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placer, DispatchAsync dispatcher, final ResponseDialogPresenterWidget dialogBox) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    // this.placeManager = placeManager;
    placeManager = placer;
    this.dispatcher = dispatcher;

    this.dialogBox = dialogBox;
  }

  @Override
  public void prepareFromRequest(PlaceRequest request) {
    super.prepareFromRequest(request);

    textToServer = request.getParameter(textToServerParam, null);
  }

  @Override
  protected void onBind() {
    super.onBind();

    Log.debug("onBind()");
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");

    // dialogBox.getWidget().setVisible(true);
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  public void showResponseDialogBox() {

    Log.debug("showResponseDialogBox()");

    addToPopupSlot(dialogBox);
  }

  public void onCloseButtonClicked() {
    getPlaceManager().revealPlace(new PlaceRequest(NameTokens.mainPage));
  }

  public static void closeButtonClicked() {
    placeManager.revealPlace(new PlaceRequest(NameTokens.mainPage));
  }

  protected DispatchAsync getDispatcher()  {
    return dispatcher;
  }

  protected PlaceManager getPlaceManager()  {
    return placeManager;
  }
}

/*


    getView().setTextToServer(textToServer);
    getView().setServerResponse("Waiting for response...");

    getDispatcher().execute(new SendTextToServer(textToServer),
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


*/
