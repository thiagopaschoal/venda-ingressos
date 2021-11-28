package br.com.tspaschoal.kafkaudemy.services;

import kafkaudemy.models.Sale;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Random;

@Slf4j
public class SaleService {

    private static long lastOperationId = 0;

    private final BigDecimal ticketUnitValue = BigDecimal.valueOf(250);

    public Sale createSale() {
        final var random = new Random();
        final var numberOfTickets = random.nextInt(10);
        return Sale.builder()
                .operationId(lastOperationId++)
                .customerId(random.nextLong())
                .numberOfTickets(numberOfTickets)
                .totalValue(ticketUnitValue.multiply(BigDecimal.valueOf(numberOfTickets)))
                .isSaleActive(random.nextBoolean())
                .build();
    }

}
