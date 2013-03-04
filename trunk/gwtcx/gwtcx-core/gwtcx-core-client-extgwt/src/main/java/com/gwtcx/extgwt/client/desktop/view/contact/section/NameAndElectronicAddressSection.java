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

package com.gwtcx.extgwt.client.desktop.view.contact.section;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;

public class NameAndElectronicAddressSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  private String[][] textFieldTemplate = {
    {I18nUtil.getConstant().salutationLabel(), ".salutation", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, "Rob"},
    {I18nUtil.getConstant().givenNameLabel(), ".givenName", RegExTokens.ALPHANUMERIC_1_16, RegExTokens.FALSE, "Robert"},
    {I18nUtil.getConstant().middleNameLabel(), ".middleName", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, "James"},
    {I18nUtil.getConstant().familyNameLabel(), ".familyName", RegExTokens.ALPHANUMERIC_1_32, RegExTokens.FALSE, "Ferguson"},
    {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu Pty Limited"},

    {I18nUtil.getConstant().businessPhoneLabel(), ".businessPhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().homePhoneLabel(), ".homePhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().mobilePhoneLabel(), ".mobilePhone", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().faxLabel(), ".fax", RegExTokens.AU_TELEPHONE_8_14, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().emailLabel(), ".email", RegExTokens.EMAIL, RegExTokens.TRUE, ""}
  };

  public NameAndElectronicAddressSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("NameAndElectronicAddressSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();
  }

  @Override
  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    String field, fieldname, value = null;

    try {

      for (int row = 0; row < getNumberOfRows(); row++) {

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