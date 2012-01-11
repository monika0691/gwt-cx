package com.sencha.gxt.core.client.dom;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator implements com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskResources {
  private static Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator _instance0 = new Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator();
  private void boxBackgroundInitializer() {
    boxBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "boxBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 1, 26, false, false
    );
  }
  private static class boxBackgroundInitializer {
    static {
      _instance0.boxBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return boxBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource boxBackground() {
    return boxBackgroundInitializer.get();
  }
  private void cssInitializer() {
    css = new com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYBK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-mask {\n  z-index : " + ("100")  + ";\n  top : " + ("0")  + ";\n  right : " + ("0")  + ";\n  width : " + ("100%")  + ";\n  height : " + ("100%")  + ";\n  zoom : " + ("1")  + ";\n  position : " + ("absolute")  + ";\n  opacity : " + ("0.5")  + ";\n  background-color : " + ("#ccc")  + ";\n}\n.GAVOEIYAK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-box {\n  z-index : " + ("101")  + ";\n  position : ") + (("absolute")  + ";\n  top : " + ("0")  + ";\n  right : " + ("0")  + ";\n  border : " + ("1px"+ " " +"solid")  + ";\n  padding : " + ("2px")  + ";\n  height : " + ((Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getSafeUri().asString() + "\") -" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getLeft() + "px -" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getTop() + "px  repeat-x")  + ";\n  border-color : " + ("#6593cf")  + ";\n  background-color : " + ("#c3daf9")  + ";\n}\n.GAVOEIYEK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-text {\n  padding : " + ("5px"+ " " +"10px"+ " " +"5px"+ " " +"10px") ) + (";\n  border : " + ("1px"+ " " +"solid")  + ";\n  cursor : " + ("wait")  + ";\n  background-color : " + ("white")  + ";\n  border-color : " + ("#a3bad9")  + ";\n  color : " + ("#222")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYDK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-positioned {\n  position : " + ("relative")  + " !important;\n}\n.GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked {\n  overflow : " + ("hidden")  + " !important;\n}\n.GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked select, .GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked object, .GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked embed {\n  visibility : " + ("hidden")  + ";\n}\n")) : ((".GAVOEIYBK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-mask {\n  z-index : " + ("100")  + ";\n  top : " + ("0")  + ";\n  left : " + ("0")  + ";\n  width : " + ("100%")  + ";\n  height : " + ("100%")  + ";\n  zoom : " + ("1")  + ";\n  position : " + ("absolute")  + ";\n  opacity : " + ("0.5")  + ";\n  background-color : " + ("#ccc")  + ";\n}\n.GAVOEIYAK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-box {\n  z-index : " + ("101")  + ";\n  position : ") + (("absolute")  + ";\n  top : " + ("0")  + ";\n  left : " + ("0")  + ";\n  border : " + ("1px"+ " " +"solid")  + ";\n  padding : " + ("2px")  + ";\n  height : " + ((Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getSafeUri().asString() + "\") -" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getLeft() + "px -" + (Mask_MaskDefaultAppearance_MaskResources_safari_en_InlineClientBundleGenerator.this.boxBackground()).getTop() + "px  repeat-x")  + ";\n  border-color : " + ("#6593cf")  + ";\n  background-color : " + ("#c3daf9")  + ";\n}\n.GAVOEIYEK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-text {\n  padding : " + ("5px"+ " " +"10px"+ " " +"5px"+ " " +"10px") ) + (";\n  border : " + ("1px"+ " " +"solid")  + ";\n  cursor : " + ("wait")  + ";\n  background-color : " + ("white")  + ";\n  border-color : " + ("#a3bad9")  + ";\n  color : " + ("#222")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYDK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-positioned {\n  position : " + ("relative")  + " !important;\n}\n.GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked {\n  overflow : " + ("hidden")  + " !important;\n}\n.GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked select, .GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked object, .GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked embed {\n  visibility : " + ("hidden")  + ";\n}\n"));
      }
      public java.lang.String box(){
        return "GAVOEIYAK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-box";
      }
      public java.lang.String mask(){
        return "GAVOEIYBK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-mask";
      }
      public java.lang.String masked(){
        return "GAVOEIYCK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-masked";
      }
      public java.lang.String positioned(){
        return "GAVOEIYDK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-positioned";
      }
      public java.lang.String text(){
        return "GAVOEIYEK-com-sencha-gxt-core-client-dom-Mask-MaskDefaultAppearance-MaskStyle-text";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskStyle get() {
      return css;
    }
  }
  public com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskStyle css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAaCAYAAAB2BDbRAAAAVklEQVR42mN4/O7Pf4a7r/7+Z7jxHMi69BhInL73G5k4fPMPlNh16TeU2Hzu13+GSTu+QYnpu3/8Z5i19zuUmH8AyF18GIVYefznf4a1J39BCbABIAIAZ1Fan/xRgxAAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource boxBackground;
  private static com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskStyle css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      boxBackground(), 
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("boxBackground", boxBackground());
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'boxBackground': return this.@com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskResources::boxBackground()();
      case 'css': return this.@com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskResources::css()();
    }
    return null;
  }-*/;
}
