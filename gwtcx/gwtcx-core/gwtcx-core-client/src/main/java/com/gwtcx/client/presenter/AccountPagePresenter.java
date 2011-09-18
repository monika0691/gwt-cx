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

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.smartgwt.view.handlers.AccountPageUiHandlers;
import com.gwtcx.client.smartgwt.widgets.EntityMasthead;
import com.gwtcx.client.smartgwt.widgets.NavigationPane;
import com.gwtcx.client.smartgwt.widgets.toolbar.EntityToolBar;
import com.gwtcx.client.util.I18nUtil;
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

public class AccountPagePresenter extends
    Presenter<AccountPagePresenter.MyView, AccountPagePresenter.MyProxy> implements
  AccountPageUiHandlers {

  private final PlaceManager placeManager;

  private static EntityMasthead masthead;
  private static NavigationPane navigationPane;
  private static EntityToolBar toolBar;

  // don't forget to update SerendipityGinjector & ClientModule
  @ProxyStandard
  @NameToken(NameTokens.accountPage)
  // @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends Proxy<AccountPagePresenter>, Place {
  }

  public interface MyView extends View, HasUiHandlers<AccountPageUiHandlers> {
    EntityToolBar getToolBar();
    EntityMasthead getMasthead();
    NavigationPane getNavigationPane();
  }

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  @Inject
  public AccountPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy);

    getView().setUiHandlers(this);

    this.placeManager = placeManager;

    AccountPagePresenter.toolBar = getView().getToolBar();
    AccountPagePresenter.masthead = getView().getMasthead();
    AccountPagePresenter.navigationPane = getView().getNavigationPane();
  }

  @Override
  protected void onBind() {
    super.onBind();

    // expand the first Navigation Pane section
    getView().getNavigationPane().expandSection(I18nUtil.getConstant().accountDetailsStackSectionName());

    // reveal the first nested Presenter
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.accountInformation);
    // placeRequest = placeRequest.with(ACTIVITY, activity).with(ACCOUNT_ID, accountId);
    placeManager.revealPlace(placeRequest);
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
    RevealRootContentEvent.fire(this, this);
  }

  public static EntityToolBar getToolBar() {
    return toolBar;
  }

  public static EntityMasthead getMasthead() {
    return masthead;
  }

  public static NavigationPane getNavigationPane() {
    return navigationPane;
  }
}
