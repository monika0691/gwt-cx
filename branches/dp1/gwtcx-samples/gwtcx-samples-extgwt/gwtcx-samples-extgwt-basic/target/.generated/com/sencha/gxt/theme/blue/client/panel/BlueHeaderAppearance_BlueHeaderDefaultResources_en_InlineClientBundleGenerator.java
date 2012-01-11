package com.sencha.gxt.theme.blue.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderDefaultResources {
  private static BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator _instance0 = new BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator();
  private void headerBackgroundInitializer() {
    headerBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "headerBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 1, 300, false, false
    );
  }
  private static class headerBackgroundInitializer {
    static {
      _instance0.headerBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return headerBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource headerBackground() {
    return headerBackgroundInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderStlyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYGPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-header {\n  position : " + ("relative")  + ";\n  padding : " + ("4px"+ " " +"5px"+ " " +"2px"+ " " +"3px")  + ";\n}\n.GAVOEIYJPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerIcon {\n  float : " + ("right")  + ";\n}\n.GAVOEIYIPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerHasIcon .GAVOEIYJPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerIcon {\n  width : " + ("18px")  + ";\n}\n.GAVOEIYIPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerHasIcon .GAVOEIYKPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerText {\n  right : " + ("20px")  + ";\n}\n.GAVOEIYKPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerText {\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("15px")  + ";\n}\n.GAVOEIYHPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerBar {\n  float : " + ("left")  + ";\n}\n.GAVOEIYGPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-header {\n  height : ") + (((BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getSafeUri().asString() + "\") -" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getLeft() + "px -" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getTop() + "px  repeat-x")  + ";\n  color : " + ("#15428b")  + ";\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("11px")  + ";\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  border-color : " + ("#99bbe8")  + ";\n  height : " + ("auto")  + ";\n  line-height : " + ("15px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#99bbe8") ) + (";\n  border-top : " + ("none")  + ";\n}\n")) : ((".GAVOEIYGPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-header {\n  position : " + ("relative")  + ";\n  padding : " + ("4px"+ " " +"3px"+ " " +"2px"+ " " +"5px")  + ";\n}\n.GAVOEIYJPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerIcon {\n  float : " + ("left")  + ";\n}\n.GAVOEIYIPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerHasIcon .GAVOEIYJPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerIcon {\n  width : " + ("18px")  + ";\n}\n.GAVOEIYIPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerHasIcon .GAVOEIYKPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerText {\n  left : " + ("20px")  + ";\n}\n.GAVOEIYKPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerText {\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("15px")  + ";\n}\n.GAVOEIYHPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerBar {\n  float : " + ("right")  + ";\n}\n.GAVOEIYGPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-header {\n  height : ") + (((BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getSafeUri().asString() + "\") -" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getLeft() + "px -" + (BlueHeaderAppearance_BlueHeaderDefaultResources_en_InlineClientBundleGenerator.this.headerBackground()).getTop() + "px  repeat-x")  + ";\n  color : " + ("#15428b")  + ";\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("11px")  + ";\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  border-color : " + ("#99bbe8")  + ";\n  height : " + ("auto")  + ";\n  line-height : " + ("15px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#99bbe8") ) + (";\n  border-top : " + ("none")  + ";\n}\n"));
      }
      public java.lang.String header(){
        return "GAVOEIYGPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-header";
      }
      public java.lang.String headerBar(){
        return "GAVOEIYHPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerBar";
      }
      public java.lang.String headerHasIcon(){
        return "GAVOEIYIPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerHasIcon";
      }
      public java.lang.String headerIcon(){
        return "GAVOEIYJPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerIcon";
      }
      public java.lang.String headerText(){
        return "GAVOEIYKPB-com-sencha-gxt-theme-blue-client-panel-BlueHeaderAppearance-BlueHeaderStlyle-headerText";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderStlyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderStlyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/gif;base64,R0lGODlhAQAsAcQAAAAAAP///5m76ISgxKvH7LjP7rrQ7rzS77/U8MHV8MLW8Mja8tTi9L3T78TY8cbZ8cnb8svd883e89Dg9M/f89Lh9NXk9djm9tfl9drn9vP3+////wAAAAAAAAAAAAAAACH5BAEAABsALAAAAAABACwBAAUyoKBl2YVZTDVRElEYR4MkivMsUCTtfO//wKBwSCwaj0hfYMlsOp/QqHRKrVqv2Kx1EAIAOw==";
  private static com.google.gwt.resources.client.ImageResource headerBackground;
  private static com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderStlyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      headerBackground(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("headerBackground", headerBackground());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'headerBackground': return this.@com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderDefaultResources::headerBackground()();
      case 'style': return this.@com.sencha.gxt.theme.blue.client.panel.BlueHeaderAppearance.BlueHeaderDefaultResources::style()();
    }
    return null;
  }-*/;
}
