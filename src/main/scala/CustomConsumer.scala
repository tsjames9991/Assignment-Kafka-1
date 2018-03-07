import java.util.{Collections, Properties}

import org.apache.kafka.clients.consumer.KafkaConsumer
import serde._
import scala.collection.JavaConverters._

object CustomConsumer extends App {
  val topic = "test-topic"
  val prop = new Properties
  prop.put("bootstrap.servers", "localhost:9092")
  prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  prop.put("value.deserializer", "serde.CustomDeserializer")
  prop.put("group.id", "something")
  prop.put("auto.offset.reset", "earliest")
  prop.put("enable.auto.commit", "false ")
  val consumer = new KafkaConsumer[String, Student](prop)
  consumer.subscribe(Collections.singletonList(topic))
  while (true) {
    val records = consumer.poll(TIMEOUT)
    for (record <- records.asScala)
      Log.info(record.value().toString)
  }
}
