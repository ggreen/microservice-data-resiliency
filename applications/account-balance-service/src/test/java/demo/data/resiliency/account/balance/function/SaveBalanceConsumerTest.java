package demo.data.resiliency.account.balance.function;

import demo.data.resiliency.account.balance.domain.Balance;
import demo.data.resiliency.account.balance.repository.BalanceMapRepository;
import nyla.solutions.core.patterns.creational.generator.JavaBeanGeneratorCreator;
import nyla.solutions.core.patterns.repository.SaveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SaveBalanceConsumerTest {

    private SaveBalanceConsumer subject;
    private Balance balance = JavaBeanGeneratorCreator.of(Balance.class).create();

    @Mock
    private SaveRepository<Balance> repository;

    @BeforeEach
    void setUp() {
        subject = new SaveBalanceConsumer(repository);
    }

    @Test
    void accept() {
        subject.accept(balance);
        verify(repository).save(balance);
    }
}