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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountDto;
import com.gwtcx.shared.dto.AddressDto;
import com.gwtcx.smartgwt.client.widgets.EntityTab;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.RowSpacerItem;
import com.smartgwt.client.widgets.form.fields.SectionItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;

public class AccountInformationGeneralTab extends EntityTab {

  public static final String ACCOUNT_NAME = "accountName";
  public static final String ACCOUNT_NUMBER = "accountNumber";
  public static final String PARENT_ACCOUNT = "parentAccount";
  public static final String PRIMARY_CONTACT = "primaryContact";
  public static final String RELATIONSHIP_TYPE = "relationshipType";
  public static final String MAIN_PHONE = "mainPhone";
  public static final String OTHER_PHONE = "otherPhone";
  public static final String FAX = "fax";
  public static final String WEB_SITE = "webSite";
  public static final String EMAIL = "email";

  public static final String ADDRESS_NAME = "addressName";
  public static final String ADDRESS_LINE_1 = "addressLine1";
  public static final String ADDRESS_LINE_2 = "addressLine2";
  public static final String ADDRESS_LINE_3 = "addressLine3";
  public static final String CITY = "city";
  public static final String STATE = "state";
  public static final String POSTAL_CODE = "postalCode";
  public static final String COUNTRY = "country";
  public static final String ADDRESS_TYPE = "addressType";

  protected Long accountId;
  protected TextItem accountName;
  protected TextItem accountNumber;
  protected TextItem parentAccount;
  protected TextItem primaryContact;
  protected ComboBoxItem relationshipType;

  protected TextItem addressName;
  protected TextItem addressLine1;
  protected TextItem addressLine2;
  protected TextItem addressLine3;
  protected TextItem city;
  protected TextItem state;
  protected TextItem postalCode;
  // protected SelectItem country;
  protected ComboBoxItem country;
  protected ComboBoxItem addressType;

  protected TextItem mainPhone;
  protected TextItem otherPhone;
  protected TextItem fax;
  protected TextItem webSite;
  protected TextItem email;

  public AccountInformationGeneralTab() {
    super(I18nUtil.getConstant().generalTab());

    //
    // Section 1 Column 1
    //
    accountName = new TextItem(ACCOUNT_NAME, I18nUtil.getConstant().accountNameLabel());
    accountName.setSelectOnFocus(true);
    // accountName.setWrapTitle(false);
    // accountName.setDefaultValue("[Account Name]");
    accountName.setRequired(true);
    accountName.setWidth(DEFAULT_FIELD_WIDTH);

    accountNumber = new TextItem(ACCOUNT_NUMBER, I18nUtil.getConstant().accountNumberLabel());
    accountNumber.setWidth(DEFAULT_FIELD_WIDTH);

    PickerIcon searchParentAccount = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
      public void onFormItemClick(FormItemIconClickEvent event) {
        SC.say("Parent Account clicked!");
      }
    });
    parentAccount = new TextItem(PARENT_ACCOUNT, I18nUtil.getConstant().parentAccountLabel());
    parentAccount.setIcons(searchParentAccount);
    parentAccount.setWidth(DEFAULT_FIELD_WIDTH);

    PickerIcon searchPrimaryContact = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
      public void onFormItemClick(FormItemIconClickEvent event) {
        SC.say("Primary Contact clicked!");
      }
    });
    primaryContact = new TextItem(PRIMARY_CONTACT, I18nUtil.getConstant().primaryContactLabel());
    primaryContact.setIcons(searchPrimaryContact);
    primaryContact.setWidth(DEFAULT_FIELD_WIDTH);

    relationshipType = new ComboBoxItem(RELATIONSHIP_TYPE, I18nUtil.getConstant().relationshipTypeLabel());
    relationshipType.setType("comboBox");
    relationshipType.setValueMap("Active", "Inactive");
    relationshipType.setDefaultToFirstOption(true);
    relationshipType.setWidth(DEFAULT_FIELD_WIDTH);

    //
    // Section 1 Column 2
    //
    mainPhone = new TextItem(MAIN_PHONE, I18nUtil.getConstant().mainPhoneLabel());
    mainPhone.setWidth(DEFAULT_FIELD_WIDTH);

    otherPhone = new TextItem(OTHER_PHONE, I18nUtil.getConstant().otherPhoneLabel());
    otherPhone.setWidth(DEFAULT_FIELD_WIDTH);

    fax = new TextItem(FAX, I18nUtil.getConstant().faxLabel());
    fax.setWidth(DEFAULT_FIELD_WIDTH);

    webSite = new TextItem(WEB_SITE, I18nUtil.getConstant().webSiteLabel());
    webSite.setWidth(DEFAULT_FIELD_WIDTH);

    email = new TextItem(EMAIL, I18nUtil.getConstant().emailLabel());
    email.setWidth(DEFAULT_FIELD_WIDTH);

    SectionItem generalSection = new SectionItem();
    generalSection.setValue(I18nUtil.getConstant().generalInformationSectionItem());
    generalSection.setItemIds(ACCOUNT_NAME, MAIN_PHONE, ACCOUNT_NUMBER, OTHER_PHONE,
        PARENT_ACCOUNT, FAX, PRIMARY_CONTACT, WEB_SITE, RELATIONSHIP_TYPE, EMAIL);

    //
    // Section 2 Column 1
    //
    addressName = new TextItem(ADDRESS_NAME, I18nUtil.getConstant().accountNameLabel());
    addressName.setWidth(DEFAULT_FIELD_WIDTH);

    addressLine1 = new TextItem(ADDRESS_LINE_1, I18nUtil.getConstant().addressLine1Label());
    addressLine1.setWidth(DEFAULT_FIELD_WIDTH);

    addressLine2 = new TextItem(ADDRESS_LINE_2, I18nUtil.getConstant().addressLine2Label());
    addressLine2.setWidth(DEFAULT_FIELD_WIDTH);

    addressLine3 = new TextItem(ADDRESS_LINE_3, I18nUtil.getConstant().addressLine3Label());
    addressLine3.setWidth(DEFAULT_FIELD_WIDTH);

    city = new TextItem(CITY, I18nUtil.getConstant().cityLabel());
    city.setWidth(DEFAULT_FIELD_WIDTH);

    state = new TextItem(STATE, I18nUtil.getConstant().stateLabel());
    state.setWidth(DEFAULT_FIELD_WIDTH);


    //
    // Section 2 Column 2
    //
    postalCode = new TextItem(POSTAL_CODE, I18nUtil.getConstant().postalCodeLabel());
    postalCode.setWidth(DEFAULT_FIELD_WIDTH);

    /*

    // TO DO - find out why the flag icons arn't working ???
    country = new SelectItem();
    country.setName(COUNTRY);
    country.setTitle(Serendipity.getConstants().countryLabel());
    LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
    valueMap.put("au", "Australia");
    valueMap.put("nz", "New Zealand");
    country.setValueMap(valueMap);
    // country.setDefaultToFirstOption(true);
    country.setImageURLPrefix(URL_PREFIX);
    country.setImageURLSuffix(URL_SUFFFIX);
    country.setIconHeight(ICON_HEIGHT);

    */

    country = new ComboBoxItem(COUNTRY, I18nUtil.getConstant().countryLabel());
    country.setType("comboBox");
    country.setValueMap("Australia", "New Zealand");
    country.setWidth(DEFAULT_FIELD_WIDTH);

    addressType = new ComboBoxItem(ADDRESS_TYPE, I18nUtil.getConstant().addressTypeLabel());
    addressType.setType("comboBox");
    addressType.setValueMap("Home", "Business", "Mailing", "Priority", "Other");
    // addressType.setDefaultToFirstOption(true);
    addressType.setWidth(DEFAULT_FIELD_WIDTH);

    RowSpacerItem rowSpacer1 = new RowSpacerItem("rowSpacer1");
    // just want to skip a column, so don't start a new row
    rowSpacer1.setStartRow(false);

    RowSpacerItem rowSpacer2 = new RowSpacerItem("rowSpacer2");
    // just want to skip a column, so don't start a new row
    rowSpacer2.setStartRow(false);

    SectionItem addressSection = new SectionItem();
    addressSection.setValue(I18nUtil.getConstant().addressInformationSectionItem());
    addressSection.setItemIds(ADDRESS_NAME, POSTAL_CODE, ADDRESS_LINE_1, COUNTRY,
        ADDRESS_LINE_2, ADDRESS_TYPE, ADDRESS_LINE_3, "rowSpacer1", CITY, "rowSpacer2",
        STATE);

    getForm().setFields(generalSection, accountName, mainPhone, accountNumber,
        otherPhone, parentAccount, fax, primaryContact, webSite, relationshipType,
        email, addressSection, addressName, postalCode,
        addressLine1, country, addressLine2, addressType, addressLine3, rowSpacer1, city,
        rowSpacer2, state);
    getForm().setTitleAlign(Alignment.LEFT);

    this.setPane(form);
  }

  @Override
  public void setFields(Object accountDto) {

    accountName.setValue(((AccountDto) accountDto).getAccountName());
    accountNumber.setValue(((AccountDto) accountDto).getAccountNumber());

    int size = ((AccountDto) accountDto).getAddresses().size();

    if (size > 0) {
      // the first Address is displayed on the General Tab
      Iterator<AddressDto> it = ((AccountDto) accountDto).getAddresses().iterator();

      AddressDto addressDto = it.next();

      addressName.setValue(addressDto.getAddressName());
      addressLine1.setValue(addressDto.getAddressLine1());
      addressLine2.setValue(addressDto.getAddressLine2());
      addressLine3.setValue(addressDto.getAddressLine3());
      city.setValue(addressDto.getCity());
      state.setValue(addressDto.getState());
      postalCode.setValue(addressDto.getPostalCode());
      country.setValue(addressDto.getCountry());
      addressType.setValue(addressDto.getAddressType());
    }
  }

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
}
