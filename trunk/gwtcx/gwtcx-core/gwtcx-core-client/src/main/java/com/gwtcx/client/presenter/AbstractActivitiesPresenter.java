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

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.uihandlers.ActivitiesUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

public abstract class AbstractActivitiesPresenter<V extends View, Proxy_ extends Proxy<?>> extends
    AbstractPagingPresenter<V, Proxy_> implements ActivitiesUiHandlers {

  private static final String HOST_FILENAME = "contact.html";
  // private static final String FEATURES = "width=880, height=540, location=no";

  @Inject
  public AbstractActivitiesPresenter(EventBus eventBus, V view, Proxy_ proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    Log.warn("AbstractActivitiesPresenter()");
  }

  @Override
  protected void retrieveResultSet() { }

  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();
  }

  public void onResultSetPreviousButtonClicked() {
    super.resultSetPreviousButtonClicked();
  }

  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();
  }

  public static void newActivity() {
    // openHostFile(HOST_FILENAME, NEW, "0", FEATURES);
  }

  public void onNewButtonClicked() {
    openHostFile(HOST_FILENAME, NEW, "0", FEATURES);
  }

  public void onRecordDoubleClicked(String id) {
    openHostFile(HOST_FILENAME, EDIT, id, FEATURES);
  }

  public void onExportButtonClicked() { }

  public void onDeleteButtonClicked(String accountId) { }

  public void onRefreshButtonClicked() {
    super.refreshButtonClicked();
  }
}
