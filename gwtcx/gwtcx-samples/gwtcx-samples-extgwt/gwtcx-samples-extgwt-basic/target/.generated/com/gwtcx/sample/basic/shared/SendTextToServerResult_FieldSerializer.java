package com.gwtcx.sample.basic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SendTextToServerResult_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getResponse(com.gwtcx.sample.basic.shared.SendTextToServerResult instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.sample.basic.shared.SendTextToServerResult.class, instance, "response");
  }
  
  private static void setResponse(com.gwtcx.sample.basic.shared.SendTextToServerResult instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.sample.basic.shared.SendTextToServerResult.class, instance, "response", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.sample.basic.shared.SendTextToServerResult instance) throws SerializationException {
    setResponse(instance, streamReader.readString());
    
  }
  
  public static com.gwtcx.sample.basic.shared.SendTextToServerResult instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return ReflectionHelper.newInstance(com.gwtcx.sample.basic.shared.SendTextToServerResult.class);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.sample.basic.shared.SendTextToServerResult instance) throws SerializationException {
    streamWriter.writeString(getResponse(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.sample.basic.shared.SendTextToServerResult_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServerResult_FieldSerializer.deserialize(reader, (com.gwtcx.sample.basic.shared.SendTextToServerResult)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServerResult_FieldSerializer.serialize(writer, (com.gwtcx.sample.basic.shared.SendTextToServerResult)object);
  }
  
}
