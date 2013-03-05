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

public class EntityTypeDto implements Serializable {

  public static final String TRUE = "TRUE";
  public static final String FALSE = "FALSE";

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String description;
  protected String activeFlag = TRUE;  // if FALSE add to list when editing a form but not for New's

  public EntityTypeDto() {
    this.id = "-1";
  }

  public EntityTypeDto(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  // http://en.wikipedia.org/wiki/Covariant_return_type
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
