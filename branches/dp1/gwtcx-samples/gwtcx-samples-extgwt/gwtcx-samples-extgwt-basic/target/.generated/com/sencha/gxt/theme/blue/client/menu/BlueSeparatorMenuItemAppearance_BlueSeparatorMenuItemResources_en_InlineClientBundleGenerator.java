package com.sencha.gxt.theme.blue.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueSeparatorMenuItemAppearance_BlueSeparatorMenuItemResources_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemResources {
  private static BlueSeparatorMenuItemAppearance_BlueSeparatorMenuItemResources_en_InlineClientBundleGenerator _instance0 = new BlueSeparatorMenuItemAppearance_BlueSeparatorMenuItemResources_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemStyle() {
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
        return (".GAVOEIYBNB-com-sencha-gxt-theme-blue-client-menu-BlueSeparatorMenuItemAppearance-BlueSeparatorMenuItemStyle-menuSep {\n  display : " + ("block")  + ";\n  font-size : " + ("1px")  + ";\n  line-height : " + ("1px")  + ";\n  margin : " + ("2px"+ " " +"3px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid")  + ";\n  overflow : " + ("hidden")  + ";\n  font-size : " + ("1px")  + ";\n  line-height : " + ("1px")  + ";\n  background-color : " + ("#e0e0e0")  + ";\n  border-bottom-color : " + ("#fff")  + ";\n}\n");
      }
      public java.lang.String menuSep(){
        return "GAVOEIYBNB-com-sencha-gxt-theme-blue-client-menu-BlueSeparatorMenuItemAppearance-BlueSeparatorMenuItemStyle-menuSep";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.blue.client.menu.BlueSeparatorMenuItemAppearance.BlueSeparatorMenuItemResources::style()();
    }
    return null;
  }-*/;
}
