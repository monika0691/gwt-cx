package com.gwtcx.shared.action;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RetrieveReportsAction_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.action.RetrieveReportsAction instance) throws SerializationException {
    instance.firstResult = streamReader.readInt();
    instance.maxResults = streamReader.readInt();
    
  }
  
  public static com.gwtcx.shared.action.RetrieveReportsAction instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.action.RetrieveReportsAction();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.action.RetrieveReportsAction instance) throws SerializationException {
    streamWriter.writeInt(instance.firstResult);
    streamWriter.writeInt(instance.maxResults);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.action.RetrieveReportsAction_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.action.RetrieveReportsAction_FieldSerializer.deserialize(reader, (com.gwtcx.shared.action.RetrieveReportsAction)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.action.RetrieveReportsAction_FieldSerializer.serialize(writer, (com.gwtcx.shared.action.RetrieveReportsAction)object);
  }
  
}
