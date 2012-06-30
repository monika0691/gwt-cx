/**
 * (C) Copyright 2012 Kiahu
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

package com.kiahu.sample.client.view;

import com.bradrydzewski.gwt.calendar.client.Calendar;
import com.google.inject.Inject;
import com.gwtcx.client.uihandlers.CalendarUiHandlers;
import com.gwtcx.extgwt.client.view.AbstractCalendarView;
import com.kiahu.sample.client.presenter.CalendarPresenter;

public class CalendarView extends AbstractCalendarView<CalendarUiHandlers>
    implements CalendarPresenter.MyView {

  @Inject
  public CalendarView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Calendar calendar) {
    super(toolBar, calendar);
  }

  // @Override
  // protected void initToolBar() { }

  // @Override
  // protected void initStatusBar() { }
}
