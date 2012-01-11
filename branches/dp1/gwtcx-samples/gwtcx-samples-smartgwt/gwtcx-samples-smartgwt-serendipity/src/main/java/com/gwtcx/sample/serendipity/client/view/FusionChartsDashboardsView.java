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

package com.gwtcx.sample.serendipity.client.view;

import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.smartgwt.client.flashlets.FusionChart;
import com.gwtcx.client.uihandlers.DashboardsUiHandlers;
import com.gwtcx.smartgwt.client.view.AbstractDashboardsView;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FusionChartsDashboardsView extends AbstractDashboardsView<DashboardsUiHandlers> implements
    DashboardsPresenter.MyView {

  // @Inject
  public FusionChartsDashboardsView() {
    super();

    drawFusionCharts(panel);
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }

  public void setResultSet() { }


  protected void drawFusionCharts(VLayout panel) {

    FusionChart chart1 = new FusionChart("FCF_StackedColumn2D.swf", "400", "350", "StCol2D.xml");

    FusionChart chart2 = new FusionChart("FCF_StackedBar2D.swf", "400", "350", "StBar2D.xml");

    // AmChart chart2 = new AmChart("amline.swf", "600", "350", "line_and_area_settings.xml", "line_and_area_data.xml"); // 600, 400
    // FusionChart chart2 = new FusionChart("FCF_StackedArea2D.swf", "400", "350", "StArea2D.xml"); // 600, 350

    FusionChart chart3 = new FusionChart("FCF_Doughnut2D.swf", "400", "350", "Doughnut2D.xml"); // 500, 369

    FusionChart chart4 = new FusionChart("FCF_Funnel.swf", "350", "300", "Funnel.xml"); // 400, 300

    HLayout northLayout = new HLayout();
    northLayout.setHeight("50%");
    northLayout.setBackgroundColor("#FFFFFF");

    northLayout.addMember(chart1);
    northLayout.addMember(chart2);

    HLayout southLayout = new HLayout();
    southLayout.setHeight("50%");
    southLayout.setBackgroundColor("#FFFFFF");

    southLayout.addMember(chart3);
    southLayout.addMember(chart4);

    panel.addMember(northLayout);
    panel.addMember(southLayout);
  }
}