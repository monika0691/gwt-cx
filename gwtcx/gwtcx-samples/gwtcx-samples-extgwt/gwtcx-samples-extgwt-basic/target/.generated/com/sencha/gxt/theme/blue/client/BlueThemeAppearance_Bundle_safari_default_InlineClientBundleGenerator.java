package com.sencha.gxt.theme.blue.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.BlueThemeAppearance.Bundle {
  private static BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator _instance0 = new BlueThemeAppearance_Bundle_safari_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.sencha.gxt.core.client.resources.ThemeStyles.Styles() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((":focus {\n  outline : " + ("none")  + " !important;\n}\n/* CssDef */\n/* CssDef */\n/* CssDef */\n.GAVOEIYHL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-border {\n  border : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYLL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderLeft {\n  border : " + ("none")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYML-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderRight {\n  border : " + ("none")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYNL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderTop {\n  border : " + ("none")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYIL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderBottom {\n  border : " + ("none")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n")) : ((":focus {\n  outline : " + ("none")  + " !important;\n}\n/* CssDef */\n/* CssDef */\n/* CssDef */\n.GAVOEIYHL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-border {\n  border : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYLL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderLeft {\n  border : " + ("none")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYML-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderRight {\n  border : " + ("none")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYNL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderTop {\n  border : " + ("none")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n.GAVOEIYIL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderBottom {\n  border : " + ("none")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#99bbe8")  + " !important;\n}\n"));
      }
      public java.lang.String backgroundColorLight() {
        return "#e0e8f8";
      }
      public java.lang.String border(){
        return "GAVOEIYHL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-border";
      }
      public java.lang.String borderBottom(){
        return "GAVOEIYIL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderBottom";
      }
      public java.lang.String borderColor() {
        return "#99bbe8";
      }
      public java.lang.String borderColorLight() {
        return "orange";
      }
      public java.lang.String borderLeft(){
        return "GAVOEIYLL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderLeft";
      }
      public java.lang.String borderRight(){
        return "GAVOEIYML-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderRight";
      }
      public java.lang.String borderTop(){
        return "GAVOEIYNL-com-sencha-gxt-core-client-resources-ThemeStyles-Styles-borderTop";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.core.client.resources.ThemeStyles.Styles get() {
      return css;
    }
  }
  public com.sencha.gxt.core.client.resources.ThemeStyles.Styles css() {
    return cssInitializer.get();
  }
  private void moreInitializer() {
    more = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "more",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 12, 16, false, false
    );
  }
  private static class moreInitializer {
    static {
      _instance0.moreInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return more;
    }
  }
  public com.google.gwt.resources.client.ImageResource more() {
    return moreInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.core.client.resources.ThemeStyles.Styles css;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAQCAYAAAAiYZ4HAAAAHElEQVR42mNgGAUkAFGn7v8gjIs/QJpop3ikAQD36yWVz45n1AAAAABJRU5ErkJggg==";
  private static com.google.gwt.resources.client.ImageResource more;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      more(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("more", more());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.sencha.gxt.theme.blue.client.BlueThemeAppearance.Bundle::css()();
      case 'more': return this.@com.sencha.gxt.theme.blue.client.BlueThemeAppearance.Bundle::more()();
    }
    return null;
  }-*/;
}
