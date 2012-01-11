package com.sencha.gxt.theme.base.client.tips;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources {
  private static TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator _instance0 = new TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator();
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
    style = new com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYCGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-tools {\n  float : " + ("left")  + ";\n}\n.GAVOEIYAGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-heading {\n  color : " + ("#444")  + ";\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("none")  + ";\n}\n.GAVOEIYBGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-text {\n  color : " + ("#444")  + ";\n  font : " + ("11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  white-space : " + ("nowrap")  + ";\n  padding-right : " + ("2px")  + ";\n  padding-left : " + ("2px")  + ";\n}\n.GAVOEIYNFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorBottom {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getHeight() + "px")  + ";\n  width : ") + (((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYPFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorRight {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getHeight() + "px")  + ";\n  width : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYOFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorLeft {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getHeight() + "px")  + ";\n  width : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getWidth() + "px") ) + (";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n")) : ((".GAVOEIYCGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-tools {\n  float : " + ("right")  + ";\n}\n.GAVOEIYAGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-heading {\n  color : " + ("#444")  + ";\n  font : " + ("bold"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("none")  + ";\n}\n.GAVOEIYBGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-text {\n  color : " + ("#444")  + ";\n  font : " + ("11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"helvetica"+ ","+ " " +"sans-serif")  + ";\n  white-space : " + ("nowrap")  + ";\n  padding-left : " + ("2px")  + ";\n  padding-right : " + ("2px")  + ";\n}\n.GAVOEIYNFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorBottom {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getHeight() + "px")  + ";\n  width : ") + (((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorBottom()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYPFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorRight {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getHeight() + "px")  + ";\n  width : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorRight()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n.GAVOEIYOFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorLeft {\n  height : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getHeight() + "px")  + ";\n  width : " + ((TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getWidth() + "px") ) + (";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getSafeUri().asString() + "\") -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getLeft() + "px -" + (TipBaseAppearance_TipResources_safari_default_InlineClientBundleGenerator.this.anchorLeft()).getTop() + "px  no-repeat")  + ";\n  position : " + ("absolute")  + ";\n}\n"));
      }
      public java.lang.String anchor(){
        return "GAVOEIYMFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchor";
      }
      public java.lang.String anchorBottom(){
        return "GAVOEIYNFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorBottom";
      }
      public java.lang.String anchorLeft(){
        return "GAVOEIYOFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorLeft";
      }
      public java.lang.String anchorRight(){
        return "GAVOEIYPFB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-anchorRight";
      }
      public java.lang.String heading(){
        return "GAVOEIYAGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-heading";
      }
      public java.lang.String text(){
        return "GAVOEIYBGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-text";
      }
      public java.lang.String tools(){
        return "GAVOEIYCGB-com-sencha-gxt-theme-base-client-tips-TipBaseAppearance-TipStyle-tools";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipStyle style() {
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
  private static com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipStyle style;
  
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
      case 'style': return this.@com.sencha.gxt.theme.base.client.tips.TipBaseAppearance.TipResources::style()();
    }
    return null;
  }-*/;
}
