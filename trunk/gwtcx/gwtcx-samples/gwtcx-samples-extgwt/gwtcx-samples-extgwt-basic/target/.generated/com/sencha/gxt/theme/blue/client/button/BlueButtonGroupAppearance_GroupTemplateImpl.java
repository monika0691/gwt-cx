package com.sencha.gxt.theme.blue.client.button;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class BlueButtonGroupAppearance_GroupTemplateImpl implements com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.GroupTemplate {
  public com.google.gwt.safehtml.shared.SafeHtml render(com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance.BlueButtonGroupStyle style){
    SafeHtml outer;
    
    /**
     * Root of template
     */
    
    /**
     * safehtml content:
       * <div class='{0}'><div class='{1}'></div></div>
     * params:
       * com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_BlueButtonGroupStyle_group_ValueProviderImpl.INSTANCE.getValue(style), com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_BlueButtonGroupStyle_body_ValueProviderImpl.INSTANCE.getValue(style)
     */
    outer = GWT.<com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_GroupTemplate_render_SafeHtml__BlueButtonGroupStyle_style___SafeHtmlTemplates>create(com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_GroupTemplate_render_SafeHtml__BlueButtonGroupStyle_style___SafeHtmlTemplates.class).render0(com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_BlueButtonGroupStyle_group_ValueProviderImpl.INSTANCE.getValue(style), com.sencha.gxt.theme.blue.client.button.BlueButtonGroupAppearance_BlueButtonGroupStyle_body_ValueProviderImpl.INSTANCE.getValue(style));
    return outer;
  }
}
