package serde

import org.apache.kafka.common.serialization.Serializer
import java.io.{ObjectOutputStream, ByteArrayOutputStream}
import java.util

class CustomSerializer extends Serializer[Student] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}


  override def serialize(topic: String, data: Student): Array[Byte] = {
    try {
      val byteOut = new ByteArrayOutputStream()
      val objOut = new ObjectOutputStream(byteOut)
      objOut.writeObject(data)
      objOut.close()
      byteOut.close()
      byteOut.toByteArray
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

  override def close(): Unit = {}
}
