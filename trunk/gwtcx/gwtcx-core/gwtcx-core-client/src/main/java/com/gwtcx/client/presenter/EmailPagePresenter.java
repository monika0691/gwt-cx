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

package com.gwtcx.client.presenter;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.uihandlers.EmailPageUiHandlers;
// import com.gwtcx.client.smartgwt.widgets.EntityMasthead;
// import com.gwtcx.client.smartgwt.widgets.toolbar.EntityToolBar;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class EmailPagePresenter extends
    Presenter<EmailPagePresenter.MyView, EmailPagePresenter.MyProxy> implements
  EmailPageUiHandlers {

  private final PlaceManager placeManager;

  // private static EntityToolBar toolBar;
  // private static EntityMasthead masthead;

  //
  // don't forget to update your Ginjector & ClientModule
  //
  @ProxyStandard
  @NameToken(NameTokens.emailPage)
  public interface MyProxy extends Proxy<EmailPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<EmailPageUiHandlers> {
    // EntityToolBar getToolBar();
    // EntityMasthead getMasthead();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public EmailPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    this.placeManager = placeManager;

    // EmailPagePresenter.toolBar = getView().getToolBar();
    // EmailPagePresenter.masthead = getView().getMasthead();
  }

  @Override
  protected void onBind() {
    super.onBind();

    // reveal the first nested Presenter
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.emailInformation);
    placeManager.revealPlace(placeRequest);
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  /*

  public static EntityToolBar getToolBar() {
    return toolBar;
  }

  public static EntityMasthead getMasthead() {
    return masthead;
  }

  */
}
