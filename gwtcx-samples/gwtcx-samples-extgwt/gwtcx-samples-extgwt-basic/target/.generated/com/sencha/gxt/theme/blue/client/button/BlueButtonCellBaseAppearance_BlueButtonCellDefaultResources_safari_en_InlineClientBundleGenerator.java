package com.sencha.gxt.theme.blue.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator implements com.sencha.gxt.theme.blue.client.button.BlueButtonCellBaseAppearance.BlueButtonCellDefaultResources {
  private static BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator _instance0 = new BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator();
  private void arrowInitializer() {
    arrow = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "arrow",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 10, 10, false, false
    );
  }
  private static class arrowInitializer {
    static {
      _instance0.arrowInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return arrow;
    }
  }
  public com.google.gwt.resources.client.ImageResource arrow() {
    return arrowInitializer.get();
  }
  private void arrowBottomInitializer() {
    arrowBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "arrowBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 200, 14, false, false
    );
  }
  private static class arrowBottomInitializer {
    static {
      _instance0.arrowBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return arrowBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource arrowBottom() {
    return arrowBottomInitializer.get();
  }
  private void splitInitializer() {
    split = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "split",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 14, 72, false, false
    );
  }
  private static class splitInitializer {
    static {
      _instance0.splitInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return split;
    }
  }
  public com.google.gwt.resources.client.ImageResource split() {
    return splitInitializer.get();
  }
  private void splitBottomInitializer() {
    splitBottom = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "splitBottom",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 200, 14, false, false
    );
  }
  private static class splitBottomInitializer {
    static {
      _instance0.splitBottomInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return splitBottom;
    }
  }
  public com.google.gwt.resources.client.ImageResource splitBottom() {
    return splitBottomInitializer.get();
  }
  private void styleInitializer() {
    style = new com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("/* @external x-toolbar-mark; */\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button {\n  cursor : " + ("pointer")  + ";\n  white-space : " + ("nowrap")  + ";\n}\n.GPT3MYQDFM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-hasWidth .GPT3MYQDMM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-mainTable {\n  width : " + ("100%")  + ";\n}\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button td {\n  text-align : " + ("center")  + ";\n}\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button td img {\n  float : " + ("right")  + ";\n}\n.GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop td img, .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom td img {\n  float : " + ("none")  + ";\n}\n.GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap {\n  padding : " + ("0"+ " " +"2px")  + ";\n}\n.GPT3MYQDDN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-text {\n  padding : " + ("0"+ " " +"2px")  + ";\n  font-family : " + ("Tahoma"+ ","+ " " +"Arial"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : ") + (("normal")  + ";\n  text-align : " + ("center")  + ";\n  cursor : " + ("pointer")  + ";\n  white-space : " + ("nowrap")  + ";\n  overview : " + ("hidden")  + ";\n}\n.GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  font-size : " + ("1px")  + ";\n}\n.GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td {\n  line-height : " + ("18px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("20px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td {\n  line-height : " + ("24px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("26px")  + ";\n}\n.GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  line-height : " + ("32px") ) + (";\n}\n.GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("34px")  + ";\n}\n.GPT3MYQDBN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-split {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  background-position : " + ("left"+ " " +"center")  + ";\n  padding-left : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDCN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-splitBottom {\n  height : ") + (((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  gwt-image : " + ("\"splitBottom\"")  + ";\n  background-position : " + ("center"+ " " +"bottom")  + ";\n  padding-bottom : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDCM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrow {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getHeight() + "px") ) + (";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  padding-left : " + ("10px")  + ";\n  background-position : " + ("left"+ " " +"center")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDDM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrowBottom {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getWidth() + "px")  + ";\n  overflow : ") + (("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  background-position : " + ("center"+ " " +"bottom")  + ";\n  padding-bottom : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n")) : (("/* @external x-toolbar-mark; */\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button {\n  cursor : " + ("pointer")  + ";\n  white-space : " + ("nowrap")  + ";\n}\n.GPT3MYQDFM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-hasWidth .GPT3MYQDMM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-mainTable {\n  width : " + ("100%")  + ";\n}\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button td {\n  text-align : " + ("center")  + ";\n}\n.GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button td img {\n  float : " + ("left")  + ";\n}\n.GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop td img, .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom td img {\n  float : " + ("none")  + ";\n}\n.GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap {\n  padding : " + ("0"+ " " +"2px")  + ";\n}\n.GPT3MYQDDN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-text {\n  padding : " + ("0"+ " " +"2px")  + ";\n  font-family : " + ("Tahoma"+ ","+ " " +"Arial"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("11px")  + ";\n  font-weight : ") + (("normal")  + ";\n  text-align : " + ("center")  + ";\n  cursor : " + ("pointer")  + ";\n  white-space : " + ("nowrap")  + ";\n  overview : " + ("hidden")  + ";\n}\n.GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  font-size : " + ("1px")  + ";\n}\n.GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td {\n  line-height : " + ("18px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("20px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td {\n  line-height : " + ("24px")  + ";\n}\n.GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("26px")  + ";\n}\n.GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon td, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  line-height : " + ("32px") ) + (";\n}\n.GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div, .GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large .GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom .GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap div {\n  height : " + ("34px")  + ";\n}\n.GPT3MYQDBN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-split {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.split()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  background-position : " + ("right"+ " " +"center")  + ";\n  padding-right : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDCN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-splitBottom {\n  height : ") + (((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.splitBottom()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  gwt-image : " + ("\"splitBottom\"")  + ";\n  background-position : " + ("center"+ " " +"bottom")  + ";\n  padding-bottom : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDCM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrow {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getHeight() + "px") ) + (";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getWidth() + "px")  + ";\n  overflow : " + ("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrow()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  padding-right : " + ("10px")  + ";\n  background-position : " + ("right"+ " " +"center")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n.GPT3MYQDDM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrowBottom {\n  height : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getHeight() + "px")  + ";\n  width : " + ((BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getWidth() + "px")  + ";\n  overflow : ") + (("hidden")  + ";\n  background : " + ("url(\"" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getSafeUri().asString() + "\") -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getLeft() + "px -" + (BlueButtonCellBaseAppearance_BlueButtonCellDefaultResources_safari_en_InlineClientBundleGenerator.this.arrowBottom()).getTop() + "px  no-repeat")  + ";\n  width : " + ("auto")  + ";\n  height : " + ("auto")  + ";\n  background-position : " + ("center"+ " " +"bottom")  + ";\n  padding-bottom : " + ("14px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n}\n"));
      }
      public java.lang.String arrow(){
        return "GPT3MYQDCM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrow";
      }
      public java.lang.String arrowBottom(){
        return "GPT3MYQDDM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-arrowBottom";
      }
      public java.lang.String button(){
        return "GPT3MYQDEM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-button";
      }
      public java.lang.String hasWidth(){
        return "GPT3MYQDFM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-hasWidth";
      }
      public java.lang.String iconBottom(){
        return "GPT3MYQDGM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconBottom";
      }
      public java.lang.String iconLeft(){
        return "GPT3MYQDHM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconLeft";
      }
      public java.lang.String iconRight(){
        return "GPT3MYQDIM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconRight";
      }
      public java.lang.String iconTop(){
        return "GPT3MYQDJM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconTop";
      }
      public java.lang.String iconWrap(){
        return "GPT3MYQDKM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-iconWrap";
      }
      public java.lang.String large(){
        return "GPT3MYQDLM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-large";
      }
      public java.lang.String mainTable(){
        return "GPT3MYQDMM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-mainTable";
      }
      public java.lang.String medium(){
        return "GPT3MYQDNM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-medium";
      }
      public java.lang.String noIcon(){
        return "GPT3MYQDOM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-noIcon";
      }
      public java.lang.String over(){
        return "GPT3MYQDPM-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-over";
      }
      public java.lang.String small(){
        return "GPT3MYQDAN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-small";
      }
      public java.lang.String split(){
        return "GPT3MYQDBN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-split";
      }
      public java.lang.String splitBottom(){
        return "GPT3MYQDCN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-splitBottom";
      }
      public java.lang.String text(){
        return "GPT3MYQDDN-com-sencha-gxt-theme-base-client-button-ButtonCellBaseAppearance-ButtonCellStyle-text";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellStyle get() {
      return style;
    }
  }
  public com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellStyle style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAFklEQVR42mNgGFrgPxZMlGKiTB5MAAAf3gj4JnSxiwAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAAOCAYAAABq6VM3AAAALUlEQVR42u3TMQ0AAAgEMfybBgP8xEibnISrAgAAAAAAjnoJCJMAYRIAAACeGvgeCPjeNr45AAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAABICAYAAADGScSgAAAAP0lEQVR42u3RsQkAMAgEQPffzIGsTQZIwHQp7uHLQ+EjdjKzq6rjNSAIgiAIfgz70PHFOxq82uYAQRAEwV/hAtuuENY01icUAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAAOCAYAAABq6VM3AAAANklEQVR42u3VAQ0AAAjDMPzrwhcY4Apok0l4XgVk3T2S7mqAyIUCAAD8M0dAGAkQRgIAAMBTCyEZuLtPdFEgAAAAAElFTkSuQmCC";
  private static com.google.gwt.resources.client.ImageResource arrow;
  private static com.google.gwt.resources.client.ImageResource arrowBottom;
  private static com.google.gwt.resources.client.ImageResource split;
  private static com.google.gwt.resources.client.ImageResource splitBottom;
  private static com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellStyle style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      arrow(), 
      arrowBottom(), 
      split(), 
      splitBottom(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("arrow", arrow());
        resourceMap.put("arrowBottom", arrowBottom());
        resourceMap.put("split", split());
        resourceMap.put("splitBottom", splitBottom());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'arrow': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellResources::arrow()();
      case 'arrowBottom': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellResources::arrowBottom()();
      case 'split': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellResources::split()();
      case 'splitBottom': return this.@com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellResources::splitBottom()();
      case 'style': return this.@com.sencha.gxt.theme.blue.client.button.BlueButtonCellBaseAppearance.BlueButtonCellDefaultResources::style()();
    }
    return null;
  }-*/;
}
