package com.gwtcx.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.exception.LoginException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.gwtcx.shared.exception.LoginException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.exception.LoginException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.exception.LoginException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.exception.LoginException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.exception.LoginException_FieldSerializer.deserialize(reader, (com.gwtcx.shared.exception.LoginException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.exception.LoginException_FieldSerializer.serialize(writer, (com.gwtcx.shared.exception.LoginException)object);
  }
  
}
