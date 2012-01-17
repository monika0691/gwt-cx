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

import java.util.List;

import com.google.inject.Inject;
import com.gwtcx.shared.dto.AccountsDto;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.gwtcx.client.uihandlers.AccountsUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.widgets.grid.AccountsContextAreaListGrid;
import com.gwtcx.smartgwt.client.widgets.grid.AccountsRecord;
import com.gwtcx.smartgwt.client.widgets.toolbar.StatusBar;
import com.gwtcx.smartgwt.client.widgets.toolbar.ToolBar;
import com.gwtplatform.mvp.client.UiHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

/**
 * AbstractAccountsView
 */
public abstract class AbstractAccountsView<C extends UiHandlers> extends AbstractPagingView<C> {

  protected String recordId;

  @Inject
  public AbstractAccountsView(ToolBar toolBar, AccountsContextAreaListGrid listGrid,
      StatusBar statusBar) {
    super(toolBar, listGrid, statusBar);

    recordId = new String("-1");
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();

    // initialise the ToolBar and register its handlers
    initToolBar();

    // register the ListGird handlers
    getGrid().addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
      @Override
      public void onRecordDoubleClick(RecordDoubleClickEvent event) {
        Record record = event.getRecord();
        recordId = record.getAttributeAsString(AccountsRecord.ACCOUNT_ID);

        if (getUiHandlers() != null) {
          // getUiHandlers().onRecordDoubleClicked(recordId);
          ((AccountsUiHandlers) getUiHandlers()).onRecordDoubleClicked(recordId);
        }
      }
    });

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  public void setResultSet(List<AccountsDto> resultSet) {
    // resultSet == null when there are no items in the table
    if (resultSet != null) {
      ((AccountsContextAreaListGrid) getGrid()).setResultSet(resultSet);
    }
  }

  @Override
  protected void initToolBar() {

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.NEW_ACCOUNT_BUTTON), I18nUtil.getConstant().newButton(),
        I18nUtil.getConstant().newButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onNewButtonClicked();
          ((AccountsUiHandlers) getUiHandlers()).onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), null);

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.EXPORT_BUTTON),
        I18nUtil.getConstant().exportButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onExportButtonClicked();
          ((AccountsUiHandlers) getUiHandlers()).onExportButtonClicked();
        }
      }
    });

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.MAIL_MERGE_BUTTON),
        I18nUtil.getConstant().mailMergeButtonTooltip(), null);
    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.REPORTS_BUTTON),
        I18nUtil.getConstant().reportsButtonTooltip(), null);

    getToolBar().addSeparator();

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.ASSIGN_BUTTON),
        I18nUtil.getConstant().assignButtonTooltip(), null);

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.DELETE_BUTTON),
        I18nUtil.getConstant().deleteButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {

        @SuppressWarnings("deprecation")
        ListGridRecord[] records = getGrid().getSelection();

          if (records.length == 1) {
            String title = I18nUtil.getConstant().accountWindowTitle() +
                records[0].getAttributeAsString(AccountsRecord.ACCOUNT_NAME);
            recordId = records[0].getAttributeAsString(AccountsRecord.ACCOUNT_ID);

            event.cancel();
            SC.ask(title, I18nUtil.getConstant().deleteAccountPrompt(), new BooleanCallback()
            {
              @Override
              public void execute(Boolean value) {
                if (value != null && value) { // Yes
                  // getUiHandlers().onDeleteButtonClicked(recordId);
                  ((AccountsUiHandlers) getUiHandlers()).onDeleteButtonClicked(recordId);
                }
              }
            });
          } else {
            getGrid().deselectAllRecords();
          }
            }
          }
        }
      );

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.EMAIL_BUTTON),
        I18nUtil.getConstant().emailButtonTooltip(), null);

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.WORKFLOW_BUTTON), I18nUtil.getConstant().workflowButton(),
        I18nUtil.getConstant().workflowButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onWorkflowButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.REFRESH_BUTTON),
        I18nUtil.getConstant().refreshButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onRefreshButtonClicked();
          ((AccountsUiHandlers) getUiHandlers()).onRefreshButtonClicked();
        }
      }
    });
  }

  @Override
  protected void initStatusBar() {

    // "0 of 50 selected"
    // statusBar.getSelectedLabel().setContents(I18nUtil.getConstant().selectedLabel());

    getStatusBar().getResultSetFirstButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onResultSetFirstButtonClicked();
          ((AccountsUiHandlers) getUiHandlers()).onResultSetFirstButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetPreviousButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onResultSetPreviousButtonClicked();
          ((AccountsUiHandlers) getUiHandlers()).onResultSetPreviousButtonClicked();
        }
      }
    });

    // "Page 1"
    // statusBar.getPageNumberLabel().setContents(I18nUtil.getConstant().pageNumberLabel());

    getStatusBar().getResultSetNextButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          ((AccountsUiHandlers) getUiHandlers()).onResultSetNextButtonClicked();
        }
      }
    });
  }
}

/*

import java.util.List;

import com.google.inject.Inject;
import com.gwtcx.client.GwtCx;
import com.gwtcx.client.model.AccountsRecord;
import com.gwtcx.client.smartgwt.view.handlers.AccountsUiHandlers;
import com.gwtcx.client.smartgwt.widgets.grid.AccountsContextAreaListGrid;
import com.gwtcx.client.smartgwt.widgets.toolbar.StatusBar;
import com.gwtcx.client.smartgwt.widgets.toolbar.ToolBar;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountsDto;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

// public class AccountsView extends PagingView<AccountsUiHandlers> implements
//     AccountsPresenter.MyView {

// public abstract class AccountsView<C extends UiHandlers> extends PagingView<C> {

public abstract class AccountsView extends PagingView<AccountsUiHandlers> {

  private String recordId;

  @Inject
  public AccountsView(ToolBar toolBar, AccountsContextAreaListGrid listGrid,
      StatusBar statusBar) {
    super(toolBar, listGrid, statusBar);

    recordId = new String("-1");
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();

    // initialise the ToolBar and register its handlers
    initToolBar();

    // register the ListGird handlers
    getListGrid().addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
      @Override
      public void onRecordDoubleClick(RecordDoubleClickEvent event) {
        Record record = event.getRecord();
        recordId = record.getAttributeAsString(AccountsRecord.ACCOUNT_ID);

        if (getUiHandlers() != null) {
          ((AccountsUiHandlers) getUiHandlers()).onRecordDoubleClicked(recordId);
        }
      }
    });

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  public void setResultSet(List<AccountsDto> resultSet) {
    // resultSet == null when there are no items in the table
    if (resultSet != null) {
      ((AccountsContextAreaListGrid) getListGrid()).setResultSet(resultSet);
    }
  }

  protected void initToolBar() {

    getToolBar().addButton(GwtCx.getResource(ToolBar.NEW_ACCOUNT_BUTTON), I18nUtil.getConstant().newButton(),
        I18nUtil.getConstant().newButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCx.getResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), null);

    getToolBar().addButton(GwtCx.getResource(ToolBar.EXPORT_BUTTON),
        I18nUtil.getConstant().exportButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onExportButtonClicked();
        }
      }
    });

    getToolBar().addButton(GwtCx.getResource(ToolBar.MAIL_MERGE_BUTTON),
        I18nUtil.getConstant().mailMergeButtonTooltip(), null);
    getToolBar().addButton(GwtCx.getResource(ToolBar.REPORTS_BUTTON),
        I18nUtil.getConstant().reportsButtonTooltip(), null);

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCx.getResource(ToolBar.ASSIGN_BUTTON),
        I18nUtil.getConstant().assignButtonTooltip(), null);

    getToolBar().addButton(GwtCx.getResource(ToolBar.DELETE_BUTTON),
        I18nUtil.getConstant().deleteButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {

          ListGridRecord[] records = getListGrid().getSelection();

          if (records.length == 1) {
            String title = I18nUtil.getConstant().accountWindowTitle() +
                records[0].getAttributeAsString(AccountsRecord.ACCOUNT_NAME);
            recordId = records[0].getAttributeAsString(AccountsRecord.ACCOUNT_ID);

            event.cancel();
            SC.ask(title, I18nUtil.getConstant().deleteAccountPrompt(), new BooleanCallback()
            {
              @Override
              public void execute(Boolean value) {
                if (value != null && value) { // Yes
                  getUiHandlers().onDeleteButtonClicked(recordId);
                }
              }
            });
          } else {
            getListGrid().deselectAllRecords();
          }
            }
          }
        }
      );

    getToolBar().addButton(GwtCx.getResource(ToolBar.EMAIL_BUTTON),
        I18nUtil.getConstant().emailButtonTooltip(), null);

    getToolBar().addButton(GwtCx.getResource(ToolBar.WORKFLOW_BUTTON), I18nUtil.getConstant().workflowButton(),
        I18nUtil.getConstant().workflowButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onWorkflowButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCx.getResource(ToolBar.REFRESH_BUTTON),
        I18nUtil.getConstant().refreshButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onRefreshButtonClicked();
        }
      }
    });
  }

  protected void initStatusBar() {

    // "0 of 50 selected"
    // statusBar.getSelectedLabel().setContents(I18nUtil.getConstant().selectedLabel());

    getStatusBar().getResultSetFirstButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onResultSetFirstButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetPreviousButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onResultSetPreviousButtonClicked();
        }
      }
    });

    // "Page 1"
    // statusBar.getPageNumberLabel().setContents(I18nUtil.getConstant().pageNumberLabel());

    getStatusBar().getResultSetNextButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onResultSetNextButtonClicked();
        }
      }
    });
  }
}

*/

