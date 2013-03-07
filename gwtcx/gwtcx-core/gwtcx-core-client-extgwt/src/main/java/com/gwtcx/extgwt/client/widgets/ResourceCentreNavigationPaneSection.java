/**
 * (C) Copyright 2010-2013 Kiahu
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

public class ResourceCentreNavigationPaneSection extends NavigationPaneSection {

  public ResourceCentreNavigationPaneSection() {
    super(NavigationPane.RESOURCE_CENTRE_FILENAME);

    Log.debug("ResourceCentreNavigationPaneSection()");

    this.setHeadingText(I18nUtil.getConstant().resourceCentreNavigationPaneSectionName());
  }

  @Override
  public SafeHtml getIcon(String data) {

    if ("highlights".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.highlights());
    } else if ("sales".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.sales());
    } else if ("settings".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.settings());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder16x16());
    }
  }
}
