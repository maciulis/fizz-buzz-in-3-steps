import org.junit.Test;

import javax.lang.model.element.NestingKind;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FizzBuzzGuidanceTest {

    @Test
    public void should_produce_correct_output_for_a_given_range() {
        final StringWriter ouput = new StringWriter();
        final FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(ouput);

        fizzBuzzGame.printForGivenRange(1, 20);

        assertThat(ouput.toString(), equalTo(expectedOutput()));
    }

    private String expectedOutput() {
        return "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    }
}
