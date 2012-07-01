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

package com.kiahu.sample.client.gin;

import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.presenter.ContactPagePresenter;
import com.gwtcx.extgwt.client.view.contact.ContactInformationTabbedFormView;
import com.gwtcx.extgwt.client.view.contact.ContactPageView;
import com.kiahu.sample.client.place.DefaultPlace;
import com.kiahu.sample.client.place.BasicProjectPlaceManager;
import com.kiahu.sample.client.presenter.AccountsPresenter;
import com.kiahu.sample.client.presenter.ActivitiesPresenter;
import com.kiahu.sample.client.presenter.AdministrationPresenter;
import com.kiahu.sample.client.presenter.CalendarPresenter;
import com.kiahu.sample.client.presenter.ContactsPresenter;
import com.kiahu.sample.client.presenter.DataManagementPresenter;
import com.kiahu.sample.client.presenter.ErrorPagePresenter;
import com.kiahu.sample.client.presenter.HighlightsPresenter;
import com.kiahu.sample.client.presenter.ImportsPresenter;
import com.kiahu.sample.client.presenter.ReportsPresenter;
import com.kiahu.sample.client.view.AccountsView;
import com.kiahu.sample.client.view.ActivitiesView;
import com.kiahu.sample.client.view.AdministrationView;
import com.kiahu.sample.client.view.CalendarView;
import com.kiahu.sample.client.view.ContactsView;
import com.kiahu.sample.client.view.DataManagementView;
import com.kiahu.sample.client.view.ErrorPageView;
import com.kiahu.sample.client.view.HighlightsView;
import com.kiahu.sample.client.view.ImportsView;
import com.kiahu.sample.client.view.ReportsView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class SharedGinModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Defaults
    //

    install(new DefaultModule(BasicProjectPlaceManager.class));

    // bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    // bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    // bind(RootPresenter.class).asEagerSingleton();
    // bind(GoogleAnalytics.class).to(GoogleAnalyticsImpl.class).in(Singleton.class);
    // bind(PlaceManager.class).to(placeManagerClass).in(Singleton.class);

    //
    // Resources
    //

    // bind(SerendipityClientBundle.class).in(Singleton.class);
    // bind(Resources.class).in(Singleton.class);

    // bind(Translations.class).in(Singleton.class);
    // bind(CurrentUser.class).asEagerSingleton();

    //
    // Singletons
    //

    // bind(LoggedInGatekeeper.class).in(Singleton.class);
    // bind(AdminGatekeeper.class).in(Singleton.class);

    //
    // Constants
    //

    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    // bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);

    // Bind the Main page to the default place
    // bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signInPage);
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.mainPage);

    //
    // Presenters
    //

    // Main Pages
    // bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
    //     MainPageView.class, MainPagePresenter.MyProxy.class);
    bindPresenter(ContactPagePresenter.class, ContactPagePresenter.MyView.class,
        ContactPageView.class, ContactPagePresenter.MyProxy.class);

    // Error Page
    bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
        ErrorPageView.class, ErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class,
        ActivitiesView.class, ActivitiesPresenter.MyProxy.class);
    bindPresenter(CalendarPresenter.class, CalendarPresenter.MyView.class,
        CalendarView.class, CalendarPresenter.MyProxy.class);
    bindPresenter(ImportsPresenter.class, ImportsPresenter.MyView.class,
        ImportsView.class, ImportsPresenter.MyProxy.class);
    bindPresenter(AccountsPresenter.class, AccountsPresenter.MyView.class,
        AccountsView.class, AccountsPresenter.MyProxy.class);
    bindPresenter(ContactsPresenter.class, ContactsPresenter.MyView.class,
        ContactsView.class, ContactsPresenter.MyProxy.class);
    bindPresenter(ReportsPresenter.class, ReportsPresenter.MyView.class,
       ReportsView.class, ReportsPresenter.MyProxy.class);

    bindPresenter(ContactInformationPresenter.class, ContactInformationPresenter.MyView.class,
            ContactInformationTabbedFormView.class, ContactInformationPresenter.MyProxy.class);

    // Settings
    bindPresenter(AdministrationPresenter.class, AdministrationPresenter.MyView.class,
       AdministrationView.class, AdministrationPresenter.MyProxy.class);
    bindPresenter(DataManagementPresenter.class, DataManagementPresenter.MyView.class,
       DataManagementView.class, DataManagementPresenter.MyProxy.class);

    // Resource Centre
    bindPresenter(HighlightsPresenter.class, HighlightsPresenter.MyView.class,
        HighlightsView.class, HighlightsPresenter.MyProxy.class);

  }
}