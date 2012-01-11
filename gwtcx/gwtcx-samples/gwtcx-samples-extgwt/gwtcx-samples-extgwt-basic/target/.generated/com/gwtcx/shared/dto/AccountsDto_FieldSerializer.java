package com.gwtcx.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountsDto_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Long getAccountId(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.Long) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "accountId");
  }
  
  private static void setAccountId(com.gwtcx.shared.dto.AccountsDto instance, java.lang.Long value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "accountId", value);
  }
  
  private static java.lang.String getAccountName(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "accountName");
  }
  
  private static void setAccountName(com.gwtcx.shared.dto.AccountsDto instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "accountName", value);
  }
  
  private static java.lang.String getEmailPrimaryContact(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "emailPrimaryContact");
  }
  
  private static void setEmailPrimaryContact(com.gwtcx.shared.dto.AccountsDto instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "emailPrimaryContact", value);
  }
  
  private static java.lang.String getLocation(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "location");
  }
  
  private static void setLocation(com.gwtcx.shared.dto.AccountsDto instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "location", value);
  }
  
  private static java.lang.String getMainPhone(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "mainPhone");
  }
  
  private static void setMainPhone(com.gwtcx.shared.dto.AccountsDto instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "mainPhone", value);
  }
  
  private static java.lang.String getPrimaryContact(com.gwtcx.shared.dto.AccountsDto instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.shared.dto.AccountsDto.class, instance, "primaryContact");
  }
  
  private static void setPrimaryContact(com.gwtcx.shared.dto.AccountsDto instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.shared.dto.AccountsDto.class, instance, "primaryContact", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.dto.AccountsDto instance) throws SerializationException {
    setAccountId(instance, (java.lang.Long) streamReader.readObject());
    setAccountName(instance, streamReader.readString());
    setEmailPrimaryContact(instance, streamReader.readString());
    setLocation(instance, streamReader.readString());
    setMainPhone(instance, streamReader.readString());
    setPrimaryContact(instance, streamReader.readString());
    
  }
  
  public static com.gwtcx.shared.dto.AccountsDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.dto.AccountsDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.dto.AccountsDto instance) throws SerializationException {
    streamWriter.writeObject(getAccountId(instance));
    streamWriter.writeString(getAccountName(instance));
    streamWriter.writeString(getEmailPrimaryContact(instance));
    streamWriter.writeString(getLocation(instance));
    streamWriter.writeString(getMainPhone(instance));
    streamWriter.writeString(getPrimaryContact(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.dto.AccountsDto_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AccountsDto_FieldSerializer.deserialize(reader, (com.gwtcx.shared.dto.AccountsDto)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AccountsDto_FieldSerializer.serialize(writer, (com.gwtcx.shared.dto.AccountsDto)object);
  }
  
}
