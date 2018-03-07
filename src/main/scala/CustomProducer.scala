import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import serde._

object CustomProducer extends App {

  val topic = "test-topic"
  val prop = new Properties
  prop.put("bootstrap.servers", "localhost:9092")
  prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  prop.put("value.serializer", "serde.CustomSerializer")
  val producer = new KafkaProducer[String, Student](prop)
  val record = new ProducerRecord[String, Student](topic, "key", student)
  producer.send(record)
  Log.info("Message Has Been Passed")
  producer.close()
}
