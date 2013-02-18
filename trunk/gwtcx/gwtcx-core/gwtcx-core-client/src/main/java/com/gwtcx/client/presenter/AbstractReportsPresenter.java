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
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtcx.client.uihandlers.ReportsUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

public abstract class AbstractReportsPresenter<V extends View, Proxy_ extends Proxy<?>> extends
    AbstractPagingPresenter<V, Proxy_> implements ReportsUiHandlers {

  public static final String DEFAULT_REPORTS_SERVICE_PATH = "reports/";
  public static final String REPORT_FILENAME = "reportFilename";

  private static final String HOST_FILENAME = "reports.html";
  private static final String FEATURES = "width=760, height=480, location=no";

  @Inject
  public AbstractReportsPresenter(EventBus eventBus, V view, Proxy_ proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    Log.warn("AbstractReportsPresenter()");
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

  public void onNewButtonClicked() {
  }

  public void onDeleteButtonClicked(String accountId) {
  }

  public void onRefreshButtonClicked() {
    super.refreshButtonClicked();
  }

  public void onRecordDoubleClicked(String reportFilename) {

    StringBuilder url = new StringBuilder();
    url.append(DEFAULT_REPORTS_SERVICE_PATH).append(HOST_FILENAME).append("?");

    String arg0Name = URL.encodeQueryString(REPORT_FILENAME);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(reportFilename);
    url.append(arg0Value);

    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, FEATURES);
  }
}