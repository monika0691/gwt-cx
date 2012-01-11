package com.sencha.gxt.theme.base.client.button;

public class ButtonCellBaseAppearance_ButtonCellTemplates_textWithStyles_SafeHtml__String_textClass__SafeStyles_textStyles__String_text___SafeHtmlTemplatesImpl implements com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_textWithStyles_SafeHtml__String_textClass__SafeStyles_textStyles__String_text___SafeHtmlTemplates {
  
  public com.google.gwt.safehtml.shared.SafeHtml textWithStyles0(java.lang.String arg0,com.google.gwt.safecss.shared.SafeStyles arg1,java.lang.String arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<td><div class=\"");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("\" style=\"");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1.asString()));
    sb.append("\">");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("</div></td>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
