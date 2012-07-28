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
import com.kiahu.sample.client.presenter.tablet.animations.AnimationsPresenter;
import com.kiahu.sample.client.presenter.tablet.animations.DissolvePresenter;
import com.kiahu.sample.client.presenter.tablet.animations.FadePresenter;
import com.kiahu.sample.client.presenter.tablet.animations.FlipPresenter;
import com.kiahu.sample.client.presenter.tablet.animations.PopPresenter;
import com.kiahu.sample.client.presenter.tablet.animations.SlidePresenter;
import com.kiahu.sample.client.presenter.tablet.animations.SlideUpPresenter;
import com.kiahu.sample.client.presenter.tablet.animations.SwapPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ButtonBarPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ButtonsPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.CarouselPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ElementsPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.FormsPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.GroupListPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.PopupsPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ProgressBarPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ProgressIndicatorPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.PullToRefreshPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.ScrollWidgetPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.SearchboxPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.SliderPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.TabBarPresenter;
import com.kiahu.sample.client.presenter.tablet.ui.UiPresenter;
import com.kiahu.sample.client.presenter.tablet.MainPageTabletPresenter;
import com.kiahu.sample.client.view.tablet.AboutView;
import com.kiahu.sample.client.view.tablet.MainPageTabletView;
import com.kiahu.sample.client.view.tablet.ui.ButtonBarView;
import com.kiahu.sample.client.view.tablet.ui.ButtonsView;
import com.kiahu.sample.client.view.tablet.ui.CarouselView;
import com.kiahu.sample.client.view.tablet.ui.ElementsView;
import com.kiahu.sample.client.view.tablet.ui.FormsView;
import com.kiahu.sample.client.view.tablet.ui.GroupListView;
import com.kiahu.sample.client.view.tablet.ui.PopupsView;
import com.kiahu.sample.client.view.tablet.ui.ProgressBarView;
import com.kiahu.sample.client.view.tablet.ui.ProgressIndicatorView;
import com.kiahu.sample.client.view.tablet.ui.PullToRefreshView;
import com.kiahu.sample.client.view.tablet.ui.ScrollWidgetView;
import com.kiahu.sample.client.view.tablet.ui.SearchboxView;
import com.kiahu.sample.client.view.tablet.ui.SliderView;
import com.kiahu.sample.client.view.tablet.ui.TabBarView;
import com.kiahu.sample.client.view.tablet.ui.UiView;
import com.kiahu.sample.client.view.tablet.animations.AnimationsView;
import com.kiahu.sample.client.view.tablet.animations.DissolveView;
import com.kiahu.sample.client.view.tablet.animations.FadeView;
import com.kiahu.sample.client.view.tablet.animations.FlipView;
import com.kiahu.sample.client.view.tablet.animations.PopView;
import com.kiahu.sample.client.view.tablet.animations.SlideUpView;
import com.kiahu.sample.client.view.tablet.animations.SlideView;
import com.kiahu.sample.client.view.tablet.animations.SwapView;

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
    bindPresenter(SlideUpPresenter.class, SlideUpPresenter.MyView.class,
        SlideUpView.class, SlideUpPresenter.MyProxy.class);
    bindPresenter(DissolvePresenter.class, DissolvePresenter.MyView.class,
        DissolveView.class, DissolvePresenter.MyProxy.class);
    bindPresenter(FadePresenter.class, FadePresenter.MyView.class,
    	FadeView.class, FadePresenter.MyProxy.class);
    bindPresenter(FlipPresenter.class, FlipPresenter.MyView.class,
    	FlipView.class, FlipPresenter.MyProxy.class);
    bindPresenter(PopPresenter.class, PopPresenter.MyView.class,
        PopView.class, PopPresenter.MyProxy.class);
    bindPresenter(SwapPresenter.class, SwapPresenter.MyView.class,
    	SwapView.class, SwapPresenter.MyProxy.class);

    bindPresenter(UiPresenter.class, UiPresenter.MyView.class,
        UiView.class, UiPresenter.MyProxy.class);
    bindPresenter(ButtonBarPresenter.class, ButtonBarPresenter.MyView.class,
        ButtonBarView.class, ButtonBarPresenter.MyProxy.class);
    bindPresenter(ButtonsPresenter.class, ButtonsPresenter.MyView.class,
    	ButtonsView.class, ButtonsPresenter.MyProxy.class);
    bindPresenter(CarouselPresenter.class, CarouselPresenter.MyView.class,
        CarouselView.class, CarouselPresenter.MyProxy.class);
    bindPresenter(ElementsPresenter.class, ElementsPresenter.MyView.class,
    	ElementsView.class, ElementsPresenter.MyProxy.class);
    bindPresenter(FormsPresenter.class, FormsPresenter.MyView.class,
        FormsView.class, FormsPresenter.MyProxy.class);
    bindPresenter(GroupListPresenter.class, GroupListPresenter.MyView.class,
    	GroupListView.class, GroupListPresenter.MyProxy.class);
    bindPresenter(PopupsPresenter.class, PopupsPresenter.MyView.class,
    	PopupsView.class, PopupsPresenter.MyProxy.class);
    bindPresenter(ProgressBarPresenter.class, ProgressBarPresenter.MyView.class,
    	ProgressBarView.class, ProgressBarPresenter.MyProxy.class);
    bindPresenter(ProgressIndicatorPresenter.class, ProgressIndicatorPresenter.MyView.class,
        ProgressIndicatorView.class, ProgressIndicatorPresenter.MyProxy.class);
    bindPresenter(PullToRefreshPresenter.class, PullToRefreshPresenter.MyView.class,
    	PullToRefreshView.class, PullToRefreshPresenter.MyProxy.class);
    bindPresenter(ScrollWidgetPresenter.class, ScrollWidgetPresenter.MyView.class,
    	ScrollWidgetView.class, ScrollWidgetPresenter.MyProxy.class);
    bindPresenter(SearchboxPresenter.class, SearchboxPresenter.MyView.class,
    	SearchboxView.class, SearchboxPresenter.MyProxy.class);
    bindPresenter(SliderPresenter.class, SliderPresenter.MyView.class,
        SliderView.class, SliderPresenter.MyProxy.class);
    bindPresenter(TabBarPresenter.class, TabBarPresenter.MyView.class,
    	TabBarView.class, TabBarPresenter.MyProxy.class);

    bindPresenter(AboutPresenter.class, AboutPresenter.MyView.class,
        AboutView.class, AboutPresenter.MyProxy.class);
  }
}
