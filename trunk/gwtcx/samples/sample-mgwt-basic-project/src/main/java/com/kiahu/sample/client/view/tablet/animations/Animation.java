/**
 * (C) Copyright 2012 Kiahu
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

package com.kiahu.sample.client.view.tablet.animations;

public class Animation {

  private String name;
  private AnimationNames animationName;

  public enum AnimationNames {
    SLIDE, SLIDE_UP, DISSOLVE, FADE, FLIP, POP, SWAP;
  }

  @SuppressWarnings("unused")
  private Animation() {

  }

  public Animation(AnimationNames animationName, String displayName) {
    this.animationName = animationName;
    this.name = displayName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AnimationNames getAnimationName() {
    return animationName;
  }
}
