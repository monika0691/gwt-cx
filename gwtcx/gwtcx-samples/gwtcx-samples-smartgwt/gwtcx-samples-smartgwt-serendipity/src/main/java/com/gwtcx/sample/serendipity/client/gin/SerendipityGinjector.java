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

package com.gwtcx.sample.serendipity.client.gin;

// import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtcx.client.presenter.AccountInformationPresenter;
import com.gwtcx.client.presenter.AccountPagePresenter;
import com.gwtcx.client.presenter.AdminGatekeeper;
import com.gwtcx.client.presenter.EmailInformationPresenter;
import com.gwtcx.client.presenter.EmailPagePresenter;
import com.gwtcx.client.presenter.FileUploadPagePresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.sample.serendipity.client.presenter.AccountsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ActivitiesPresenter;
import com.gwtcx.sample.serendipity.client.presenter.AdministrationPresenter;
import com.gwtcx.sample.serendipity.client.presenter.CalendarPresenter;
import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ErrorPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.HighlightsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ImportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.ReportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SignInPagePresenter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public interface SerendipityGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();
  // Resources getResources();
  // DispatchAsync getDispatcher();
  // ProxyFailureHandler getProxyFailureHandler();
  // CurrentUser getCurrentUser();
  // Translations getTranslations();

  LoggedInGatekeeper getLoggedInGatekeeper();
  AdminGatekeeper    getAdminGatekeeper();

  // Sign In
  Provider<SignInPagePresenter> getSignInPagePresenter();

  // Main Page(s)
  AsyncProvider<MainPagePresenter> getSerendipityMainPagePresenter();

  Provider<AccountPagePresenter> getAccountPagePresenter();
  Provider<FileUploadPagePresenter> getFileUploadPagePresenter();
  Provider<EmailPagePresenter> getEmailPagePresenter();

  // Error Page
  AsyncProvider<ErrorPagePresenter> getErrorPagePresenter();

  // Sales
  AsyncProvider<ActivitiesPresenter> getActivitiesPresenter();
  AsyncProvider<CalendarPresenter> getCalendarPresenter();
  AsyncProvider<DashboardsPresenter> getDashboardsPresenter();
  AsyncProvider<ImportsPresenter> getImportsPresenter();
  AsyncProvider<AccountsPresenter> getAccountsPresenter();
  AsyncProvider<ReportsPresenter> getReportsPresenter();

  AsyncProvider<AccountInformationPresenter> getAccountInformationPresenter();
  AsyncProvider<EmailInformationPresenter> getEmailInformationPresenter();

  // Settings
  AsyncProvider<AdministrationPresenter> getAdministrationPresenter();

  // Resource Centre
  AsyncProvider<HighlightsPresenter> getHighlightsPresenter();

  // @deprecated -> ProxyFailureHandler getProxyFailureHandler();
  // see AsyncCallFailEvent
}
