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

package com.gwtcx.client.smartgwt.flashlets;

import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.plugins.Flashlet;

/**
 * AmChart simple wrapper for AmCharts.
 */
public class AmChart extends Flashlet {

  private static int count = 0;

  private String swfId;

    private HashMap<String, String> hashMap;

  public AmChart(String src, String width, String height, String settingsUrl, String dataUrl) {
    super();

    init(src, width, height);

    hashMap.put("flashvars", "&id=" + swfId + "&chartWidth=" + width + "&chartHeight=" + height +
        "&settings_file=" + (GWT.getModuleBaseURL() + "gwtcx/charts/amcharts/data/") + settingsUrl +
        "&data_file=" + (GWT.getModuleBaseURL() + "gwtcx/charts/amcharts/data/") + dataUrl);

    setParams(hashMap);
  }

  public AmChart(String src, String width, String height, String chartSettings, String chartData, String notUsed) {
    super();

    init(src, width, height);

    hashMap.put("flashvars", "&id=" + swfId + "&chartWidth=" + width + "&chartHeight=" + height +
        "&chart_settings=" + chartSettings + "&chart_data=" + chartData);

    setParams(hashMap);
  }

  private void init(String src, String width, String height) {

    setCodeBase("http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0");
    setClassID("clsid:d27cdb6e-ae6d-11cf-96b8-444553540000");
    setPluginsPage("http://www.macromedia.com/go/getflashplayer");

    swfId = "amChartId_" + count;
    ++count;

    setID(swfId);
    setName(swfId);
    setSize(width, height);
    setSrc(GWT.getModuleBaseURL() + "gwtcx/charts/amcharts/flash/" + src);

    hashMap = new HashMap<String, String>();

    hashMap.put("id", swfId);

    // hashMap.put("allowscriptaccess", "always");
    // hashMap.put("wmode", "opaque" );
    // hashMap.put("quality", "high");
    // hashMap.put("bgcolor", "#ffffff");

    // If you embed the chart into your web page, and the page has layers such as drop-down menus or
    // drop-down forms, and you want them appear above the chart, you need to add the following  line
    // to your code.
    // hashMap.put("wmode", "opaque" );

    // "&DOMId="

    // setParams(hashMap);

    // setCanSelectText(true);
  }
}

