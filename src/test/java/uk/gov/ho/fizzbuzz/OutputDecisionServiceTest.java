package uk.gov.ho.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OutputDecisionServiceTest {

    private OutputDecisionService outputDecisionService = new OutputDecisionService();

    @Test
    public void should_give_a_number_when_not_multiple_of_3_or_5() {
        assertThat(outputDecisionService.forGiven(1), equalTo("1"));
    }

    @Test
    public void should_give_fizz_for_multiples_of_3() {
        assertThat(outputDecisionService.forGiven(6), equalTo("fizz"));
        assertThat(outputDecisionService.forGiven(9), equalTo("fizz"));
        assertThat(outputDecisionService.forGiven(12), equalTo("fizz"));
    }

    @Test
    public void should_give_buzz_for_multiples_of_5() {
        assertThat(outputDecisionService.forGiven(5), equalTo("buzz"));
        assertThat(outputDecisionService.forGiven(10), equalTo("buzz"));
        assertThat(outputDecisionService.forGiven(20), equalTo("buzz"));
    }

    @Test
    public void should_give_fizzbuzz_for_multiples_of_3_and_5() {
        assertThat(outputDecisionService.forGiven(15), equalTo("fizzbuzz"));
        assertThat(outputDecisionService.forGiven(45), equalTo("fizzbuzz"));
    }

    @Test
    public void should_give_lucky_for_numbers_containing_3() {
        assertThat(outputDecisionService.forGiven(3), equalTo("luck"));
        assertThat(outputDecisionService.forGiven(13), equalTo("luck"));
        assertThat(outputDecisionService.forGiven(30), equalTo("luck"));
    }
}