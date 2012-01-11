package com.sencha.gxt.theme.base.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources {
  private static TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator _instance0 = new TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("input.GAVOEIYFV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-focus, textarea.GAVOEIYFV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-focus {\n  border : " + ("1px"+ " " +"solid"+ " " +"#7eadd9")  + ";\n}\ninput.GAVOEIYGV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-invalid, textarea.GAVOEIYGV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-invalid {\n  height : " + ((TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getTop() + "px  repeat-x")  + ";\n  background-color : " + ("#fff")  + ";\n  background-position : " + ("bottom")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#c30")  + ";\n  height : " + ("auto")  + ";\n}\n.GAVOEIYJV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-wrap {\n  position : " + ("relative")  + ";\n  right : " + ("0")  + ";\n  top : ") + (("0")  + ";\n  zoom : " + ("1")  + ";\n  white-space : " + ("nowrap")  + ";\n  text-align : " + ("right")  + ";\n}\n.GAVOEIYDV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-field {\n  font : " + ("12px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYCV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-empty {\n  color : " + ("gray")  + ";\n}\n/* @external ext-ie ext-strict; */\n.GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text, .GAVOEIYBV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-area {\n  height : " + ((TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getTop() + "px  repeat-x")  + ";\n  height : " + ("auto")  + ";\n}\n.GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text {\n  background-color : " + ("#fff") ) + (";\n  border : " + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";\n  padding : " + ("1px"+ " " +"3px")  + ";\n  resize : " + ("none")  + ";\n  height : " + ("22px")  + ";\n  line-height : " + ("18px")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.GAVOEIYBV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-area {\n  background-color : " + ("#fff")  + ";\n  border : " + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";\n  padding : " + ("1px"+ " " +"3px")  + ";\n  resize : " + ("none")  + ";\n  overflow : ") + (("visible")  + ";\n}\n.ext-ie .GAVOEIYEV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-file {\n  height : " + ("22px")  + ";\n  line-height : " + ("18px")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.ext-strict .GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text {\n  height : " + ("18px")  + ";\n}\n")) : (("input.GAVOEIYFV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-focus, textarea.GAVOEIYFV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-focus {\n  border : " + ("1px"+ " " +"solid"+ " " +"#7eadd9")  + ";\n}\ninput.GAVOEIYGV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-invalid, textarea.GAVOEIYGV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-invalid {\n  height : " + ((TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.invalidLine()).getTop() + "px  repeat-x")  + ";\n  background-color : " + ("#fff")  + ";\n  background-position : " + ("bottom")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#c30")  + ";\n  height : " + ("auto")  + ";\n}\n.GAVOEIYJV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-wrap {\n  position : " + ("relative")  + ";\n  left : " + ("0")  + ";\n  top : ") + (("0")  + ";\n  zoom : " + ("1")  + ";\n  white-space : " + ("nowrap")  + ";\n  text-align : " + ("left")  + ";\n}\n.GAVOEIYDV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-field {\n  font : " + ("12px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYCV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-empty {\n  color : " + ("gray")  + ";\n}\n/* @external ext-ie ext-strict; */\n.GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text, .GAVOEIYBV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-area {\n  height : " + ((TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getHeight() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getSafeUri().asString() + "\") -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getLeft() + "px -" + (TextFieldDefaultAppearance_TextFieldResources_default_InlineClientBundleGenerator.this.textBackground()).getTop() + "px  repeat-x")  + ";\n  height : " + ("auto")  + ";\n}\n.GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text {\n  background-color : " + ("#fff") ) + (";\n  border : " + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";\n  padding : " + ("1px"+ " " +"3px")  + ";\n  resize : " + ("none")  + ";\n  height : " + ("22px")  + ";\n  line-height : " + ("18px")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.GAVOEIYBV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-area {\n  background-color : " + ("#fff")  + ";\n  border : " + ("1px"+ " " +"#b5b8c8"+ " " +"solid")  + ";\n  padding : " + ("1px"+ " " +"3px")  + ";\n  resize : " + ("none")  + ";\n  overflow : ") + (("visible")  + ";\n}\n.ext-ie .GAVOEIYEV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-file {\n  height : " + ("22px")  + ";\n  line-height : " + ("18px")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.ext-strict .GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text {\n  height : " + ("18px")  + ";\n}\n"));
      }
      public java.lang.String area(){
        return "GAVOEIYBV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-area";
      }
      public java.lang.String empty(){
        return "GAVOEIYCV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-empty";
      }
      public java.lang.String field(){
        return "GAVOEIYDV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-field";
      }
      public java.lang.String file(){
        return "GAVOEIYEV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-file";
      }
      public java.lang.String focus(){
        return "GAVOEIYFV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-focus";
      }
      public java.lang.String invalid(){
        return "GAVOEIYGV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-invalid";
      }
      public java.lang.String readonly(){
        return "GAVOEIYHV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-readonly";
      }
      public java.lang.String text(){
        return "GAVOEIYIV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-text";
      }
      public java.lang.String wrap(){
        return "GAVOEIYJV-com-sencha-gxt-theme-base-client-field-TextFieldDefaultAppearance-TextFieldStyle-wrap";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle get() {
      return css;
    }
  }
  public com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle css() {
    return cssInitializer.get();
  }
  private void invalidLineInitializer() {
    invalidLine = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "invalidLine",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 4, 3, false, false
    );
  }
  private static class invalidLineInitializer {
    static {
      _instance0.invalidLineInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return invalidLine;
    }
  }
  public com.google.gwt.resources.client.ImageResource invalidLine() {
    return invalidLineInitializer.get();
  }
  private void textBackgroundInitializer() {
    textBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 1, 18, false, false
    );
  }
  private static class textBackgroundInitializer {
    static {
      _instance0.textBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource textBackground() {
    return textBackgroundInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldStyle css;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "2659A66C9CEC1586DA091ACEC4A3AE6B.cache.png";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAASCAYAAACaV7S8AAAANElEQVR42pXEuQnAQAwAwe2/SCcGxwYhhLhn7RZuguG6H3kjJDIlq6S6pceQOZesvcXfUR9VjEbUejI8wwAAAABJRU5ErkJggg==";
  private static com.google.gwt.resources.client.ImageResource invalidLine;
  private static com.google.gwt.resources.client.ImageResource textBackground;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      invalidLine(), 
      textBackground(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("invalidLine", invalidLine());
        resourceMap.put("textBackground", textBackground());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources::css()();
      case 'invalidLine': return this.@com.sencha.gxt.theme.base.client.field.ValueBaseFieldDefaultAppearance.ValueBaseFieldResources::invalidLine()();
      case 'textBackground': return this.@com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance.TextFieldResources::textBackground()();
    }
    return null;
  }-*/;
}
