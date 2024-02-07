package demo.data.resiliency.account.balance.repository;

import demo.data.resiliency.account.balance.domain.Balance;
import lombok.RequiredArgsConstructor;
import nyla.solutions.core.patterns.repository.FindByIdRepository;
import nyla.solutions.core.patterns.repository.SaveRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BalanceMapRepository implements FindByIdRepository<Balance,String>,
        SaveRepository<Balance> {

    private final Map<String, Balance> map;

    @Override
    public Optional<Balance> findById(String id) {
        var value = this.map.get(id);
        if(value == null)
            return Optional.empty();
        return Optional.of(value);
    }

    public Balance save(Balance balance) {
        return  map.put(balance.id(),balance);
    }
}
