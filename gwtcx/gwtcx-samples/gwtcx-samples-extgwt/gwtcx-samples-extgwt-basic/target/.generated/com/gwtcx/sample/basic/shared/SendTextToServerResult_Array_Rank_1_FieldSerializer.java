package com.gwtcx.sample.basic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SendTextToServerResult_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.sample.basic.shared.SendTextToServerResult[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.gwtcx.sample.basic.shared.SendTextToServerResult[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.gwtcx.sample.basic.shared.SendTextToServerResult[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.sample.basic.shared.SendTextToServerResult[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.sample.basic.shared.SendTextToServerResult_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServerResult_Array_Rank_1_FieldSerializer.deserialize(reader, (com.gwtcx.sample.basic.shared.SendTextToServerResult[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.sample.basic.shared.SendTextToServerResult_Array_Rank_1_FieldSerializer.serialize(writer, (com.gwtcx.sample.basic.shared.SendTextToServerResult[])object);
  }
  
}
