package kafkaudemy.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafkaudemy.models.Sale;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class SaleDeserializer implements Deserializer<Sale> {

    @SneakyThrows
    @Override
    public Sale deserialize(String s, byte[] bytes) {
        return new ObjectMapper().readValue(bytes, Sale.class);
    }
}
