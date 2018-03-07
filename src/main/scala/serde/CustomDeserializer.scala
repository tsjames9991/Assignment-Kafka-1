package serde

import org.apache.kafka.common.serialization.Deserializer
import java.io.{ObjectInputStream, ByteArrayInputStream}
import java.util

class CustomDeserializer extends Deserializer[Student] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def deserialize(topic: String, bytes: Array[Byte]) = {
    val byteIn = new ByteArrayInputStream(bytes)
    val objIn = new ObjectInputStream(byteIn)
    val obj = objIn.readObject().asInstanceOf[Student]
    byteIn.close()
    objIn.close()
    obj
  }

  override def close(): Unit = {}
}
