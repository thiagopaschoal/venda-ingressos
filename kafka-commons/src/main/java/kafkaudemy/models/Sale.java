package kafkaudemy.models;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@AllArgsConstructor
@ToString
public class Sale {
    private Long operationId;
    private Long customerId;
    private BigDecimal totalValue;
    private Integer numberOfTickets;
    private Boolean isSaleActive;

    public Sale() {}
}
