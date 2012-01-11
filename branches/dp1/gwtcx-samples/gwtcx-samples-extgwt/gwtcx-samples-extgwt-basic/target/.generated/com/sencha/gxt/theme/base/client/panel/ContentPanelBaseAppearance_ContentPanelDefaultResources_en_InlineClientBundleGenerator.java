package com.sencha.gxt.theme.base.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ContentPanelBaseAppearance_ContentPanelDefaultResources_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelDefaultResources {
  private static ContentPanelBaseAppearance_ContentPanelDefaultResources_en_InlineClientBundleGenerator _instance0 = new ContentPanelBaseAppearance_ContentPanelDefaultResources_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYJ4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-panel {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n}\n.GAVOEIYI4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-noHeader {\n  border-top-width : " + ("1px")  + ";\n}\n.GAVOEIYE4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-body {\n  border-bottom : " + ("1px"+ " " +"solid")  + ";\n  border-right : " + ("1px"+ " " +"solid")  + ";\n  border-left : " + ("1px"+ " " +"solid")  + ";\n  border-top : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  position : " + ("relative")  + ";\n}\n")) : ((".GAVOEIYJ4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-panel {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n}\n.GAVOEIYI4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-noHeader {\n  border-top-width : " + ("1px")  + ";\n}\n.GAVOEIYE4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-body {\n  border-bottom : " + ("1px"+ " " +"solid")  + ";\n  border-left : " + ("1px"+ " " +"solid")  + ";\n  border-right : " + ("1px"+ " " +"solid")  + ";\n  border-top : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  position : " + ("relative")  + ";\n}\n"));
      }
      public java.lang.String body(){
        return "GAVOEIYE4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-body";
      }
      public java.lang.String bodyWrap(){
        return "GAVOEIYF4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-bodyWrap";
      }
      public java.lang.String footer(){
        return "GAVOEIYG4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-footer";
      }
      public java.lang.String header(){
        return "GAVOEIYH4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-header";
      }
      public java.lang.String noHeader(){
        return "GAVOEIYI4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-noHeader";
      }
      public java.lang.String panel(){
        return "GAVOEIYJ4-com-sencha-gxt-theme-base-client-panel-ContentPanelBaseAppearance-ContentPanelStyle-panel";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance.ContentPanelDefaultResources::style()();
    }
    return null;
  }-*/;
}
