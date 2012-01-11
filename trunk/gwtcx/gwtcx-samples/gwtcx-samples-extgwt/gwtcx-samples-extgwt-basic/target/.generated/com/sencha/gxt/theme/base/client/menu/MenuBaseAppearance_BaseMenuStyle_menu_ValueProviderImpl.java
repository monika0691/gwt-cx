package com.sencha.gxt.theme.base.client.menu;

public class MenuBaseAppearance_BaseMenuStyle_menu_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle, java.lang.String> {
  public static final MenuBaseAppearance_BaseMenuStyle_menu_ValueProviderImpl INSTANCE = new MenuBaseAppearance_BaseMenuStyle_menu_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle object) {
    return object.menu();
  }
  public void setValue(com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "menu";
  }
}
