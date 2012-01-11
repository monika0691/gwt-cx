package com.sencha.gxt.theme.blue.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueButtonGroupAppearance_BlueButtonGroupResources_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupResources {
  private static BlueButtonGroupAppearance_BlueButtonGroupResources_default_InlineClientBundleGenerator _instance0 = new BlueButtonGroupAppearance_BlueButtonGroupResources_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "css";
      }
      public String getText() {
        return (".GAVOEIYJJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-group {\n  padding : " + ("1px")  + ";\n}\n.GAVOEIYLJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-text {\n  font : " + ("11px"+ " " +"arial"+ ","+ " " +"tahoma"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#3e6aaa")  + ";\n  padding : " + ("2px")  + ";\n  text-align : " + ("center")  + ";\n}\n");
      }
      public java.lang.String body(){
        return "GAVOEIYIJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-body";
      }
      public java.lang.String group(){
        return "GAVOEIYJJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-group";
      }
      public java.lang.String header(){
        return "GAVOEIYKJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-header";
      }
      public java.lang.String text(){
        return "GAVOEIYLJB-com-sencha-gxt-theme-blue-client-button-BlueButtonGroupAppearance-BlueButtonGroupStyle-text";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle get() {
      return css;
    }
  }
  public com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupResources::css()();
    }
    return null;
  }-*/;
}
