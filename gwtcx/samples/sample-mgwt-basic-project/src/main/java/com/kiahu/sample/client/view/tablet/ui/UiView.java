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
import com.kiahu.sample.client.event.UIEntrySelectedEvent.UIEntry;
import com.kiahu.sample.client.presenter.tablet.UiPresenter;
import com.kiahu.sample.client.uihandlers.UiUiHandlers;
import com.kiahu.sample.client.view.tablet.BasicCell;

public class UiView extends ViewWithUiHandlers<UiUiHandlers> implements
    UiPresenter.MyView {

  public LayoutPanel panel;

  public CellListWithHeader<Item> cellList;
  public ArrayList<Item> list;

  @Inject
  public UiView() {
    super();

    Log.debug("UiView()");

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

    cellList = new CellListWithHeader<Item>(new BasicCell<Item>() {
      @Override
      public String getDisplayString(Item model) {
        return model.getDisplayString();
      }

      @Override
      public boolean canBeSelected(Item model) {
        return true;
      }
    });

    cellList.getCellList().setRound(true);

    scrollPanel.setWidget(cellList);
    scrollPanel.setScrollingEnabledX(false);

    panel.add(headerPanel);
    panel.add(scrollPanel);

    headerPanel.setCenter(NameTokens.ui);

    cellList.getCellList().render(createAnimations());
  }

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    cellList.getCellList().addCellSelectedHandler(
        new CellSelectedHandler() {

      @Override
      public void onCellSelected(CellSelectedEvent event) {

        Item item = list.get(event.getIndex());

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneClicked(item.getDisplayString());
        }
      }
    });
  }

  private List<Item> createAnimations() {

    list = new ArrayList<Item>();

    list.add(new Item("ButtonBar", UIEntry.BUTTON_BAR));
    list.add(new Item("Buttons", UIEntry.BUTTONS));
    list.add(new Item("Carousel", UIEntry.CAROUSEL));
    list.add(new Item("Elements", UIEntry.ELEMENTS));
    list.add(new Item("Forms", UIEntry.FORMS));
    list.add(new Item("Group List", UIEntry.GROUP_LIST));
    list.add(new Item("Popups", UIEntry.POPUPS));
    list.add(new Item("ProgressBar", UIEntry.PROGRESS_BAR));
    list.add(new Item("ProgressIndicator", UIEntry.PROGRESS_INDICATOR));
    list.add(new Item("PullToRefresh", UIEntry.PULL_TO_REFRESH));
    list.add(new Item("Scroll Widget", UIEntry.SCROLL_WIDGET));
    list.add(new Item("Searchbox", UIEntry.SEARCH_BOX));
    list.add(new Item("Slider", UIEntry.SLIDER));
    list.add(new Item("TabBar", UIEntry.TABBAR));

    return list;
  }

  @Override
  public Widget asWidget() {

    Log.debug("asWidget()");

    return panel;
  }
}