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

import java.util.ArrayList;
import java.util.List;

import org.restlet.ext.wadl.WadlServerResource;
import org.restlet.resource.Get;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtcx.shared.dto.ContactsDto;
import com.gwtcx.shared.dto.ContactsRepresentation;
import com.kiahu.sample.shared.restlet.ContactsResource;

public class ContactsServerResource extends WadlServerResource implements
    ContactsResource {

  @Get
  public ContactsRepresentation retreive() {

    ContactsRepresentation result = null;

    try {
      List<ContactsDto> contacts = retrieveContacts();

      if (contacts != null) {
        result = new ContactsRepresentation(contacts);
      }
    }
    catch  (Exception e) {
      Log.warn("Unable to retrieve Contacts - ", e);
    }

    return result;
  }

  public static List<ContactsDto> retrieveContacts() {

    List<ContactsDto> contacts = new ArrayList<ContactsDto>();

    contacts.add(new ContactsDto("1").
        setFullName("Dr Frank Wolf").
        setParentCustomer("Abacus Property Group").setCity("Sydney").
        setLocation("Level 34, 264-278 George Street Sydney NSW 2000").
        setPhone("0414 414 515").setBusinessPhone("(02) 9253 8600").
        setEmail("enquiries@abacus.com.au"));

    contacts.add(new ContactsDto("2").
        setFullName("Mr Mark Chellew").
        setParentCustomer("Adelaide Brighton Limited").setCity("Adelaide").
        setLocation("Level 1, 157 Grenfell Street Adelaide SA 5000").
        setPhone("0414 234 535").setBusinessPhone("(08) 8223 8000").
        setEmail("enquiries@adbri.com.au"));

    contacts.add(new ContactsDto("3").
        setFullName("Mr Michael Fraser").
        setParentCustomer("AGL Energy Limited").setCity("North Sydney").
        setLocation("Level 22, 101 Miller Street North Sydney NSW 2065").
        setPhone("0414 114 115").setBusinessPhone("(02) 9921 2999").
        setEmail("enquiries@agl.com.au"));

    contacts.add(new ContactsDto("4").
        setFullName("Mr Peter Boyd").
        setParentCustomer("Alesco Corporation Limited").setCity("Sydney").
        setLocation("Level 24, 207 Kent Street Sydney NSW 2000").
        setPhone("0414 233 332").setBusinessPhone("(02) 9248 2000").
        setEmail("enquiries@alesco.com.au"));

    contacts.add(new ContactsDto("5").
        setFullName("Mr John Bevan").
        setParentCustomer("Alumina Limited").setCity("Southbank").
        setLocation("Level 12, 60 City Road Southbank VIC 3006").
        setPhone("0414 456 345").setBusinessPhone("(03) 8699 2600").
        setEmail("enquiries@alumina.com.au"));

    return contacts;
  }
}

/*

public class ContactsServerResource extends WadlServerResource implements
    ContactsResource {

  @Get
  public ContactsRepresentation retreive() {

    ContactsRepresentation result = null;

    try {
      List<ContactRepresentation> contacts = retrieveContacts();

      if (contacts != null) {
        result = new ContactsRepresentation(contacts);
      }
    }
    catch  (Exception e) {
      Log.warn("Unable to retrieve Contacts - ", e);
    }

    return result;
  }

  public static List<ContactRepresentation> retrieveContacts() {

    List<ContactRepresentation> contacts = new ArrayList<ContactRepresentation>();

    contacts.add(new ContactRepresentation("1").
        setFullName("Dr Frank Wolf").
        setParentCustomer("Abacus Property Group").setCity("Sydney").
        setLocation("Level 34, 264-278 George Street Sydney NSW 2000").
        setMobilePhone("0414 414 515").setBusinessPhone("(02) 9253 8600").
        setEmail("enquiries@abacus.com.au"));

    contacts.add(new ContactRepresentation("2").
        setFullName("Mr Mark Chellew").
        setParentCustomer("Adelaide Brighton Limited").setCity("Adelaide").
        setLocation("Level 1, 157 Grenfell Street Adelaide SA 5000").
        setMobilePhone("0414 234 535").setBusinessPhone("(08) 8223 8000").
        setEmail("enquiries@adbri.com.au"));

    contacts.add(new ContactRepresentation("3").
        setFullName("Mr Michael Fraser").
        setParentCustomer("AGL Energy Limited").setCity("North Sydney").
        setLocation("Level 22, 101 Miller Street North Sydney NSW 2065").
        setMobilePhone("0414 114 115").setBusinessPhone("(02) 9921 2999").
        setEmail("enquiries@agl.com.au"));

    contacts.add(new ContactRepresentation("4").
        setFullName("Mr Peter Boyd").
        setParentCustomer("Alesco Corporation Limited").setCity("Sydney").
        setLocation("Level 24, 207 Kent Street Sydney NSW 2000").
        setMobilePhone("0414 233 332").setBusinessPhone("(02) 9248 2000").
        setEmail("enquiries@alesco.com.au"));

    contacts.add(new ContactRepresentation("5").
        setFullName("Mr John Bevan").
        setParentCustomer("Alumina Limited").setCity("Southbank").
        setLocation("Level 12, 60 City Road Southbank VIC 3006").
        setMobilePhone("0414 456 345").setBusinessPhone("(03) 8699 2600").
        setEmail("enquiries@alumina.com.au"));

    return contacts;
  }

}


  @Get ("json")
  public ContactRepresentation getContact() {

    ContactRepresentation result = new ContactRepresentation("1").
        setFullName("Dr Frank Wolf").
      setParentCustomer("Abacus Property Group").setCity("Sydney").
      setLocation("Level 34, 264-278 George Street Sydney NSW 2000").
      setMobilePhone("0414 414 515").setBusinessPhone("(02) 9253 8600").
      setEmail("enquiries@abacus.com.au");

    return result;
  }

  @Options
  public String description() {
    return "String description() - hello, world";
  }


  @Get("application/x-java-serialized-object+gwt")

  @Get("text/html")
  public String toHtml() {
    return "html hello, world";
  }

  @Get("text/plain")
  public String toTxt() {
    return "txt hello, world";
  }


  public void add(ContactRepresentation contact) {

    System.out.println("Email: " + contact.getEmail());
    System.out.println("First name: " + contact.getFirstName());
    System.out.println("Last name: " + contact.getLastName());
    System.out.println("Login: " + contact.getLogin());
    System.out.println("Nick name: " + contact.getNickName());
    System.out.println("Sender name: " + contact.getSenderName());
    System.out.println();
  }

*/