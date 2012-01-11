package com.gwtcx.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ReportsDto_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.dto.ReportsDto instance) throws SerializationException {
    instance.description = streamReader.readString();
    instance.entityName = streamReader.readString();
    instance.modifiedOn = streamReader.readString();
    instance.reportFilename = streamReader.readString();
    instance.reportId = (java.lang.Long) streamReader.readObject();
    instance.reportName = streamReader.readString();
    instance.reportType = streamReader.readString();
    
  }
  
  public static com.gwtcx.shared.dto.ReportsDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.dto.ReportsDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.dto.ReportsDto instance) throws SerializationException {
    streamWriter.writeString(instance.description);
    streamWriter.writeString(instance.entityName);
    streamWriter.writeString(instance.modifiedOn);
    streamWriter.writeString(instance.reportFilename);
    streamWriter.writeObject(instance.reportId);
    streamWriter.writeString(instance.reportName);
    streamWriter.writeString(instance.reportType);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.dto.ReportsDto_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.dto.ReportsDto_FieldSerializer.deserialize(reader, (com.gwtcx.shared.dto.ReportsDto)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.dto.ReportsDto_FieldSerializer.serialize(writer, (com.gwtcx.shared.dto.ReportsDto)object);
  }
  
}
