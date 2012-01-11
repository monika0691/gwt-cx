package com.sencha.gxt.theme.blue.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueContentPanelAppearance_BlueContentPanelDefaultResources_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelDefaultResources {
  private static BlueContentPanelAppearance_BlueContentPanelDefaultResources_default_InlineClientBundleGenerator _instance0 = new BlueContentPanelAppearance_BlueContentPanelDefaultResources_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYCOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-panel {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n  border-color : " + ("#99bbe8")  + ";\n}\n.GAVOEIYBOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-noHeader {\n  border-top-width : " + ("1px")  + ";\n}\n.GAVOEIYNNB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-body {\n  border-bottom : " + ("1px"+ " " +"solid")  + ";\n  border-right : " + ("1px"+ " " +"solid")  + ";\n  border-left : " + ("1px"+ " " +"solid")  + ";\n  border-top : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  position : ") + (("relative")  + ";\n  background-color : " + ("#fff")  + ";\n  border-color : " + ("#99bbe8")  + ";\n}\n")) : ((".GAVOEIYCOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-panel {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n  border-color : " + ("#99bbe8")  + ";\n}\n.GAVOEIYBOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-noHeader {\n  border-top-width : " + ("1px")  + ";\n}\n.GAVOEIYNNB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-body {\n  border-bottom : " + ("1px"+ " " +"solid")  + ";\n  border-left : " + ("1px"+ " " +"solid")  + ";\n  border-right : " + ("1px"+ " " +"solid")  + ";\n  border-top : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  position : ") + (("relative")  + ";\n  background-color : " + ("#fff")  + ";\n  border-color : " + ("#99bbe8")  + ";\n}\n"));
      }
      public java.lang.String body(){
        return "GAVOEIYNNB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-body";
      }
      public java.lang.String bodyWrap(){
        return "GAVOEIYONB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-bodyWrap";
      }
      public java.lang.String footer(){
        return "GAVOEIYPNB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-footer";
      }
      public java.lang.String header(){
        return "GAVOEIYAOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-header";
      }
      public java.lang.String noHeader(){
        return "GAVOEIYBOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-noHeader";
      }
      public java.lang.String panel(){
        return "GAVOEIYCOB-com-sencha-gxt-theme-blue-client-panel-BlueContentPanelAppearance-BlueContentPanelStyle-panel";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.blue.client.panel.BlueContentPanelAppearance.BlueContentPanelDefaultResources::style()();
    }
    return null;
  }-*/;
}
