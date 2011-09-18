package com.gwtcx.client.smartgwt.view;

import com.gwtcx.client.smartgwt.widgets.EntityTab;
import com.gwtcx.client.util.I18nUtil;
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