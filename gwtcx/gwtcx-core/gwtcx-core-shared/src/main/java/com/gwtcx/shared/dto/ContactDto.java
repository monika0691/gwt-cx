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

// http://stackoverflow.com/questions/12294627/generate-setters-that-return-self-in-eclipse
// http://www.marchwicki.pl/blog/2010/11/building-a-pojo-in-an-elegant-way/
// TODO: http://stackoverflow.com/questions/4342601/building-an-object/)
// http://my.safaribooksonline.com/book/programming/java/9780137150021/creating-and-destroying-objects/ch02lev1sec2

// See: http://en.wikipedia.org/wiki/Method_chaining

package com.gwtcx.shared.dto;

import java.util.List;

public class ContactDto extends EntityDto {

  private static final long serialVersionUID = 1L;

  enum Field
  {
     SALUTATION("salutation"), GIVEN_NAME("givenName"), MIDDLE_NAME("middleName"),
     FAMILY_NAME("familyName"), FULL_NAME("fullName"), CORRESPONDENCE("correspondence"),
     JOB_TITLE("jobTitle"), OCCUPATION("occupation"), PARENT_CUSTOMER("parentCustomer"), CURRENCY("currency"),
     BUSINESS_PHONE("businessPhone"), HOME_PHOME("homePhone"), MOBILE_PHONE("mobilePhone"), FAX("fax"), PAGER("pager"), EMAIL("email"),
     NOT_USED("notUsed");

     private Field(String stringValue) { this.stringValue = stringValue; }
     public String toString() { return stringValue; }

     private String stringValue;

     // It's important to have the constants at the top, and the methods/attributes at the bottom.
  }

  protected String salutation;      // Rob
  protected String givenName;       // Robert
  protected String middleName;      // James
  protected String familyName;      // Ferguson
  protected String fullName;        // summary element e.g. Rob Ferguson
  protected String correspondence;  // Mr R J Ferguson
  protected String jobTitle;        // Senior Consultant
  protected String occupation;      // Software Engineer
  protected String parentCustomer;  // Kiahu
  protected String currency;        // AUD

  protected String businessPhone;   // +61 2 9241 4858
  protected String homePhone;       //
  protected String mobilePhone;     //
  protected String fax;             //
  protected String pager;           //
  protected String email;           //

  protected String department;
  protected String manager;
  protected String managerPhone;
  protected String role;
  protected String assistent;
  protected String assistentPhone;

  protected String gender;
  protected String maritalStatus;
  protected String partnerName;
  protected String birthday;
  protected String anniversary;

  // Address details
  private List<AddressDto> addresses;

  public ContactDto() {
    super();
  }

  public ContactDto(String id) {
    super(id);
  }

  // http://en.wikipedia.org/wiki/Covariant_return_type
  @Override
  public ContactDto setId(String id) {
    this.id = id;
    return this;
  }

  public Field getFieldAsEnum(String fieldName) {

    Field result = Field.NOT_USED;

    for (Field field : Field.values()) {
      if (fieldName.contentEquals(field.toString())) {
        result = field;
      }
    }

    return result;
  }

  public String getFieldValue(String fieldName) {

    String result = null;
    Field field = getFieldAsEnum(fieldName);

    switch (field) {

      // name

      case SALUTATION: result = getSalutation(); break;

      case GIVEN_NAME: result = getGivenName(); break;

      case MIDDLE_NAME: result = getMiddleName(); break;

      case FAMILY_NAME: result = getFamilyName(); break;

      case FULL_NAME: result = getFullName(); break;

      case CORRESPONDENCE: result = getCorrespondence(); break;

      case JOB_TITLE: result = getJobTitle(); break;

      case OCCUPATION: result = getOccupation(); break;

      case PARENT_CUSTOMER: result = getParentCustomer(); break;

      case CURRENCY: result = getCurrency(); break;

      // electronic address

      case BUSINESS_PHONE: result = getBusinessPhone(); break;

      case HOME_PHOME: result = getHomePhone(); break;

      case MOBILE_PHONE: result = getMobilePhone(); break;

      case FAX: result = getFax(); break;

      case EMAIL: result = getEmail(); break;

      default:
        result = "Unknown field";
        break;
    }

    return result;
  }

  public void setFieldValue(String fieldName, String value) {

    Field field = getFieldAsEnum(fieldName);

    switch (field) {

      // name

      case SALUTATION: setSalutation(value); break;

      case GIVEN_NAME: setGivenName(value); break;

      case MIDDLE_NAME: setMiddleName(value); break;

      case FAMILY_NAME: setFamilyName(value); break;

      case FULL_NAME: setFullName(value); break;

      case CORRESPONDENCE: setCorrespondence(value); break;

      case JOB_TITLE: setJobTitle(value); break;

      case OCCUPATION: setOccupation(value); break;

      case PARENT_CUSTOMER: setParentCustomer(value); break;

      case CURRENCY: setCurrency(value); break;

      // electronic address

      case BUSINESS_PHONE: setBusinessPhone(value); break;

      case HOME_PHOME: setHomePhone(value); break;

      case MOBILE_PHONE: setMobilePhone(value); break;

      case FAX: setFax(value); break;

      case EMAIL: setEmail(value); break;

      default:
        break;
    }
  }

  public String getSalutation() {
    return salutation;
  }

  public ContactDto setSalutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  public String getGivenName() {
    return givenName;
  }

  public ContactDto setGivenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  public String getMiddleName() {
    return middleName;
  }

  public ContactDto setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public String getFamilyName() {
    return familyName;
  }

  public ContactDto setFamilyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  public String getFullName() {
    return fullName;
  }

  public ContactDto setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public String getCorrespondence() {
    return correspondence;
  }

  public ContactDto setCorrespondence(String correspondence) {
    this.correspondence = correspondence;
    return this;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public ContactDto setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  public String getOccupation() {
    return occupation;
  }

  public ContactDto setOccupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  public String getParentCustomer() {
    return parentCustomer;
  }

  public ContactDto setParentCustomer(String parentCustomer) {
    this.parentCustomer = parentCustomer;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public ContactDto setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public String getBusinessPhone() {
    return businessPhone;
  }

  public ContactDto setBusinessPhone(String businessPhone) {
    this.businessPhone = businessPhone;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactDto setHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public ContactDto setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getFax() {
    return fax;
  }

  public ContactDto setFax(String fax) {
    this.fax = fax;
    return this;
  }

  public String getPager() {
    return pager;
  }

  public ContactDto setPager(String pager) {
    this.pager = pager;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ContactDto setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getDepartment() {
    return department;
  }

  public ContactDto setDepartment(String department) {
    this.department = department;
    return this;
  }

  public String getManager() {
    return manager;
  }

  public ContactDto setManager(String manager) {
    this.manager = manager;
    return this;
  }

  public String getManagerPhone() {
    return managerPhone;
  }

  public ContactDto setManagerPhone(String managerPhone) {
    this.managerPhone = managerPhone;
    return this;
  }

  public String getRole() {
    return role;
  }

  public ContactDto setRole(String role) {
    this.role = role;
    return this;
  }

  public String getAssistent() {
    return assistent;
  }

  public ContactDto setAssistent(String assistent) {
    this.assistent = assistent;
    return this;
  }

  public String getAssistentPhone() {
    return assistentPhone;
  }

  public ContactDto setAssistentPhone(String assistentPhone) {
    this.assistentPhone = assistentPhone;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public ContactDto setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public ContactDto setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  public String getPartnerName() {
    return partnerName;
  }

  public ContactDto setPartnerName(String partnerName) {
    this.partnerName = partnerName;
    return this;
  }

  public String getBirthday() {
    return birthday;
  }

  public ContactDto setBirthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  public String getAnniversary() {
    return anniversary;
  }

  public ContactDto setAnniversary(String anniversary) {
    this.anniversary = anniversary;
    return this;
  }

  public List<AddressDto> getAddresses() {
    return addresses;
  }

  public ContactDto setAddresses(List<AddressDto> addresses) {
    this.addresses = addresses;
    return this;
  }
}
