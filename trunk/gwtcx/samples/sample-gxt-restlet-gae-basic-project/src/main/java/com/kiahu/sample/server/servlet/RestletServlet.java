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

package com.kiahu.sample.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.Context;
import org.restlet.ext.servlet.ServletAdapter;
import org.restlet.ext.wadl.WadlApplication;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.kiahu.sample.server.restlet.BasicProjectServerApplication;
import com.kiahu.sample.server.restlet.ContactServerResource;
import com.kiahu.sample.server.restlet.ContactsServerResource;
import com.kiahu.sample.server.restlet.GuiceRouter;
import com.kiahu.sample.server.restlet.RootServerResource;

@Singleton
@SuppressWarnings("serial")
public class RestletServlet extends HttpServlet {

  private static final String rootPath = "/";
  private static final String contactsPath = "/contacts";
  private static final String contactPath = contactsPath + "/{id}";
  // private static final String accountsPath = "/accounts";

  @Inject private Injector injector;
  private Context context;
  private ServletAdapter adapter;

  // http://stackoverflow.com/questions/2176216/how-to-inject-injector
  // Provider<T> should be used for lazy/optional initialization. You should be
  // avoiding references to the Injector in your code in almost all cases.
  // That said, in a class that is created by Guice, the Injector that is creating
  // the object can be injected just by declaring a dependency on Injector.
  // The Injector is automatically available for injection without you declaring any binding for it.

  // See also GuiceFinder and GucieRouter

  @Override
  public void init() throws ServletException
  {
    context = new Context();
    WadlApplication application = new BasicProjectServerApplication();
    application.setContext(context);

    application.setInboundRoot(new GuiceRouter(injector, context)
    {
      @Override
      protected void attachRoutes()
      {
        attach(rootPath, RootServerResource.class);
        attach(contactsPath, ContactsServerResource.class);
        attach(contactPath, ContactServerResource.class);
      }
    });

    adapter = new ServletAdapter(getServletContext());
    adapter.setNext(application);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException
  {
    adapter.service(request, response);
  }
}