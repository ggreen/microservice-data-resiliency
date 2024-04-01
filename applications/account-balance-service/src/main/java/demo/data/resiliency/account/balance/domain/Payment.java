package demo.data.resiliency.account.balance.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *  "AccountId": "22289",
 *         "Amount": {
 *           "Amount": "1230.00",
 *           "Currency": "GBP"
 *         }
 */
public record Payment(String id, BigDecimal amount) {
}
