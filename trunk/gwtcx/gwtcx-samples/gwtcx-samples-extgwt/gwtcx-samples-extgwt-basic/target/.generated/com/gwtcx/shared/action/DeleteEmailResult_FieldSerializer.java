package com.gwtcx.shared.action;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DeleteEmailResult_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.action.DeleteEmailResult instance) throws SerializationException {
    
  }
  
  public static com.gwtcx.shared.action.DeleteEmailResult instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.action.DeleteEmailResult();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.action.DeleteEmailResult instance) throws SerializationException {
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.action.DeleteEmailResult_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.action.DeleteEmailResult_FieldSerializer.deserialize(reader, (com.gwtcx.shared.action.DeleteEmailResult)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.action.DeleteEmailResult_FieldSerializer.serialize(writer, (com.gwtcx.shared.action.DeleteEmailResult)object);
  }
  
}
