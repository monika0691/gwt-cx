package com.gwtcx.shared.action;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SendEmailAction_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.action.SendEmailAction instance) throws SerializationException {
    instance.dto = (com.gwtcx.shared.dto.EmailDto) streamReader.readObject();
    
  }
  
  public static com.gwtcx.shared.action.SendEmailAction instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.action.SendEmailAction();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.action.SendEmailAction instance) throws SerializationException {
    streamWriter.writeObject(instance.dto);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.action.SendEmailAction_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.action.SendEmailAction_FieldSerializer.deserialize(reader, (com.gwtcx.shared.action.SendEmailAction)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.action.SendEmailAction_FieldSerializer.serialize(writer, (com.gwtcx.shared.action.SendEmailAction)object);
  }
  
}
