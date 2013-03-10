/**
 * (C) Copyright 2010-2013 Kiahu
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

package com.gwtcx.extgwt.client.desktop.view.contact.tab.section;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.extgwt.client.field.LookupField;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;

import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;

public class NameAndElectronicAddressSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  private String[][] textFieldTemplate = {
    {I18nUtil.getConstant().salutationLabel(), ".salutation", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, "Rob"},
    {I18nUtil.getConstant().givenNameLabel(), ".givenName", RegExTokens.ALPHANUMERIC_1_16, RegExTokens.FALSE, "Robert"},
    {I18nUtil.getConstant().middleNameLabel(), ".middleName", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, "James"},
    {I18nUtil.getConstant().familyNameLabel(), ".familyName", RegExTokens.ALPHANUMERIC_1_32, RegExTokens.FALSE, "Ferguson"},
    // {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu  Pty Limited"},

    {I18nUtil.getConstant().businessPhoneLabel(), ".businessPhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().homePhoneLabel(), ".homePhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().mobilePhoneLabel(), ".mobilePhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().faxLabel(), ".fax", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().emailLabel(), ".email", RegExTokens.EMAIL, RegExTokens.TRUE, ""}
  };

  LookupField parentCustomer;

  public NameAndElectronicAddressSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("NameAndElectronicAddressSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();

    createLookupFields();
  }

  public void createLookupFields() {

    LookupField parentCustomer = new LookupField();
    parentCustomer.addTriggerClickHandler(new TriggerClickHandler() {
      @Override
      public void onTriggerClick(final TriggerClickEvent event) {

        Info.display("LookupField", "You clicked the lookup button.");
      }
    });

    getPanel().add(new FieldLabel(parentCustomer, I18nUtil.getConstant().parentCustomerLabel()), new HtmlData(".parentCustomer"));
  }

  @Override
  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    String field, fieldname, value = null;

    try {

      for (int row = 0; row < getNumberOfTextFieldRows(); row++) {

        field = getTextFieldTemplate()[row][HTML_DATA];
        fieldname = field.substring(1);  // remove the "." prefix
        value = dto.getFieldValue(fieldname);

        Log.debug("field: " + field + " fieldname: " + fieldname + " value: " + value);

        getTextFields()[row].setValue(value);
        getTextFields()[row].setEmptyText("");
      }
    } catch (Exception e) {
      Log.error("Unable to set fields: " + e);
    }
  }

  @Override
  public void getFields(ContactRepresentation dto) {

    Log.debug("getFields()");

  }
}

/*


  public static final int DEFAULT_MAX_RESULTS = 50;

  public static final String ID = "id";
  public static final String ACTIVITY = "activity";
  public static final String NEW = "new";
  public static final String EDIT = "edit";
  public static final String PARAMETER_SEPERATOR = "&";
  public static final String NAME = "_blank";
  public static final String FEATURES = "width=880, height=540, location=no";

  public static void openHostFile(String filename, String queryString, String id, String features) {

    StringBuilder url = new StringBuilder();
    url.append(filename).append("?");

    String arg0Name = URL.encodeQueryString(ID);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(id);
    url.append(GwtCxEntryPoint.encodeBase64(arg0Value));
    Log.debug("Window.open() arg0Value: " + arg0Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg0Value));
    url.append(PARAMETER_SEPERATOR);

    String arg1Name = URL.encodeQueryString(ACTIVITY);
    url.append(arg1Name);
    url.append("=");
    String arg1Value = URL.encodeQueryString(queryString);
    url.append(GwtCxEntryPoint.encodeBase64(arg1Value));
    Log.debug("Window.open() arg1Value: " + arg1Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg1Value));

    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, features);
  }



    // String field = null;
    // String fieldname = null;
    // String value = null;

  // String toReturn = "";
  // SafeHtml sfHtml = SimpleHtmlSanitizer.sanitizeHtml(toReturn);
  // toReturn = sfHtml.asString();

  @Override
  public void getFields(Object accountDto) {

    ((AccountDto) accountDto).setAccountName(accountName.getValueAsString());
    ((AccountDto) accountDto).setAccountNumber(accountNumber.getValueAsString());
    // parentAccount;
    // primaryContact;
    // relationshipType;

    // Address Information
    List<AddressDto> addresseDtos = new ArrayList<AddressDto>();
    AddressDto addressDto = new AddressDto();

    addressDto.setAddressName(addressName.getValueAsString());
    addressDto.setAddressLine1(addressLine1.getValueAsString());
    addressDto.setAddressLine2(addressLine2.getValueAsString());
    addressDto.setAddressLine3(addressLine3.getValueAsString());
    addressDto.setCity(city.getValueAsString());
    addressDto.setState(state.getValueAsString());
    addressDto.setPostalCode(postalCode.getValueAsString());
    addressDto.setCountry(country.getValueAsString());
    addressDto.setAddressType(addressType.getValueAsString());

    addresseDtos.add(addressDto);
    ((AccountDto) accountDto).setAddresses(addresseDtos);

    // return accountDto;
  }


  // protected TextField salutation;      // Rob
  // protected TextField givenName;       // Robert
  // protected TextField middleName;      // James
  // protected TextField familyName;      // Ferguson
  // protected TextField fullName;        // summary element e.g. Rob Ferguson
  // protected TextField correspondence;  // Mr R J Ferguson
  // protected TextField jobTitle;        // Senior Consultant
  // protected TextField occupation;      // Software Engineer
  // protected TextField parentCustomer;  // Kiahu
  // protected TextField currency;        // AUD

  // protected TextField businessPhone;
  // protected TextField homePhone;
  // protected TextField mobilePhone;
  // protected TextField fax;
  // protected TextField pager;
  // protected TextField email;


*/