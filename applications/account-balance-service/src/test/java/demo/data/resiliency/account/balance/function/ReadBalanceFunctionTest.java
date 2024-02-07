package demo.data.resiliency.account.balance.function;

import demo.data.resiliency.account.balance.domain.Balance;
import nyla.solutions.core.patterns.creational.generator.JavaBeanGeneratorCreator;
import nyla.solutions.core.patterns.repository.FindByIdRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReadBalanceFunctionTest {

    private ReadBalanceFunction subject;
    private String accountId = "test";
    private Balance expected;
    @Mock
    private FindByIdRepository repository;

    @BeforeEach
    void setUp() {
        expected = JavaBeanGeneratorCreator
                .of(Balance.class).create();
    }

    @Test
    void apply() {
        when(repository.findById(anyString())).thenReturn(Optional.of(expected));

        subject = new ReadBalanceFunction(repository);

        var actual = subject.apply(accountId);
        assertThat(actual).isEqualTo(expected);
    }
}