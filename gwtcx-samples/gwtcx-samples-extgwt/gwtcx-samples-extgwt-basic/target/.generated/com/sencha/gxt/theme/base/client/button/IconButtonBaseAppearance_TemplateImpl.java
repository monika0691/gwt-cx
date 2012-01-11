package com.sencha.gxt.theme.base.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class IconButtonBaseAppearance_TemplateImpl implements com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.Template {
  public com.google.gwt.safehtml.shared.SafeHtml render(com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance.IconButtonBaseStyle style){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <div class="{0}"></div>
     * params:
       * com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance_IconButtonBaseStyle_button_ValueProviderImpl.INSTANCE.getValue(style)
     */
    outer = GWT.<com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance_Template_render_SafeHtml__IconButtonBaseStyle_style___SafeHtmlTemplates>create(com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance_Template_render_SafeHtml__IconButtonBaseStyle_style___SafeHtmlTemplates.class).render0(com.sencha.gxt.theme.base.client.button.IconButtonBaseAppearance_IconButtonBaseStyle_button_ValueProviderImpl.INSTANCE.getValue(style));
    return outer;
  }
}
