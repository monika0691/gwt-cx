package com.sencha.gxt.theme.base.client.menu;

public class MenuBaseAppearance_BaseMenuStyle_menuList_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle, java.lang.String> {
  public static final MenuBaseAppearance_BaseMenuStyle_menuList_ValueProviderImpl INSTANCE = new MenuBaseAppearance_BaseMenuStyle_menuList_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle object) {
    return object.menuList();
  }
  public void setValue(com.sencha.gxt.theme.base.client.menu.MenuBaseAppearance.BaseMenuStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "menuList";
  }
}
