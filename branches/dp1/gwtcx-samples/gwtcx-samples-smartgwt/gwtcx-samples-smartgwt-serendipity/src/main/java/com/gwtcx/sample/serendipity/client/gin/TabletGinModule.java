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

import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SignInPagePresenter;
import com.gwtcx.sample.serendipity.client.view.tablet.DashboardsTabletView;
import com.gwtcx.sample.serendipity.client.view.tablet.SignInPageTabletView;
import com.gwtcx.smartgwt.client.view.SignInPageView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TabletGinModule  extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Presenters
    //

    // Sign In
    bindPresenter(SignInPagePresenter.class, SignInPageView.class,
        SignInPageTabletView.class, SignInPagePresenter.MyProxy.class);

    bindPresenter(DashboardsPresenter.class, DashboardsPresenter.MyView.class,
        DashboardsTabletView.class, DashboardsPresenter.MyProxy.class);

  }
}
