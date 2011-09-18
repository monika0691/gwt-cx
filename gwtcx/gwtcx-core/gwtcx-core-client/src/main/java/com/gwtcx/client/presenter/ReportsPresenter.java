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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.smartgwt.view.handlers.ReportsUiHandlers;
import com.gwtcx.client.smartgwt.widgets.grid.ReportsRecord;
import com.gwtplatform.dispatch.client.DispatchAsync;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

public abstract class ReportsPresenter<V extends View, Proxy_ extends Proxy<?>> extends
    PagingPresenter<V, Proxy_> implements ReportsUiHandlers {

  @Inject
  public ReportsPresenter(EventBus eventBus, V view, Proxy_ proxy,
      DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy, dispatcher, placeManager);

    // getView().setUiHandlers(this);
  }

  @Override
  protected void revealInParent() {

    Log.warn("Don't forget to @Override revealInParent()");

    // For example:
    // RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  @Override
  protected void retrieveResultSet() { }

  @Override
  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();
  }

  @Override
  public void onResultSetPreviousButtonClicked() {
    super.resultSetPreviousButtonClicked();
  }

  @Override
  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();
  }

  @Override
  public void onNewButtonClicked() {
  }

  @Override
  public void onDeleteButtonClicked(String accountId) {
  }

  @Override
  public void onRefreshButtonClicked() {
    super.refreshButtonClicked();
  }

  public static final String DEFAULT_REPORTS_SERVICE_PATH = "reports/";
  private static final String HOST_FILENAME = "Reports.html";
  private static final String NAME = "_blank";
  private static final String FEATURES = "width=760, height=480";

  @Override
  public void onRecordDoubleClicked(String reportFilename) {

    StringBuilder url = new StringBuilder();
    url.append(DEFAULT_REPORTS_SERVICE_PATH).append(HOST_FILENAME).append("?");

    String arg0Name = URL.encodeQueryString(ReportsRecord.REPORT_FILENAME);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(reportFilename);
    url.append(arg0Value);
    // url.append(encodeBase64(arg0Value));

    // Log.debug("Window.open() RelativeURL: " + Serendipity.getRelativeURL(url.toString()));
    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, FEATURES);
  }
}