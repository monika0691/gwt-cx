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

package com.kiahu.sample.client.util;

import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class ChromeWorkaround {

  private static boolean isChrome = isChrome();

  // workaround for chrome bug
  // see: http://code.google.com/p/mgwt/issues/detail?id=164
  public static void maybeUpdateScroller(ScrollPanel scrollPanel) {

	// no impact on production
	// this compiles out!
	if (!MGWT.getOsDetection().isDesktop())
		  return;

	if (isChrome) {
      scrollPanel.setUsePos(true);
	}
  }

  private static native boolean isChrome()/*-{
	return navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
  }-*/;
}
