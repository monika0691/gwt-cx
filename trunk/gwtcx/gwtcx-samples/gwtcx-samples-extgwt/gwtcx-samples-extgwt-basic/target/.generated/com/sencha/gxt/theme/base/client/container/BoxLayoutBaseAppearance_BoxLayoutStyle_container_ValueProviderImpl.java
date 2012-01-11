package com.sencha.gxt.theme.base.client.container;

public class BoxLayoutBaseAppearance_BoxLayoutStyle_container_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle, java.lang.String> {
  public static final BoxLayoutBaseAppearance_BoxLayoutStyle_container_ValueProviderImpl INSTANCE = new BoxLayoutBaseAppearance_BoxLayoutStyle_container_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle object) {
    return object.container();
  }
  public void setValue(com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "container";
  }
}
