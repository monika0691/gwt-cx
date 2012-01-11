package com.sencha.gxt.theme.base.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class ButtonCellBaseAppearance_ButtonCellTemplatesImpl implements com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance.ButtonCellTemplates {
  public com.google.gwt.safehtml.shared.SafeHtml icon(java.lang.String iconWrapClass, com.google.gwt.safehtml.shared.SafeHtml imageHtml){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <td valign=middle class="{0}"><div>{1}&nbsp;</div></td>
     * params:
       * iconWrapClass, imageHtml
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_icon_SafeHtml__String_iconWrapClass__SafeHtml_imageHtml___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_icon_SafeHtml__String_iconWrapClass__SafeHtml_imageHtml___SafeHtmlTemplates.class).icon0(iconWrapClass, imageHtml);
    return outer;
  }
  public com.google.gwt.safehtml.shared.SafeHtml iconWithStyles(java.lang.String iconWrapClass, com.google.gwt.safecss.shared.SafeStyles imageStyles, com.google.gwt.safehtml.shared.SafeHtml imageHtml){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <td valign=middle class="{0}"><div style="{1}">{2}&nbsp;</div></td>
     * params:
       * iconWrapClass, imageStyles, imageHtml
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_iconWithStyles_SafeHtml__String_iconWrapClass__SafeStyles_imageStyles__SafeHtml_imageHtml___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_iconWithStyles_SafeHtml__String_iconWrapClass__SafeStyles_imageStyles__SafeHtml_imageHtml___SafeHtmlTemplates.class).iconWithStyles0(iconWrapClass, imageStyles, imageHtml);
    return outer;
  }
  public com.google.gwt.safehtml.shared.SafeHtml outer(java.lang.String cls, com.google.gwt.safecss.shared.SafeStyles styles){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <div class="{0}" style="{1}">
     * params:
       * cls, styles
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_outer_SafeHtml__String_cls__SafeStyles_styles___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_outer_SafeHtml__String_cls__SafeStyles_styles___SafeHtmlTemplates.class).outer0(cls, styles);
    return outer;
  }
  public com.google.gwt.safehtml.shared.SafeHtml text(java.lang.String textClass, java.lang.String text){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <td><div class="{0}">{1}</div></td>
     * params:
       * textClass, text
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_text_SafeHtml__String_textClass__String_text___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_text_SafeHtml__String_textClass__String_text___SafeHtmlTemplates.class).text0(textClass, text);
    return outer;
  }
  public com.google.gwt.safehtml.shared.SafeHtml textWithStyles(java.lang.String textClass, com.google.gwt.safecss.shared.SafeStyles textStyles, java.lang.String text){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <td><div class="{0}" style="{1}">{2}</div></td>
     * params:
       * textClass, textStyles, text
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_textWithStyles_SafeHtml__String_textClass__SafeStyles_textStyles__String_text___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_textWithStyles_SafeHtml__String_textClass__SafeStyles_textStyles__String_text___SafeHtmlTemplates.class).textWithStyles0(textClass, textStyles, text);
    return outer;
  }
}
