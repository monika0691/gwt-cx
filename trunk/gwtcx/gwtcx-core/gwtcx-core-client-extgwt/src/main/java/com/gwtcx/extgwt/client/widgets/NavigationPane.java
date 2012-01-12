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
import com.google.gwt.resources.client.ImageResource;
import com.gwtcx.client.resources.SalesIcons;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.IconProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.tree.Tree;

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
    // this.setWidget(contentPanel);

    TreeStore<NavigationPaneSectionModel> store = new TreeStore<NavigationPaneSectionModel>(NavigationPaneSectionModel.KP);

    Tree<NavigationPaneSectionModel, String> tree = new Tree<NavigationPaneSectionModel, String>(store,
        new ValueProvider<NavigationPaneSectionModel, String>() {

          @Override
          public String getValue(NavigationPaneSectionModel object) {
            return object.getName();
          }

          @Override
          public void setValue(NavigationPaneSectionModel object, String value) {
          }

          @Override
          public String getPath() {
            return "name";
          }
        });

    tree.setIconProvider(new IconProvider<NavigationPaneSectionModel>() {
        public ImageResource getIcon(NavigationPaneSectionModel model) {
          if (null == model.getIcon()) {
            return null;
          } else if ("activities".equalsIgnoreCase(model.getIcon())) {
            return SalesIcons.INSTANCE.activities();
          } else if ("calendar" == model.getIcon()) {
            return SalesIcons.INSTANCE.calendar();
          } else {
            return SalesIcons.INSTANCE.activities();
          }
        }
      });

    NavigationPaneSectionModel model = new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().activitiesMenuItemName(), ExtGwtCx.getConstant().activitiesMenuItemName());

    store.add(model);

    /*
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().calendarMenuItemName(), ExtGwtCx.getConstant().calendarMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().dashboardsMenuItemName(), ExtGwtCx.getConstant().dashboardsMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().importsMenuItemName(), ExtGwtCx.getConstant().importsMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().accountsMenuItemName(), ExtGwtCx.getConstant().accountsMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().contactsMenuItemName(), ExtGwtCx.getConstant().contactsMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().queuesMenuItemName(), ExtGwtCx.getConstant().queuesMenuItemName()));
    store.add(new NavigationPaneSectionModel(null, ExtGwtCx.getConstant().reportsMenuItemName(), ExtGwtCx.getConstant().reportsMenuItemName()));
    */

    contentPanel.add(tree);

    // List<NavigationPaneSectionModel> list = new ArrayList<NavigationPaneSectionModel>();

    return contentPanel;
  }

}
