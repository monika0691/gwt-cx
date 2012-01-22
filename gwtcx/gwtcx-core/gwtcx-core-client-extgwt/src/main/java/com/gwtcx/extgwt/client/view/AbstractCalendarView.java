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
import com.bradrydzewski.gwt.calendar.client.Calendar;
import com.bradrydzewski.gwt.calendar.client.CalendarSettings;
import com.bradrydzewski.gwt.calendar.client.CalendarSettings.Click;
import com.bradrydzewski.gwt.calendar.client.CalendarViews;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.resources.ToolBarIcons;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;

/**
 * AbstractCalendarView
 */
public abstract class AbstractCalendarView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;

  protected final com.gwtcx.extgwt.client.widgets.ToolBar toolBar;
  protected final Calendar calendar;

  protected CalendarSettings settings;

  protected ToggleButton monthButton;
  protected ToggleButton weekButton;
  protected ToggleButton dayButton;

  @Inject
  public AbstractCalendarView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Calendar calendar) {
    super();

    this.toolBar = toolBar;
    this.calendar = calendar;

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.settings = new CalendarSettings();
    this.settings.setOffsetHourLabels(false);  // change hour offset to false to facilitate Google style
    this.settings.setEnableDragDrop(true);
    this.settings.setEnableDragDropCreation(true);
    this.settings.setTimeBlockClickNumber(Click.None);

    this.calendar.setSettings(settings);
    this.calendar.setView(CalendarViews.DAY, 7);
    this.calendar.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    // this.calendar.scrollToHour(8);  // not implemented :-)

    this.panel.add(this.toolBar);   // , new VerticalLayoutData(1, -1));
    this.panel.add(this.calendar);  // , new VerticalLayoutData(1, -1));

    // this.panel.forceLayout();

    this.panel.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {

        int width = event.getWidth();
        int height = event.getHeight();

        Log.debug("ResizeHandler() - width: " + width + " height: " + height);

        toolBar.setWidth(width + "px");
        calendar.setWidth(width + "px");
        calendar.setHeight(height - 30 + "px");
      }
    });

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initToolBar();

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  // public void setResultSet(List<CalendarDto> resultSet) {  }

  protected void initToolBar() {

    // getToolBar().setPack(BoxLayoutPack.END);

    ToolTipConfig config = new ToolTipConfig();
    config.setTitleHtml("Day");
    config.setBodyHtml("Switch to day view");
    config.setTrackMouse(true);

    dayButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.day(), "Day", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        monthButton.setValue(false);
        weekButton.setValue(false);
        dayButton.setValue(true);
        calendar.setView(CalendarViews.DAY, 1);
      }
    });

    // getToolBar().addSeparator();

    config = new ToolTipConfig();
    config.setTitleHtml("Week");
    config.setBodyHtml("Switch to week view");
    config.setTrackMouse(true);

    weekButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.week(), "Week", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        monthButton.setValue(false);
        weekButton.setValue(true);
        dayButton.setValue(false);
        calendar.setView(CalendarViews.DAY, 7);
      }
    });

    // getToolBar().addSeparator();

    config = new ToolTipConfig();
    config.setTitleHtml("Month");
    config.setBodyHtml("Switch to month view");
    config.setTrackMouse(true);

    monthButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.month(), "Month", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        monthButton.setValue(true);
        weekButton.setValue(false);
        dayButton.setValue(false);
        calendar.setView(CalendarViews.MONTH);
      }
    });

    getToolBar().addFill();

    monthButton.setValue(false);
    weekButton.setValue(true);
    dayButton.setValue(false);
    calendar.setView(CalendarViews.DAY, 7);
  }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public com.gwtcx.extgwt.client.widgets.ToolBar getToolBar() {
    return toolBar;
  }
}


/*


    // this.toolBar.setSpacing(4);

      // resizeTimer.schedule(2000);

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



  // Info.display("Click", ((ToggleButton) event.getSource()).getText() + " clicked, value: " + ((ToggleButton) event.getSource()).getValue());

    // calendar.setDate(new Date()); //calendar date, not required
    // calendar.setDays(3); //number of days displayed at a time, not required
    // calendar.setWidth("500px");
    // calendar.setHeight("400px");

*/
