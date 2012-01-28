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

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public interface NavigationPaneSectionModel {

  @PropertyName("icon")
  String getIcon();

  @PropertyName("name")
  String getName();

  @PropertyName("displayName")
  String getDisplayName();
}

/*

public class NavigationPaneSectionModelListStore extends ListStore<NavigationPaneSectionModel> {

  public static ModelKeyProvider<NavigationPaneSectionModel> KP = new ModelKeyProvider<NavigationPaneSectionModel>() {
    @Override
    public String getKey(NavigationPaneSectionModel item) {
      return item.getName();
    }
  };

  public NavigationPaneSectionModelListStore() {
    super(KP);
  }
}




public class NavigationPaneSectionModel implements Serializable {

  private static final long serialVersionUID = 3308992559832998314L;

  public static ModelKeyProvider<NavigationPaneSectionModel> KP = new ModelKeyProvider<NavigationPaneSectionModel>() {
    @Override
    public String getKey(NavigationPaneSectionModel item) {
      return item.getName();
    }
  };

  private String icon;
  private String name;
  private String displayName;

  public NavigationPaneSectionModel(String icon, String name, String displayName) {
    this.icon = icon;
    this.name = name;
    this.displayName = displayName;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}

*/
