package demo.data.resiliency.account.balance.function;

import demo.data.resiliency.account.balance.domain.Balance;
import demo.data.resiliency.account.balance.domain.Payment;
import demo.data.resiliency.account.balance.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class MakePaymentConsumer implements Consumer<Payment> {

    private final BalanceRepository repository;
    @Override
    public void accept(Payment payment) {
        repository.save(calculateNewBalance(payment));
    }

    Balance calculateNewBalance(Payment payment) {
        var balance = repository.findById(payment.id()).orElse(new Balance(payment.id(), BigDecimal.ZERO));

        return new Balance(balance.id(),balance.amount().add(payment.amount()));
    }
}
