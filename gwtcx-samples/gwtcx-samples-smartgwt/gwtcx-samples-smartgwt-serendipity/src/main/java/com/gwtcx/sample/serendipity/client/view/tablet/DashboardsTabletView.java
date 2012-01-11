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

package com.gwtcx.sample.serendipity.client.view.tablet;

import java.util.Date;

import org.moxieapps.gwt.highcharts.client.Axis;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Style;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.XAxis;
import org.moxieapps.gwt.highcharts.client.YAxis;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.FunnelDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.Labels;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.PlotBandLabel;
import org.moxieapps.gwt.highcharts.client.labels.PyramidDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PyramidPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.client.uihandlers.DashboardsUiHandlers;
import com.gwtcx.smartgwt.client.view.AbstractDashboardsView;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.WidgetCanvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class DashboardsTabletView extends AbstractDashboardsView<DashboardsUiHandlers> implements
    DashboardsPresenter.MyView {

  // @Inject
  public DashboardsTabletView() {
    super();

    Log.debug("DashboardsTabletView()");

    panel.setOverflow(Overflow.AUTO);

    if (GWT.isScript()) {

      HLayout northLayout = new HLayout();
      northLayout.setHeight("50%");
      northLayout.setBackgroundColor("white");
      northLayout.setMembersMargin(8);

      final Chart chart1 = createPyramidChart();
      chart1.setWidth100();
      final Canvas chart1Container = new Canvas();
      chart1Container.setSize("500", "420");
      final WidgetCanvas chart1WidgetCanvas = new WidgetCanvas(chart1);

      chart1Container.addChild(chart1WidgetCanvas);
      northLayout.addMember(chart1Container);

      HLayout southLayout = new HLayout();
      southLayout.setHeight("50%");
      southLayout.setBackgroundColor("white");
      southLayout.setMembersMargin(8);

      final Chart chart2 = createFunnelChart();
      chart2.setWidth100();
      final Canvas chart2Container = new Canvas();
      chart2Container.setSize("500", "420");
      final WidgetCanvas chart2WidgetCanvas = new WidgetCanvas(chart2);

      chart2Container.addChild(chart2WidgetCanvas);
      southLayout.addMember(chart2Container);

      panel.addMember(northLayout);
      panel.addMember(southLayout);
    }
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }

  public void setResultSet() { }

  public Chart createFunnelChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.FUNNEL)
          .setChartTitleText("<b>" + "Funnel Chart" + "</b>")
          // .setNeckWidth("100%")
          // .setNeckHeight("0%")
          .setMargin(50, 10, 60, 170)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setFunnelPlotOptions(new FunnelPlotOptions()
              .setFunnelDataLabels(new FunnelDataLabels()
              .setAlign(Labels.Align.LEFT)
              .setX(-300)
              .setEnabled(true)
              .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          // return dataLabelsData.getPointName();
                          return "<b>" + dataLabelsData.getPointName() + "</b>: (" +
                          NumberFormat.getFormat("#,###").format(dataLabelsData.getYAsDouble()) + ")";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " +
                      NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble());
                  }
              })
          );

      // chart.setWidth("0%");

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Impressions", 15654),
              new Point("Clicks", 4064),
              new Point("Downloads", 1987),
              new Point("Purchase", 976),
              new Point("Repeat Purchase", 846)
          })


      /*

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Repeat Purchase", 846),
              new Point("Purchase", 976),
              new Point("Downloads", 1987),
              new Point("Clicks", 4064),
              new Point("Impressions", 15654)
          })

      */

      );

      return chart;
  }


  public Chart createPyramidChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PYRAMID)
          .setChartTitleText("<b>" + "Pyramid Chart" + "</b>")
          // .setNeckWidth("100%")
          // .setNeckHeight("0%")
          .setMargin(50, 10, 60, 170)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setPyramidPlotOptions(new PyramidPlotOptions()
              .setPyramidDataLabels(new PyramidDataLabels()
              // .setAlign(Labels.Align.LEFT)
              // .setX(-300)
              .setEnabled(true)
              .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          // return dataLabelsData.getPointName();
                          return "<b>" + dataLabelsData.getPointName() + "</b>: (" +
                          NumberFormat.getFormat("#,###").format(dataLabelsData.getYAsDouble()) + ")";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " +
                      NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble());
                  }
              })
          );

      // chart.setWidth("0%");

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Repeat Purchase", 846),
              new Point("Purchase", 976),
              new Point("Downloads", 1987),
              new Point("Clicks", 4064),
              new Point("Impressions", 15654)
          })
      );

      return chart;
  }


  public Chart createBasicPieChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PIE)
          .setChartTitleText("<b>" + "Pie Chart" + "</b>")
          // .setMargin(10, 10, 10, 10)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setPiePlotOptions(new PiePlotOptions()
              .setAllowPointSelect(true)
              .setCursor(PlotOptions.Cursor.POINTER)
              .setPieDataLabels(new PieDataLabels()
                  .setConnectorColor("#000000")
                  .setEnabled(true)
                  .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          return dataLabelsData.getPointName() + ": " + dataLabelsData.getYAsDouble() + " %";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                  }
              })
          );

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Impressions", 45.0),
              new Point("Clicks", 26.8),
              new Point("Downloads", 12.8)
                  .setSliced(true)
                  .setSelected(true),
              new Point("Purchase", 8.5),
              new Point("Repeat Purchase", 6.9)
          })
      );

      return chart;
  }


  public Chart createDonutChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PIE)
          .setMargin(50, 0, 0, 0)
          .setChartTitleText("<b>" + "Donut Chart" + "</b>")
          .setChartSubtitleText("Browser Market Share - Inner circle: 2010, Outer circle: 2011")
          .setPlotBackgroundColor("none")
          .setPlotBorderWidth(0)
          .setPlotShadow(false)
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                          toolTipData.getPointName() + ": " + toolTipData.getYAsDouble() + " %";
                  }
              })
          );

      chart.addSeries(chart.createSeries()
          .setName("2010")
          .setPlotOptions(new PiePlotOptions()
              .setSize(.45)
              .setInnerSize(.20)
              .setDataLabels(new DataLabels()
                  .setEnabled(false)
              )
          )
          .setPoints(new Point[]{
              new Point("Firefox", 44.2).setColor("#4572A7"),
              new Point("IE", 46.6).setColor("#AA4643"),
              new Point("Chrome", 3.1).setColor("#89A54E"),
              new Point("Safari", 2.7).setColor("#80699B"),
              new Point("Opera", 2.3).setColor("#3D96AE"),
              new Point("Others", 0.4).setColor("#DB843D")
          })
      );

      chart.addSeries(chart.createSeries()
          .setName("2011")
          .setPlotOptions(new PiePlotOptions()
              .setInnerSize(.45)
              .setPieDataLabels(new PieDataLabels()
                  .setEnabled(true)
                  .setColor("#000000")
                  .setConnectorColor("#000000")
              )
          )
          .setPoints(new Point[]{
              new Point("Firefox", 45.0).setColor("#4572A7"),
              new Point("IE", 26.8).setColor("#AA4643"),
              new Point("Chrome", 12.8).setColor("#89A54E"),
              new Point("Safari", 8.5).setColor("#80699B"),
              new Point("Opera", 6.2).setColor("#3D96AE"),
              new Point("Others", 0.2).setColor("#DB843D")
          })
      );

      return chart;
  }

  public Chart createSplineWithPlotBandsChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.SPLINE)
          .setChartTitleText("Wind speed during two days")
          .setChartSubtitleText("October 6th and 7th 2009 at two locations in Vik i Sogn, Norway")
          .setLegend(new Legend()
              .setEnabled(false)
          )
          .setCredits(new Credits()
              .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return DateTimeFormat.getFormat("d. MMMM YYYY HH:00").format(
                          new Date(toolTipData.getXAsLong())
                      ) + ": " + toolTipData.getYAsDouble() + " m/s";
                  }
              })
          )
          .setSplinePlotOptions(new SplinePlotOptions()
              .setLineWidth(4)
              .setHoverStateLineWidth(5)
              .setMarker(new Marker()
                  .setEnabled(false)
                  .setHoverState(new Marker()
                      .setEnabled(true)
                      .setSymbol(Marker.Symbol.CIRCLE)
                      .setRadius(5)
                      .setLineWidth(1)
                  )
              )
              .setPointInterval(3600000)  // one hour
              .setPointStart(
                  DateTimeFormat.getFormat("yyyy-MM-dd").parse("2009-10-06").getTime()
              )
          );

      chart.getXAxis()
          .setType(Axis.Type.DATE_TIME);

      final YAxis axis = chart.getYAxis();
      final Color blueColor = new Color(68, 170, 213, 0.1);
      final Color clearColor = new Color(0, 0, 0, 0);
      axis.setAxisTitleText("Wind speed (m/s)")
          .setMin(0)
          .setMinorGridLineWidth(0)
          .setGridLineWidth(0)
          .setAlternateGridColor(null)
          .setPlotBands(
              axis.createPlotBand()   // Light air
                  .setFrom(0.3)
                  .setTo(1.5)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Light air")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Light breeze
                  .setFrom(1.5)
                  .setTo(3.3)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Light breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Gentle breeze
                  .setFrom(3.3)
                  .setTo(5.5)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Gentle breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Moderate breeze
                  .setFrom(5.5)
                  .setTo(8)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Moderate breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Fresh breeze
                  .setFrom(8)
                  .setTo(11)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Fresh breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Strong breeze
                  .setFrom(11)
                  .setTo(14)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Strong breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // High wind
                  .setFrom(14)
                  .setTo(15)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("High wind")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  )
          );

      chart.addSeries(chart.createSeries()
          .setName("Hestavollane")
          .setPoints(new Number[]{
              4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9, 7.1,
              7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8, 5.9, 7.4,
              8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4, 12.1, 9.5, 7.5,
              7.1, 7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8, 2.9, 1.3, 4.4, 4.2,
              3.0, 3.0
          })
      );
      chart.addSeries(chart.createSeries()
          .setName("Voll")
          .setPoints(new Number[] {
              0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3, 0.0,
              0.0, 0.4, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
              0.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7, 3.9, 1.7, 2.3,
              3.0, 3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0, 0.9, 0.4, 0.3, 0.5, 0.4
          })
      );

      return chart;
  }


  public Chart createStackedAreaChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.AREA)
          .setChartTitleText("Historic and Estimated Worldwide Population Growth by Region")
          .setChartSubtitleText("Source: Wikipedia.org")
          .setAreaPlotOptions(new AreaPlotOptions()
              .setStacking(PlotOptions.Stacking.NORMAL)
              .setLineColor("#666666")
              .setLineWidth(1)
              .setMarker(new Marker()
                  .setLineWidth(1)
                  .setLineColor("#666666")
              )
          )
          .setToolTip(new ToolTip()
              .setFormatter(
                  new ToolTipFormatter() {
                      public String format(ToolTipData toolTipData) {
                          return toolTipData.getXAsDouble() + ": " +
                              NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble()) + " millions";
                      }
                  }
              )
          );

      chart.getXAxis()
          .setCategories(
              "1750", "1800", "1850", "1900", "1950", "1999", "2050"
          )
          .setTickmarkPlacement(XAxis.TickmarkPlacement.ON)
          .setAxisTitleText(null);

      chart.getYAxis()
          .setAxisTitleText("Billions")
          .setLabels(new YAxisLabels()
              .setFormatter(
                  new AxisLabelsFormatter() {
                      public String format(AxisLabelsData axisLabelsData) {
                          return String.valueOf(axisLabelsData.getValueAsLong() / 1000);
                      }
                  }
              )
          );

      chart.addSeries(chart.createSeries()
          .setName("Asia")
          .setPoints(new Number[] { 502, 635, 809, 947, 1402, 3634, 5268 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Africa")
          .setPoints(new Number[] { 106, 107, 111, 133, 221, 767, 1766 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Europe")
          .setPoints(new Number[] { 163, 203, 276, 408, 547, 729, 628 })
      );
      chart.addSeries(chart.createSeries()
          .setName("America")
          .setPoints(new Number[] { 18, 31, 54, 156, 339, 818, 1201 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Oceania")
          .setPoints(new Number[] { 2, 2, 2, 6, 13, 30, 46 })
      );

      return chart;
  }


  public Chart createDynamicSplineChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.SPLINE)
          .setMarginRight(10)
          .setChartTitleText("Live random data")
          .setBarPlotOptions(new BarPlotOptions()
              .setDataLabels(new DataLabels()
                  .setEnabled(true)
              )
          )
          .setLegend(new Legend()
              .setEnabled(false)
          )
          .setCredits(new Credits()
              .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                          DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss")
                              .format(new Date(toolTipData.getXAsLong())) + "<br/>" +
                          NumberFormat.getFormat("0.00").format(toolTipData.getYAsDouble());
                  }
              })
          );

      chart.getXAxis()
          .setType(Axis.Type.DATE_TIME)
          .setTickPixelInterval(150);

      chart.getYAxis()
          .setAxisTitleText("Value")
          .setPlotLines(
              chart.getYAxis().createPlotLine()
                  .setValue(0)
                  .setWidth(1)
                  .setColor("#808080")
          );

      final Series series = chart.createSeries();
      chart.addSeries(series
          .setName("Random data")
      );

      // Generate an array of random data
      long time = new Date().getTime();
      for(int i = -19; i <= 0; i++) {
          series.addPoint(time + i * 1000, com.google.gwt.user.client.Random.nextDouble());
      }

      Timer tempTimer = new Timer() {
          @Override
          public void run() {
              series.addPoint(
                  new Date().getTime(),
                  com.google.gwt.user.client.Random.nextDouble(),
                  true, true, true
              );
          }
      };
      tempTimer.scheduleRepeating(1000);

      return chart;
  }
}
