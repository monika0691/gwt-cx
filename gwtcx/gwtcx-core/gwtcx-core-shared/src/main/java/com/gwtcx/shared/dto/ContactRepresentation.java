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

public class ContactRepresentation extends ContactDto {

  private static final long serialVersionUID = 1L;

  public ContactRepresentation() {
    super();
  }

  public ContactRepresentation(String id) {
    super(id);
  }

  public ContactRepresentation setSalutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  public ContactRepresentation setGivenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  public ContactRepresentation setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactRepresentation setFamilyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  public ContactRepresentation setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public ContactRepresentation setCorrespondence(String correspondence) {
    this.correspondence = correspondence;
    return this;
  }

  public ContactRepresentation setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  public ContactRepresentation setOccupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  public ContactRepresentation setParentCustomer(String parentCustomer) {
    this.parentCustomer = parentCustomer;
    return this;
  }

  public ContactRepresentation setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public ContactRepresentation setBusinessPhone(String businessPhone) {
    this.businessPhone = businessPhone;
    return this;
  }

  public ContactRepresentation setHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactRepresentation setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactRepresentation setFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactRepresentation setPager(String pager) {
    this.pager = pager;
    return this;
  }

  public ContactRepresentation setEmail(String email) {
    this.email = email;
    return this;
  }
}
