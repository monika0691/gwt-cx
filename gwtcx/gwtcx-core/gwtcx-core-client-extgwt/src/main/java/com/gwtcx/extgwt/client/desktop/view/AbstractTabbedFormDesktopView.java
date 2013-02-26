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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.shared.dto.EntityDto;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FormPanel;

/**
 * AbstractTabbedFormDesktopView
 */
public abstract class AbstractTabbedFormDesktopView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  // public static final String ENTITY_CONTEXT_AREA_STYLE_NAME = "gwtcx-Entity-ContextArea";

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  public static final int DEFAULT_MARGIN = 8;

  protected final EventBus eventBus;
  protected final FormPanel form;
  protected final TabPanel tabPanel;

  protected EntityDto dto = null;
  protected VerticalLayoutContainer panel;

  @Inject
  public AbstractTabbedFormDesktopView(final EventBus eventBus, final FormPanel form, final TabPanel tabPanel) {
    super();

    Log.debug("AbstractTabbedFormView()");

    this.eventBus= eventBus;
    this.form= form;
    this.tabPanel= tabPanel;

    setPanel(new VerticalLayoutContainer());

    getPanel().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    getForm().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    getTabPanel().setWidth(CONTEXT_AREA_WIDTH);

    getPanel().add(getForm(), new VerticalLayoutData(1, -1));
    getForm().setWidget(getTabPanel());

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      @Override
      public void execute() {

        Log.debug("execute()");

        resize();
      }
    });

    bindCustomUiHandlers();
  }

  protected void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    getPanel().setSize(width + "px", height + "px");
    getForm().setSize(width + "px", height + "px");
    getTabPanel().setWidth(width + "px");

    getPanel().onResize();
  }

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

  public FormPanel getForm() {
    return form;
  }

  public TabPanel getTabPanel() {
    return tabPanel;
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
}