/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.smartgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.presenter.FileUploadPagePresenter;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.gwtcx.client.uihandlers.FileUploadPageUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * FileUploadPageView
 */
public class FileUploadPageView extends ViewWithUiHandlers<FileUploadPageUiHandlers> implements
    FileUploadPagePresenter.MyView {

  public static final String WIZARD_HEADER_STYLE_NAME = "gwtcx-Wizard-Header";
  public static final String WIZARD_BODY_STYLE_NAME = "gwtcx-Wizard-Body";
  public static final String WIZARD_FOOTER_STYLE_NAME = "gwtcx-Wizard-Footer";
  public static final String WIZARD_NAME_STYLE_NAME = "gwtcx-Wizard-Name";
  public static final String WIZARD_DESCRIPTION_STYLE_NAME = "gwtcx-Wizard-Description";

  public static final String DEFAULT_MARGIN = "0px";

  public static final int HEADER_HEIGHT = 58;
  public static final int FOOTER_HEIGHT = 48;

  private static final String DEFAULT_FILE_UPLOAD_SERVICE_PATH = "upload/";
  private static final String TARGET = "uploadTarget";

  private static final String RECORD_TYPE = "recordType";
  private static final String MAP_NAME = "mapName";
  private static final String FILE_NAME = "filename";

  private static final String BLANK_SPACE = " ";

  private static final int FORM_MARGIN = 8;
  private static final int NUMBER_OF_COLUMNS = 2;
  private static final int CELL_PADDING = 2;
  private static final int LAYOUT_MARGIN = 8;
  private static final int LAYOUT_PADDING = 8;

  private VLayout panel;
  private VLayout northLayout;
  private VLayout southLayout;

  private DynamicForm uploadForm;
  private UploadItem uploadItem;
  private ComboBoxItem recordType;
  private ComboBoxItem mapName;

  @Inject
  public FileUploadPageView() {

    // get rid of scroll bars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area
    Window.enableScrolling(false);
    Window.setMargin(DEFAULT_MARGIN);

    // initialise the main layout container
    panel = new VLayout();
    panel.setWidth100();
    panel.setHeight100();

    // initialise the North layout container
    northLayout = new VLayout();
    northLayout.setWidth100();
    northLayout.setHeight(HEADER_HEIGHT);

    // initialise the South layout container
    southLayout = new VLayout();
    southLayout.setWidth100();
    southLayout.setHeight100();

    // add the nested layout containers to the main layout containers
    northLayout.addMember(initHeader());
    southLayout.addMember(initBody());
    southLayout.addMember(initFooter());

    // add the North and South layout containers to the main layout container
    panel.addMember(northLayout);
    panel.addMember(southLayout);

    // bindCustomUiHandlers();

    // set the browser window's title
    Window.setTitle(I18nUtil.getConstant().fileUploadWindowTitle());
  }

  // protected void bindCustomUiHandlers() {}

  @Override
  public Widget asWidget() {
    return panel;
  }

  private VLayout initHeader() {

    // initialise the Header layout container
    VLayout header = new VLayout();
    header.setStyleName(WIZARD_HEADER_STYLE_NAME);

    header.setWidth100();
    header.setHeight(HEADER_HEIGHT);

    HLayout line1 = new HLayout();
    line1.setWidth100();
    line1.setHeight100();

    HLayout line2 = new HLayout();
    line2.setWidth100();
    line2.setHeight100();

    // initialise the Name label
    Label name = new Label();
    name.setStyleName(WIZARD_NAME_STYLE_NAME);
    name.setContents(I18nUtil.getConstant().fileUploadHeaderLine1Label());
    name.setWidth100();

    // initialise the Description label
    Label description = new Label();
    description.setStyleName(WIZARD_DESCRIPTION_STYLE_NAME);
    description.setContents(I18nUtil.getConstant().fileUploadHeaderLine2Label());
    description.setWidth100();

    // add the labels to the nested layout containers
    line1.addMember(name);
    line2.addMember(description);

    // add the North and South layout containers to the main layout container
    header.addMember(line1);
    header.addMember(line2);

    return header;
  }

  private VLayout initBody() {

    // initialise the Footer layout container
    VLayout body = new VLayout();
    body.setStyleName(WIZARD_BODY_STYLE_NAME);
    body.setWidth100();
    body.setHeight100();

    // initialise the form
    uploadForm = new DynamicForm();
    uploadForm.setWidth100();
    uploadForm.setMargin(FORM_MARGIN);
    uploadForm.setNumCols(NUMBER_OF_COLUMNS);
    uploadForm.setCellPadding(CELL_PADDING);
    // uploadForm.setAutoFocus(false);
    uploadForm.setWrapItemTitles(false);
    // no ":" after the field name
    uploadForm.setTitleSuffix(BLANK_SPACE);
    uploadForm.setRequiredTitleSuffix(BLANK_SPACE);

    // initialise the hidden frame
    NamedFrame frame = new NamedFrame(TARGET);
    frame.setWidth("1px");
    frame.setHeight("1px");
    frame.setVisible(false);

    uploadForm.setEncoding(Encoding.MULTIPART);
    uploadForm.setMethod(FormMethod.POST);
    // set the (hidden) form target
    uploadForm.setTarget(TARGET);
    uploadForm.setAction(SmartGwtEntryPoint.getRelativeURL(DEFAULT_FILE_UPLOAD_SERVICE_PATH));

    // initialise the Record type field
    recordType = new ComboBoxItem(RECORD_TYPE, I18nUtil.getConstant().recordTypeLabel());
    recordType.setName(RECORD_TYPE);
    recordType.setType("comboBox");
    // recordType.setValueMap("Account", "Contact");   // TO DO
    recordType.setValueMap(I18nUtil.getConstant().accountLabel());
    recordType.setDefaultToFirstOption(true);
    recordType.setSelectOnFocus(true);

    // initialise the Map field
    mapName = new ComboBoxItem(MAP_NAME, I18nUtil.getConstant().dataMapLabel());
    mapName.setName(MAP_NAME);
    mapName.setType("comboBox");
    // mapName.setValueMap("Automatic", "Create new map");  // TO DO
    mapName.setValueMap(I18nUtil.getConstant().automaticLabel());
    mapName.setDefaultToFirstOption(true);

    // initialise the File name field
    uploadItem = new UploadItem(FILE_NAME);
    uploadItem.setName(FILE_NAME);
    uploadItem.setTitle(I18nUtil.getConstant().fileNameLabel());
    uploadItem.setWidth(280);

    // set the fields into the form
    uploadForm.setFields(recordType, mapName, uploadItem);

    // add the Upload Form and the (hidden) Frame to the main layout container
    body.addMember(uploadForm);
    body.addMember(frame);

    return body;
  }

  private VLayout initFooter() {

    // initialise the Footer layout container
    VLayout footer = new VLayout();
    footer.setStyleName(WIZARD_FOOTER_STYLE_NAME);
    footer.setWidth100();
    footer.setHeight(FOOTER_HEIGHT);

    HLayout hLayout = new HLayout();
    hLayout.setWidth100();
    hLayout.setHeight(FOOTER_HEIGHT);

    // initialise the OK button
    IButton okButton = new IButton(I18nUtil.getConstant().ok());
    // stretchButton.setWidth(150);
    okButton.setShowRollOver(true);
    okButton.setShowDisabled(true);
    okButton.setShowDown(true);
    // stretchButton.setTitleStyle("stretchTitle");
    // stretchButton.setIcon("silk/printer.png");
    okButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            Object obj = uploadItem.getDisplayValue();

            if (obj != null) {
                Log.debug("uploadItem.getDisplayValue(): " + obj.toString());

              // uploadForm.submitForm();
              if (getUiHandlers() != null) {
                getUiHandlers().onOkButtonClicked();
              }
            } else {
              SC.say(I18nUtil.getConstant().selectAFilePrompt());
          }
      }
    });

    // initialise the Cancel button
    IButton cancelButton = new IButton(I18nUtil.getConstant().cancel());
    cancelButton.setShowRollOver(true);
    cancelButton.setShowDisabled(true);
    cancelButton.setShowDown(true);
    cancelButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
      if (getUiHandlers() != null) {
        getUiHandlers().onCancelButtonClicked();
      }
    }});

    // layout the OK and Cancel buttons
    hLayout.setLayoutMargin(LAYOUT_MARGIN);
    hLayout.addMember(new LayoutSpacer());
    hLayout.addMember(okButton);
    LayoutSpacer padding = new LayoutSpacer();
    padding.setWidth(LAYOUT_PADDING);
    hLayout.addMember(padding);
    hLayout.addMember(cancelButton);

    // add the nested layout container to the main layout container
    footer.addMember(hLayout);

    return footer;
  }

  public void submitForm() {
    uploadForm.submitForm();
  }
}
