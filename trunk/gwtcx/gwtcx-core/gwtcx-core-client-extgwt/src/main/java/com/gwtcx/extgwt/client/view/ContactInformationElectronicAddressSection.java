package com.gwtcx.extgwt.client.view;

import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ContactInformationElectronicAddressSection {

  protected HtmlLayoutContainer panel;

  protected TextField businessPhone;
  protected TextField homePhone;
  protected TextField mobilePhone;
  protected TextField fax;
  // protected TextField pager;
  // protected TextField email;

  public ContactInformationElectronicAddressSection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    createFields();
  }

  public void createFields() {

    businessPhone = new TextField();
    panel.add(new FieldLabel(businessPhone, "Business Phone"), new HtmlData(".businessPhone"));

    homePhone = new TextField();
    panel.add(new FieldLabel(homePhone, "Home Phone"), new HtmlData(".homePhone"));

    mobilePhone = new TextField();
    panel.add(new FieldLabel(mobilePhone, "Mobile Phone"), new HtmlData(".mobilePhone"));

    fax = new TextField();
    panel.add(new FieldLabel(fax, "Fax"), new HtmlData(".fax"));

  }
}
