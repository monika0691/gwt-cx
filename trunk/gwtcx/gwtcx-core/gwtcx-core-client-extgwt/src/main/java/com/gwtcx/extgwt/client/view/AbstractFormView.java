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

package com.gwtcx.extgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.shared.dto.EntityDto;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FormPanel;

/**
 * AbstractFormView
 */
public abstract class AbstractFormView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  // public static final String ENTITY_CONTEXT_AREA_STYLE_NAME = "gwtcx-Entity-ContextArea";

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  public static final int DEFAULT_MARGIN = 8;

  protected VerticalLayoutContainer panel;
  protected FormPanel form;

  protected EntityDto dto;

  protected final EventBus eventBus;
  // private EntityToolBar toolBar;

  @Inject
  public AbstractFormView(final EventBus eventBus) {
    super();

    Log.debug("AbstractFormView()");

    this.eventBus= eventBus;

    dto = null;

    setPanel(new VerticalLayoutContainer());
    getPanel().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    setForm(new FormPanel());
    getForm().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    getPanel().add(getForm(), new VerticalLayoutData(1, -1));

    /*

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      @Override
      public void execute() {

        Log.debug("execute()");

        resize();
      }
    });

    */

    // /*

    this.panel.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {

        int width = event.getWidth();
        int height = event.getHeight();

        Log.debug("ResizeHandler() - width: " + width + " height: " + height);

        panel.setSize(width + "px", height + "px");
        form.setSize(width + "px", height + "px");
        // form.forceLayout();
      }
    });

    // */

    bindCustomUiHandlers();
  }

  /*

  protected void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    panel.setSize(width + "px", height + "px");
    form.setSize(width + "px", height + "px");
    // panel.onResize();
  }

  */

  protected void bindCustomUiHandlers() { }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public VerticalLayoutContainer getPanel() {
    return panel;
  }

  public void setPanel(VerticalLayoutContainer panel) {
    this.panel = panel;;
  }

  public void setForm(FormPanel form) {
    this.form = form;;
  }

  public FormPanel getForm() {
    return form;
  }

  public void setId(String id) {

    Log.warn("Don't forget to @Override setId()");

    /*

    if (dto != null) {
      dto.setId(id);

      // set Masthead label and the browser window's title
      setMastheadLabel(dto.getName());
    }

    */
  }

  /*

  public void setResultSet(EntityDto dto) {

    try {
      if (dto != null) {
        this.dto = dto;
        setFields(this.dto);
      }
    } catch (Exception e) {
      Log.warn("Unable to set server response: " + e);
    }
  }

  public void setFields(EntityDto dto) {

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

  */
}