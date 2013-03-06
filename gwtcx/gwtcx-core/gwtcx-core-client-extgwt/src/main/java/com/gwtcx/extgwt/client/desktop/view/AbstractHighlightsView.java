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

package com.gwtcx.extgwt.client.desktop.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtcx.client.resources.TextResources;
import com.gwtcx.extgwt.client.StyleTokens;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public abstract class AbstractHighlightsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;
  protected HTML htmlPanel;

  // private HTMLPane htmlPane;

  // @Inject
  public AbstractHighlightsView() {
    super();

    Log.debug("HighlightsView()");

    this.panel = new VerticalLayoutContainer();
    this.panel.setStyleName(StyleTokens.contextArea);
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.htmlPanel = new HTML();
    this.htmlPanel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    String html = TextResources.INSTANCE.getHighlightsHtml().getText();
    this.htmlPanel.setHTML(html);

    // add the HTML Panel to the View's layout container
    this.panel.add(this.htmlPanel);  // , new VerticalLayoutData(1, 1));

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
        htmlPanel.setSize(width + "px", height + "px");
      }
    });

    // */

    bindCustomUiHandlers();
  }

  /*

  public void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    panel.setSize(width + "px", height + "px");
    panel.onResize();
  }

  */

  protected void bindCustomUiHandlers() { }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }
}