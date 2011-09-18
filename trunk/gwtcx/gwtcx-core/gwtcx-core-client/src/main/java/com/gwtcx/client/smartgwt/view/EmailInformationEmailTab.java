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

package com.gwtcx.client.smartgwt.view;

import com.gwtcx.client.smartgwt.widgets.EntityTab;
import com.gwtcx.client.smartgwt.widgets.TinyMceEditorItem;
import com.gwtcx.client.util.I18nUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.RowSpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;

public class EmailInformationEmailTab extends EntityTab {

  public static final String FROM = "from";
  public static final String TO = "to";
  public static final String SUBJECT = "subject";
  public static final String REGARDING = "regarding";
  public static final String OWNER = "owner";
  public static final String DURATION = "duration";
  public static final String DUE_DATE = "dueDate";
  public static final String CATEGORY = "category";
  public static final String CC = "cc";
  public static final String BCC = "bcc";
  public static final String PRIORITY = "priority";
  public static final String SUB_CATEGORY = "subCategory";

  // protected Long emailId;
  protected TextItem from;
  protected TextItem to;
  protected TextItem subject;
  protected TinyMceEditorItem editorItem;
  protected TextItem regarding;
  protected TextItem owner;
  protected ComboBoxItem duration;
  protected DateItem dueDate;
  protected TextItem category;
  protected TextItem cc;
  protected TextItem bcc;
  protected ComboBoxItem priority;
  protected TextItem subCategory;

  public EmailInformationEmailTab() {
    super(I18nUtil.getConstant().emailTab());

    //
    // Section 1 Column 1
    //
    PickerIcon searchFrom = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("From clicked!");
      }
    });
    from = new TextItem(FROM, I18nUtil.getConstant().fromLabel());
    from.setIcons(searchFrom);
    from.setRequired(true);
    from.setSelectOnFocus(true);
    from.setWidth(DEFAULT_FIELD_WIDTH);
    from.setValue("sales@uptick.com.au");

    PickerIcon searchTo = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("To clicked!");
      }
    });
    to = new TextItem(TO, I18nUtil.getConstant().toLabel());
    to.setIcons(searchTo);
    to.setRequired(true);
    to.setWidth(DEFAULT_FIELD_WIDTH);
    to.setValue("support@uptick.com.au");

    subject = new TextItem(SUBJECT, I18nUtil.getConstant().subjectLabel());
    subject.setColSpan(4);
    subject.setWidth(DEFAULT_FIELD_WIDTH);
    subject.setValue("New Email");

    editorItem = new TinyMceEditorItem("editorItem");
    editorItem.setColSpan(4);
    editorItem.setWidth("100%");
    editorItem.setHeight(126);  // TextItem Height 16 + Cell Psdding 2 * 7 = 126
    editorItem.setShowTitle(false);
    // editorItem.setValue(html);

    PickerIcon searchRegarding = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("Regarding clicked!");
      }
    });
    regarding = new TextItem(REGARDING, I18nUtil.getConstant().regardingLabel());
    regarding.setColSpan(4);
    regarding.setIcons(searchRegarding);
    regarding.setWidth(DEFAULT_FIELD_WIDTH);
    // regarding.setValue("New Email");

    PickerIcon searchOwner = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("Owner clicked!");
      }
    });
    owner = new TextItem(OWNER, I18nUtil.getConstant().ownerLabel());
    owner.setColSpan(4);
    owner.setIcons(searchOwner);
    owner.setWidth(DEFAULT_FIELD_WIDTH);
    owner.setValue("sales@uptick.com.au");

    duration = new ComboBoxItem(DURATION, I18nUtil.getConstant().durationLabel());
    duration.setType("comboBox");
    duration.setValueMap("30 minutes", "60 minutes");
    duration.setDefaultToFirstOption(true);
    duration.setWidth(DEFAULT_FIELD_WIDTH);

    dueDate = new DateItem(DUE_DATE, I18nUtil.getConstant().dueDateLabel());
    // dueDate.setTitle("");
    dueDate.setUseTextField(true);
    // dueDate.setHint("<nobr>Direct date input</nobr>");

    category = new TextItem(CATEGORY, I18nUtil.getConstant().categoryLabel());
    category.setWidth(DEFAULT_FIELD_WIDTH);
    // category.setValue("");


    //
    // Section 1 Column 2
    //
    PickerIcon searchCc = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("Cc clicked!");
      }
    });
    cc = new TextItem(CC, I18nUtil.getConstant().ccLabel());
    cc.setIcons(searchCc);
    cc.setWidth(DEFAULT_FIELD_WIDTH);

    PickerIcon searchBcc = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
        public void onFormItemClick(FormItemIconClickEvent event) {
      SC.say("Bcc clicked!");
      }
    });
    bcc = new TextItem(BCC, I18nUtil.getConstant().bccLabel());
    bcc.setIcons(searchBcc);
    bcc.setWidth(DEFAULT_FIELD_WIDTH);

    priority = new ComboBoxItem(PRIORITY, I18nUtil.getConstant().priorityLabel());
    priority.setType("comboBox");
    priority.setValueMap("Normal", "High");
    priority.setDefaultToFirstOption(true);
    priority.setWidth(DEFAULT_FIELD_WIDTH);

    subCategory = new TextItem(SUB_CATEGORY, I18nUtil.getConstant().subCategoryLabel());
    subCategory.setWidth(DEFAULT_FIELD_WIDTH);
    // subCategory.setValue("");


    RowSpacerItem rowSpacer1 = new RowSpacerItem("rowSpacer1");
    // just want to skip a column, so don't start a new row
    rowSpacer1.setStartRow(false);

    getForm().setFields(from, cc, to, bcc, subject, editorItem, regarding, owner, duration,
        priority, dueDate, rowSpacer1, category, subCategory);
    getForm().setTitleAlign(Alignment.LEFT);

    // getForm().setWidth100();
    // getForm().setHeight100();

    this.setPane(getForm());
  }

  @Override
  public void setFields(Object dto) {

  }

  @Override
  public void getFields(Object dto) {

  }
}

/*


  private static String html = "<strong>Welcome to the TinyMCE editor demo!</strong>"
        + "<p>Feel free to try out the different features that are provided, please note that the "
        + "MCImageManager and MCFileManager specific functionality is part of our commercial offering."
        + "The demo is to show the integration.</p>"
        + "<p>We really recommend <a href=\"http://www.getfirefox.com\" target=\"_blank\">Firefox</a> "
        + "as the primary browser for the best editing experience, but of course, TinyMCE is compatible"
        + "with all major browsers.</p>"
        + "Got questions or need help?"
        + "<p>If you have questions or need help, feel free to visit our community forum. We also offer "
        + "Enterprise support solutions. Also do not miss out on the documentation, its a great resource "
        + "for understanding how TinyMCE works and integrates.</p>";




    CkEditorItem editor = new CkEditorItem("editor");
    editor.setColSpan(4);
    editor.setWidth(DEFAULT_FIELD_WIDTH);
    editor.setHeight(DEFAULT_FIELD_WIDTH);
    editor.setShowTitle(false);
    // editor.setValue("Hello, World");

    getForm().setFields(from, cc, to, bcc, subject, editor);
    getForm().setTitleAlign(Alignment.LEFT);






    // initialise the nested layout container
    // VLayout vLayout = new VLayout();
    // vLayout.addMember(getForm());
    // vLayout.addMember(editor);
    // this.setPane(vLayout);




    Canvas canvas = new Canvas("canvasTinyMce");
    canvas.addChild(new TinyMCE());
    canvas.setSize("98%", "74%");

    // initialise the nested layout container
    VLayout vLayout = new VLayout();
    vLayout.addMember(getForm());
    vLayout.addMember(canvas);



  // protected TextAreaItem editor;

    editor = new TextAreaItem();
    editor.setTitle("");
    editor.setColSpan(4);
    editor.setWidth(DEFAULT_FIELD_WIDTH);
    editor.setHeight(200);

*/

