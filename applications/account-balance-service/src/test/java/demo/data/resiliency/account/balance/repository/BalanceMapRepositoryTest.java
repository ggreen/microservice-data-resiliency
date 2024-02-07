package demo.data.resiliency.account.balance.repository;

import demo.data.resiliency.account.balance.domain.Balance;
import nyla.solutions.core.patterns.creational.generator.JavaBeanGeneratorCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceMapRepositoryTest {

    private BalanceMapRepository subject;
    private Map<String, Balance> map;
    private Balance balance = JavaBeanGeneratorCreator.of(Balance.class).create();

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        subject = new BalanceMapRepository(map);

    }

    @Test
    void findById() {
        subject.save(balance);
        Optional<Balance> expected = Optional.of(balance);
        assertThat(subject.findById(balance.id())).isEqualTo(expected);
    }
}