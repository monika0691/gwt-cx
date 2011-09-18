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

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.ErrorPagePresenter;
import com.gwtcx.client.smartgwt.view.handlers.ErrorPageUiHandlers;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class SerendipityErrorPagePresenter extends 
    ErrorPagePresenter<SerendipityErrorPagePresenter.MyView, SerendipityErrorPagePresenter.MyProxy> implements
  ErrorPageUiHandlers {

  //
  // don't forget to update your Ginjector & ClientModule
  // 
  @ProxyCodeSplit
  @NameToken(NameTokens.errorPage)
  @NoGatekeeper
  public interface MyProxy extends Proxy<SerendipityErrorPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<ErrorPageUiHandlers> {
  }

  @Inject
  public SerendipityErrorPagePresenter(EventBus eventBus, MyView view, 
        MyProxy proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);
    
    getView().setUiHandlers(this);    
  }

  @Override
  public void onOkButtonClicked() {
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.mainPage);
    getPlaceManager().revealPlace(placeRequest);
  }
}