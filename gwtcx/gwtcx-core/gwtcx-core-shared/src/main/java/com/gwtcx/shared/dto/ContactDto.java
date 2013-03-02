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

  protected String addressName;     // Stamford Residences
  protected String addressLine1;    // 33A 171 Gloucester Street
  protected String addressLine2;
  protected String addressLine3;
  protected String city;            // Sydney
  protected String state;           // NSW
  protected String postalCode;      // 2000
  protected String country;         // Australia
  protected String location;        // 33A 171 Gloucester Street Sydney NSW
  protected String addressType;     // Home

  protected String businessPhone;   // +61 2 9241 4858
  protected String homePhone;       //
  protected String mobilePhone;     //
  protected String fax;             //
  protected String pager;           //
  protected String email;           //

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

  public String getAddressName() {
    return addressName;
  }

  public ContactDto setAddressName(String addressName) {
    this.addressName = addressName;
    return this;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public ContactDto setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public ContactDto setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public String getAddressLine3() {
    return addressLine3;
  }

  public ContactDto setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  public String getCity() {
    return city;
  }

  public ContactDto setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public ContactDto setState(String state) {
    this.state = state;
    return this;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public ContactDto setPostalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public ContactDto setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getLocation() {
    return location;
  }

  public ContactDto setLocation(String location) {
    this.location = location;
    return this;
  }

  public String getAddressType() {
    return addressType;
  }

  public ContactDto setAddressType(String addressType) {
    this.addressType = addressType;
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
}
