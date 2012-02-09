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

package com.gwtcx.server.gae.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.KeyFactory;
import com.gwtcx.server.gae.dao.ContactDao;
import com.gwtcx.server.gae.domain.Contact;
import com.gwtcx.shared.action.RetrieveContactsAction;
import com.gwtcx.shared.action.RetrieveContactsResult;
import com.gwtcx.shared.dto.ContactsDto;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class RetrieveContactsHandler implements
    ActionHandler<RetrieveContactsAction, RetrieveContactsResult> {

      // import java.util.logging.Logger;

  private static Logger logger = Logger.getLogger(RetrieveContactsHandler.class.getName());

  @Override
  public RetrieveContactsResult execute(RetrieveContactsAction action,
      ExecutionContext context) throws ActionException {

    RetrieveContactsResult result = null;
    ContactDao contactDao = new ContactDao();

    logger.info("Retrieve Contacts");

    try {
      List<Contact> contacts = contactDao.retrieveContacts(action.getMaxResults(),
          action.getFirstResult());

      if (contacts != null) {
        List<ContactsDto> contactsDtos = new ArrayList<ContactsDto>(contacts.size());

        for (Contact contact : contacts) {
            contactsDtos.add(toDto(contact));
        }

        result = new RetrieveContactsResult(contactsDtos);
      }
    }
    catch (Exception e) {
      logger.info("Unable to retrieve Contacts - " + e);

      throw new ActionException(e);
    }

    return result;
  }

  /**
   * toDto:
   *
   * Key has two String representations. Key.toString() outputs a string that is
   * useful in logging and debugging, KeyFactory.keyToString() outputs a string
   * that you can safely pass around in forms and urls.
   *
   */
  private ContactsDto toDto(Contact contact) {

    String key = KeyFactory.keyToString(contact.getPartyKey());

    return new ContactsDto(key, contact.getFullName(), "parentCustomer", "location", "phone", "businessPhone", "email");
  }

  @Override
  public Class<RetrieveContactsAction> getActionType() {
    return RetrieveContactsAction.class;
  }

  @Override
  public void undo(RetrieveContactsAction action, RetrieveContactsResult result,
      ExecutionContext context) throws ActionException {
  }
}
