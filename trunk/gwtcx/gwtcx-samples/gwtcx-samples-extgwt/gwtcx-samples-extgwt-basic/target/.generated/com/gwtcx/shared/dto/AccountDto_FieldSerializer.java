package com.gwtcx.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountDto_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.dto.AccountDto instance) throws SerializationException {
    instance.accountId = (java.lang.Long) streamReader.readObject();
    instance.accountName = streamReader.readString();
    instance.accountNumber = streamReader.readString();
    instance.addresses = (java.util.List) streamReader.readObject();
    instance.email = streamReader.readString();
    instance.fax = streamReader.readString();
    instance.mainPhone = streamReader.readString();
    instance.otherPhone = streamReader.readString();
    instance.parentAccount = streamReader.readString();
    instance.primaryContact = streamReader.readString();
    instance.relationshipType = streamReader.readString();
    instance.webSite = streamReader.readString();
    
  }
  
  public static com.gwtcx.shared.dto.AccountDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.dto.AccountDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.dto.AccountDto instance) throws SerializationException {
    streamWriter.writeObject(instance.accountId);
    streamWriter.writeString(instance.accountName);
    streamWriter.writeString(instance.accountNumber);
    streamWriter.writeObject(instance.addresses);
    streamWriter.writeString(instance.email);
    streamWriter.writeString(instance.fax);
    streamWriter.writeString(instance.mainPhone);
    streamWriter.writeString(instance.otherPhone);
    streamWriter.writeString(instance.parentAccount);
    streamWriter.writeString(instance.primaryContact);
    streamWriter.writeString(instance.relationshipType);
    streamWriter.writeString(instance.webSite);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.dto.AccountDto_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AccountDto_FieldSerializer.deserialize(reader, (com.gwtcx.shared.dto.AccountDto)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AccountDto_FieldSerializer.serialize(writer, (com.gwtcx.shared.dto.AccountDto)object);
  }
  
}
