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

package com.gwtcx.shared.dto;

import java.io.Serializable;

public class ContactsDto  implements Serializable {

  private static final long serialVersionUID = -239301601506762909L;

  private String id;
  private String fullName;
  private String parentCustomer;
  private String city;
  private String location;
  private String phone;
  private String businessPhone;
  private String email;

  public ContactsDto() {
    this.id = "-1";
  }

  public ContactsDto(String id) {
    this.id = id;
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getParentCustomer() {
    return parentCustomer;
  }

  public void setParentCustomer(String parentCustomer) {
    this.parentCustomer = parentCustomer;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getBusinessPhone() {
    return businessPhone;
  }

  public void setBusinessPhone(String businessPhone) {
    this.businessPhone = businessPhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ContactsDto [id=");
    builder.append(id);
    builder.append(", fullName=");
    builder.append(fullName);
    builder.append(", parentCustomer=");
    builder.append(parentCustomer);
    builder.append(", city=");
    builder.append(city);
    builder.append(", location=");
    builder.append(location);
    builder.append(", phone=");
    builder.append(phone);
    builder.append(", businessPhone=");
    builder.append(businessPhone);
    builder.append(", email=");
    builder.append(email);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    ContactsDto other = (ContactsDto) obj;
    if (businessPhone == null) {
        if (other.businessPhone != null)
            return false;
    } else if (!businessPhone.equals(other.businessPhone))
        return false;
    if (city == null) {
        if (other.city != null)
            return false;
    } else if (!city.equals(other.city))
        return false;
    if (email == null) {
        if (other.email != null)
            return false;
    } else if (!email.equals(other.email))
        return false;
    if (fullName == null) {
        if (other.fullName != null)
            return false;
    } else if (!fullName.equals(other.fullName))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    if (location == null) {
        if (other.location != null)
            return false;
    } else if (!location.equals(other.location))
        return false;
    if (parentCustomer == null) {
        if (other.parentCustomer != null)
            return false;
    } else if (!parentCustomer.equals(other.parentCustomer))
        return false;
    if (phone == null) {
        if (other.phone != null)
            return false;
    } else if (!phone.equals(other.phone))
        return false;
    return true;
  }
}
