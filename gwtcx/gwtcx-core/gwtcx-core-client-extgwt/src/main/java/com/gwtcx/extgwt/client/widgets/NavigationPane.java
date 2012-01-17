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
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;

/**
 * NavigationPane
 */
public class NavigationPane extends AccordionLayoutContainer {

  NavigationPane() {
    super();

    Log.debug("NavigationPane()");
  }

  public NavigationPaneSection addSection(String sectionName) {

    Log.debug("addSection() - " + sectionName);

    NavigationPaneSection section = new NavigationPaneSection();
    section.setAnimCollapse(false);
    section.setHeadingText(sectionName);
    this.add(section);
    this.setWidget(section);

    return section;
  }

  /*

  public void addRecordClickHandler(String sectionName, SimpleSafeHtmlCell<String> cell) {
      // tree.setCell(cell);

    Log.debug("addRecordClickHandler()");

    for (int i = 0; i < getWidgetCount(); i++) {
      // Widget widget = this.getWidget(i);

      ContentPanel contentPanel = (ContentPanel) this.getWidget(i);

      if (sectionName.contentEquals(contentPanel.getText())) {
          // ((NavigationPaneSection) sectionStackSection).addRecordClickHandler(clickHandler);

          // tree.setCell(cell);

        Log.debug("sectionName.contentEquals(contentPanel.getText())");
      }
    }
  }

  */

}

/*

    // tree.setExpanded(model, true);

    // store.add(model, newItem("activities", ExtGwtCx.getConstant().activitiesMenuItemName(), ExtGwtCx.getConstant().activitiesMenuItemName()));
    // store.add(model, newItem("calendar", ExtGwtCx.getConstant().calendarMenuItemName(), ExtGwtCx.getConstant().calendarMenuItemName()));

*/