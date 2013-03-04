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

package com.gwtcx.shared.dto;

public class AddressDto extends EntityDto {

  private static final long serialVersionUID = 1L;

  enum Field
  {
     ADDRESS_NAME("addressName"),
     ADDRESS_LINE_1("addressLine1"), ADDRESS_LINE_2("addressLine2"), ADDRESS_LINE_3("addressLine3"),
     CITY("city"), STATE("state"), POSTAL_CODE("postalCode"),
     COUNTRY("country"), LOCATION("location"), ADDRESS_TYPE("addressType"),
     NOT_USED("notUsed");

     private Field(String stringValue) { this.stringValue = stringValue; }
     public String toString() { return stringValue; }

     private String stringValue;

     // It's important to have the constants at the top, and the methods/attributes at the bottom.
  }

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

  public AddressDto() {
    super();
  }

  public AddressDto(String id) {
    super(id);
  }

  public String getAddressName() {
    return addressName;
  }

  public AddressDto setAddressName(String addressName) {
    this.addressName = addressName;
    return this;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public AddressDto setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public AddressDto setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public String getAddressLine3() {
    return addressLine3;
  }

  public AddressDto setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  public String getCity() {
    return city;
  }

  public AddressDto setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public AddressDto setState(String state) {
    this.state = state;
    return this;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public AddressDto setPostalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public AddressDto setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getLocation() {
    return location;
  }

  public AddressDto setLocation(String location) {
    this.location = location;
    return this;
  }

  public String getAddressType() {
    return addressType;
  }

  public AddressDto setAddressType(String addressType) {
    this.addressType = addressType;
    return this;
  }
}

/*

  public AddressDto(String id, String addressName,
      String addressLine1, String addressLine2, String addressLine3,
    String city, String state, String postalCode,
    String country, String location, String addressType) {
    this.id = id;
    this.addressName = addressName;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.addressLine3 = addressLine3;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.location = location;
    this.addressType = addressType;
  }


*/