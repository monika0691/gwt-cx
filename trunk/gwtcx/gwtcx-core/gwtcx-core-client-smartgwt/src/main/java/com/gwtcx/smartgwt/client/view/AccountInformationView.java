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

import com.allen_sauer.gwt.log.client.Log;
// import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.event.MastheadUpdateEvent;
import com.gwtcx.client.presenter.AccountInformationPresenter;
import com.gwtcx.client.uihandlers.AccountInformationUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountDto;
import com.gwtcx.smartgwt.client.widgets.EntityTab;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class AccountInformationView extends ViewWithUiHandlers<AccountInformationUiHandlers>
    implements AccountInformationPresenter.MyView {

  public static final String ENTITY_CONTEXT_AREA_STYLE_NAME = "gwtcx-Entity-ContextArea";

  private final EventBus eventBus;

  private AccountDto accountDto;
  // private EntityToolBar toolBar;

  private VLayout panel;
  private TabSet tabSet;

  @Inject
  public AccountInformationView(final EventBus eventBus) {
    super();

    this.eventBus= eventBus;

    accountDto = null;
    // toolBar = AccountPagePresenter.getToolBar();

    // initialise the Information View layout container
    panel = new VLayout();
    panel.setStyleName(ENTITY_CONTEXT_AREA_STYLE_NAME);
    panel.setWidth100();

    // initialise the TabSet container
    tabSet = new TabSet();
    tabSet.addTab(new AccountInformationGeneralTab());

    panel.addMember(tabSet);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    // initToolBar();

    setMastheadLabel(I18nUtil.getConstant().newAccount());
  }

  /*

  protected void initToolBar() {

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.SAVE_BUTTON),
        I18nUtil.getConstant().saveButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (validateTabs()) {
          if (getUiHandlers() != null) {
            getUiHandlers().onSaveButtonClicked(getFields());
          }
        }
      }
    });

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.SAVE_AND_CLOSE_BUTTON),
        I18nUtil.getConstant().saveAndCloseButton(),
        I18nUtil.getConstant().saveAndCloseButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (validateTabs()) {
          if (getUiHandlers() != null) {
            getUiHandlers().onSaveAndCloseButtonClicked(getFields());
          }
        }
      }
    });

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onPrintPreviewClicked();
        }
      }
    });

    toolBar.addSeparator();

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.EMAIL_BUTTON),
        I18nUtil.getConstant().emailButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onEmailButtonClicked();
        }
      }
    });

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.ATTACH_BUTTON),
        I18nUtil.getConstant().attachButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onAttachButtonClicked();
        }
      }
    });

    toolBar.addMenuButton(I18nUtil.getConstant().reportsButton(),
        "Account Overview, Account Summary, Product By Account",
        new com.smartgwt.client.widgets.menu.events.ClickHandler() {
          public void onClick(MenuItemClickEvent event) {
            if (getUiHandlers() != null) {
              // getUiHandlers().onAttachButtonClicked();
            }
          }
        });

    toolBar.addSeparator();

    toolBar.addButton(SmartGwtEntryPoint.getThemedResource(ToolBar.HELP_BUTTON),
        I18nUtil.getConstant().helpButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onHelpButtonClicked();
        }
      }
    });
  }

  */

  @Override
  public Widget asWidget() {
    return panel;
  }

  public void setAccountId(String accountId) {

    if (accountDto != null) {
      accountDto.setAccountId(accountId);

      // set Masthead Account Name label and the browser window's title
      setMastheadLabel(accountDto.getAccountName());
    }
  }

  public void setResultSet(AccountDto accountDto) {

    try {
      if (accountDto != null) {
        this.accountDto = accountDto;
        setFields(this.accountDto);
      }
    } catch (Exception e) {
      Log.warn("Unable to set server response: " + e);
    }
  }

  public void setFields(AccountDto accountDto) {

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      entityTab.setFields(accountDto);
    }

    // set Masthead Account Name label and the browser window's title
    setMastheadLabel(accountDto.getAccountName());
  }

  public AccountDto getFields() {

    if (accountDto == null) {
      accountDto = new AccountDto();
    }

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      entityTab.getFields(accountDto);
    }

    return accountDto;
  }

  public Boolean validateTabs() {
    Boolean result = true;

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      if (! entityTab.getForm().validate(false)) {
        result = false;
        break;
      }
    }

    return result;
  }

  private void setMastheadLabel(String name) {

    MastheadUpdateEvent.fire(eventBus, name + I18nUtil.getConstant().informationLabel());
    // AccountPagePresenter.getMasthead().setLabelContents(name + I18nUtil.getConstant().informationLabel());

    // set the browser window's title e.g. "Account: ABC Corporation Pty Ltd"
    Window.setTitle(I18nUtil.getConstant().accountWindowTitle() + name);
  }
}
