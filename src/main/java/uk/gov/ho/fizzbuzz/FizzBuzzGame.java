package uk.gov.ho.fizzbuzz;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.IntStream;

public class FizzBuzzGame {
    private final Writer output;
    private final OutputDecisionService outputDecisionService;

    public FizzBuzzGame(Writer output) {
        this.output = output;
        this.outputDecisionService = new OutputDecisionService();
    }

    public void printForGivenRange(int rangeStartInclusive, int rangeEndInclusive) {
        IntStream.range(rangeStartInclusive, rangeEndInclusive+1).forEach(number -> writeOutputFor(number));
    }

    private void writeOutputFor(int number) {
        try {
            output.write(outputDecisionService.forGiven(number) + " ");
        } catch (IOException e) {
            throw new FizzBuzzException("Unable to write output", e);
        }
    }
}
