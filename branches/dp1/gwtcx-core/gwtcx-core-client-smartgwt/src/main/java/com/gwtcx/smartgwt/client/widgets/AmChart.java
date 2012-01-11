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

package com.gwtcx.smartgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
// import com.smartgwt.client.widgets.events.DrawEvent;
// import com.smartgwt.client.widgets.events.DrawHandler;

public class AmChart extends Canvas {

  private static final String ID_PREFIX = "AmChartId_";

  private static int count;

  private boolean initialised = false;
  private String chartId;

  {
    count++;
    setOverflow(Overflow.VISIBLE);
    setCanDragResize(false);
    setRedrawOnResize(false);
    // setZIndex(0);
  }

  private static String html = "<div id=\"chart_nested_div\" style=\"position: absolute; z-index: 1000000\"> </div>"
      + "<script type='text/javascript' language='javascript'>"
      + "var chartData = [{country:\"Czech Republic\",litres:156.90},"
      + "{country:\"Ireland\",litres:131.10},"
      + "{country:\"Germany\",litres:115.80},"
      + "{country:\"Australia\",litres:109.90},"
      + "{country:\"Austria\",litres:108.30},"
      + "{country:\"UK\",litres:99.00}];"
      + "var chart = new $wnd.AmCharts.AmPieChart();"
      + "chart.dataProvider = chartData;"
      + "chart.titleField = \"country\";"
      + "chart.valueField = \"litres\";"
      + "var legend = new $wnd.AmCharts.AmLegend();"
      + "legend.align = \"center\";"
      + "chart.addLegend(legend);"
      + "chart.write(\"chart_nested_div\");"
      + "</script>";

  public AmChart(){
    super(ID_PREFIX + (count + 1));
    // super(ID_PREFIX + count);

    Log.debug("AmChart()");

    chartId = ID_PREFIX + count;

    Log.debug("id: " + ID_PREFIX + count);
    Log.debug("chartId: " + chartId);

    this.setContents(html);

    /*

    addDrawHandler(new DrawHandler() {
      @Override
      public void onDraw(DrawEvent event) {
        Log.debug("drawChart()");
        drawChart();
      }
    });

    */
  }

  // called by BaseWidget doInit()
  protected void onInit() {
    Log.debug("onInit()");
  }

  /*

  @Override
  public String getInnerHTML() {

    Log.debug("getInnerHTML()");

    if (this.getContents() != null) {
      // return "<div style='width=100%; height=100%; z-index:999999' id=" + chartId + ">" + getContents()+ "</div>";
      return "<div style='width=500px; height=400px; z-index:999999' id=" + chartId + ">" + getContents()+ "</div>";
    }

    // return "<div style='width=100%; height=100%; z-index:999999' id=" + chartId + ">" + "</div>";
    return "<div style='width=500px; height=400px; z-index:999999' id=" + chartId + ">" + "</div>";
  }

  */

  public native boolean drawChart() /*-{

    var result = true;


    if (! this.@com.gwtcx.client.smartgwt.widgets.AmChart::initialised) {

      if (typeof $wnd.AmCharts.AmPieChart=='function') {

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

            var id = this.@com.gwtcx.client.smartgwt.widgets.AmChart::chartId;

            chart.write(id);

            this.@com.gwtcx.client.smartgwt.widgets.AmChart::initialised = true;

            result = false;

      }
    }

    return result;

  }-*/;

  /*

  protected void onDraw() {
    Log.debug("onDraw()");
    Log.debug("chartId: " + chartId);

    if (drawChart()) {
      Log.debug("drawChart() returned true");
    }
  }

  */

  protected void onDestroy() {
    Log.debug("onDestroy()");
  }

  public boolean isLoaded() {
    return initialised;
  }
}