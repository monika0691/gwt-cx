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

import com.kiahu.sample.client.presenter.DashboardsPresenter;
import com.kiahu.sample.client.presenter.MainPagePresenter;
import com.kiahu.sample.client.view.desktop.DashboardsDesktopView;
import com.kiahu.sample.client.view.desktop.MainPageDesktopView;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DesktopGinModule  extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Presenters
    //

    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageDesktopView.class, MainPagePresenter.MyProxy.class);

    bindPresenter(DashboardsPresenter.class, DashboardsPresenter.MyView.class,
        DashboardsDesktopView.class, DashboardsPresenter.MyProxy.class);
  }
}

