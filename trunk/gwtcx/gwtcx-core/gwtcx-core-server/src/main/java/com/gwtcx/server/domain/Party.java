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
// <class>com.gwtcx.core.server.domain.Party</class>

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = EntityTokens.PARTY_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = EntityTokens.PARTY_TYPE_COLUMN, discriminatorType = DiscriminatorType.STRING, length = 1)
@DiscriminatorValue(value = EntityTokens.PARTY_TABLE_DISCRIMINATOR_VALUE)
// @Cacheable(true)
public class Party {
	
  @Id
  @Column(name = EntityTokens.PARTY_ID_COLUMN)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long partyId;
  
  @Column(name = EntityTokens.PARTY_TYPE_COLUMN, nullable = false)
  @Enumerated(EnumType.STRING)
  protected String partyType;  

}
