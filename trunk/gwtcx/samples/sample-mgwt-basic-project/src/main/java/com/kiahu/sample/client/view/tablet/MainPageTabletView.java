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

package com.kiahu.sample.client.view.tablet;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.MainPageTabletPresenter;
import com.kiahu.sample.client.uihandlers.MainPageTabletUiHandlers;
import com.kiahu.sample.client.view.tablet.ui.Topic;

public class MainPageTabletView extends ViewWithUiHandlers<MainPageTabletUiHandlers> implements
    MainPageTabletPresenter.MyView {

  public LayoutPanel panel;

  public CellListWithHeader<Topic> cellList;
  public ArrayList<Topic> topicList;

  @Inject
  public MainPageTabletView() {
    super();

    Log.debug("MainPageTabletView()");

    createAndBindUi();

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;

    panel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    cellList = new CellListWithHeader<Topic>(new BasicCell<Topic>() {
      @Override
      public String getDisplayString(Topic model) {
        return model.getName();
      }

      @Override
      public boolean canBeSelected(Topic model) {
        return true;
      }
    });

    cellList.getCellList().setRound(true);

    scrollPanel.setWidget(cellList);
    scrollPanel.setScrollingEnabledX(false);

    panel.add(headerPanel);
    panel.add(scrollPanel);

    headerPanel.setCenter("mgwt");

    cellList.getCellList().render(createTopicsList());
  }

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    cellList.getCellList().addCellSelectedHandler(
        new CellSelectedHandler() {

      @Override
      public void onCellSelected(CellSelectedEvent event) {

        Topic topic = topicList.get(event.getIndex());

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneClicked(topic.getName());
        }
      }
    });
  }

  private List<Topic> createTopicsList() {

    topicList = new ArrayList<Topic>();

    topicList.add(new Topic(NameTokens.animations, 5));
    topicList.add(new Topic(NameTokens.ui, 5));

    return topicList;
  }

  @Override
  public Widget asWidget() {

    Log.debug("asWidget()");

    return panel;
  }
}
