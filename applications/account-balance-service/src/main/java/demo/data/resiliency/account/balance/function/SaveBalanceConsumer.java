package demo.data.resiliency.account.balance.function;

import demo.data.resiliency.account.balance.domain.Balance;
import lombok.RequiredArgsConstructor;
import nyla.solutions.core.patterns.repository.SaveRepository;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class SaveBalanceConsumer implements Consumer<Balance> {

    private final SaveRepository<Balance> repository;
    @Override
    public void accept(Balance balance) {
        repository.save(balance);
    }
}
