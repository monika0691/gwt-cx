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
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import com.sencha.gxt.widget.core.client.menu.SeparatorMenuItem;

public class ApplicationMenu implements IsWidget {

  private static final String SEPARATOR = "separator";
  public static final String DELIMITER = ",";

  public interface ApplicationMenuUiBinder extends UiBinder<Widget, ApplicationMenu> { }

  private static ApplicationMenuUiBinder uiBinder = GWT.create(ApplicationMenuUiBinder.class);

  protected Widget widget;

  @UiField MenuBar menuBar;

  @Inject
  public ApplicationMenu() {
    super();

    Log.debug("ApplicationMenu()");

    createAndBindUi();
  }

  protected void createAndBindUi() {
    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  public Menu addMenu(String menuName) {

    // initialise the new menu
    Menu menu = new Menu();

    menuBar.add(new MenuBarItem(menuName, menu));

    return menu;
  }

  public Menu addMenu(String menuName, String menuItemNames, SelectionHandler<Item> handler) {

    Menu menu = new Menu();

    // create an array of menu item names
    String[] menuItems = process(menuItemNames);

    for (int i = 0; i < menuItems.length; i++) {

      // remove any whitespace
      String menuItemName = menuItems[i].replaceAll("\\W", "");

      if (menuItemName.contentEquals(SEPARATOR)) {
        menu.add(new SeparatorMenuItem());
        continue;
      }

      MenuItem menuItem = new MenuItem(menuItems[i]);
      // menuItem.setStyleName(StyleTokens.menuBarItem);

      if (handler != null) {
        menuItem.addSelectionHandler(handler);
      }

      menu.add(menuItem);
    }

    menuBar.add(new MenuBarItem(menuName, menu));

    return menu;
  }

  public Menu addSubMenu(Menu parentMenu, String subMenuName, String menuItemNames,
      SelectionHandler<Item> handler) {

    // initialise the new sub menu
    Menu menu = new Menu();

    // create an array of menu item names
    String[] menuItems = process(menuItemNames);

    for (int i = 0; i < menuItems.length; i++) {

      // remove any whitespace
      String menuItemName = menuItems[i].replaceAll("\\W", "");

      if (menuItemName.contentEquals(SEPARATOR)) {
        menu.add(new SeparatorMenuItem());
        continue;
      }

      MenuItem menuItem = new MenuItem(menuItems[i]);

      if (handler != null) {
        menuItem.addSelectionHandler(handler);
      }

      menu.add(menuItem);
    }

    // add the sub menu to the parent menu
    MenuItem menuItem = new MenuItem(subMenuName);
    parentMenu.add(menuItem);
    menuItem.setSubMenu(menu);

    return menu;
  }

  public static String[] process(String line) {
    return line.split(DELIMITER);
  }
}