package com.sencha.gxt.theme.blue.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources {
  private static BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator _instance0 = new BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator();
  private void itemOverInitializer() {
    itemOver = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "itemOver",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 2, 21, false, false
    );
  }
  private static class itemOverInitializer {
    static {
      _instance0.itemOverInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return itemOver;
    }
  }
  public com.google.gwt.resources.client.ImageResource itemOver() {
    return itemOverInitializer.get();
  }
  private void menuInitializer() {
    menu = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "menu",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 250, 1, false, false
    );
  }
  private static class menuInitializer {
    static {
      _instance0.menuInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return menu;
    }
  }
  public com.google.gwt.resources.client.ImageResource menu() {
    return menuInitializer.get();
  }
  private void miniBottomInitializer() {
    miniBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "miniBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 35, 5, false, false
    );
  }
  private static class miniBottomInitializer {
    static {
      _instance0.miniBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return miniBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource miniBottom() {
    return miniBottomInitializer.get();
  }
  private void miniTopInitializer() {
    miniTop = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "miniTop",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 35, 5, false, false
    );
  }
  private static class miniTopInitializer {
    static {
      _instance0.miniTopInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return miniTop;
    }
  }
  public com.google.gwt.resources.client.ImageResource miniTop() {
    return miniTopInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu {\n  border : " + ("1px"+ " " +"solid")  + ";\n  z-index : " + ("15000")  + ";\n  zoom : " + ("1")  + ";\n  background : " + ("repeat-y")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu a {\n  text-decoration : " + ("none")  + " !important;\n}\n.GAVOEIYPLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuList {\n  padding : " + ("2px")  + ";\n  background : " + ("transparent")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  overflow-y : ") + (("hidden")  + ";\n}\n.GAVOEIYAMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItem {\n  white-space : " + ("nowrap")  + ";\n  display : " + ("block")  + ";\n  padding : " + ("1px")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYOLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuItemActive {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("1px")  + ";\n  padding : " + ("0")  + ";\n}\n.GAVOEIYMLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-dateMenu {\n  padding : " + ("0")  + " !important;\n}\n.GAVOEIYMLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-dateMenu .GAVOEIYPLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuList {\n  padding : " + ("0")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu .GAVOEIYDMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScroller {\n  margin : " + ("0") ) + (";\n  width : " + ("100%")  + ";\n  background-position : " + ("center")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  height : " + ("8px")  + ";\n  line-height : " + ("8px")  + ";\n  cursor : " + ("pointer")  + ";\n  padding : " + ("0")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu .GAVOEIYEMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerActive {\n  height : " + ("6px")  + ";\n  line-height : " + ("6px")  + ";\n}\n.GAVOEIYBMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItemIndent {\n  padding-right : " + ("27px")  + " !important;\n}\n.GAVOEIYHMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-noSeperator {\n  background-image : ") + (("none")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu {\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getTop() + "px  repeat-y")  + ";\n  width : " + ("auto")  + ";\n  border-color : " + ("#718bb7")  + ";\n  background-color : " + ("#f0f0f0")  + ";\n}\n.GAVOEIYOLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuItemActive {\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getTop() + "px  repeat-y")  + ";\n  width : " + ("auto") ) + (";\n  background-color : " + ("#ebf3fd")  + ";\n  background-repeat : " + ("repeat-x")  + ";\n  background-position : " + ("right"+ " " +"bottom")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#aaccf6")  + ";\n  padding : " + ("0")  + ";\n  color : " + ("#233d6d")  + ";\n}\n.GAVOEIYIMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-plain {\n  background-color : " + ("#fff")  + " !important;\n}\n.GAVOEIYGMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerTop {\n  height : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : ") + (("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getTop() + "px  no-repeat")  + ";\n}\n.GAVOEIYFMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerBottom {\n  height : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getTop() + "px  no-repeat")  + ";\n}\n.GAVOEIYDMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScroller {\n  border-width : " + ("1px"+ " " +"0")  + ";\n}\n")) : ((".GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu {\n  border : " + ("1px"+ " " +"solid")  + ";\n  z-index : " + ("15000")  + ";\n  zoom : " + ("1")  + ";\n  background : " + ("repeat-y")  + ";\n  outline : " + ("0"+ " " +"none")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu a {\n  text-decoration : " + ("none")  + " !important;\n}\n.GAVOEIYPLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuList {\n  padding : " + ("2px")  + ";\n  background : " + ("transparent")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  overflow : " + ("hidden")  + ";\n  overflow-y : ") + (("hidden")  + ";\n}\n.GAVOEIYAMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItem {\n  white-space : " + ("nowrap")  + ";\n  display : " + ("block")  + ";\n  padding : " + ("1px")  + ";\n  font : " + ("normal"+ " " +"11px"+ " " +"tahoma"+ ","+ " " +"arial"+ ","+ " " +"sans-serif")  + ";\n}\n.GAVOEIYOLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuItemActive {\n  border-style : " + ("solid")  + ";\n  border-width : " + ("1px")  + ";\n  padding : " + ("0")  + ";\n}\n.GAVOEIYMLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-dateMenu {\n  padding : " + ("0")  + " !important;\n}\n.GAVOEIYMLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-dateMenu .GAVOEIYPLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuList {\n  padding : " + ("0")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu .GAVOEIYDMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScroller {\n  margin : " + ("0") ) + (";\n  width : " + ("100%")  + ";\n  background-position : " + ("center")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  height : " + ("8px")  + ";\n  line-height : " + ("8px")  + ";\n  cursor : " + ("pointer")  + ";\n  padding : " + ("0")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu .GAVOEIYEMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerActive {\n  height : " + ("6px")  + ";\n  line-height : " + ("6px")  + ";\n}\n.GAVOEIYBMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItemIndent {\n  padding-left : " + ("27px")  + " !important;\n}\n.GAVOEIYHMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-noSeperator {\n  background-image : ") + (("none")  + ";\n}\n.GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu {\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.menu()).getTop() + "px  repeat-y")  + ";\n  width : " + ("auto")  + ";\n  border-color : " + ("#718bb7")  + ";\n  background-color : " + ("#f0f0f0")  + ";\n}\n.GAVOEIYOLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuItemActive {\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.itemOver()).getTop() + "px  repeat-y")  + ";\n  width : " + ("auto") ) + (";\n  background-color : " + ("#ebf3fd")  + ";\n  background-repeat : " + ("repeat-x")  + ";\n  background-position : " + ("left"+ " " +"bottom")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#aaccf6")  + ";\n  padding : " + ("0")  + ";\n  color : " + ("#233d6d")  + ";\n}\n.GAVOEIYIMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-plain {\n  background-color : " + ("#fff")  + " !important;\n}\n.GAVOEIYGMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerTop {\n  height : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : ") + (("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniTop()).getTop() + "px  no-repeat")  + ";\n}\n.GAVOEIYFMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerBottom {\n  height : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getSafeUri().asString() + "\") -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getLeft() + "px -" + (BlueMenuAppearance_BlueMenuResources_safari_en_InlineClientBundleGenerator.this.miniBottom()).getTop() + "px  no-repeat")  + ";\n}\n.GAVOEIYDMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScroller {\n  border-width : " + ("1px"+ " " +"0")  + ";\n}\n"));
      }
      public java.lang.String dateMenu(){
        return "GAVOEIYMLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-dateMenu";
      }
      public java.lang.String menu(){
        return "GAVOEIYNLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menu";
      }
      public java.lang.String menuItemActive(){
        return "GAVOEIYOLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuItemActive";
      }
      public java.lang.String menuList(){
        return "GAVOEIYPLB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuList";
      }
      public java.lang.String menuListItem(){
        return "GAVOEIYAMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItem";
      }
      public java.lang.String menuListItemIndent(){
        return "GAVOEIYBMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuListItemIndent";
      }
      public java.lang.String menuRadioGroup(){
        return "GAVOEIYCMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuRadioGroup";
      }
      public java.lang.String menuScroller(){
        return "GAVOEIYDMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScroller";
      }
      public java.lang.String menuScrollerActive(){
        return "GAVOEIYEMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerActive";
      }
      public java.lang.String menuScrollerBottom(){
        return "GAVOEIYFMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerBottom";
      }
      public java.lang.String menuScrollerTop(){
        return "GAVOEIYGMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-menuScrollerTop";
      }
      public java.lang.String noSeperator(){
        return "GAVOEIYHMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-noSeperator";
      }
      public java.lang.String plain(){
        return "GAVOEIYIMB-com-sencha-gxt-theme-blue-client-menu-BlueMenuAppearance-BlueMenuStyle-plain";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAIAAAAVCAYAAABsZT8HAAAAGklEQVR42mN4/fnvfxBmoJBx88Xv/yBMTwYA+d2en2a9xcEAAAAASUVORK5CYII=";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAAABCAYAAAD3ubPnAAAAHklEQVR42mP48OHDf1riR48f/wcBWtszikfxKMaNAfI0uFl52k+EAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAFCAYAAADPLFVyAAAANklEQVR42mO4ePHi/8GCGUAAxHjz5g3J2NnZFQOTYw7cITBADQdRxSHUcBBVHYLsILqmESQAACG6H+sTbbGtAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAFCAYAAADPLFVyAAAANUlEQVR42mNgQAMXL178Ty/MgA+AFLx584Zk7OzsSpY+nA6ixCEwTBUHUcMhVHEQPdMIIQwAgl8f6zRdECkAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource itemOver;
  private static com.google.gwt.resources.client.ImageResource menu;
  private static com.google.gwt.resources.client.ImageResource miniBottom;
  private static com.google.gwt.resources.client.ImageResource miniTop;
  private static com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      itemOver(), 
      menu(), 
      miniBottom(), 
      miniTop(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("itemOver", itemOver());
        resourceMap.put("menu", menu());
        resourceMap.put("miniBottom", miniBottom());
        resourceMap.put("miniTop", miniTop());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'itemOver': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources::itemOver()();
      case 'menu': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources::menu()();
      case 'miniBottom': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources::miniBottom()();
      case 'miniTop': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources::miniTop()();
      case 'style': return this.@com.sencha.gxt.theme.blue.client.menu.BlueMenuAppearance.BlueMenuResources::style()();
    }
    return null;
  }-*/;
}
