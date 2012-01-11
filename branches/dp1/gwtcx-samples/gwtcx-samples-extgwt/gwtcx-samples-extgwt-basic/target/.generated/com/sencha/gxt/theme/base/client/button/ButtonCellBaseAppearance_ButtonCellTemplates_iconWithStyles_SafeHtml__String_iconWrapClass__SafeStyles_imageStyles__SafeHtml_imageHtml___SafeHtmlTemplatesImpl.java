package com.sencha.gxt.theme.base.client.button;

public class ButtonCellBaseAppearance_ButtonCellTemplates_iconWithStyles_SafeHtml__String_iconWrapClass__SafeStyles_imageStyles__SafeHtml_imageHtml___SafeHtmlTemplatesImpl implements com.sencha.gxt.theme.base.client.button.ButtonCellBaseAppearance_ButtonCellTemplates_iconWithStyles_SafeHtml__String_iconWrapClass__SafeStyles_imageStyles__SafeHtml_imageHtml___SafeHtmlTemplates {
  
  public com.google.gwt.safehtml.shared.SafeHtml iconWithStyles0(java.lang.String arg0,com.google.gwt.safecss.shared.SafeStyles arg1,com.google.gwt.safehtml.shared.SafeHtml arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<td valign=middle class=\"");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("\"><div style=\"");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1.asString()));
    sb.append("\">");
    sb.append(arg2.asString());
    sb.append("&nbsp;</div></td>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
