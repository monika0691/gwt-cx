package com.sencha.gxt.theme.base.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class HeaderBaseAppearance_HeaderDefaultResources_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderDefaultResources {
  private static HeaderBaseAppearance_HeaderDefaultResources_default_InlineClientBundleGenerator _instance0 = new HeaderBaseAppearance_HeaderDefaultResources_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYHHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-header {\n  position : " + ("relative")  + ";\n  padding : " + ("4px"+ " " +"5px"+ " " +"2px"+ " " +"3px")  + ";\n}\n.GAVOEIYKHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerIcon {\n  float : " + ("right")  + ";\n}\n.GAVOEIYJHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerHasIcon .GAVOEIYKHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerIcon {\n  width : " + ("18px")  + ";\n}\n.GAVOEIYJHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerHasIcon .GAVOEIYLHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerText {\n  right : " + ("20px")  + ";\n}\n.GAVOEIYLHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerText {\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("15px")  + ";\n}\n.GAVOEIYIHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerBar {\n  float : " + ("left")  + ";\n}\n")) : ((".GAVOEIYHHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-header {\n  position : " + ("relative")  + ";\n  padding : " + ("4px"+ " " +"3px"+ " " +"2px"+ " " +"5px")  + ";\n}\n.GAVOEIYKHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerIcon {\n  float : " + ("left")  + ";\n}\n.GAVOEIYJHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerHasIcon .GAVOEIYKHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerIcon {\n  width : " + ("18px")  + ";\n}\n.GAVOEIYJHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerHasIcon .GAVOEIYLHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerText {\n  left : " + ("20px")  + ";\n}\n.GAVOEIYLHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerText {\n  font-family : " + ("tahoma"+ ","+ " " +"arial"+ ","+ " " +"verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("15px")  + ";\n}\n.GAVOEIYIHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerBar {\n  float : " + ("right")  + ";\n}\n"));
      }
      public java.lang.String header(){
        return "GAVOEIYHHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-header";
      }
      public java.lang.String headerBar(){
        return "GAVOEIYIHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerBar";
      }
      public java.lang.String headerHasIcon(){
        return "GAVOEIYJHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerHasIcon";
      }
      public java.lang.String headerIcon(){
        return "GAVOEIYKHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerIcon";
      }
      public java.lang.String headerText(){
        return "GAVOEIYLHB-com-sencha-gxt-theme-base-client-widget-HeaderBaseAppearance-HeaderStyle-headerText";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.base.client.widget.HeaderBaseAppearance.HeaderDefaultResources::style()();
    }
    return null;
  }-*/;
}
