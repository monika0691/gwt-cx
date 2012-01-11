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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.client.uihandlers.DashboardsUiHandlers;
import com.gwtcx.smartgwt.client.view.AbstractDashboardsView;
import com.gwtcx.smartgwt.client.widgets.AmChart;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AmChartsDashboardsView extends AbstractDashboardsView<DashboardsUiHandlers> implements
    DashboardsPresenter.MyView {

  // @Inject
  public AmChartsDashboardsView() {
    super();

    drawAmCharts(panel);
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }

  public void setResultSet() { }

  private static String html = "<div id=\"chart_nested_div\" style=\"position: absolute; z-index: 1000000\"> </div>\n";
  private HTMLFlow htmlFlow;

  protected void drawAmCharts(VLayout panel) {

    AmChart chart1 = new AmChart();

    HLayout northLayout = new HLayout();
    northLayout.setHeight("50%");
    northLayout.setBackgroundColor("white");

    HLayout southLayout = new HLayout();
    southLayout.setHeight("50%");
    southLayout.setBackgroundColor("white");

    northLayout.addMember(chart1);

    panel.addMember(northLayout);
    panel.addMember(southLayout);


    /*

    HLayout northLayout = new HLayout();
    northLayout.setHeight("100%");
    northLayout.setBackgroundColor("white");


    htmlFlow = new HTMLFlow(html);
    northLayout.addMember(htmlFlow);

    panel.addMember(northLayout);

    loadAmChart();

    */

    /*

    AmChart chart1 = new AmChart();

    HLayout northLayout = new HLayout();
    northLayout.setHeight("50%");
    northLayout.setBackgroundColor("white");

    HLayout southLayout = new HLayout();
    southLayout.setHeight("50%");
    southLayout.setBackgroundColor("white");

    northLayout.addMember(chart1);

    panel.addMember(northLayout);
    panel.addMember(southLayout);


    */

  }

  public void loadAmChart() {

    Timer t = new Timer() {
      public void run() {

        Log.debug("run()");

        Element div = DOM.getElementById("chart_nested_div");

        if (div != null) {
          Log.debug("DOM.getElementById(\"chart_nested_div\") - " + div.getId());
        }

        Log.debug("drawAmChart()");
        drawAmChart();
      }
    };

    // Schedule the timer to run once after waiting 2 seconds
    t.schedule(2000);
  }

  private native void drawAmChart() /*-{

     var chartData = [{country:"Czech Republic",litres:156.90},
                {country:"Ireland",litres:131.10},
                {country:"Germany",litres:115.80},
                {country:"Australia",litres:109.90},
                {country:"Austria",litres:108.30},
                {country:"UK",litres:99.00}];

            var chart = new $wnd.AmCharts.AmPieChart();
            chart.dataProvider = chartData;
            chart.titleField = "country";
            chart.valueField = "litres";

            var legend = new $wnd.AmCharts.AmLegend();
            legend.align = "center";
            chart.addLegend(legend);

            chart.write("chart_nested_div");

  }-*/;

}

    /*

    HLayout northLayout = new HLayout();
    northLayout.setHeight("100%");
    northLayout.setBackgroundColor("white");


    htmlFlow = new HTMLFlow(html);
    northLayout.addMember(htmlFlow);

    panel.addMember(northLayout);

    loadAmChart();

    */

    /*

    AmChart chart1 = new AmChart();

    HLayout northLayout = new HLayout();
    northLayout.setHeight("50%");
    northLayout.setBackgroundColor("white");

    HLayout southLayout = new HLayout();
    southLayout.setHeight("50%");
    southLayout.setBackgroundColor("white");

    northLayout.addMember(chart1);

    panel.addMember(northLayout);
    panel.addMember(southLayout);


    */



