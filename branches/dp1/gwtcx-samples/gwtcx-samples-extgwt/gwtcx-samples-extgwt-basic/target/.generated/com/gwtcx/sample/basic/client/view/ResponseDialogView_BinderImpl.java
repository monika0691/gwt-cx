package com.gwtcx.sample.basic.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.PopupPanel;

public class ResponseDialogView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.PopupPanel, com.gwtcx.sample.basic.client.view.ResponseDialogView>, com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<b>Sending name to the server:</b>")
    SafeHtml html1();
     
    @Template("<br> <b>Server replies:</b>")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<b>Remote Procedure Call</b>")
    SafeHtml html5();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.PopupPanel createAndBindUi(final com.gwtcx.sample.basic.client.view.ResponseDialogView owner) {

    com.gwtcx.sample.basic.client.view.ResponseDialogView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.gwtcx.sample.basic.client.view.ResponseDialogView_BinderImpl_GenBundle) GWT.create(com.gwtcx.sample.basic.client.view.ResponseDialogView_BinderImpl_GenBundle.class);
    com.gwtcx.sample.basic.client.view.ResponseDialogView_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTML f_HTML4 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelTextToServer = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTML f_HTML5 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelServerResponse = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.sencha.gxt.widget.core.client.button.TextButton closeButton = (com.sencha.gxt.widget.core.client.button.TextButton) GWT.create(com.sencha.gxt.widget.core.client.button.TextButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId2).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0, domId1).asString());
    com.google.gwt.user.client.ui.DialogBox f_DialogBox1 = new com.google.gwt.user.client.ui.DialogBox(false, false);

    f_VerticalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HTML4.setHTML(template.html1().asString());
    f_VerticalPanel3.add(f_HTML4);
    f_VerticalPanel3.add(labelTextToServer);
    f_HTML5.setHTML(template.html2().asString());
    f_VerticalPanel3.add(f_HTML5);
    f_VerticalPanel3.add(labelServerResponse);
    closeButton.setText("Close");
    f_HTMLPanel6.setStyleName("buttonsDiv");
    f_DialogBox1.setHTML(template.html5().asString());
    f_DialogBox1.setWidget(f_HTMLPanel2);
    f_DialogBox1.setAnimationEnabled(true);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord1.detach();
    f_HTMLPanel6.addAndReplaceElement(closeButton, domId2Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    f_HTMLPanel2.addAndReplaceElement(f_VerticalPanel3, domId0Element);
    f_HTMLPanel2.addAndReplaceElement(f_HTMLPanel6, domId1Element);


    final com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler() {
      public void onSelect(com.sencha.gxt.widget.core.client.event.SelectEvent event) {
        owner.onCloseButtonClicked(event);
      }
    };
    closeButton.addSelectHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.closeButton = closeButton;
    owner.labelServerResponse = labelServerResponse;
    owner.labelTextToServer = labelTextToServer;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_DialogBox1;
  }
}
