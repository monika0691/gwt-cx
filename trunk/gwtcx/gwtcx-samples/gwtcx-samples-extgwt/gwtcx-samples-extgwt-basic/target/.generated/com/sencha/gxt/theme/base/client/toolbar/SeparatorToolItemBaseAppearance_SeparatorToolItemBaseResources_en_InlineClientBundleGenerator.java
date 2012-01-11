package com.sencha.gxt.theme.base.client.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemBaseResources {
  private static SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator _instance0 = new SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator();
  private void backgroundInitializer() {
    background = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "background",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 2, 13, false, false
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
  private void cssInitializer() {
    css = new com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemStyle() {
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
        return (".GAVOEIYEGB-com-sencha-gxt-theme-base-client-toolbar-SeparatorToolItemBaseAppearance-SeparatorToolItemStyle-separator {\n  width : " + ((SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator.this.background()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator.this.background()).getSafeUri().asString() + "\") -" + (SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator.this.background()).getLeft() + "px -" + (SeparatorToolItemBaseAppearance_SeparatorToolItemBaseResources_en_InlineClientBundleGenerator.this.background()).getTop() + "px  repeat-y")  + ";\n  background-position : " + ("center"+ " " +"center")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  cursor : " + ("default")  + ";\n  display : " + ("block")  + ";\n  font-size : " + ("1px")  + ";\n  height : " + ("16px")  + ";\n  padding : ") + (("0"+ " " +"3px")  + ";\n  overflow : " + ("hidden")  + ";\n}\n");
      }
      public java.lang.String separator(){
        return "GAVOEIYEGB-com-sencha-gxt-theme-base-client-toolbar-SeparatorToolItemBaseAppearance-SeparatorToolItemStyle-separator";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemStyle get() {
      return css;
    }
  }
  public com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemStyle css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAIAAAANCAYAAACD4L/xAAAAEUlEQVR42mOYdew/GDDQkQEAv11fk6zspTEAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource background;
  private static com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemStyle css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      background(), 
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("background", background());
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'background': return this.@com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemBaseResources::background()();
      case 'css': return this.@com.sencha.gxt.theme.base.client.toolbar.SeparatorToolItemBaseAppearance.SeparatorToolItemBaseResources::css()();
    }
    return null;
  }-*/;
}
