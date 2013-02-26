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

package com.gwtcx.server.gae.domain;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Party
 *
 * JPA defines entities called "mapped superclasses" for the situation where you
 * don't persist an actual object of a superclass type but that all subclasses of
 * that type that are entities will also persist the values for the fields of the
 * "mapped superclass".
 *
 * See: http://www.datanucleus.org/products/accessplatform/jpa/orm/inheritance.html
 *
 */
@Entity
@MappedSuperclass
public class Party extends DatastoreEntity {

  // @DiscriminatorColumn(name = EntityTokens.PARTY_TYPE_COLUMN, discriminatorType = DiscriminatorType.STRING, length = 1)
  // @DiscriminatorValue(value = EntityTokens.PARTY_TABLE_DISCRIMINATOR_VALUE)

  enum PartyType
  {
     ACCOUNT("A"), CONTACT("C"), INDIVIDUAL("I"), ORGANISATION("O");

     // Be sure to make all of your persistent fields private and create accessors
     // (getters and setters) for them. In addition to all the good reasons for
     // using encapsulation, if a persistent object field is accessed directly from
     // another object, this may circumvent the JPA/JDO class enhancement post-processing.

     private PartyType(String abbreviation) { this.abbreviation = abbreviation; }
     public String getAbbreviation() { return abbreviation; }

     private String abbreviation;
  }

}

/*

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
      String input = in.next().toUpperCase();
      Size size = Enum.valueOf(Size.class, input);
      System.out.println("size=" + size);
      System.out.println("abbreviation=" + size.getAbbreviation());
      if (size == Size.EXTRA_LARGE)
         System.out.println("Good job--you paid attention to the _.");
   }

  // import java.util.logging.Logger;

  // @Id
  // @Column(name = EntityTokens.PARTY_ID_COLUMN)
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // protected Long partyId;

  // private static Logger logger = Logger.getLogger(AbstractParty.class.getName());

  public Long getPartyId() {
    return partyId;
  }

  public void setPartyId(Long partyId) {
    this.partyId = partyId;
  }

*/