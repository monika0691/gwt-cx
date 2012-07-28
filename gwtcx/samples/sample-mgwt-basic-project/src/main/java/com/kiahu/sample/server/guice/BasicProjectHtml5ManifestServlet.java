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

package com.kiahu.sample.server.guice;

import com.google.inject.Singleton;
import com.googlecode.mgwt.linker.server.MGWTHtml5ManifestServlet;

// import net.jcip.annotations.ThreadSafe;

@Singleton
@SuppressWarnings("serial")
// @ThreadSafe
public class BasicProjectHtml5ManifestServlet extends MGWTHtml5ManifestServlet {

  // private static final long serialVersionUID = 3003646428681343770L;

  public BasicProjectHtml5ManifestServlet() {
    super();
  }
}