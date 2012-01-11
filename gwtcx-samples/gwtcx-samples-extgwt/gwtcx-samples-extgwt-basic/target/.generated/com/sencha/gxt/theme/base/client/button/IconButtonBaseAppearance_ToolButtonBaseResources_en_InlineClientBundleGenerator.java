package com.sencha.gxt.theme.base.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class IconButtonBaseAppearance_ToolButtonBaseResources_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.ToolButtonBaseResources {
  private static IconButtonBaseAppearance_ToolButtonBaseResources_en_InlineClientBundleGenerator _instance0 = new IconButtonBaseAppearance_ToolButtonBaseResources_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle() {
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
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYEN-com-sencha-gxt-theme-base-client-button-IconButtonBaseAppearance-IconButtonBaseStyle-button {\n  width : " + ("15px")  + ";\n  height : " + ("15px")  + ";\n  overflow : " + ("hidden")  + ";\n  margin-right : " + ("2px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n")) : ((".GAVOEIYEN-com-sencha-gxt-theme-base-client-button-IconButtonBaseAppearance-IconButtonBaseStyle-button {\n  width : " + ("15px")  + ";\n  height : " + ("15px")  + ";\n  overflow : " + ("hidden")  + ";\n  margin-left : " + ("2px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n"));
      }
      public java.lang.String button(){
        return "GAVOEIYEN-com-sencha-gxt-theme-base-client-button-IconButtonBaseAppearance-IconButtonBaseStyle-button";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.ToolButtonBaseResources::style()();
    }
    return null;
  }-*/;
}
