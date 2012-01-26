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

package com.gwtcx.extgwt.client.data;

import java.io.Serializable;

import com.sencha.gxt.data.shared.ModelKeyProvider;

/**
 * ContextAreaModel
 */
public class ContextAreaModel implements Serializable {

  private static final long serialVersionUID = 1L;

  public static ModelKeyProvider<ContextAreaModel> KP = new ModelKeyProvider<ContextAreaModel>() {
    @Override
    public String getKey(ContextAreaModel item) {
      return item.getColumn1Name();
    }
  };

  private String column1Icon;
  private String column1Name;
  private String column1DisplayName;
  private String column1Description;
  private String column2Icon;
  private String column2Name;
  private String column2DisplayName;
  private String column2Description;

  public ContextAreaModel(String column1Icon, String column1Name, String column1DisplayName, String column1Description,
      String column2Icon, String column2Name, String column2DisplayName, String column2Description) {
    this.column1Icon = column1Icon;
    this.column1Name = column1Name;
    this.column1DisplayName = column1DisplayName;
    this.column1Description = column1Description;
    this.column2Icon = column2Icon;
    this.column2Name = column2Name;
    this.column2DisplayName = column2DisplayName;
    this.column2Description = column2Description;
  }

  public String getColumn1Icon() {
     return column1Icon;
  }

  public void setColumn1Icon(String column1Icon) {
    this.column1Icon = column1Icon;
  }

  public String getColumn1Name() {
    return column1Name;
  }

  public void setColumn1Name(String column1Name) {
    this.column1Name = column1Name;
  }

  public String getColumn1DisplayName() {
    return column1DisplayName;
  }

  public void setColumn1DisplayName(String column1DisplayName) {
    this.column1DisplayName = column1DisplayName;
  }

  public String getColumn1Description() {
    return column1Description;
  }

  public void setColumn1Description(String column1Description) {
    this.column1Description = column1Description;
  }

  public String getColumn2Icon() {
    return column2Icon;
  }

  public void setColumn2Icon(String column2Icon) {
    this.column2Icon = column2Icon;
  }

  public String getColumn2Name() {
    return column2Name;
  }

  public void setColumn2Name(String column2Name) {
    this.column2Name = column2Name;
  }

  public String getColumn2DisplayName() {
    return column2DisplayName;
  }

  public void setColumn2DisplayName(String column2DisplayName) {
    this.column2DisplayName = column2DisplayName;
  }

  public String getColumn2Description() {
    return column2Description;
  }

  public void setColumn2Description(String column2Description) {
    this.column2Description = column2Description;
  }
}
