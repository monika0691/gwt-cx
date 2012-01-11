package com.gwtplatform.dispatch.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BatchResult_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getResults(com.gwtplatform.dispatch.shared.BatchResult instance) {
    return (java.util.List) ReflectionHelper.getField(com.gwtplatform.dispatch.shared.BatchResult.class, instance, "results");
  }
  
  private static void setResults(com.gwtplatform.dispatch.shared.BatchResult instance, java.util.List value) 
  {
    ReflectionHelper.setField(com.gwtplatform.dispatch.shared.BatchResult.class, instance, "results", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.gwtplatform.dispatch.shared.BatchResult instance) throws SerializationException {
    setResults(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static com.gwtplatform.dispatch.shared.BatchResult instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtplatform.dispatch.shared.BatchResult();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtplatform.dispatch.shared.BatchResult instance) throws SerializationException {
    streamWriter.writeObject(getResults(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtplatform.dispatch.shared.BatchResult_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtplatform.dispatch.shared.BatchResult_FieldSerializer.deserialize(reader, (com.gwtplatform.dispatch.shared.BatchResult)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtplatform.dispatch.shared.BatchResult_FieldSerializer.serialize(writer, (com.gwtplatform.dispatch.shared.BatchResult)object);
  }
  
}
