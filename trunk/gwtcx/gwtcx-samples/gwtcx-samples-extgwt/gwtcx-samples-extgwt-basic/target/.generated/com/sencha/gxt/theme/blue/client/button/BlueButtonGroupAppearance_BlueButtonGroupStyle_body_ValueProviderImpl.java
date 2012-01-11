package com.sencha.gxt.theme.blue.client.button;

public class BlueButtonGroupAppearance_BlueButtonGroupStyle_body_ValueProviderImpl implements com.sencha.gxt.core.client.ValueProvider<com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle, java.lang.String> {
  public static final BlueButtonGroupAppearance_BlueButtonGroupStyle_body_ValueProviderImpl INSTANCE = new BlueButtonGroupAppearance_BlueButtonGroupStyle_body_ValueProviderImpl();
  public java.lang.String getValue(com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle object) {
    return object.body();
  }
  public void setValue(com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle object, java.lang.String value) {
    com.google.gwt.core.client.GWT.log("Setter was called on ValueProvider, but no setter exists.", new RuntimeException());
  }
  public String getPath() {
    return "body";
  }
}
