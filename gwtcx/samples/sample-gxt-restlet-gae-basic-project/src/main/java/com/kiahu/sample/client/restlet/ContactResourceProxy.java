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

import com.gwtcx.shared.dto.ContactRepresentation;

public interface ContactResourceProxy extends ClientProxy{

  @Get
  public void retrieve(Result<ContactRepresentation> result);

}
