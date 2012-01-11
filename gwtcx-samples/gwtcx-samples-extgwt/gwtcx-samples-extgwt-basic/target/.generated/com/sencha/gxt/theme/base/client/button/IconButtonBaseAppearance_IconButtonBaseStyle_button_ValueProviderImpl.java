package com.sencha.gxt.theme.base.client.button;

public class IconButtonBaseAppearance_IconButtonBaseStyle_button_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle, java.lang.String> {
  public static final IconButtonBaseAppearance_IconButtonBaseStyle_button_ValueProviderImpl INSTANCE = new IconButtonBaseAppearance_IconButtonBaseStyle_button_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle object) {
    return object.button();
  }
  public void setValue(com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "button";
  }
}
