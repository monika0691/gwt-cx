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

package com.kiahu.sample.server.restlet;

import org.restlet.ext.wadl.WadlServerResource;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.kiahu.sample.shared.restlet.ContactResource;

public class ContactServerResource extends WadlServerResource implements
    ContactResource {

  private String id;

  @Override
  protected void doInit() throws ResourceException {
    this.id = getAttribute("id");
  }

  @Get
  public ContactRepresentation retreive() {

    ContactRepresentation result = null;

    try {
      ContactRepresentation contact = new ContactRepresentation(id).
          setSalutation("Frank").
          setGivenName("Frank").
          setMiddleName("").
          setFamilyName("Wolf").
          setFullName("Frank Wolf").
          setCorrespondence("Dr Frank Wolf").
          setJobTitle("CEO").
          setOccupation("Director").
          setParentCustomer("Abacus Property Group").
          setCurrency("AUD").
          setAddressName("Abacus House").
          setAddressLine1("Level 34, 264-278 George Street").setAddressLine2("").setAddressLine3("").
          setCity("Sydney").setPostalCode("2000").setCountry("Australia").
          setLocation("Level 34, 264-278 George Street Sydney NSW 2000").
          setAddressType("Mailing").
          setBusinessPhone("(02) 9253 8600").
          setHomePhone("(02) 9253 8600").
          setMobilePhone("0414 414 515").
          setFax("").
          setPager("").
          setEmail("enquiries@abacus.com.au");

      if (contact != null) {
        result = contact;
      }
    }
    catch  (Exception e) {
      Log.warn("Unable to retrieve Contact - ", e);
    }

    return result;
  }
}
