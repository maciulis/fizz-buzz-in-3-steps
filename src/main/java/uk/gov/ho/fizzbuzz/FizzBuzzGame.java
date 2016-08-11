package uk.gov.ho.fizzbuzz;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.IntStream;

public class FizzBuzzGame {
    private final Writer output;
    private final OutputDecisionService outputDecisionService;
    private final StatisticsService statisticsService;

    public FizzBuzzGame(Writer output) {
        this.output = output;
        this.outputDecisionService = new OutputDecisionService();
        this.statisticsService = new StatisticsService(output);
    }

    public void printForGivenRange(int rangeStartInclusive, int rangeEndInclusive) {
        IntStream.range(rangeStartInclusive, rangeEndInclusive+1).forEach(number -> writeOutputFor(number));
        statisticsService.printStatistics();
    }

    private void writeOutputFor(int number) {
        try {
            final String outputToWrite = outputDecisionService.forGiven(number);
            output.write(outputToWrite + " ");
            statisticsService.writtenOutput(outputToWrite);
        } catch (IOException e) {
            throw new FizzBuzzException("Unable to write output", e);
        }
    }
}
