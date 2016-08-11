package uk.gov.ho.fizzbuzz;

import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzGuidanceTest {

    @Test
    public void should_produce_correct_output_for_a_given_range() {
        final StringWriter ouput = new StringWriter();
        final FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(ouput);

        fizzBuzzGame.printForGivenRange(1, 20);

        assertThat(ouput.toString(), equalTo(expectedOutput()));
    }

    private String expectedOutput() {
        return "1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz ";
    }
}
