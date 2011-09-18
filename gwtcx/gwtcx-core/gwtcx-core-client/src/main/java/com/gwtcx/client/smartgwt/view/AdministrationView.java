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

package com.gwtcx.client.smartgwt.view;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.smartgwt.view.handlers.AdministrationUiHandlers;
import com.gwtcx.client.smartgwt.widgets.grid.SettingsContextAreaListGrid;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class AdministrationView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_STYLE_NAME = "gwtcx-ContextArea";
  public static final String CONTEXT_AREA_WIDTH = "*";

  private SettingsContextAreaListGrid listGrid;
  private VLayout panel;

  @Inject
  public AdministrationView(SettingsContextAreaListGrid listGrid) {
    super();

    this.listGrid = listGrid;

    panel = new VLayout();

    // initialise the View's layout container
    panel.setStyleName(CONTEXT_AREA_STYLE_NAME);
    panel.setWidth(CONTEXT_AREA_WIDTH);

    // add the List Grid to the View's layout container
    panel.addMember(this.listGrid);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // register the ListGird handlers
    listGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
      @Override
      public void onCellDoubleClick(CellDoubleClickEvent event) {
        Record record = event.getRecord();
        int colNum = event.getColNum();
        String columnName = "column1Name";

        // we are only interested in the columns 0 and 2 (the icon columns)
        if (colNum >= 2) {
          colNum = 2;
          columnName = "column2Name";
        } else {
          colNum = 0;
        }

        String place = record.getAttribute(columnName);

        if (getUiHandlers() != null) {
          ((AdministrationUiHandlers) getUiHandlers()).onCellDoubleClicked(place);
        }
      }
    });
  }


  @Override
  public Widget asWidget() {
    return panel;
  }
}