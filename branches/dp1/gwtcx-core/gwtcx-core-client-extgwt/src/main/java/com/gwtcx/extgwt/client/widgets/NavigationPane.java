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
import com.google.gwt.core.client.GWT;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;

public class NavigationPane extends AccordionLayoutContainer {

  private static AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

  NavigationPane() {
    super();

    Log.debug("NavigationPane()");
  }

  public ContentPanel addSection(String sectionName) {

    ContentPanel contentPanel = new ContentPanel(appearance);
    contentPanel.setAnimCollapse(false);
    contentPanel.setHeadingText(sectionName);
    this.add(contentPanel);
    // con.setWidget(contentPanel);
    return contentPanel;
  }

}
