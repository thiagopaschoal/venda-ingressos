package br.com.tspaschoal.kafkaudemy;

import kafkaudemy.config.KafkaConfig;
import kafkaudemy.models.Sale;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

@Slf4j
public class Launcher {

    public static void main(String[] args) throws InterruptedException {

        final var consumerConfig = KafkaConfig.createKafkaConsumerConfig();
        try (final var consumer = new KafkaConsumer<String, Sale>(consumerConfig)) {
            consumer.subscribe(Collections.singletonList("TICKET_SALE_TOPIC"));
            while(true) {
                final var records = consumer.poll(Duration.ofSeconds(5));
                Thread.sleep(Duration.ofSeconds(5).getSeconds());
                records.forEach(record -> {
                    Sale sale = record.value();
                    System.out.println(sale);
                });
            }
        }
    }
}
