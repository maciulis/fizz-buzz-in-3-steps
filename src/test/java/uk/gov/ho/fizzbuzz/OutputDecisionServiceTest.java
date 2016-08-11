package uk.gov.ho.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OutputDecisionServiceTest {

    @Test
    public void should_give_a_number_when_not_multiple_of_3_or_5() {
        assertThat(new OutputDecisionService().forGiven(1), equalTo("1"));
    }

    @Test
    public void should_give_fizz_for_multiples_of_3() {
        assertThat(new OutputDecisionService().forGiven(3), equalTo("fizz"));
        assertThat(new OutputDecisionService().forGiven(6), equalTo("fizz"));
        assertThat(new OutputDecisionService().forGiven(9), equalTo("fizz"));
    }

    @Test
    public void should_give_buzz_for_multiples_of_5() {
        assertThat(new OutputDecisionService().forGiven(5), equalTo("buzz"));
        assertThat(new OutputDecisionService().forGiven(10), equalTo("buzz"));
        assertThat(new OutputDecisionService().forGiven(20), equalTo("buzz"));
    }

    @Test
    public void should_give_fizzbuzz_for_multiples_of_3_and_5() {
        assertThat(new OutputDecisionService().forGiven(15), equalTo("fizzbuzz"));
        assertThat(new OutputDecisionService().forGiven(30), equalTo("fizzbuzz"));
        assertThat(new OutputDecisionService().forGiven(45), equalTo("fizzbuzz"));
    }
}