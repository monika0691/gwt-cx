package com.gwtcx.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EmailDto_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.dto.EmailDto instance) throws SerializationException {
    instance.bcc = streamReader.readString();
    instance.cc = streamReader.readString();
    instance.emailId = (java.lang.Long) streamReader.readObject();
    instance.from = streamReader.readString();
    instance.message = streamReader.readString();
    instance.owner = streamReader.readString();
    instance.regarding = streamReader.readString();
    instance.subject = streamReader.readString();
    instance.to = streamReader.readString();
    
  }
  
  public static com.gwtcx.shared.dto.EmailDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.dto.EmailDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.dto.EmailDto instance) throws SerializationException {
    streamWriter.writeString(instance.bcc);
    streamWriter.writeString(instance.cc);
    streamWriter.writeObject(instance.emailId);
    streamWriter.writeString(instance.from);
    streamWriter.writeString(instance.message);
    streamWriter.writeString(instance.owner);
    streamWriter.writeString(instance.regarding);
    streamWriter.writeString(instance.subject);
    streamWriter.writeString(instance.to);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.dto.EmailDto_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.dto.EmailDto_FieldSerializer.deserialize(reader, (com.gwtcx.shared.dto.EmailDto)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.dto.EmailDto_FieldSerializer.serialize(writer, (com.gwtcx.shared.dto.EmailDto)object);
  }
  
}
