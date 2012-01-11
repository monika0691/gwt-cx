package com.sencha.gxt.theme.base.client.container;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BoxLayoutBaseAppearance_BoxLayoutBaseResources_safari_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutBaseResources {
  private static BoxLayoutBaseAppearance_BoxLayoutBaseResources_safari_en_InlineClientBundleGenerator _instance0 = new BoxLayoutBaseAppearance_BoxLayoutBaseResources_safari_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYNN-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-container {\n  overflow : " + ("hidden")  + ";\n}\n.GAVOEIYON-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-inner {\n  overflow : " + ("hidden")  + ";\n  zoom : " + ("1")  + ";\n  position : " + ("relative")  + ";\n  right : " + ("0")  + ";\n  top : " + ("0")  + ";\n}\n")) : ((".GAVOEIYNN-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-container {\n  overflow : " + ("hidden")  + ";\n}\n.GAVOEIYON-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-inner {\n  overflow : " + ("hidden")  + ";\n  zoom : " + ("1")  + ";\n  position : " + ("relative")  + ";\n  left : " + ("0")  + ";\n  top : " + ("0")  + ";\n}\n"));
      }
      public java.lang.String container(){
        return "GAVOEIYNN-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-container";
      }
      public java.lang.String inner(){
        return "GAVOEIYON-com-sencha-gxt-theme-base-client-container-BoxLayoutBaseAppearance-BoxLayoutStyle-inner";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.base.client.container.BoxLayoutBaseAppearance.BoxLayoutBaseResources::style()();
    }
    return null;
  }-*/;
}
