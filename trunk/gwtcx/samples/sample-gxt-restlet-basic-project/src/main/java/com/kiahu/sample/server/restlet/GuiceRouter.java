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

package com.kiahu.sample.server.restlet;

import org.restlet.Context;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

import com.google.inject.Injector;

public class GuiceRouter extends Router {

  private final Injector injector;

  public GuiceRouter(Injector injector, Context context)
  {
      super(context);
      this.injector = injector;
      attachRoutes();
  }

  @Override
  public Finder createFinder(Class<? extends ServerResource>  targetClass)
  {
    return new GuiceFinder(injector, getContext(), targetClass);
  }

  protected void attachRoutes() {};

  protected Injector getInjector()
  {
    return injector;
  }
}
