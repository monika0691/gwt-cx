package com.allen_sauer.gwt.log.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class LogClientBundle_default_InlineClientBundleGenerator implements com.allen_sauer.gwt.log.client.impl.LogClientBundle {
  private static LogClientBundle_default_InlineClientBundleGenerator _instance0 = new LogClientBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.allen_sauer.gwt.log.client.impl.LogClientBundle.LogCssResource() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("/* @external log-panel; */\n.log-panel {\n  background-color : " + ("#ecf2fc")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"red")  + ";\n  margin : " + ("0")  + ";\n  filter : " + ("alpha(opacity\\=95)")  + ";\n  opacity : " + ("0.95")  + ";\n  z-index : " + ("1000")  + ";\n}\n.log-panel .GAVOEIYI-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-text-area {\n  font-size : " + ("10pt")  + ";\n  margin : " + ("0")  + ";\n  text-align : " + ("right")  + ";\n}\n.log-panel BUTTON {\n  font-size : " + ("10pt")  + ";\n  margin : ") + (("0")  + ";\n}\n.log-panel .GAVOEIYJ-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-title {\n  cursor : " + ("move")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.log-panel .GAVOEIYB-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-button {\n  margin : " + ("0"+ " " +"1.2em")  + ";\n}\n.log-panel BUTTON.GAVOEIYA-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-about {\n  color : " + ("#444")  + " !important;\n}\n.log-panel .GAVOEIYH-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-stacktrace {\n  white-space : " + ("nowrap")  + ";\n}\n.log-panel .GAVOEIYC-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message {\n  white-space : " + ("pre")  + ";\n  font-family : " + ("monospace")  + ";\n  cursor : " + ("help")  + ";\n}\n.log-panel .GAVOEIYD-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message-hover {\n  background-color : " + ("#f0f0f0")  + ";\n}\n.log-panel .GAVOEIYG-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-scroll-panel {\n  background-color : " + ("#fff") ) + (";\n}\n.log-panel .GAVOEIYF-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-resize-se {\n  cursor : " + ("sw-resize")  + ";\n}\n")) : (("/* @external log-panel; */\n.log-panel {\n  background-color : " + ("#ecf2fc")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"red")  + ";\n  margin : " + ("0")  + ";\n  filter : " + ("alpha(opacity\\=95)")  + ";\n  opacity : " + ("0.95")  + ";\n  z-index : " + ("1000")  + ";\n}\n.log-panel .GAVOEIYI-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-text-area {\n  font-size : " + ("10pt")  + ";\n  margin : " + ("0")  + ";\n  text-align : " + ("left")  + ";\n}\n.log-panel BUTTON {\n  font-size : " + ("10pt")  + ";\n  margin : ") + (("0")  + ";\n}\n.log-panel .GAVOEIYJ-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-title {\n  cursor : " + ("move")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.log-panel .GAVOEIYB-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-button {\n  margin : " + ("0"+ " " +"1.2em")  + ";\n}\n.log-panel BUTTON.GAVOEIYA-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-about {\n  color : " + ("#444")  + " !important;\n}\n.log-panel .GAVOEIYH-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-stacktrace {\n  white-space : " + ("nowrap")  + ";\n}\n.log-panel .GAVOEIYC-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message {\n  white-space : " + ("pre")  + ";\n  font-family : " + ("monospace")  + ";\n  cursor : " + ("help")  + ";\n}\n.log-panel .GAVOEIYD-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message-hover {\n  background-color : " + ("#f0f0f0")  + ";\n}\n.log-panel .GAVOEIYG-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-scroll-panel {\n  background-color : " + ("#fff") ) + (";\n}\n.log-panel .GAVOEIYF-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-resize-se {\n  cursor : " + ("se-resize")  + ";\n}\n"));
      }
      public java.lang.String logClearAbout(){
        return "GAVOEIYA-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-about";
      }
      public java.lang.String logClearButton(){
        return "GAVOEIYB-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-clear-button";
      }
      public java.lang.String logMessage(){
        return "GAVOEIYC-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message";
      }
      public java.lang.String logMessageHover(){
        return "GAVOEIYD-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-message-hover";
      }
      public java.lang.String logPanel(){
        return "log-panel";
      }
      public java.lang.String logResizeSe(){
        return "GAVOEIYF-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-resize-se";
      }
      public java.lang.String logScrollPanel(){
        return "GAVOEIYG-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-scroll-panel";
      }
      public java.lang.String logStacktrace(){
        return "GAVOEIYH-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-stacktrace";
      }
      public java.lang.String logTextArea(){
        return "GAVOEIYI-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-text-area";
      }
      public java.lang.String logTitle(){
        return "GAVOEIYJ-com-allen_sauer-gwt-log-client-impl-LogClientBundle-LogCssResource-log-title";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.allen_sauer.gwt.log.client.impl.LogClientBundle.LogCssResource get() {
      return css;
    }
  }
  public com.allen_sauer.gwt.log.client.impl.LogClientBundle.LogCssResource css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.allen_sauer.gwt.log.client.impl.LogClientBundle.LogCssResource css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.allen_sauer.gwt.log.client.impl.LogClientBundle::css()();
    }
    return null;
  }-*/;
}
