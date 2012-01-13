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

package com.gwtcx.smartgwt.client.view;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.presenter.AbstractPagingPresenter;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.widgets.grid.ContextAreaListGrid;
import com.gwtcx.smartgwt.client.widgets.toolbar.StatusBar;
import com.gwtcx.smartgwt.client.widgets.toolbar.ToolBar;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * PagingView
 */
public abstract class AbstractPagingView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_STYLE_NAME = "gwtcx-ContextArea";
  public static final String CONTEXT_AREA_WIDTH = "*";

  private final ToolBar toolBar;
  private final ContextAreaListGrid listGrid;
  private final StatusBar statusBar;
  // private final JumpBar jumpBar;

  private int numberOfElements;
  private int numberSelected;
  private int pageNumber;

  private VLayout panel;

  @Inject
  public AbstractPagingView(ToolBar toolBar, ContextAreaListGrid listGrid, StatusBar statusBar) {
    super();

    this.toolBar = toolBar;
    this.listGrid = listGrid;
    this.statusBar = statusBar;

    this.numberOfElements = AbstractPagingPresenter.DEFAULT_MAX_RESULTS;
    this.numberSelected = 0;
    pageNumber = 1;

    panel = new VLayout();

    // initialise the View's layout container
    panel.setStyleName(CONTEXT_AREA_STYLE_NAME);
    panel.setWidth(CONTEXT_AREA_WIDTH);

    // add the Tool Bar, List Grid, and Status Bar to the View's layout container
    panel.addMember(this.toolBar);
    panel.addMember(this.listGrid);
    panel.addMember(this.statusBar);
    // this.addMember(this.jumpBar);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // register the ListGird handlers
    listGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
      @Override
      public void onSelectionChanged(SelectionEvent event) {

        ListGridRecord[] records = event.getSelection();

        setNumberSelected(records.length);

        String selectedLabel = I18nUtil.getMessage().selected(getNumberSelected(),
            getNumberOfElements());
        statusBar.getSelectedLabel().setContents(selectedLabel);

        // Log.debug("onSelectionChanged() - records: " + records.length);
      }
    });
  }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public ToolBar getToolBar() {
    return toolBar;
  }

  public ContextAreaListGrid getListGrid() {
    return listGrid;
  }

  public StatusBar getStatusBar() {
    return statusBar;
  }

  public int getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  public int getNumberSelected() {
    return numberSelected;
  }

  public void setNumberSelected(int numberSelected) {
    this.numberSelected = numberSelected;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public void refreshStatusBar() {

    // update Selected label e.g "0 of 50 selected"
    String selectedLabel = I18nUtil.getMessage().selected(getNumberSelected(), getNumberOfElements());
    getStatusBar().getSelectedLabel().setContents(selectedLabel);

    // update Page number label e.g "Page 1"
    String pageNumberLabel = I18nUtil.getMessage().page(getPageNumber());
    getStatusBar().getPageNumberLabel().setContents(pageNumberLabel);
  }

  public void removeSelectedData() {
    listGrid.removeSelectedData();
  }
}
