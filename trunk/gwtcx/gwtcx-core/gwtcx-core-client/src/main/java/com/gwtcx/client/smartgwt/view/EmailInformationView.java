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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.presenter.EmailInformationPresenter;
import com.gwtcx.client.presenter.EmailPagePresenter;
import com.gwtcx.client.smartgwt.view.handlers.EmailInformationUiHandlers;
import com.gwtcx.client.smartgwt.widgets.EntityTab;
import com.gwtcx.client.smartgwt.widgets.toolbar.EntityToolBar;
import com.gwtcx.client.smartgwt.widgets.toolbar.ToolBar;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.EmailDto;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class EmailInformationView extends ViewWithUiHandlers<EmailInformationUiHandlers>
    implements EmailInformationPresenter.MyView {

  public static final String ENTITY_CONTEXT_AREA_STYLE_NAME = "gwtcx-Entity-ContextArea";

  private EmailDto dto;
  private EntityToolBar toolBar;

  private VLayout panel;
  private TabSet tabSet;

  @Inject
  public EmailInformationView() {

    dto = null;
    toolBar = EmailPagePresenter.getToolBar();

    // initialise the Information View layout container
    panel = new VLayout();
    panel.setStyleName(ENTITY_CONTEXT_AREA_STYLE_NAME);
    panel.setWidth100();

    // initialise the TabSet container
    tabSet = new TabSet();
    tabSet.addTab(new EmailInformationEmailTab());
    tabSet.addTab(new EmailInformationAttachmentsTab());

    panel.addMember(tabSet);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initToolBar();

    setMastheadLabel(I18nUtil.getConstant().newEmail());
  }

  protected void initToolBar() {

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.SAVE_BUTTON),
        I18nUtil.getConstant().saveButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (validateTabs()) {
          if (getUiHandlers() != null) {
            getUiHandlers().onSaveButtonClicked(getFields());
          }
        }
      }
    });

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.SAVE_AND_CLOSE_BUTTON),
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

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.PRINT_PREVIEW_BUTTON),
        I18nUtil.getConstant().printPreviewButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onPrintPreviewClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.EMAIL_BUTTON),
        I18nUtil.getConstant().emailButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onEmailButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addButton(GwtCxEntryPoint.getThemedResource(ToolBar.HELP_BUTTON),
        I18nUtil.getConstant().helpButtonTooltip(), new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (getUiHandlers() != null) {
          // getUiHandlers().onHelpButtonClicked();
        }
      }
    });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public void setId(Long id) {
    if (dto != null) {
      dto.setId(id);

      // set Masthead Account Name label and the browser window's title
      // setMastheadAccountNameLabel(accountDto.getAccountName());
    }
  }

  public void setResultSet(EmailDto dto) {

    try {
      if (dto != null) {
        this.dto = dto;
        setFields(this.dto);
      }
    } catch (Exception e) {
      Log.warn("Unable to set server response: " + e);
    }
  }

  public void setFields(EmailDto dto) {

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      entityTab.setFields(dto);
    }

    // set Masthead Account Name label and the browser window's title
    // setMastheadAccountNameLabel(dto.getAccountName());
  }

  public EmailDto getFields() {

    if (dto == null) {
      dto = new EmailDto();
    }

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      entityTab.getFields(dto);
    }

    return dto;
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

  public EntityToolBar getToolBar() {
    return toolBar;
  }

  private void setMastheadLabel(String name) {

    EmailPagePresenter.getMasthead().setLabelContents(name + I18nUtil.getConstant().informationLabel());

    // set the browser window's title e.g. "Email: New Email"
    Window.setTitle(I18nUtil.getConstant().emailWindowTitle() + name);
  }
}
