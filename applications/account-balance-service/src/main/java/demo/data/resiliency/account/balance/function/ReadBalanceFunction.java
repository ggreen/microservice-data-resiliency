package demo.data.resiliency.account.balance.function;

import demo.data.resiliency.account.balance.domain.Balance;
import lombok.RequiredArgsConstructor;
import nyla.solutions.core.patterns.repository.FindByIdRepository;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ReadBalanceFunction implements Function<String, Balance> {

    private final FindByIdRepository<Balance,String> repository;

    @Override
    public Balance apply(String id) {
        return repository.findById(id).orElse(null);
    }
}
