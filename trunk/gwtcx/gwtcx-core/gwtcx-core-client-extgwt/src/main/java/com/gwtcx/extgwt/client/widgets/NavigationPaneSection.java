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

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModelListStore;
import com.gwtcx.extgwt.client.widgets.grid.NavigationPaneSectionGrid;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * NavigationPaneSection
 */
public class NavigationPaneSection extends ContentPanel {

  private static AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

  protected final Grid<?> grid;

  @Inject
  public NavigationPaneSection(NavigationPaneSectionGrid grid) {
    super(appearance);

    this.grid = grid;

    add(this.grid);
  }

  public NavigationPaneSection() {
    this(new NavigationPaneSectionGrid(new NavigationPaneSectionModelListStore()));
  }

  public Grid<?> getGrid() {
    return grid;
  }

  public void addRowClickHandler(RowClickHandler handler) {
    getGrid().addRowClickHandler(handler);
  }

  public void selectRecord(int rowIndex) {
    getGrid().getSelectionModel().select(rowIndex, false);
  }
}

/*

public class NavigationPaneSection extends ContentPanel {

  private static AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

  protected TreeStore<NavigationPaneSectionModel> store;
  protected Tree<NavigationPaneSectionModel, String> tree;

  public NavigationPaneSection() {
    super(appearance);

    store = new TreeStore<NavigationPaneSectionModel>(NavigationPaneSectionModel.KP);

    tree = new Tree<NavigationPaneSectionModel, String>(store,
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
          } else if ("calendar".equalsIgnoreCase(model.getIcon())) {
            return SalesIcons.INSTANCE.calendar();
          } else {
            return SalesIcons.INSTANCE.activities();
          }
        }
      });

    NavigationPaneSectionModel model = newItem(null,      // icon
        ExtGwtCx.getConstant().activitiesMenuItemName(),  // name
        ExtGwtCx.getConstant().activitiesMenuItemName()); // displayName
    store.add(model);

    store.add(newItem(null, ExtGwtCx.getConstant().calendarMenuItemName(), ExtGwtCx.getConstant().calendarMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().dashboardsMenuItemName(), ExtGwtCx.getConstant().dashboardsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().importsMenuItemName(), ExtGwtCx.getConstant().importsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().accountsMenuItemName(), ExtGwtCx.getConstant().accountsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().contactsMenuItemName(), ExtGwtCx.getConstant().contactsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().queuesMenuItemName(), ExtGwtCx.getConstant().queuesMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().reportsMenuItemName(), ExtGwtCx.getConstant().reportsMenuItemName()));

    add(tree);
  }

  private NavigationPaneSectionModel newItem(String icon, String name, String displayName) {
    return new NavigationPaneSectionModel(icon, name, displayName);
  }

  public void addRecordClickHandler(SimpleSafeHtmlCell<String> cell) {
    tree.setCell(cell);
  }
}

*/