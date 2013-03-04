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

public class ContactsDto extends EntityDto {

  private static final long serialVersionUID = 1L;

  private String fullName;
  private String parentCustomer;
  private String city;
  private String location;
  private String phone;
  private String businessPhone;
  private String email;

  public ContactsDto() {
    super();
  }

  public ContactsDto(String id) {
    super(id);
  }

  // http://en.wikipedia.org/wiki/Covariant_return_type
  @Override
  public ContactsDto setId(String id) {
    this.id = id;
    return this;
  }

  public ContactsDto(String id, String fullName, String parentCustomer, String city,
      String location, String phone, String businessPhone, String email) {

    this.id = id;
    this.fullName = fullName;
    this.parentCustomer = parentCustomer;
    this.city = city;
    this.location = location;
    this.phone = phone;
    this.businessPhone = businessPhone;
    this.email = email;
  }

  public String getFullName() {
    return fullName;
  }

  public ContactsDto setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public String getParentCustomer() {
    return parentCustomer;
  }

  public ContactsDto setParentCustomer(String parentCustomer) {
    this.parentCustomer = parentCustomer;
    return this;
  }

  public String getCity() {
    return city;
  }

  public ContactsDto setCity(String city) {
    this.city = city;
    return this;
  }

  public String getLocation() {
    return location;
  }

  public ContactsDto setLocation(String location) {
    this.location = location;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public ContactsDto setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getBusinessPhone() {
    return businessPhone;
  }

  public ContactsDto setBusinessPhone(String businessPhone) {
    this.businessPhone = businessPhone;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ContactsDto setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getId() {
    return id;
  }
}