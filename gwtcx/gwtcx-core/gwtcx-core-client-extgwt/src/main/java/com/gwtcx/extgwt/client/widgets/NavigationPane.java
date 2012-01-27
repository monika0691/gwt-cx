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

import java.util.Iterator;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModelListStore;
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

  public void selectRecord(String name) {

    WidgetCollection children = this.getChildren();

    Iterator<Widget> iterator = children.iterator();

    while (iterator.hasNext()) {

      Widget child = (Widget) iterator.next();

      assert child instanceof NavigationPaneSection : "NavigationPane children must be NavigationPaneSections";

      NavigationPaneSection section = (NavigationPaneSection) child;

      Log.debug("sectionName: " + section.getText());

      NavigationPaneSectionModelListStore store = (NavigationPaneSectionModelListStore) section.getGrid().getStore();
      NavigationPaneSectionModel model = store.findModelWithKey(name);

      if (model != null) {
        int rowIndex = store.indexOf(model);

        Log.debug("selectRecord(rowIndex): " + rowIndex);

        section.selectRecord(rowIndex);
        break;
      }
    }
  }

  /*

  public void selectRecord(String name) {

    Log.debug("selectRecord(place) - " + name);

    SectionStackSection[] sections = sectionStack.getSections();

    Log.debug("Number of sections: " + sections.length);

    for (int i = 0; i < sections.length; i++) {
      SectionStackSection sectionStackSection = sections[i];

      // see if we match any records in this section's ListGrid
      if (((NavigationPaneSection) sectionStackSection).getRecord(name) != -1) {

        if (!sectionStack.sectionIsExpanded(i)) {
          Log.debug("sectionStack.expandSection(i)");
          sectionStack.expandSection(i);
        }

        ((NavigationPaneSection) sectionStackSection).selectRecord(name);
        break;
      }
    }
  }

  */


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



      // NavigationPaneSectionModel model = (NavigationPaneSectionModel) section.getGrid().getStore().findModelWithKey(name);

      // int rowIndex = section.getGrid().getStore().indexOf(model);



      //  NavigationPaneSectionModel model = (NavigationPaneSectionModel) salesSection.getGrid().getStore().get(rowIndex);
      // navigationPaneSectionClicked(model.getName());


    // NavigationPaneSectionModel model = (NavigationPaneSectionModel) section.getGrid().getStore().get(1);
    // Log.debug("model.getName(): " + model.getName());

    // tree.setExpanded(model, true);

    // store.add(model, newItem("activities", ExtGwtCx.getConstant().activitiesMenuItemName(), ExtGwtCx.getConstant().activitiesMenuItemName()));
    // store.add(model, newItem("calendar", ExtGwtCx.getConstant().calendarMenuItemName(), ExtGwtCx.getConstant().calendarMenuItemName()));

*/