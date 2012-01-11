package com.gwtplatform.dispatch.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class DispatchService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, String> methodMapJava;
  private static final Map<String, String> signatureMapJava;
  
  static {
    methodMapJava = loadMethodsJava();
    signatureMapJava = loadSignaturesJava();
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadMethodsJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException/2345075298", "com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.XsrfToken/4254043109", "com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer");
    result.put("com.gwtcx.sample.basic.shared.SendTextToServer/2949720429", "com.gwtcx.sample.basic.shared.SendTextToServer_FieldSerializer");
    result.put("com.gwtcx.sample.basic.shared.SendTextToServerResult/1945525311", "com.gwtcx.sample.basic.shared.SendTextToServerResult_FieldSerializer");
    result.put("[Lcom.gwtcx.sample.basic.shared.SendTextToServerResult;/2394189090", "com.gwtcx.sample.basic.shared.SendTextToServerResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.CreateAccountAction/2819381962", "com.gwtcx.shared.action.CreateAccountAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.CreateAccountResult/1383698251", "com.gwtcx.shared.action.CreateAccountResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.CreateAccountResult;/2151507489", "com.gwtcx.shared.action.CreateAccountResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.CreateEmailAction/3801653664", "com.gwtcx.shared.action.CreateEmailAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.CreateEmailResult/1685791850", "com.gwtcx.shared.action.CreateEmailResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.CreateEmailResult;/2464578128", "com.gwtcx.shared.action.CreateEmailResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.DeleteAccountAction/1026758044", "com.gwtcx.shared.action.DeleteAccountAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.DeleteAccountResult/3401392771", "com.gwtcx.shared.action.DeleteAccountResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.DeleteAccountResult;/637394534", "com.gwtcx.shared.action.DeleteAccountResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.DeleteEmailAction/3149717149", "com.gwtcx.shared.action.DeleteEmailAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.DeleteEmailResult/2142424471", "com.gwtcx.shared.action.DeleteEmailResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.DeleteEmailResult;/3883010455", "com.gwtcx.shared.action.DeleteEmailResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.LoginAction/2009390431", "com.gwtcx.shared.action.LoginAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.LoginResult/1518862844", "com.gwtcx.shared.action.LoginResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.LoginResult;/2580129685", "com.gwtcx.shared.action.LoginResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveAccountAction/2338624243", "com.gwtcx.shared.action.RetrieveAccountAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveAccountResult/1044230945", "com.gwtcx.shared.action.RetrieveAccountResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.RetrieveAccountResult;/49384684", "com.gwtcx.shared.action.RetrieveAccountResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveAccountsAction/3778620630", "com.gwtcx.shared.action.RetrieveAccountsAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveAccountsResult/75121496", "com.gwtcx.shared.action.RetrieveAccountsResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.RetrieveAccountsResult;/4208824823", "com.gwtcx.shared.action.RetrieveAccountsResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveEmailAction/2137001523", "com.gwtcx.shared.action.RetrieveEmailAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveEmailResult/1647589994", "com.gwtcx.shared.action.RetrieveEmailResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.RetrieveEmailResult;/2328986349", "com.gwtcx.shared.action.RetrieveEmailResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveReportsAction/782257560", "com.gwtcx.shared.action.RetrieveReportsAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.RetrieveReportsResult/1467502394", "com.gwtcx.shared.action.RetrieveReportsResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.RetrieveReportsResult;/4007432202", "com.gwtcx.shared.action.RetrieveReportsResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.SendEmailAction/945850580", "com.gwtcx.shared.action.SendEmailAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.SendEmailResult/1775547943", "com.gwtcx.shared.action.SendEmailResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.SendEmailResult;/2888743321", "com.gwtcx.shared.action.SendEmailResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.UpdateAccountAction/1099396183", "com.gwtcx.shared.action.UpdateAccountAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.UpdateAccountResult/3297502910", "com.gwtcx.shared.action.UpdateAccountResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.UpdateAccountResult;/2396008472", "com.gwtcx.shared.action.UpdateAccountResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.action.UpdateEmailAction/2687989740", "com.gwtcx.shared.action.UpdateEmailAction_FieldSerializer");
    result.put("com.gwtcx.shared.action.UpdateEmailResult/2336154903", "com.gwtcx.shared.action.UpdateEmailResult_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.action.UpdateEmailResult;/1330207225", "com.gwtcx.shared.action.UpdateEmailResult_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.dto.AccountDto/1669260617", "com.gwtcx.shared.dto.AccountDto_FieldSerializer");
    result.put("com.gwtcx.shared.dto.AccountsDto/3446673556", "com.gwtcx.shared.dto.AccountsDto_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.dto.AccountsDto;/422569108", "com.gwtcx.shared.dto.AccountsDto_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.dto.AddressDto/3287114179", "com.gwtcx.shared.dto.AddressDto_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.dto.AddressDto;/3683097413", "com.gwtcx.shared.dto.AddressDto_Array_Rank_1_FieldSerializer");
    result.put("com.gwtcx.shared.dto.EmailDto/58171291", "com.gwtcx.shared.dto.EmailDto_FieldSerializer");
    result.put("com.gwtcx.shared.dto.ReportsDto/15548410", "com.gwtcx.shared.dto.ReportsDto_FieldSerializer");
    result.put("[Lcom.gwtcx.shared.dto.ReportsDto;/2942697356", "com.gwtcx.shared.dto.ReportsDto_Array_Rank_1_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.ActionException/2451163915", "com.gwtplatform.dispatch.shared.ActionException_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.ActionImpl/2338109017", "com.gwtplatform.dispatch.shared.ActionImpl_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.BatchResult/3569380335", "com.gwtplatform.dispatch.shared.BatchResult_FieldSerializer");
    result.put("[Lcom.gwtplatform.dispatch.shared.BatchResult;/569845401", "com.gwtplatform.dispatch.shared.BatchResult_Array_Rank_1_FieldSerializer");
    result.put("[Lcom.gwtplatform.dispatch.shared.Result;/3987005119", "com.gwtplatform.dispatch.shared.Result_Array_Rank_1_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.ServiceException/918872072", "com.gwtplatform.dispatch.shared.ServiceException_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.UnsecuredActionImpl/3290230922", "com.gwtplatform.dispatch.shared.UnsecuredActionImpl_FieldSerializer");
    result.put("com.gwtplatform.dispatch.shared.UnsupportedActionException/26432650", "com.gwtplatform.dispatch.shared.UnsupportedActionException_FieldSerializer");
    result.put("java.lang.Long/4227064769", "com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer");
    result.put("java.lang.String/2004016611", "com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer");
    result.put("java.util.ArrayList/4159755760", "com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer");
    result.put("java.util.Arrays$ArrayList/2507071751", "com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer");
    result.put("java.util.Collections$EmptyList/4157118744", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer");
    result.put("java.util.Collections$SingletonList/1586180994", "com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer");
    result.put("java.util.LinkedList/3953877921", "com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer");
    result.put("java.util.Stack/1346942793", "com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer");
    result.put("java.util.Vector/3057315478", "com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadSignaturesJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException", "com.google.gwt.user.client.rpc.RpcTokenException/2345075298");
    result.put("com.google.gwt.user.client.rpc.XsrfToken", "com.google.gwt.user.client.rpc.XsrfToken/4254043109");
    result.put("com.gwtcx.sample.basic.shared.SendTextToServer", "com.gwtcx.sample.basic.shared.SendTextToServer/2949720429");
    result.put("com.gwtcx.sample.basic.shared.SendTextToServerResult", "com.gwtcx.sample.basic.shared.SendTextToServerResult/1945525311");
    result.put("[Lcom.gwtcx.sample.basic.shared.SendTextToServerResult;", "[Lcom.gwtcx.sample.basic.shared.SendTextToServerResult;/2394189090");
    result.put("com.gwtcx.shared.action.CreateAccountAction", "com.gwtcx.shared.action.CreateAccountAction/2819381962");
    result.put("com.gwtcx.shared.action.CreateAccountResult", "com.gwtcx.shared.action.CreateAccountResult/1383698251");
    result.put("[Lcom.gwtcx.shared.action.CreateAccountResult;", "[Lcom.gwtcx.shared.action.CreateAccountResult;/2151507489");
    result.put("com.gwtcx.shared.action.CreateEmailAction", "com.gwtcx.shared.action.CreateEmailAction/3801653664");
    result.put("com.gwtcx.shared.action.CreateEmailResult", "com.gwtcx.shared.action.CreateEmailResult/1685791850");
    result.put("[Lcom.gwtcx.shared.action.CreateEmailResult;", "[Lcom.gwtcx.shared.action.CreateEmailResult;/2464578128");
    result.put("com.gwtcx.shared.action.DeleteAccountAction", "com.gwtcx.shared.action.DeleteAccountAction/1026758044");
    result.put("com.gwtcx.shared.action.DeleteAccountResult", "com.gwtcx.shared.action.DeleteAccountResult/3401392771");
    result.put("[Lcom.gwtcx.shared.action.DeleteAccountResult;", "[Lcom.gwtcx.shared.action.DeleteAccountResult;/637394534");
    result.put("com.gwtcx.shared.action.DeleteEmailAction", "com.gwtcx.shared.action.DeleteEmailAction/3149717149");
    result.put("com.gwtcx.shared.action.DeleteEmailResult", "com.gwtcx.shared.action.DeleteEmailResult/2142424471");
    result.put("[Lcom.gwtcx.shared.action.DeleteEmailResult;", "[Lcom.gwtcx.shared.action.DeleteEmailResult;/3883010455");
    result.put("com.gwtcx.shared.action.LoginAction", "com.gwtcx.shared.action.LoginAction/2009390431");
    result.put("com.gwtcx.shared.action.LoginResult", "com.gwtcx.shared.action.LoginResult/1518862844");
    result.put("[Lcom.gwtcx.shared.action.LoginResult;", "[Lcom.gwtcx.shared.action.LoginResult;/2580129685");
    result.put("com.gwtcx.shared.action.RetrieveAccountAction", "com.gwtcx.shared.action.RetrieveAccountAction/2338624243");
    result.put("com.gwtcx.shared.action.RetrieveAccountResult", "com.gwtcx.shared.action.RetrieveAccountResult/1044230945");
    result.put("[Lcom.gwtcx.shared.action.RetrieveAccountResult;", "[Lcom.gwtcx.shared.action.RetrieveAccountResult;/49384684");
    result.put("com.gwtcx.shared.action.RetrieveAccountsAction", "com.gwtcx.shared.action.RetrieveAccountsAction/3778620630");
    result.put("com.gwtcx.shared.action.RetrieveAccountsResult", "com.gwtcx.shared.action.RetrieveAccountsResult/75121496");
    result.put("[Lcom.gwtcx.shared.action.RetrieveAccountsResult;", "[Lcom.gwtcx.shared.action.RetrieveAccountsResult;/4208824823");
    result.put("com.gwtcx.shared.action.RetrieveEmailAction", "com.gwtcx.shared.action.RetrieveEmailAction/2137001523");
    result.put("com.gwtcx.shared.action.RetrieveEmailResult", "com.gwtcx.shared.action.RetrieveEmailResult/1647589994");
    result.put("[Lcom.gwtcx.shared.action.RetrieveEmailResult;", "[Lcom.gwtcx.shared.action.RetrieveEmailResult;/2328986349");
    result.put("com.gwtcx.shared.action.RetrieveReportsAction", "com.gwtcx.shared.action.RetrieveReportsAction/782257560");
    result.put("com.gwtcx.shared.action.RetrieveReportsResult", "com.gwtcx.shared.action.RetrieveReportsResult/1467502394");
    result.put("[Lcom.gwtcx.shared.action.RetrieveReportsResult;", "[Lcom.gwtcx.shared.action.RetrieveReportsResult;/4007432202");
    result.put("com.gwtcx.shared.action.SendEmailAction", "com.gwtcx.shared.action.SendEmailAction/945850580");
    result.put("com.gwtcx.shared.action.SendEmailResult", "com.gwtcx.shared.action.SendEmailResult/1775547943");
    result.put("[Lcom.gwtcx.shared.action.SendEmailResult;", "[Lcom.gwtcx.shared.action.SendEmailResult;/2888743321");
    result.put("com.gwtcx.shared.action.UpdateAccountAction", "com.gwtcx.shared.action.UpdateAccountAction/1099396183");
    result.put("com.gwtcx.shared.action.UpdateAccountResult", "com.gwtcx.shared.action.UpdateAccountResult/3297502910");
    result.put("[Lcom.gwtcx.shared.action.UpdateAccountResult;", "[Lcom.gwtcx.shared.action.UpdateAccountResult;/2396008472");
    result.put("com.gwtcx.shared.action.UpdateEmailAction", "com.gwtcx.shared.action.UpdateEmailAction/2687989740");
    result.put("com.gwtcx.shared.action.UpdateEmailResult", "com.gwtcx.shared.action.UpdateEmailResult/2336154903");
    result.put("[Lcom.gwtcx.shared.action.UpdateEmailResult;", "[Lcom.gwtcx.shared.action.UpdateEmailResult;/1330207225");
    result.put("com.gwtcx.shared.dto.AccountDto", "com.gwtcx.shared.dto.AccountDto/1669260617");
    result.put("com.gwtcx.shared.dto.AccountsDto", "com.gwtcx.shared.dto.AccountsDto/3446673556");
    result.put("[Lcom.gwtcx.shared.dto.AccountsDto;", "[Lcom.gwtcx.shared.dto.AccountsDto;/422569108");
    result.put("com.gwtcx.shared.dto.AddressDto", "com.gwtcx.shared.dto.AddressDto/3287114179");
    result.put("[Lcom.gwtcx.shared.dto.AddressDto;", "[Lcom.gwtcx.shared.dto.AddressDto;/3683097413");
    result.put("com.gwtcx.shared.dto.EmailDto", "com.gwtcx.shared.dto.EmailDto/58171291");
    result.put("com.gwtcx.shared.dto.ReportsDto", "com.gwtcx.shared.dto.ReportsDto/15548410");
    result.put("[Lcom.gwtcx.shared.dto.ReportsDto;", "[Lcom.gwtcx.shared.dto.ReportsDto;/2942697356");
    result.put("com.gwtplatform.dispatch.shared.ActionException", "com.gwtplatform.dispatch.shared.ActionException/2451163915");
    result.put("com.gwtplatform.dispatch.shared.ActionImpl", "com.gwtplatform.dispatch.shared.ActionImpl/2338109017");
    result.put("com.gwtplatform.dispatch.shared.BatchResult", "com.gwtplatform.dispatch.shared.BatchResult/3569380335");
    result.put("[Lcom.gwtplatform.dispatch.shared.BatchResult;", "[Lcom.gwtplatform.dispatch.shared.BatchResult;/569845401");
    result.put("[Lcom.gwtplatform.dispatch.shared.Result;", "[Lcom.gwtplatform.dispatch.shared.Result;/3987005119");
    result.put("com.gwtplatform.dispatch.shared.ServiceException", "com.gwtplatform.dispatch.shared.ServiceException/918872072");
    result.put("com.gwtplatform.dispatch.shared.UnsecuredActionImpl", "com.gwtplatform.dispatch.shared.UnsecuredActionImpl/3290230922");
    result.put("com.gwtplatform.dispatch.shared.UnsupportedActionException", "com.gwtplatform.dispatch.shared.UnsupportedActionException/26432650");
    result.put("java.lang.Long", "java.lang.Long/4227064769");
    result.put("java.lang.String", "java.lang.String/2004016611");
    result.put("java.util.ArrayList", "java.util.ArrayList/4159755760");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/2507071751");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/4157118744");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/1586180994");
    result.put("java.util.LinkedList", "java.util.LinkedList/3953877921");
    result.put("java.util.Stack", "java.util.Stack/1346942793");
    result.put("java.util.Vector", "java.util.Vector/3057315478");
    return result;
  }
  
  public DispatchService_TypeSerializer() {
    super(methodMapJava, null, signatureMapJava, null);
  }
  
}
