/**
 * (C) Copyright 2010-2013 Kiahu
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

package com.gwtcx.extgwt.client.desktop.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.gwtcx.client.resources.ToolBarIcons;
import com.gwtcx.client.uihandlers.AccountsUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountsDto;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;

/**
 * AbstractAccountsView
 */
public abstract class AbstractAccountsDesktopView<C extends UiHandlers> extends AbstractPagingDesktopView<C> {

  // protected String id;

  @Inject
  public AbstractAccountsDesktopView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Grid<?> grid) {
    super(toolBar, grid);

    // id = new String("-1");
  }

  public void resetAndFocus() {

    Log.debug("resetAndFocus()");
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();

    // initialise the ToolBar and register its handlers
    initToolBar();

    getGrid().addRowDoubleClickHandler(new RowDoubleClickHandler() {
      @Override
      public void onRowDoubleClick(RowDoubleClickEvent event) {

        AccountsDto dto = (AccountsDto) getGrid().getStore().get(event.getRowIndex());
        assert dto != null;

        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof AccountsUiHandlers;
          ((AccountsUiHandlers) getUiHandlers()).onRecordDoubleClicked(dto.getId());
        }

        Log.debug("id = " + dto.getId());
      }
    });

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  public void setResultSet(List<AccountsDto> resultSet) {
    // resultSet == null when there are no items in the table
    // if (resultSet != null) {
    //   ((ContactsContextAreaListGrid) getListGrid()).setResultSet(resultSet);
    // }
  }

  @Override
  protected void initToolBar() {

    ToolTipConfig config = getToolBar().createToolTipConfig(I18nUtil.getConstant().newButton(), "Create a new Account");

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.newAccount(), I18nUtil.getConstant().newButton(), config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof AccountsUiHandlers;
          ((AccountsUiHandlers) getUiHandlers()).onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.printPreview(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.export(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.mailMerge(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.reports(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.assign(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.delete(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.sendEmail(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.workflow(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.refresh(), null, null);

    getToolBar().addFill();
  }

  @Override
  protected void initStatusBar() {

    /*

    // "0 of 50 selected"
    // statusBar.getSelectedLabel().setContents(I18nUtil.getConstant().selectedLabel());

    getStatusBar().getResultSetFirstButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof AccountsUiHandlers;
          ((AccountsUiHandlers) getUiHandlers()).onResultSetFirstButtonClicked();
        }
      }
    });

    getStatusBar().getResultSetPreviousButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof AccountsUiHandlers;
          ((AccountsUiHandlers) getUiHandlers()).onResultSetPreviousButtonClicked();
        }
      }
    });

    // "Page 1"
    // statusBar.getPageNumberLabel().setContents(I18nUtil.getConstant().pageNumberLabel());

    getStatusBar().getResultSetNextButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof AccountsUiHandlers;
          ((AccountsUiHandlers) getUiHandlers()).onResultSetNextButtonClicked();
        }
      }
    });

    */
  }
}

// Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");

