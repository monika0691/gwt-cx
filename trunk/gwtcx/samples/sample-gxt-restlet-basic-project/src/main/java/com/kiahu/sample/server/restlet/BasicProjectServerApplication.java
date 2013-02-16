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

import org.restlet.Restlet;
import org.restlet.ext.wadl.WadlApplication;
import org.restlet.routing.Router;

public class BasicProjectServerApplication extends WadlApplication {

  /**
   * Creates an application that can automatically introspect and expose
   * itself as with a WADL description upon reception of an OPTIONS request on
   * the "*" target URI.
   */
  public BasicProjectServerApplication() {
    setName("Basic Project Server Application");
    setDescription("Kiahu CX GXT/Restlet Sample");
    setOwner("Kiahu");
    setAuthor("The Kiahu CX Team");
  }

  /**
   * Creates a inbound root Restlet that will receive all incoming calls. In
   * general, instances of Router, Filter or Finder classes will be used as
   * initial application Restlet.
   *
   * @return The inbound root Restlet.
   */
  @Override
  public Restlet createInboundRoot() {
    Router router = new Router(getContext());
    // router.attach("/", RootServerResource.class);
    router.attach("/contacts/", RootServerResource.class);
    /*
    router.attach("/accounts/", AccountsServerResource.class);
    router.attach("/accounts/{accountId}", AccountServerResource.class);
    router.attach("/accounts/{accountId}/mails/", MailsServerResource.class);
    router.attach("/accounts/{accountId}/mails/{mailId}", MailServerResource.class);
    router.attach("/accounts/{accountId}/contacts/", ContactsServerResource.class);
    router.attach("/accounts/{accountId}/contacts/{contactId}", ContactServerResource.class);
    */
    return router;
  }

}
