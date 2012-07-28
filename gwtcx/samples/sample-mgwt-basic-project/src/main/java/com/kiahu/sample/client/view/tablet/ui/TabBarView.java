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

package com.kiahu.sample.client.view.tablet.ui;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.tabbar.BookmarkTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.SearchTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.TabBarPresenter;

public class TabBarView extends AbstractUiView implements TabBarPresenter.MyView {

  @Inject
  public TabBarView() {
    super();

    Log.debug("TabBarView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    TabPanel tabPanel = new TabPanel();

	tabPanel.add(new BookmarkTabBarButton(), new Label("Bookmark"));
	// tabPanel.add(new ContactsTabBarButton(), new Label("Contacts"));
	// tabPanel.add(new DownloadsTabBarButton(), new Label("Downloads"));
	// tabPanel.add(new FavoritesTabBarButton(), new Label("Favorites"));
	// tabPanel.add(new FeaturedTabBarButton(), new Label("Featured"));
	tabPanel.add(new HistoryTabBarButton(), new Label("History"));
	// tabPanel.add(new MoreTabBarButton(), new Label("More"));
	// tabPanel.add(new MostRecentTabBarButton(), new Label("Most Recent"));
	// tabPanel.add(new MostViewedTabBarButton(), new Label("Most Viewed"));
	tabPanel.add(new SearchTabBarButton(), new Label("Search"));

	panel.remove(scrollPanel);
	panel.add(tabPanel);

    headerPanel.setCenter(NameTokens.tabBar);
  }
}