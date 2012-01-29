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

package com.gwtcx.extgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.NavigationPaneIcons;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.client.util.I18nUtil;

public class SalesNavigationPaneSection extends NavigationPaneSection {

  public SalesNavigationPaneSection() {
    super(NavigationPane.SALES_FILENAME);

    Log.debug("SalesNavigationPaneSection()");

    this.setHeadingText(I18nUtil.getConstant().salesStackSectionName());
  }

  @Override
  public SafeHtml getIcon(String data) {

    if ("activities".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.activities());
    } else if ("calendar".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.calendar());
    } else if ("dashboards".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.dashboards());
    } else if ("imports".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.imports());
    } else if ("accounts".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.accounts());
    } else if ("contacts".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.contacts());
    } else if ("queues".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.queues());
    } else if ("reports".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.reports());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder16());
    }
  }
}
