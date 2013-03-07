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

public class ContactDetailsNavigationPaneSection extends NavigationPaneSection {

  public ContactDetailsNavigationPaneSection() {
    super(NavigationPane.CONTACT_DETAILS_FILENAME);

    Log.debug("ContactDetailsNavigationPaneSection()");

    this.setHeadingText(I18nUtil.getConstant().contactDetailsNavigationPaneSectionName());
  }

  @Override
  public SafeHtml getIcon(String data) {

    if ("information".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.information());
    } else if ("moreaddresses".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.moreAddresses());
    } else if ("activities".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.activities());
    } else if ("history".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.history());
    } else if ("relationships".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(NavigationPaneIcons.INSTANCE.relationships());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder16x16());
    }
  }
}
