package com.sencha.gxt.theme.base.client.widget;

public class HeaderBaseAppearance_HeaderStyle_headerIcon_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle, java.lang.String> {
  public static final HeaderBaseAppearance_HeaderStyle_headerIcon_ValueProviderImpl INSTANCE = new HeaderBaseAppearance_HeaderStyle_headerIcon_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle object) {
    return object.headerIcon();
  }
  public void setValue(com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "headerIcon";
  }
}
