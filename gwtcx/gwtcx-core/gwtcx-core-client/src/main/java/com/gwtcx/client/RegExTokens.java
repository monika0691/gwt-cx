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

package com.gwtcx.client;

public class RegExTokens {

  // Regular expressions are composed of two types of characters. The special
  // characters are called metacharacters and the literal or normal text characters.

  // It might help to think of regular expressions as their own language,
  // with literal text acting as the words and metacharacters as the grammar.
  // The words are combined with grammar according to a set of rules to create
  // an expression that communicates an idea.

  // White List Input Validation
  // https://www.owasp.org/index.php/Input_Validation_Cheat_Sheet
  // https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
  // http://www.regular-expressions.info/
  // http://regexlib.com/
  // http://rick.measham.id.au/paste/explain.pl?regex=.*
  // http://regexpal.com/

  public final static String TRUE =  "TRUE";
  public final static String FALSE =  "FALSE";

  public final static String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,32})";
  // ^[A-Za-z0-9!@#$%^&*()_]{6,20}$

  // "^[a-zA-Z0-9 -]+$";  // no min/max

  public final static String ALPHANUMERIC_0_8 =  "^[A-Za-z0-9 -]{0,8}$";
  public final static String ALPHANUMERIC_0_16 = "^[A-Za-z0-9 -]{0,16}$";
  public final static String ALPHANUMERIC_0_32 = "^[A-Za-z0-9 -]{0,32}$";
  public final static String ALPHANUMERIC_0_64 = "^[A-Za-z0-9 -]{0,64}$";

  public final static String ALPHANUMERIC_1_8 =  "^[A-Za-z0-9 -]{1,8}$";   // also requires setAllowBlank(false)
  public final static String ALPHANUMERIC_1_16 = "^[A-Za-z0-9 -]{1,16}$";  // also requires setAllowBlank(false)
  public final static String ALPHANUMERIC_1_32 = "^[A-Za-z0-9 -]{1,32}$";  // also requires setAllowBlank(false)
  public final static String ALPHANUMERIC_1_64 = "^[A-Za-z0-9 -]{1,64}$";  // also requires setAllowBlank(false)

  public final static String NUMERIC_0_10 = "^[0-9 ]{0,10}$";  //

  public final static String EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  // public final static String EMAIL = "^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$";
  // public final static String EMAIL = "^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$";
  // public final static String EMAIL = "(\w[-._\w]*\w@\w[-._\w]*\w\.\w{2,3})";

  // public final static String URL = "^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$";
  // public final static String URL = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$";

}
