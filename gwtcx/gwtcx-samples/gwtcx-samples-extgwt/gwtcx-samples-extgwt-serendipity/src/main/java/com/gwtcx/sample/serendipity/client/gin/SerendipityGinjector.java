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

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.presenter.ContactPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.AccountsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ActivitiesPresenter;
import com.gwtcx.sample.serendipity.client.presenter.AdministrationPresenter;
import com.gwtcx.sample.serendipity.client.presenter.CalendarPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ContactsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.DataManagementPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ErrorPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.HighlightsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ImportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.ReportsPresenter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public interface SerendipityGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();

  // LoggedInGatekeeper getLoggedInGatekeeper();
  // AdminGatekeeper    getAdminGatekeeper();

  // Sign In
  // Provider<SignInPagePresenter> getSignInPagePresenter();

  // Main Page(s)
  // AsyncProvider<MainPagePresenter> getMainPagePresenter();
  Provider<MainPagePresenter> getMainPagePresenter();

  Provider<ContactPagePresenter> getContactPagePresenter();

  // Error Page
  AsyncProvider<ErrorPagePresenter> getErrorPagePresenter();

  // Sales
  AsyncProvider<ActivitiesPresenter> getActivitiesPresenter();
  AsyncProvider<CalendarPresenter> getCalendarPresenter();
  AsyncProvider<DashboardsPresenter> getDashboardsPresenter();
  AsyncProvider<ImportsPresenter> getImportsPresenter();
  AsyncProvider<AccountsPresenter> getAccountsPresenter();
  AsyncProvider<ContactsPresenter> getContactsPresenter();
  AsyncProvider<ReportsPresenter> getReportsPresenter();

  // AsyncProvider<AccountInformationPresenter> getAccountInformationPresenter();
  // AsyncProvider<EmailInformationPresenter> getEmailInformationPresenter();

  AsyncProvider<ContactInformationPresenter> getContactInformationPresenter();

  // Settings
  AsyncProvider<AdministrationPresenter> getAdministrationPresenter();
  AsyncProvider<DataManagementPresenter> getDataManagementPresenter();

  // Resource Centre
  AsyncProvider<HighlightsPresenter> getHighlightsPresenter();

}