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

import java.util.Date;

import com.allen_sauer.gwt.log.client.Log;
import com.bradrydzewski.gwt.calendar.client.Calendar;
import com.bradrydzewski.gwt.calendar.client.CalendarSettings;
import com.bradrydzewski.gwt.calendar.client.CalendarSettings.Click;
import com.bradrydzewski.gwt.calendar.client.CalendarViews;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.resources.ToolBarIcons;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

/**
 * AbstractCalendarView
 */
public abstract class AbstractCalendarView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";
  // public static final String TOOLBAR_WIDTH = "100%";
  public static final String TOOLBAR_HEIGHT = "26px";

  public static final int DAY = 1;
  public static final int WEEK = 7;
  public static final int MONTH = 30;

  protected VerticalLayoutContainer panel;

  protected final com.gwtcx.extgwt.client.widgets.ToolBar toolBar;
  protected final Calendar calendar;

  protected CalendarSettings settings;

  protected TextButton todayButton;
  protected TextButton previousButton;
  protected TextButton nextButton;
  protected ToggleButton monthButton;
  protected ToggleButton weekButton;
  protected ToggleButton dayButton;

  protected LabelToolItem periodLabel;

  @Inject
  public AbstractCalendarView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Calendar calendar) {
    super();

    this.toolBar = toolBar;
    this.calendar = calendar;

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    this.toolBar.setSize(CONTEXT_AREA_WIDTH, TOOLBAR_HEIGHT);
    this.calendar.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.settings = new CalendarSettings();
    this.settings.setOffsetHourLabels(false);  // change hour offset to false to facilitate Google style
    this.settings.setEnableDragDrop(true);
    this.settings.setEnableDragDropCreation(true);
    this.settings.setTimeBlockClickNumber(Click.None);

    this.calendar.setSettings(settings);
    // this.calendar.setView(CalendarViews.DAY, WEEK);
    // this.calendar.scrollToHour(8);  // not implemented :-)

    this.panel.add(this.toolBar, new VerticalLayoutData(1, -1));
    this.panel.add(this.calendar);
    // this.panel.add(this.calendar, new VerticalLayoutData(1, 1));

    // TO DO: there seems to be a sizing bug related to ToolBar.addFill()
    // so we need to use a ResizeHandler rather than a ScheduledCommand.

    /*

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
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
        toolBar.setWidth(width + "px");
        calendar.setWidth(width + "px");
        calendar.setHeight(height - 26 + "px");
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

  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initToolBar();

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  // public void setResultSet(List<CalendarDto> resultSet) {  }

  protected void initToolBar() {

    todayButton = getToolBar().addTextButton(ToolBarIcons.INSTANCE.date(), "Today", null, new SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {

        Date today = new Date();
        calendar.setDate(today);

        if (dayButton.getValue()) {
          updatePeriodLabel(DAY, today);
        } else if (weekButton.getValue()) {
          updatePeriodLabel(WEEK, today);
        } else if (monthButton.getValue()) {
          updatePeriodLabel(MONTH, today);
        }
      }
    });

    previousButton = getToolBar().addTextButton(ToolBarIcons.INSTANCE.previous(), null, new SelectHandler() {
      @SuppressWarnings("deprecation")
      @Override
      public void onSelect(SelectEvent event) {

        // 1 or 7 or 3 ???
        int days = calendar.getView().getDisplayedDays();

        if (days == 3) {
          days = MONTH;
        }

        Date currentDate = calendar.getDate();
        Date newDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() - days);

        calendar.setDate(newDate);

        Log.debug("Date: " + currentDate.toString() + " - days: " + days);

        updatePeriodLabel(days, newDate);
      }
    });

    nextButton = getToolBar().addTextButton(ToolBarIcons.INSTANCE.next(), null, new SelectHandler() {
      @SuppressWarnings("deprecation")
      @Override
      public void onSelect(SelectEvent event) {

        // 1 or 7 or 3 ???
        int days = calendar.getView().getDisplayedDays();

        if (days == 3) {
          days = MONTH;
        }

        Date currentDate = calendar.getDate();
        Date newDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() + days);

        calendar.setDate(newDate);

        Log.debug("Date: " + currentDate.toString() + " + days: " + days);

        updatePeriodLabel(days, newDate);
      }
    });

    // default is "Day"
    periodLabel = getToolBar().addLabel("&nbsp");
    updatePeriodLabel(1, calendar.getDate());

    getToolBar().addFill();

    ToolTipConfig config = getToolBar().createToolTipConfig("Day", "Switch to day view");

    dayButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.day(), "Day", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        dayButton.setValue(true);
        weekButton.setValue(false);
        monthButton.setValue(false);
        calendar.setView(CalendarViews.DAY, DAY);
        updatePeriodLabel(1, calendar.getDate());
      }
    });

    config = getToolBar().createToolTipConfig("Week", "Switch to week view");

    weekButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.week(), "Week", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        dayButton.setValue(false);
        weekButton.setValue(true);
        monthButton.setValue(false);
        calendar.setView(CalendarViews.DAY, WEEK);
        updatePeriodLabel(7, calendar.getDate());
      }
    });

    config = getToolBar().createToolTipConfig("Month", "Switch to month view");

    monthButton = getToolBar().addToggleButton(ToolBarIcons.INSTANCE.month(), "Month", config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        dayButton.setValue(false);
        weekButton.setValue(false);
        monthButton.setValue(true);
        calendar.setView(CalendarViews.MONTH);
        updatePeriodLabel(MONTH, calendar.getDate());
      }
    });

    // default is "Day"
    dayButton.setValue(true);
    weekButton.setValue(false);
    monthButton.setValue(false);
    calendar.setView(CalendarViews.DAY, DAY);
  }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public com.gwtcx.extgwt.client.widgets.ToolBar getToolBar() {
    return toolBar;
  }

  @SuppressWarnings("deprecation")
  private void updatePeriodLabel(int days, Date newDate) {
    DateTimeFormat dateTimeFormat;

    if (days == DAY) {
      // e.g. Monday, January 23, 2012 in the default locale
      dateTimeFormat = DateTimeFormat.getFormat("EEEE, MMMM dd, yyyy");
      periodLabel.setLabel(dateTimeFormat.format(newDate));
    } else if (days == WEEK) {
      dateTimeFormat = DateTimeFormat.getFormat("MMM dd");
      String text = dateTimeFormat.format(newDate) + " - " ;

      Date toDate = new Date(newDate.getYear(), newDate.getMonth(), newDate.getDate() + WEEK);

      if (toDate.getMonth() != newDate.getMonth()) {
        dateTimeFormat = DateTimeFormat.getFormat("MMM dd, yyyy");
      }
      else {
        dateTimeFormat = DateTimeFormat.getFormat("dd, yyyy");
      }

      text += dateTimeFormat.format(toDate);
      periodLabel.setLabel(text);
    } else if (days == MONTH) {
      dateTimeFormat = DateTimeFormat.getFormat("MMMM yyyy");
      periodLabel.setLabel(dateTimeFormat.format(newDate));
    }
  }
}

/*

    // config = getToolBar().createToolTipConfig("Next period", "Jump to the next period");
    // ToolTipConfig config = getToolBar().createToolTipConfig("Previous period", "Jump to the previous period");

    // getToolBar().setPack(BoxLayoutPack.END);
    // getToolBar().addSeparator();

    // this.toolBar.setSpacing(4);






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



  // Info.display("Click", ((ToggleButton) event.getSource()).getText() + " clicked, value: " + ((ToggleButton) event.getSource()).getValue());

    // calendar.setDate(new Date()); //calendar date, not required
    // calendar.setDays(3); //number of days displayed at a time, not required
    // calendar.setWidth("500px");
    // calendar.setHeight("400px");

*/
