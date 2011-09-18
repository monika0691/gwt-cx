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
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtcx.client.CurrentUser;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.LoginAuthenticatedEvent;
import com.gwtcx.client.presenter.SignInPagePresenter;
import com.gwtcx.client.smartgwt.view.handlers.SignInPageUiHandlers;
import com.gwtcx.shared.action.LoginAction;
import com.gwtcx.shared.action.LoginResult;
import com.gwtcx.shared.exception.LoginException;
import com.gwtplatform.dispatch.client.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class SerendipitySignInPagePresenter extends 
    SignInPagePresenter<SerendipitySignInPagePresenter.MyView, SerendipitySignInPagePresenter.MyProxy> implements
  SignInPageUiHandlers {
	
  //
  // don't forget to update your Ginjector & ClientModule
  // 
  @ProxyStandard
  @NameToken(NameTokens.signInPage)
  @NoGatekeeper
  public interface MyProxy extends Proxy<SerendipitySignInPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<SignInPageUiHandlers> {
    String getUserNameText();
    String getPasswordText();
    void resetAndFocus();
  }

  @Inject
  public SerendipitySignInPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void onReset() {
    super.onReset();

    getView().resetAndFocus();
  }
  
  @Override
  protected void sendCredentialsToServer() {
	  
    String login = getView().getUserNameText();
    String password = getView().getPasswordText();

    getDispatcher().execute(new LoginAction(login, password),
        new AsyncCallback<LoginResult>() {
        
      @Override
      public void onFailure(Throwable caught) {
        String message = "onFailure() - " + caught.getLocalizedMessage();
        
        if (caught instanceof LoginException) {
          message = "onFailure() - " + "Invalid User name or Password.";
        }
          
        getView().resetAndFocus();
        
        Log.debug(message);
      }

      @Override
      public void onSuccess(LoginResult result) {
        CurrentUser currentUser = new CurrentUser(getView().getUserNameText());
        
        LoginAuthenticatedEvent.fire(getEventBus(), currentUser);
        
        PlaceRequest placeRequest = new PlaceRequest(NameTokens.mainPage);
        getPlaceManager().revealPlace(placeRequest);
        
        Log.debug("onSuccess() - Session Key: " + result.getSessionKey());        
      }
    });
  }
}