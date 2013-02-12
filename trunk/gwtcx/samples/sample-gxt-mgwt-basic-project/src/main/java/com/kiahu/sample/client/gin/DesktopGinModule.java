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

import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.presenter.ContactPagePresenter;
import com.gwtcx.extgwt.client.desktop.contact.view.ContactInformationTabbedFormDesktopView;
import com.gwtcx.extgwt.client.desktop.contact.view.ContactPageDesktopView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.kiahu.sample.client.presenter.AccountsPresenter;
import com.kiahu.sample.client.presenter.ActivitiesPresenter;
import com.kiahu.sample.client.presenter.AdministrationPresenter;
import com.kiahu.sample.client.presenter.CalendarPresenter;
import com.kiahu.sample.client.presenter.ContactsPresenter;
import com.kiahu.sample.client.presenter.DashboardsPresenter;
import com.kiahu.sample.client.presenter.DataManagementPresenter;
import com.kiahu.sample.client.presenter.ErrorPagePresenter;
import com.kiahu.sample.client.presenter.HighlightsPresenter;
import com.kiahu.sample.client.presenter.ImportsPresenter;
import com.kiahu.sample.client.presenter.MainPagePresenter;
import com.kiahu.sample.client.presenter.ReportsPresenter;
import com.kiahu.sample.client.view.desktop.AccountsDesktopView;
import com.kiahu.sample.client.view.desktop.ActivitiesDesktopView;
import com.kiahu.sample.client.view.desktop.AdministrationDesktopView;
import com.kiahu.sample.client.view.desktop.CalendarDesktopView;
import com.kiahu.sample.client.view.desktop.ContactsDesktopView;
import com.kiahu.sample.client.view.desktop.DashboardsDesktopView;
import com.kiahu.sample.client.view.desktop.DataManagementDesktopView;
import com.kiahu.sample.client.view.desktop.ErrorPageDesktopView;
import com.kiahu.sample.client.view.desktop.HighlightsDesktopView;
import com.kiahu.sample.client.view.desktop.ImportsDesktopView;
import com.kiahu.sample.client.view.desktop.MainPageDesktopView;
import com.kiahu.sample.client.view.desktop.ReportsDesktopView;

public class DesktopGinModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Presenters
    //

    // Main Page - index.html
    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageDesktopView.class, MainPagePresenter.MyProxy.class);

    // Contact Page - contact.html
    bindPresenter(ContactPagePresenter.class, ContactPagePresenter.MyView.class,
        ContactPageDesktopView.class, ContactPagePresenter.MyProxy.class);

    // Error Page
    bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
        ErrorPageDesktopView.class, ErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class,
        ActivitiesDesktopView.class, ActivitiesPresenter.MyProxy.class);
    bindPresenter(CalendarPresenter.class, CalendarPresenter.MyView.class,
        CalendarDesktopView.class, CalendarPresenter.MyProxy.class);
    bindPresenter(DashboardsPresenter.class, DashboardsPresenter.MyView.class,
        DashboardsDesktopView.class, DashboardsPresenter.MyProxy.class);
    bindPresenter(ImportsPresenter.class, ImportsPresenter.MyView.class,
        ImportsDesktopView.class, ImportsPresenter.MyProxy.class);
    bindPresenter(AccountsPresenter.class, AccountsPresenter.MyView.class,
        AccountsDesktopView.class, AccountsPresenter.MyProxy.class);
    bindPresenter(ContactsPresenter.class, ContactsPresenter.MyView.class,
        ContactsDesktopView.class, ContactsPresenter.MyProxy.class);
    bindPresenter(ReportsPresenter.class, ReportsPresenter.MyView.class,
       ReportsDesktopView.class, ReportsPresenter.MyProxy.class);

    bindPresenter(ContactInformationPresenter.class, ContactInformationPresenter.MyView.class,
      ContactInformationTabbedFormDesktopView.class, ContactInformationPresenter.MyProxy.class);

    // Settings
    bindPresenter(AdministrationPresenter.class, AdministrationPresenter.MyView.class,
       AdministrationDesktopView.class, AdministrationPresenter.MyProxy.class);
    bindPresenter(DataManagementPresenter.class, DataManagementPresenter.MyView.class,
       DataManagementDesktopView.class, DataManagementPresenter.MyProxy.class);

    // Resource Centre
    bindPresenter(HighlightsPresenter.class, HighlightsPresenter.MyView.class,
        HighlightsDesktopView.class, HighlightsPresenter.MyProxy.class);
  }
}

/*

    //
    // Presenters
    //

    // Main Page - index.html
    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageDesktopView.class, MainPagePresenter.MyProxy.class);
    bindPresenter(MainPageTabletPresenter.class, MainPageTabletPresenter.MyView.class,
        MainPageTabletView.class, MainPageTabletPresenter.MyProxy.class);

    // Contact Page - contact.html
    bindPresenter(ContactPagePresenter.class, ContactPagePresenter.MyView.class,
        ContactPageDesktopView.class, ContactPagePresenter.MyProxy.class);

    // Error Page
    bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
        ErrorPageDesktopView.class, ErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class,
        ActivitiesDesktopView.class, ActivitiesPresenter.MyProxy.class);
    bindPresenter(CalendarPresenter.class, CalendarPresenter.MyView.class,
        CalendarDesktopView.class, CalendarPresenter.MyProxy.class);
    bindPresenter(DashboardsPresenter.class, DashboardsPresenter.MyView.class,
        DashboardsDesktopView.class, DashboardsPresenter.MyProxy.class);
    bindPresenter(ImportsPresenter.class, ImportsPresenter.MyView.class,
        ImportsDesktopView.class, ImportsPresenter.MyProxy.class);
    bindPresenter(AccountsPresenter.class, AccountsPresenter.MyView.class,
        AccountsDesktopView.class, AccountsPresenter.MyProxy.class);
    bindPresenter(ContactsPresenter.class, ContactsPresenter.MyView.class,
        ContactsDesktopView.class, ContactsPresenter.MyProxy.class);
    bindPresenter(ReportsPresenter.class, ReportsPresenter.MyView.class,
       ReportsDesktopView.class, ReportsPresenter.MyProxy.class);

    bindPresenter(ContactInformationPresenter.class, ContactInformationPresenter.MyView.class,
      ContactInformationTabbedFormDesktopView.class, ContactInformationPresenter.MyProxy.class);

    // Settings
    bindPresenter(AdministrationPresenter.class, AdministrationPresenter.MyView.class,
       AdministrationDesktopView.class, AdministrationPresenter.MyProxy.class);
    bindPresenter(DataManagementPresenter.class, DataManagementPresenter.MyView.class,
       DataManagementDesktopView.class, DataManagementPresenter.MyProxy.class);

    // Resource Centre
    bindPresenter(HighlightsPresenter.class, HighlightsPresenter.MyView.class,
        HighlightsDesktopView.class, HighlightsPresenter.MyProxy.class);



*/

