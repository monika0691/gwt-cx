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

import com.google.inject.Inject;
import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.smartgwt.view.handlers.ImportsUiHandlers;
import com.gwtcx.client.smartgwt.widgets.grid.ImportsContextAreaListGrid;
import com.gwtcx.client.smartgwt.widgets.toolbar.StatusBar;
import com.gwtcx.client.smartgwt.widgets.toolbar.ToolBar;
import com.gwtcx.client.util.I18nUtil;
import com.gwtplatform.mvp.client.UiHandlers;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

public abstract class ImportsView<C extends UiHandlers> extends PagingView<C> {

  @Inject
  public ImportsView(ToolBar toolBar, ImportsContextAreaListGrid listGrid,
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
      }
    });

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  protected void initToolBar() {

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.NEW_IMPORT_BUTTON), I18nUtil.getConstant().newButton(),
            I18nUtil.getConstant().newButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ImportsUiHandlers) getUiHandlers()).onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), null);
    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.ASSIGN_BUTTON),
        I18nUtil.getConstant().assignButtonTooltip(), null);
    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.DELETE_BUTTON),
        I18nUtil.getConstant().deleteButtonTooltip(), null);

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.REFRESH_BUTTON),
        I18nUtil.getConstant().refreshButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ImportsUiHandlers) getUiHandlers()).onRefreshButtonClicked();
        }
      }
    });
  }

  protected void initStatusBar() {

    getStatusBar().getResultSetFirstButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ImportsUiHandlers) getUiHandlers()).onResultSetFirstButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetPreviousButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ImportsUiHandlers) getUiHandlers()).onResultSetPreviousButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetNextButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((ImportsUiHandlers) getUiHandlers()).onResultSetNextButtonClicked();
        }
      }
    });
  }
}