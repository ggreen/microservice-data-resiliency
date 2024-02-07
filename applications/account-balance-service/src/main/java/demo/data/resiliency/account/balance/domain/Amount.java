package demo.data.resiliency.account.balance.domain;

import java.math.BigDecimal;

public record Amount(BigDecimal amount, String currency) {
}
