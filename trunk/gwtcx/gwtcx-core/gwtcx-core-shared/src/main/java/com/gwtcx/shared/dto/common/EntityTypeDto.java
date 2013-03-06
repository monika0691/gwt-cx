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

package com.gwtcx.shared.dto.common;

import java.io.Serializable;

// https://blogs.oracle.com/drm/entry/reference_data_management
// HL7 Guidelines

public class EntityTypeDto implements Serializable {

  public static final String TRUE = "TRUE";
  public static final String FALSE = "FALSE";

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String code;               // E.g. The four codes specified in ISO/IEC 5218 are: 0 = not known, 1 = male, 2 = female, 9 = not applicable.
  protected String description;
  protected String activeFlag = TRUE;  // if FALSE add to list when editing a form but not for New's

  public EntityTypeDto() {
    this.id = "-1";
  }

  public EntityTypeDto(String id, String name) {
    this();
    this.name = name;
  }

  public EntityTypeDto(String id, String name, String code) {
    this();
    this.name = name;
    this.code = code;
  }

  public String getId() {
    return id;
  }

  // http://en.wikipedia.org/wiki/Method_chaining
  public EntityTypeDto setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public EntityTypeDto setName(String name) {
    this.name = name;
    return this;
  }


  public String getCode() {
    return code;
  }

  public EntityTypeDto setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public EntityTypeDto setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getActiveFlag() {
    return activeFlag;
  }

  public EntityTypeDto setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
    return this;
  }
}
