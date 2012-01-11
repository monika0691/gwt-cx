package com.gwtcx.sample.basic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SendTextToServer_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getTextToServer(com.gwtcx.sample.basic.shared.SendTextToServer instance) {
    return (java.lang.String) ReflectionHelper.getField(com.gwtcx.sample.basic.shared.SendTextToServer.class, instance, "textToServer");
  }
  
  private static void setTextToServer(com.gwtcx.sample.basic.shared.SendTextToServer instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.gwtcx.sample.basic.shared.SendTextToServer.class, instance, "textToServer", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.sample.basic.shared.SendTextToServer instance) throws SerializationException {
    setTextToServer(instance, streamReader.readString());
    
    com.gwtplatform.dispatch.shared.UnsecuredActionImpl_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.gwtcx.sample.basic.shared.SendTextToServer instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return ReflectionHelper.newInstance(com.gwtcx.sample.basic.shared.SendTextToServer.class);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.sample.basic.shared.SendTextToServer instance) throws SerializationException {
    streamWriter.writeString(getTextToServer(instance));
    
    com.gwtplatform.dispatch.shared.UnsecuredActionImpl_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.sample.basic.shared.SendTextToServer_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServer_FieldSerializer.deserialize(reader, (com.gwtcx.sample.basic.shared.SendTextToServer)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServer_FieldSerializer.serialize(writer, (com.gwtcx.sample.basic.shared.SendTextToServer)object);
  }
  
}
