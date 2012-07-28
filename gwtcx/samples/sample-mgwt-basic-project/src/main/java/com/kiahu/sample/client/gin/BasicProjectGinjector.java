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

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
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

//
// Create a method for each object type you want to create, and the an implementation
// of the interface gets generated for you at compile time.
// See: http://code.google.com/p/google-gin/wiki/GinTutorial#Step_2._Defining_the_Ginjector
//
public interface BasicProjectGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();

  // Error Page
  // AsyncProvider<ErrorPagePresenter> getErrorPagePresenter();

  Provider<MainPageTabletPresenter> getMainPageTabletPresenter();

  AsyncProvider<AnimationsPresenter> getAnimationsPresenter();
  AsyncProvider<SlidePresenter> getSlidePresenter();
  AsyncProvider<SlideUpPresenter> getSlideUpPresenter();
  AsyncProvider<DissolvePresenter> getDissolvePresenter();
  AsyncProvider<FadePresenter> getFadePresenter();
  AsyncProvider<FlipPresenter> getFlipPresenter();
  AsyncProvider<PopPresenter> getPopPresenter();
  AsyncProvider<SwapPresenter> getSwapPresenter();

  AsyncProvider<UiPresenter> getUiPresenter();
  AsyncProvider<ButtonBarPresenter> getButtonBarPresenter();
  AsyncProvider<ButtonsPresenter> getButtonsPresenter();
  AsyncProvider<CarouselPresenter> getCarouselPresenter();
  AsyncProvider<ElementsPresenter> getElementsPresenter();
  AsyncProvider<FormsPresenter> getFormsPresenter();
  AsyncProvider<GroupListPresenter> getGroupListPresenter();
  AsyncProvider<PopupsPresenter> getPopupsPresenter();
  AsyncProvider<ProgressBarPresenter> getProgressBarPresenter();
  AsyncProvider<ProgressIndicatorPresenter> getProgressIndicatorPresenter();
  AsyncProvider<PullToRefreshPresenter> getPullToRefreshPresenter();
  AsyncProvider<ScrollWidgetPresenter> getScrollWidgetPresenter();
  AsyncProvider<SearchboxPresenter> getSearchboxPresenter();
  AsyncProvider<SliderPresenter> getSliderPresenter();
  AsyncProvider<TabBarPresenter> getTabBarPresenter();

  AsyncProvider<AboutPresenter> getAboutPresenter();
}