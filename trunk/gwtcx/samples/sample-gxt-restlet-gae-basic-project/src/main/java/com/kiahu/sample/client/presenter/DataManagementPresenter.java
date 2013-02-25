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

package com.kiahu.sample.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.presenter.AbstractDataManagementPresenter;
import com.gwtcx.client.uihandlers.DataManagementUiHandlers;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class DataManagementPresenter extends
    AbstractDataManagementPresenter<DataManagementPresenter.MyView, DataManagementPresenter.MyProxy> implements
  DataManagementUiHandlers {

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.dataManagement)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  // @UseGatekeeper(AdminGatekeeper.class)
  public interface MyProxy extends Proxy<DataManagementPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<DataManagementUiHandlers> {
  }

  @Inject
  public DataManagementPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {

    Log.debug("revealInParent() - " + NameTokens.dataManagement);

    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    Log.debug("onReveal() - " + NameTokens.dataManagement);

    NavigationPaneUpdateEvent.fire(this.getEventBus(), NameTokens.dataManagement, ExtGwtCx.getConstant().dataManagementMenuItemName());
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");
  }
}