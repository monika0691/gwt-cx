package com.gwtcx.smartgwt.client.view;

import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.widgets.EntityTab;
import com.smartgwt.client.types.Alignment;

public class EmailInformationAttachmentsTab extends EntityTab {

  public EmailInformationAttachmentsTab() {
    super(I18nUtil.getConstant().attachmentsTab());

    //
    // Section 1 Column 1
    //


    //
    // Section 1 Column 2
    //


    // getForm().setFields();
    getForm().setTitleAlign(Alignment.LEFT);

    this.setPane(getForm());
  }

  @Override
  public void setFields(Object dto) {

  }

  @Override
  public void getFields(Object dto) {

  }
}