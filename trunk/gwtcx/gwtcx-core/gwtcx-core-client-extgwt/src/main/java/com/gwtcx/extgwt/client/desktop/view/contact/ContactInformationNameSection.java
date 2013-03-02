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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;

public class ContactInformationNameSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  protected TextField salutation;      // Rob
  protected TextField givenName;       // Robert
  protected TextField middleName;      // James
  protected TextField familyName;      // Ferguson
  // protected TextField fullName;        // summary element e.g. Rob Ferguson
  // protected TextField correspondence;  // Mr R J Ferguson
  // protected TextField jobTitle;        // Senior Consultant
  // protected TextField occupation;      // Software Engineer
  protected TextField parentCustomer;  // Kiahu
  // protected TextField currency;        // AUD

  protected TextField businessPhone;
  protected TextField homePhone;
  protected TextField mobilePhone;
  protected TextField fax;
  // protected TextField pager;
  protected TextField email;

  private final static int FIELD_LABEL = 0;
  private final static int HTML_DATA = 1;
  private final static int REGEX = 2;
  private final static int ALLOW_BLANKS = 3;
  private final static int EMPTY_TEXT = 4;

  private String[][] fields = {
    {I18nUtil.getConstant().salutationLabel(), ".salutation", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, "Rob"},
    {I18nUtil.getConstant().givenNameLabel(), ".givenName", RegExTokens.ALPHANUMERIC_1_16, RegExTokens.FALSE, "Robert"},
    {I18nUtil.getConstant().middleNameLabel(), ".middleName", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, "James"},
    {I18nUtil.getConstant().familyNameLabel(), ".familyName", RegExTokens.ALPHANUMERIC_1_32, RegExTokens.FALSE, "Ferguson"},
    {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu Pty Limited"},

    {I18nUtil.getConstant().businessPhoneLabel(), ".businessPhone", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().homePhoneLabel(), ".homePhone", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().mobilePhoneLabel(), ".mobilePhone", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().faxLabel(), ".fax", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().emailLabel(), ".email", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""}
  };

  private int rows = fields.length;
  private TextField [] textFields = new TextField[rows];

  public ContactInformationNameSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("ContactInformationNameSection()");

    createFields();
  }

  @Override
  public void createFields() {

    Log.debug("createFields()");

    Log.debug("rows: " + rows);

    try {
      for (int row = 0; row < rows; row++) {

        Log.debug("FieldLabel: " + fields[row][FIELD_LABEL] + " HtmlData: " + fields[row][HTML_DATA]);

        textFields[row] = new TextField();
        getPanel().add(new FieldLabel(textFields[row], fields[row][FIELD_LABEL]), new HtmlData(fields[row][HTML_DATA]));
        textFields[row].addValidator(new RegExValidator(fields[row][REGEX], "Regular Expression: " + fields[row][REGEX]));

        if (fields[row][ALLOW_BLANKS].contentEquals(RegExTokens.TRUE)) {
          textFields[row].setAllowBlank(true);

          Log.debug("setAllowBlank(true)");
        } else {
          textFields[row].setAllowBlank(false);

          Log.debug("setAllowBlank(false)");
        }

        if (fields[row][EMPTY_TEXT].length() != 0) {
          textFields[row].setEmptyText(fields[row][EMPTY_TEXT]);
        }
      }
    } catch (Exception e) {
      Log.error("Unable to create fields: " + e);
    }
  }

  @Override
  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    String field = null;
    String fieldname = null;
    String value = null;

    try {

      for (int row = 0; row < rows; row++) {

        field = fields[row][HTML_DATA];
        fieldname = field.substring(1);  // remove the CSS class prefix "."
        value = dto.getFieldValue(fieldname);

        Log.debug("field: " + field);
        Log.debug("fieldname: " + fieldname);
        Log.debug("value: " + value);

        textFields[row].setValue(value);
        textFields[row].setEmptyText("");
      }
    } catch (Exception e) {
      Log.error("Unable to set fields: " + e);
    }
  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }
}

/*

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

*/