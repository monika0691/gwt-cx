package com.gwtcx.shared.action;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RetrieveEmailResult_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.action.RetrieveEmailResult instance) throws SerializationException {
    instance.dto = (com.gwtcx.shared.dto.EmailDto) streamReader.readObject();
    
  }
  
  public static com.gwtcx.shared.action.RetrieveEmailResult instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.action.RetrieveEmailResult();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.action.RetrieveEmailResult instance) throws SerializationException {
    streamWriter.writeObject(instance.dto);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.action.RetrieveEmailResult_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.action.RetrieveEmailResult_FieldSerializer.deserialize(reader, (com.gwtcx.shared.action.RetrieveEmailResult)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.action.RetrieveEmailResult_FieldSerializer.serialize(writer, (com.gwtcx.shared.action.RetrieveEmailResult)object);
  }
  
}
