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
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * AbstractPagingView
 */
public abstract class AbstractPagingView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";
  // public static final String TOOLBAR_WIDTH = "100%";
  public static final String TOOLBAR_HEIGHT = "26px";

  protected VerticalLayoutContainer panel;

  protected final com.gwtcx.extgwt.client.widgets.ToolBar toolBar;
  protected final Grid<?> grid;

  @Inject
  public AbstractPagingView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Grid<?> grid) {
    super();

    Log.debug("AbstractPagingView()");

    this.toolBar = toolBar;
    this.grid = grid;

    // panel.setStyleName(StyleTokens.contextArea);
    setPanel(new VerticalLayoutContainer());
    getPanel().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    getToolBar().setSize(CONTEXT_AREA_WIDTH, TOOLBAR_HEIGHT);
    getGrid().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Tool Bar, and the Grid to the View's layout container
    getPanel().add(getToolBar(), new VerticalLayoutData(1, -1));
    getPanel().add(getGrid(), new VerticalLayoutData(1, 1));

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

  public com.gwtcx.extgwt.client.widgets.ToolBar getToolBar() {
    return toolBar;
  }

  public Grid<?> getGrid() {
    return grid;
  }

  // public StatusBar getStatusBar() {
  //   return statusBar;
  // }
}

/*

this.panel.addResizeHandler(new ResizeHandler() {
  @Override
  public void onResize(ResizeEvent event) {

    int width = event.getWidth();
    int height = event.getHeight();

    Log.debug("ResizeHandler() - width: " + width + " height: " + height);

    toolBar.setWidth(width + "px");
    grid.setWidth(width + "px");
    grid.setHeight(height - 26 + "px");
  }
});

*/



/*




    toolBar.setWidth(width + "px");
    grid.setWidth(width + "px");
    grid.setHeight(height - 26 + "px");


    // panel.forceLayout();





    Size s = panel.getElement().getStyleSize();
    // Size s = XElement.as(panel.getElement().getParentElement()).getSize(true);

    this.panel.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {
        resizeTimer.schedule(2000);
      }
    });


  private Timer resizeTimer = new Timer() {
    @Override
    public void run() {

      Log.debug("run()");

      toolBar.setWidth(width + "px");

      calendar.setWidth(width + "px");
      calendar.setHeight(height - 36 + "px");
      calendar.doSizing();
      calendar.doLayout();
    }
  };


*/