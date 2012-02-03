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

// import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public abstract class AbstractMainPagePresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> implements MainPageUiHandlers {

  private final PlaceManager placeManager;

  // public static NavigationPaneHeader navigationPaneHeader = null;
  // public static NavigationPane navigationPane = null;

  @Inject
  public AbstractMainPagePresenter(EventBus eventBus, V view, Proxy_ proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy);

    // getView().setUiHandlers(this);

    this.placeManager = placeManager;

    // MainPagePresenter.navigationPaneHeader = getView().getNavigationPaneHeader();
    // MainPagePresenter.navigationPane = getView().getNavigationPane();
  }

  @Override
  protected void onBind() {
    super.onBind();

    // Log.debug("onBind()");

    // expand the first Navigation Pane section
    // getView().getNavigationPane().expandSection(I18nUtil.getConstant().salesStackSectionName());

    // reveal the first nested Presenter
    // PlaceRequest placRequest = new PlaceRequest(NameTokens.activities);
    // placeManager.revealPlace(placRequest);
  }

  @Override
  protected void onReveal() {
    super.onReveal();

    // Log.debug("onReveal()");
  }

  @Override
  protected void onReset() {
    super.onReset();

    // Log.debug("onReset()");
  }

  @Override
  protected void revealInParent() {

    // Log.debug("revealInParent()");

    RevealRootContentEvent.fire(this, this);
  }

  protected void navigationPaneClicked(String place) {
    if (place.length() != 0) {
      PlaceRequest placeRequest = new PlaceRequest(place);
      getPlaceManager().revealPlace(placeRequest);
    }
  }

  public void onNewActivityClicked(String place) {
    AbstractActivitiesPresenter.newActivity();
  }

  public void onNewRecordClicked(String place) {
    AbstractAccountsPresenter.newAccount();
  }

  public void onGoToMenuItemClicked(String place) {
    navigationPaneClicked(place);
  }

  public void onNavigationPaneSectionHeaderClicked(String place) {
    navigationPaneClicked(place);
  }

  public void onNavigationPaneSectionClicked(String place) {
    navigationPaneClicked(place);
  }

  public PlaceManager getPlaceManager() {
    return placeManager;
  }

  /*

  public static NavigationPaneHeader getNavigationPaneHeader() {
    return navigationPaneHeader;
  }

  public static NavigationPane getNavigationPane() {
    return navigationPane;
  }

  */
}
