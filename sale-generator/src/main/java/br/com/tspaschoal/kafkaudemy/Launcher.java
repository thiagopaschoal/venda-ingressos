package br.com.tspaschoal.kafkaudemy;

import br.com.tspaschoal.kafkaudemy.services.SaleService;
import kafkaudemy.config.KafkaConfig;
import kafkaudemy.models.Sale;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;

@Slf4j
public class Launcher {

    public static void main(String[] args) {

        final var producerConfig = KafkaConfig.createKafkaProducerConfig();
        final var saleService = new SaleService();
        try (final var producer = new KafkaProducer<String, Sale>(producerConfig)) {
            while(true) {
                try {
                    Sale sale = saleService.createSale();
                    log.info("Processando a compra (OperationCode: + " + sale.getOperationId() + " ....");
                    Thread.sleep(Duration.ofSeconds(5).getSeconds());
                    producer.send(new ProducerRecord<>("TICKET_SALE_TOPIC", sale));
                    log.info("Compra processada com sucesso!!!");
                } catch (InterruptedException e) {
                    log.error("erro durante o processamento da compra! Favor verificar.");
                }
            }
        }
    }
}
