package com.gwtcx.extgwt.client.desktop.view.contact.section;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ProfessionalInformationSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  protected TextField department;
  protected TextField role;
  protected TextField manager;
  protected TextField managerPhone;
  protected TextField assistent;
  protected TextField assistentPhone;

  /*

  private String[][] fields = {
    {I18nUtil.getConstant().salutationLabel(), ".salutation", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, "Rob"},
    {I18nUtil.getConstant().givenNameLabel(), ".givenName", RegExTokens.ALPHANUMERIC_1_16, RegExTokens.FALSE, "Robert"},
    {I18nUtil.getConstant().middleNameLabel(), ".middleName", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, "James"},
    {I18nUtil.getConstant().familyNameLabel(), ".familyName", RegExTokens.ALPHANUMERIC_1_32, RegExTokens.FALSE, "Ferguson"},
    {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu Pty Limited"},

    {I18nUtil.getConstant().businessPhoneLabel(), ".businessPhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().homePhoneLabel(), ".homePhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().mobilePhoneLabel(), ".mobilePhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().faxLabel(), ".fax", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().emailLabel(), ".email", RegExTokens.EMAIL, RegExTokens.TRUE, ""}
  };

  private int rows = fields.length;
  private TextField [] textFields = new TextField[rows];

  */

  public ProfessionalInformationSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("ContactInformationNameSection()");

    createFields();
  }

}
