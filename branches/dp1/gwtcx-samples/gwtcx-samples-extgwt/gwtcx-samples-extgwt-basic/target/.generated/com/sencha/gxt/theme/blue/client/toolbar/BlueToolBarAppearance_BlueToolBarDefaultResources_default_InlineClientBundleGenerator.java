package com.sencha.gxt.theme.blue.client.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultResources {
  private static BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator _instance0 = new BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator();
  private void backgroundInitializer() {
    background = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "background",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 2, 56, false, false
    );
  }
  private static class backgroundInitializer {
    static {
      _instance0.backgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return background;
    }
  }
  public com.google.gwt.resources.client.ImageResource background() {
    return backgroundInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYGVB-com-sencha-gxt-theme-blue-client-toolbar-BlueToolBarAppearance-BlueToolBarDefaultStyle-toolBar {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0"+ " " +"0"+ " " +"1px"+ " " +"0")  + ";\n  display : " + ("block")  + ";\n  background : " + ("repeat-x"+ " " +"top"+ " " +"right")  + ";\n  position : " + ("relative")  + ";\n  right : " + ("0")  + ";\n  top : " + ("0")  + ";\n  zoom : " + ("1")  + ";\n  overflow : " + ("hidden")  + ";\n  width : " + ("auto")  + ";\n  height : ") + (("auto")  + ";\n  border : " + ("none")  + ";\n}\n/* @external x-toolbar-mark; */\n.x-toolbar-mark {\n  border-width : " + ("0"+ " " +"0"+ " " +"1px"+ " " +"0")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#99b9e9")  + ";\n  height : " + ((BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getSafeUri().asString() + "\") -" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getLeft() + "px -" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getTop() + "px  repeat-x")  + ";\n  background-color : " + ("#d0def0")  + ";\n  height : " + ("auto")  + ";\n}\n")) : ((".GAVOEIYGVB-com-sencha-gxt-theme-blue-client-toolbar-BlueToolBarAppearance-BlueToolBarDefaultStyle-toolBar {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("0"+ " " +"0"+ " " +"1px"+ " " +"0")  + ";\n  display : " + ("block")  + ";\n  background : " + ("repeat-x"+ " " +"top"+ " " +"left")  + ";\n  position : " + ("relative")  + ";\n  left : " + ("0")  + ";\n  top : " + ("0")  + ";\n  zoom : " + ("1")  + ";\n  overflow : " + ("hidden")  + ";\n  width : " + ("auto")  + ";\n  height : ") + (("auto")  + ";\n  border : " + ("none")  + ";\n}\n/* @external x-toolbar-mark; */\n.x-toolbar-mark {\n  border-width : " + ("0"+ " " +"0"+ " " +"1px"+ " " +"0")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#99b9e9")  + ";\n  height : " + ((BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getSafeUri().asString() + "\") -" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getLeft() + "px -" + (BlueToolBarAppearance_BlueToolBarDefaultResources_default_InlineClientBundleGenerator.this.background()).getTop() + "px  repeat-x")  + ";\n  background-color : " + ("#d0def0")  + ";\n  height : " + ("auto")  + ";\n}\n"));
      }
      public java.lang.String moreButton(){
        return "GAVOEIYFVB-com-sencha-gxt-theme-blue-client-toolbar-BlueToolBarAppearance-BlueToolBarDefaultStyle-moreButton";
      }
      public java.lang.String toolBar(){
        return "GAVOEIYGVB-com-sencha-gxt-theme-blue-client-toolbar-BlueToolBarAppearance-BlueToolBarDefaultStyle-toolBar";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAIAAAA4CAYAAADXVynvAAAArElEQVR42o3QuRKCQBCE4Xn/N/OCBQ8EZRWvjBsTk3bagMEyMfi6/mhrQJrnCyTZYwBZpPcBpNGDZH/rQZLoJF+xu/YgjQ5ksb10IItN0YFkXbQgi/jcgqbRgCQ6NSAL5xuQRehrkAR5DbJYHWvQNCqQLA8VyGKhQzLPKpBGCZJZWoIsxnd+I8grkARew3+HHsZTx5tD/SaycDruE/oDSFyhUUwj0iGJdeI/4w2HI5Y2f7R+rgAAAABJRU5ErkJggg==";
  private static com.google.gwt.resources.client.ImageResource background;
  private static com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      background(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("background", background());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'background': return this.@com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultResources::background()();
      case 'style': return this.@com.sencha.gxt.theme.blue.client.toolbar.BlueToolBarAppearance.BlueToolBarDefaultResources::style()();
    }
    return null;
  }-*/;
}
