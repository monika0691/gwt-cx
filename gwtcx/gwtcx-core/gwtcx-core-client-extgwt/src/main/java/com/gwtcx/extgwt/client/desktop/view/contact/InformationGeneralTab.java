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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.sencha.gxt.widget.core.client.TabPanel;

public class InformationGeneralTab extends ContactTab {

  private String[][] fieldSets = {
    {"General Information"},
    {"Address Information"}
  };

  public InformationGeneralTab(TabPanel tabPanel) {
    super(tabPanel);

    Log.debug("InformationGeneralTab(TabPanel tabPanel)");

    setFieldSets(fieldSets);
    createFieldSets("General");
  }
}

/*


  public EntityTab<ContactRepresentation> setTabPanel(TabPanel tabPanel) {

    super.setTabPanel(tabPanel);

    if (getTabPanel() != null) {

      VerticalLayoutContainer layout = new VerticalLayoutContainer();

      layout.setSize(AbstractTabbedFormDesktopView.CONTEXT_AREA_WIDTH, AbstractTabbedFormDesktopView.CONTEXT_AREA_HEIGHT);
      layout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      createFieldSets(layout);

      getTabPanel().add(layout, "General");
    }

    return this;
  }



  protected void createFieldSets(VerticalLayoutContainer layoutContainer) {

    FieldSet fieldSet = null;
    HtmlLayoutContainer htmlLayout = null;

    Log.debug("createFieldSets()");

    Log.debug("numberOfFieldSets: " + numberOfFieldSets);

    for (int row = 0; row < numberOfFieldSets; row++) {

      fieldSet = new FieldSet();
      fieldSet.setHeadingText(fieldSets[row][FIELD_SET_LABEL]);
      fieldSet.setCollapsible(true);

      htmlLayout = getFieldSetHtmlLayout(fieldSets[row][FIELD_SET_LABEL]);
      htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      entitySections[row] = getFieldSetSection(fieldSets[row][FIELD_SET_LABEL], htmlLayout);

      fieldSet.add(htmlLayout);
      layoutContainer.add(fieldSet, new VerticalLayoutData(1, -1));
    }
  }

    // vLayout.setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

*/

/*

The values for HorizontalLayoutData and VerticalLayoutData have different meanings depending on which range they are in:

- If -1, then the item is measured, and given the space it has requested - useful for fields or labels
- If greater than 1, a pixel value is assigned - you've noticed this in using 100, which draws as 100px wide
- If greater than 0, and less than or equal to 1, then it will be assigned a percentage of the remaining size after the
  first two items listed have been calculated. The value 1 is 100%, and .25 would be 25% of the remaining space.

*/