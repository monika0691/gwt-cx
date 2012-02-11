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

public class EntityTokens {

  //
  // Datastore entity (a MappedSuperclass)
  //

  public static final String DATASTORE_ENTITY_KEY_COLUMN = "KEY";
  public static final String DATASTORE_ENTITY_TYPE_COLUMN = "TYPE";

  //
  // Versioned entity (a MappedSuperclass)
  //

  public static final String VERSION_COLUMN = "VERSION";
  public static final String CREATED_BY_COLUMN = "CREATED_BY";
  public static final String CREATED_TIMESTAMP_COLUMN = "CREATED_TIMESTAMP";
  public static final String UPDATED_BY_COLUMN = "UPDATED_BY";
  public static final String UPDATED_TIMESTAMP_COLUMN = "UPDATED_BY_TIMESTAMP";

  //
  // Contact entity
  //

  public static final String GIVEN_NAME_COLUMN = "GIVEN_NAME";
  public static final String MIDDLE_NAME_COLUMN = "MIDDLE_NAME";
  public static final String FAMILY_NAME_COLUMN = "FAMILY_NAME";
  public static final String SALUTATION_COLUMN = "SALUTATION";
  public static final String CORRESPONDENCE_COLUMN = "CORRESPONDENCE";
  public static final String JOB_TITLE_COLUMN = "JOB_TITLE";
  public static final String OCCUPATION_COLUMN = "OCCUPATION";

  public static final String BUSINESS_PHONE_COLUMN = "BUSINESS_PHONE";
  public static final String FAX_COLUMN = "FAX";
  public static final String MOBILE_PHONE_COLUMN = "MOBILE_PHONE";
  public static final String HOME_PHONE_COLUMN = "HOME_PHONE";
  public static final String EMAIL_COLUMN = "EMAIL";

}
