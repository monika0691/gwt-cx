package com.sencha.gxt.theme.blue.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemResources {
  private static BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator _instance0 = new BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator();
  private void menuParentInitializer() {
    menuParent = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "menuParent",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 12, 9, false, false
    );
  }
  private static class menuParentInitializer {
    static {
      _instance0.menuParentInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return menuParent;
    }
  }
  public com.google.gwt.resources.client.ImageResource menuParent() {
    return menuParentInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYNMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItem {\n  -khtml-user-select : " + ("none")  + ";\n  -webkit-user-select : " + ("ignore")  + ";\n}\na.GAVOEIYNMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItem {\n  cursor : " + ("pointer")  + ";\n  display : " + ("block")  + ";\n  line-height : " + ("16px")  + ";\n  outline-style : " + ("none")  + ";\n  outline-width : " + ("0")  + ";\n  padding : " + ("3px"+ " " +"27px"+ " " +"3px"+ " " +"21px")  + ";\n  position : " + ("relative")  + ";\n  text-decoration : " + ("none")  + ";\n  white-space : ") + (("nowrap")  + ";\n  color : " + ("#222")  + ";\n}\n.GAVOEIYANB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuListItem {\n  white-space : " + ("nowrap")  + ";\n  display : " + ("block")  + ";\n  padding : " + ("1px")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYPMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemIcon {\n  border : " + ("0"+ " " +"none")  + ";\n  height : " + ("16px")  + ";\n  padding : " + ("0")  + ";\n  vertical-align : " + ("top")  + ";\n  width : " + ("16px") ) + (";\n  position : " + ("absolute")  + ";\n  right : " + ("3px")  + ";\n  top : " + ("3px")  + ";\n  margin : " + ("0")  + ";\n  background-position : " + ("center")  + ";\n}\n.GAVOEIYOMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemArrow {\n  height : " + ((BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getSafeUri().asString() + "\") -" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getLeft() + "px -" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getTop() + "px  no-repeat")  + ";\n  height : " + ("auto")  + ";\n  width : ") + (("auto")  + ";\n  background-position : " + ("left")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n")) : ((".GAVOEIYNMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItem {\n  -khtml-user-select : " + ("none")  + ";\n  -webkit-user-select : " + ("ignore")  + ";\n}\na.GAVOEIYNMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItem {\n  cursor : " + ("pointer")  + ";\n  display : " + ("block")  + ";\n  line-height : " + ("16px")  + ";\n  outline-style : " + ("none")  + ";\n  outline-width : " + ("0")  + ";\n  padding : " + ("3px"+ " " +"21px"+ " " +"3px"+ " " +"27px")  + ";\n  position : " + ("relative")  + ";\n  text-decoration : " + ("none")  + ";\n  white-space : ") + (("nowrap")  + ";\n  color : " + ("#222")  + ";\n}\n.GAVOEIYANB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuListItem {\n  white-space : " + ("nowrap")  + ";\n  display : " + ("block")  + ";\n  padding : " + ("1px")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYPMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemIcon {\n  border : " + ("0"+ " " +"none")  + ";\n  height : " + ("16px")  + ";\n  padding : " + ("0")  + ";\n  vertical-align : " + ("top")  + ";\n  width : " + ("16px") ) + (";\n  position : " + ("absolute")  + ";\n  left : " + ("3px")  + ";\n  top : " + ("3px")  + ";\n  margin : " + ("0")  + ";\n  background-position : " + ("center")  + ";\n}\n.GAVOEIYOMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemArrow {\n  height : " + ((BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getSafeUri().asString() + "\") -" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getLeft() + "px -" + (BlueMenuItemAppearance_BlueMenuItemResources_safari_default_InlineClientBundleGenerator.this.menuParent()).getTop() + "px  no-repeat")  + ";\n  height : " + ("auto")  + ";\n  width : ") + (("auto")  + ";\n  background-position : " + ("right")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n"));
      }
      public java.lang.String menuItem(){
        return "GAVOEIYNMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItem";
      }
      public java.lang.String menuItemArrow(){
        return "GAVOEIYOMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemArrow";
      }
      public java.lang.String menuItemIcon(){
        return "GAVOEIYPMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuItemIcon";
      }
      public java.lang.String menuListItem(){
        return "GAVOEIYANB-com-sencha-gxt-theme-blue-client-menu-BlueMenuItemAppearance-BlueMenuItemStyle-menuListItem";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAJCAYAAAAGuM1UAAAAb0lEQVR42mOwaLr2n4EUYNtx979Ny2XiNWmXnvo/9fT//5bEagJp6Dv87X/X4T//HTtv/idKQ8iCl/+TVn38n77g6n+j0v3/CWoIWvDmf+iUc/+1CvcTZ4N798n/mnn7iPeDTsEB4kPJquocSfEAADQCQiRH/8LtAAAAAElFTkSuQmCC";
  private static com.google.gwt.resources.client.ImageResource menuParent;
  private static com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      menuParent(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("menuParent", menuParent());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'menuParent': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemResources::menuParent()();
      case 'style': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance.BlueMenuItemResources::style()();
    }
    return null;
  }-*/;
}
