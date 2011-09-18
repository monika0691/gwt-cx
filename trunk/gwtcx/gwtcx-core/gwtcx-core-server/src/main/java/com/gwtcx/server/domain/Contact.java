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

package com.gwtcx.server.domain;

// Don't forget to add the add the following line to persistence.xml:
// <class>com.gwtcx.core.server.domain.Contact</class>

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = EntityTokens.CONTACT_TABLE)
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name = EntityTokens.CONTACT_ID_COLUMN, referencedColumnName = EntityTokens.PARTY_ID_COLUMN)
public class Contact extends Party {
	
  @Column(name = EntityTokens.GIVEN_NAME_COLUMN, length = EntityTokens.GIVEN_NAME_COLUMN_LENGTH)
  protected String givenName;
  
  @Column(name = EntityTokens.MIDDLE_NAME_COLUMN, length = EntityTokens.MIDDLE_NAME_COLUMN_LENGTH)
  protected String middleName;  
  
  @Column(name = EntityTokens.FAMILY_NAME_COLUMN, length = EntityTokens.FAMILY_NAME_COLUMN_LENGTH)
  protected String familyName;  

}
