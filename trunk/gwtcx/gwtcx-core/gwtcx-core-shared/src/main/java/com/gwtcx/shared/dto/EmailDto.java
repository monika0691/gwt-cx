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

public class EmailDto implements Serializable {

  private static final long serialVersionUID = -6853340818289177309L;

  protected Long emailId;

  public EmailDto() {
    this.emailId = -1L;
  }

  public EmailDto(Long emailId) {
    this.emailId = emailId;
  }
  
  public Long getId() {
    return emailId;
  }  

  public Long getEmailId() {
    return emailId;
  }
  
  public void setId(Long id) {
    this.emailId = id;
  }  

  public void setEmailId(Long emailId) {
    this.emailId = emailId;
  }
}
