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

  protected String emailId;
  protected String from;
  protected String to;
  protected String cc;
  protected String bcc;
  protected String subject;
  protected String message;
  protected String regarding;
  protected String owner;

  // Attachment details
  // protected List<AttachmentDto> attachments;

  public EmailDto() {
    this.emailId = "-1";
  }

  public EmailDto(String id) {
    this.emailId = id;
  }

  public String getId() {
    return emailId;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setId(String id) {
    this.emailId = id;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getCc() {
    return cc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  public String getBcc() {
    return bcc;
  }

  public void setBcc(String bcc) {
    this.bcc = bcc;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRegarding() {
    return regarding;
  }

  public void setRegarding(String regarding) {
    this.regarding = regarding;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
