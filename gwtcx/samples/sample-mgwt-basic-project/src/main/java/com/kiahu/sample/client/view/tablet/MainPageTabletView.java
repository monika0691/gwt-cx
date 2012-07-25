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

public class MainPageTabletView extends ViewWithUiHandlers<MainPageTabletUiHandlers> implements
    MainPageTabletPresenter.MyView {

  public LayoutPanel navigationPaneLayoutPanel;

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

    createNavigationPane();
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
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

  private void createNavigationPane() {

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;

    navigationPaneLayoutPanel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    navigationPaneLayoutPanel.add(headerPanel);

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

    navigationPaneLayoutPanel.add(scrollPanel);

    // view.setTitle("mgwt");
    headerPanel.setCenter("mgwt");
    // view.getFirstHeader().setText("Showcase");
    // cellList.getHeader().setText("Showcase");
    // view.setTopics(createTopicsList());
    cellList.getCellList().render(createTopicsList());
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

    return navigationPaneLayoutPanel;
  }
}

/*


public class MainPageTabletView extends ViewWithUiHandlers<MainPageTabletUiHandlers> implements
    MainPageTabletPresenter.MyView {

  public LayoutPanel panel;

  // @UiField
  public SimplePanel westPanel;
  // @UiField
  public SimplePanel centerPanel;

  public LayoutPanel navigationPaneLayoutPanel;
  public LayoutPanel contextAreaLayoutPanel;

  public CellListWithHeader<Topic> cellList;
  public ArrayList<Topic> topicList;

  @Inject
  public MainPageTabletView() {
    super();

    Log.debug("MainPageTabletView()");

    createAndBindUi();

    // see AbstractMainPageDesktopView
    ViewPort viewPort = new MGWTSettings.ViewPort();
    viewPort.setTargetDensity(DENSITY.MEDIUM);
    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

    MGWTSettings settings = new MGWTSettings();
    settings.setViewPort(viewPort);
    settings.setIconUrl("images/logo.png");
    settings.setAddGlosToIcon(true);
    settings.setFullscreen(true);
    settings.setPreventScrolling(true);
    MGWT.applySettings(settings);

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    panel = new LayoutPanel();

    westPanel = new SimplePanel();
    getWestPanel().getElement().setId("NavigationPane");
    getWestPanel().getElement().addClassName("landscapeonly");

    // AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);
    // final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();
    // new OrientationRegionHandler(navContainer, tabletPortraitOverlay, navDisplay);
    // new MasterRegionHandler(clientFactory.getEventBus(), "nav", tabletPortraitOverlay);

    centerPanel = new SimplePanel();
    getCenterPanel().getElement().setId("ContextArea");

    getPanel().add(getWestPanel());
    getPanel().add(getCenterPanel());

    createNavigationPane();

    createContextArea();
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
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

  private void createNavigationPane() {

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;

    navigationPaneLayoutPanel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    navigationPaneLayoutPanel.add(headerPanel);

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

    navigationPaneLayoutPanel.add(scrollPanel);

    getWestPanel().add(navigationPaneLayoutPanel);



    // view.setTitle("mgwt");
    headerPanel.setCenter("mgwt");

    // view.getFirstHeader().setText("Showcase");
    // cellList.getHeader().setText("Showcase");

    // view.setTopics(createTopicsList());
    cellList.getCellList().render(createTopicsList());
  }

  private void createContextArea() {

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;
    RoundPanel round;

    contextAreaLayoutPanel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    contextAreaLayoutPanel.add(headerPanel);

    round = new RoundPanel();

    round.add(new HTML("<br />"));
    round.add(new HTML("Kiahu CX - mgwt Showcase"));
    round.add(new HTML("Version 1.1.2-SNAPSHOT"));
    round.add(new HTML("<br />"));

    scrollPanel.setWidget(round);
    scrollPanel.setScrollingEnabledX(false);

    contextAreaLayoutPanel.add(scrollPanel);

    getCenterPanel().add(contextAreaLayoutPanel);




    // view.setTitle("About");
    headerPanel.setCenter("About");
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

  @Override
  public void setInSlot(Object slot, Widget content) {

    Log.debug("setInSlot()");

    if (slot == MainPageTabletPresenter.TYPE_SetNavigationPaneContent) {
      setNavigationPaneContent(content);
    }
    else if (slot == MainPageTabletPresenter.TYPE_SetContextAreaContent) {
      setContextAreaContent(content);
    }
    else {
      super.setInSlot(slot, content);
    }
  }

  private void setNavigationPaneContent(Widget content) {

    Log.debug("setNavigationPaneContent()");

    getWestPanel().clear();

    if (content != null) {
      getWestPanel().add(content);
     }
  }

  private void setContextAreaContent(Widget content) {

    Log.debug("setContextAreaContent()");

    getCenterPanel().clear();

    if (content != null) {
      getCenterPanel().add(content);
     }
  }

  public LayoutPanel getPanel() {
    return panel;
  }

  public SimplePanel getWestPanel() {
    return westPanel;
  }

  public SimplePanel getCenterPanel() {
    return centerPanel;
  }

  @Override
  public void reset() {
    getWestPanel().clear();
    getWestPanel().add(navigationPaneLayoutPanel);
  }
}

*/