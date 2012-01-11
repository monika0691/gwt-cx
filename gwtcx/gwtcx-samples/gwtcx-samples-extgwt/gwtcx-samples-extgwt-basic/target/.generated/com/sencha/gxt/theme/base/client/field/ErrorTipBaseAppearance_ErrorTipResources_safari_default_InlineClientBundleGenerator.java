package com.sencha.gxt.theme.base.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipResources {
  private static ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator _instance0 = new ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator();
  private void anchorBottomInitializer() {
    anchorBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "anchorBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 9, 10, false, false
    );
  }
  private static class anchorBottomInitializer {
    static {
      _instance0.anchorBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return anchorBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource anchorBottom() {
    return anchorBottomInitializer.get();
  }
  private void anchorLeftInitializer() {
    anchorLeft = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "anchorLeft",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 10, 9, false, false
    );
  }
  private static class anchorLeftInitializer {
    static {
      _instance0.anchorLeftInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return anchorLeft;
    }
  }
  public com.google.gwt.resources.client.ImageResource anchorLeft() {
    return anchorLeftInitializer.get();
  }
  private void anchorRightInitializer() {
    anchorRight = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "anchorRight",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 10, 9, false, false
    );
  }
  private static class anchorRightInitializer {
    static {
      _instance0.anchorRightInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return anchorRight;
    }
  }
  public com.google.gwt.resources.client.ImageResource anchorRight() {
    return anchorRightInitializer.get();
  }
  private void anchorTopInitializer() {
    anchorTop = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "anchorTop",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 9, 10, false, false
    );
  }
  private static class anchorTopInitializer {
    static {
      _instance0.anchorTopInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return anchorTop;
    }
  }
  public com.google.gwt.resources.client.ImageResource anchorTop() {
    return anchorTopInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYGR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-tools {\n  float : " + ("left")  + ";\n}\n.GAVOEIYER-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-heading {\n  color : " + ("#444")  + ";\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("none")  + ";\n}\n.GAVOEIYFR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-text {\n  color : " + ("#444")  + ";\n  font : " + ("11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  white-space : " + ("nowrap")  + ";\n  padding-right : " + ("2px")  + ";\n  padding-left : " + ("2px")  + ";\n}\n.GAVOEIYBR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorBottom {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getHeight() + "px")  + ";\n  width : ") + (((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYDR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorRight {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getHeight() + "px")  + ";\n  width : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYCR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorLeft {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getHeight() + "px")  + ";\n  width : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getWidth() + "px") ) + (";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYER-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-heading, .GAVOEIYFR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-text {\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#444")  + ";\n}\n")) : ((".GAVOEIYGR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-tools {\n  float : " + ("right")  + ";\n}\n.GAVOEIYER-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-heading {\n  color : " + ("#444")  + ";\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("none")  + ";\n}\n.GAVOEIYFR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-text {\n  color : " + ("#444")  + ";\n  font : " + ("11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  white-space : " + ("nowrap")  + ";\n  padding-left : " + ("2px")  + ";\n  padding-right : " + ("2px")  + ";\n}\n.GAVOEIYBR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorBottom {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getHeight() + "px")  + ";\n  width : ") + (((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYDR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorRight {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getHeight() + "px")  + ";\n  width : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYCR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorLeft {\n  height : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getHeight() + "px")  + ";\n  width : " + ((ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getWidth() + "px") ) + (";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getSafeUri().asString() + "\") -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getLeft() + "px -" + (ErrorTipBaseAppearance_ErrorTipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYER-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-heading, .GAVOEIYFR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-text {\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#444")  + ";\n}\n"));
      }
      public java.lang.String anchor(){
        return "GAVOEIYAR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchor";
      }
      public java.lang.String anchorBottom(){
        return "GAVOEIYBR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorBottom";
      }
      public java.lang.String anchorLeft(){
        return "GAVOEIYCR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorLeft";
      }
      public java.lang.String anchorRight(){
        return "GAVOEIYDR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-anchorRight";
      }
      public java.lang.String heading(){
        return "GAVOEIYER-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-heading";
      }
      public java.lang.String text(){
        return "GAVOEIYFR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-text";
      }
      public java.lang.String tools(){
        return "GAVOEIYGR-com-sencha-gxt-theme-base-client-field-ErrorTipBaseAppearance-ErrorTipStyle-tools";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAKCAYAAABmBXS+AAAAVElEQVR42mO4/+nHfxB+9ek/BobJMdTMOP7/5qMPWBWBxEHyYEXztlzHqggkDlYEAthMg5sCA9hMQzEFWSHMNAxTsJmG1RR003AqQDYNryKYQnQxABRnx++6FJdrAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAJCAYAAAALpr0TAAAAOklEQVR42mNgwANqZhz/D8L3P/34j1fBvC3X/9989AFTIbqCV5/+wzFBBXCFhBSQbiJJbiTZ1/jCEQBrQsfv1FZtNAAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAJCAYAAAALpr0TAAAAPElEQVR42mO4/+nH/5oZx8GYAR8AKbz56MP/eVuu49fw6tP//zCMVwOyQrwasCnEpoE8E/G6kWhfExuOAKRxx+8lO1+5AAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAKCAYAAABmBXS+AAAAUElEQVR42mNgQAM1M47/Z8AHQArmbbn+H69CkOTNRx9wK4KZ8urTf9ymwUwBKcJqGrIpMIxhGrIpMIxiGjZTMEzDZgqGafc//fgPwtgUweQAw0vH75rkqhIAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource anchorBottom;
  private static com.google.gwt.resources.client.ImageResource anchorLeft;
  private static com.google.gwt.resources.client.ImageResource anchorRight;
  private static com.google.gwt.resources.client.ImageResource anchorTop;
  private static com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      anchorBottom(), 
      anchorLeft(), 
      anchorRight(), 
      anchorTop(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("anchorBottom", anchorBottom());
        resourceMap.put("anchorLeft", anchorLeft());
        resourceMap.put("anchorRight", anchorRight());
        resourceMap.put("anchorTop", anchorTop());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'anchorBottom': return this.@com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources::anchorBottom()();
      case 'anchorLeft': return this.@com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources::anchorLeft()();
      case 'anchorRight': return this.@com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources::anchorRight()();
      case 'anchorTop': return this.@com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources::anchorTop()();
      case 'style': return this.@com.sencha.gxt.theme.base.client.field.ErrorTipBaseAppearance.ErrorTipResources::style()();
    }
    return null;
  }-*/;
}
