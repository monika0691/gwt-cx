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

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.smartgwt.view.handlers.ReportsUiHandlers;
import com.gwtcx.client.smartgwt.widgets.grid.ReportsContextAreaListGrid;
import com.gwtcx.client.smartgwt.widgets.grid.ReportsRecord;
import com.gwtcx.client.smartgwt.widgets.toolbar.StatusBar;
import com.gwtcx.client.smartgwt.widgets.toolbar.ToolBar;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.ReportsDto;
import com.gwtplatform.mvp.client.UiHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

public abstract class ReportsView<C extends UiHandlers> extends PagingView<C> {

  @Inject
  public ReportsView(ToolBar toolBar, ReportsContextAreaListGrid listGrid,
      StatusBar statusBar) {
    super(toolBar, listGrid, statusBar);
  }

  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();

    // initialise the ToolBar and register its handlers
    initToolBar();

    // register the ListGird handlers
    getListGrid().addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
      @Override
      public void onRecordDoubleClick(RecordDoubleClickEvent event) {
        Record record = event.getRecord();
        String reportFilename = record.getAttributeAsString(ReportsRecord.REPORT_FILENAME);

        Log.debug("onRecordDoubleClick() - " + reportFilename);

        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onRecordDoubleClicked(reportFilename);
        }
      }
    });

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  public void setResultSet(List<ReportsDto> resultSet) {
    // resultSet == null when there are no items in table
    if (resultSet != null) {
      ((ReportsContextAreaListGrid)getListGrid()).setResultSet(resultSet);
    }
  }

  protected void initToolBar() {

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.NEW_REPORT_BUTTON), I18nUtil.getConstant().newButton(),
            I18nUtil.getConstant().newButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), null);
    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.EXPORT_BUTTON),
        I18nUtil.getConstant().exportButtonTooltip(), null);

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.ASSIGN_BUTTON),
        I18nUtil.getConstant().assignButtonTooltip(), null);
    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.DELETE_BUTTON),
        I18nUtil.getConstant().deleteButtonTooltip(), null);

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.REFRESH_BUTTON),
        I18nUtil.getConstant().refreshButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onRefreshButtonClicked();
        }
      }
    });
  }

  protected void initStatusBar() {

    getStatusBar().getResultSetFirstButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onResultSetFirstButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetPreviousButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onResultSetPreviousButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetNextButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ReportsUiHandlers) getUiHandlers()).onResultSetNextButtonClicked();
        }
      }
    });
  }
}
