package kafkaudemy.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafkaudemy.models.Sale;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

public class SaleSerializer implements Serializer<Sale> {

    @SneakyThrows
    @Override
    public byte[] serialize(String topic, Sale sale) {
        return new ObjectMapper().writeValueAsBytes(sale);
    }
}
