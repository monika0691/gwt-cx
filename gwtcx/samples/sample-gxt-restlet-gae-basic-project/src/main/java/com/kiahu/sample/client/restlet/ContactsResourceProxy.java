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

package com.kiahu.sample.client.restlet;

import org.restlet.client.resource.ClientProxy;
import org.restlet.client.resource.Get;
import org.restlet.client.resource.Result;

import com.gwtcx.shared.dto.ContactsRepresentation;

public interface ContactsResourceProxy extends ClientProxy {

    @Get
    public void retrieve(Result<ContactsRepresentation> result);

}

/*

http://stackoverflow.com/questions/4051397/restlet-posting-json-to-appengine-error

You encountered a limitation of GAE that several Restlet users faced.

Some time ago, GAE stopped supporting accepting chunked HTTP entity. We reproduced this issue with both POST and PUT and raw GAE Servlets, so this isn't Restlet related. See GAE issue: http://code.google.com/p/googleappengine/issues/detail?id=129

The only workaround we found is to not chunk entities, meaning being able to compute their size in advance.

In Restlet 2.1 M3 version that we just released, we added a simple "entityBuffering" property on ClientResource to facilitate this (set to 'false' by default).

*/