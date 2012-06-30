/**
 * (C) Copyright 2012 Kiahu
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

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.event.NavigationPaneUpdateEvent;
import com.gwtcx.client.presenter.AbstractHighlightsPresenter;
import com.gwtcx.client.uihandlers.HighlightsUiHandlers;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class HighlightsPresenter extends
    AbstractHighlightsPresenter<HighlightsPresenter.MyView, HighlightsPresenter.MyProxy> implements
  HighlightsUiHandlers {

  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.highlights)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<HighlightsPresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<HighlightsUiHandlers> {
    // void setResultSet();
  }

  @Inject
  public HighlightsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void onReveal() {
    super.onReveal();
    NavigationPaneUpdateEvent.fire(getEventBus(), NameTokens.highlights, ExtGwtCx.getConstant().highlightsMenuItemName());
  }
}