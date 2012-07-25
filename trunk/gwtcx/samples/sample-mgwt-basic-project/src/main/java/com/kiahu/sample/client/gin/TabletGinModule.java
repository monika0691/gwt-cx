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

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.kiahu.sample.client.presenter.tablet.AboutPresenter;
import com.kiahu.sample.client.presenter.tablet.AnimationsPresenter;
import com.kiahu.sample.client.presenter.tablet.MainPageTabletPresenter;
import com.kiahu.sample.client.presenter.tablet.SlidePresenter;
import com.kiahu.sample.client.presenter.tablet.UiPresenter;
import com.kiahu.sample.client.view.tablet.AboutView;
import com.kiahu.sample.client.view.tablet.AnimationsView;
import com.kiahu.sample.client.view.tablet.MainPageTabletView;
import com.kiahu.sample.client.view.tablet.SlideView;
import com.kiahu.sample.client.view.tablet.UiView;

public class TabletGinModule  extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Presenters
    //

    // Main Page - index.html
    bindPresenter(MainPageTabletPresenter.class, MainPageTabletPresenter.MyView.class,
        MainPageTabletView.class, MainPageTabletPresenter.MyProxy.class);

    // Error Page
    // bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
    //     ErrorPageDesktopView.class, ErrorPagePresenter.MyProxy.class);

    bindPresenter(AnimationsPresenter.class, AnimationsPresenter.MyView.class,
        AnimationsView.class, AnimationsPresenter.MyProxy.class);
    bindPresenter(SlidePresenter.class, SlidePresenter.MyView.class,
            SlideView.class, SlidePresenter.MyProxy.class);

    bindPresenter(AboutPresenter.class, AboutPresenter.MyView.class,
        AboutView.class, AboutPresenter.MyProxy.class);

    bindPresenter(UiPresenter.class, UiPresenter.MyView.class,
        UiView.class, UiPresenter.MyProxy.class);

  }
}
