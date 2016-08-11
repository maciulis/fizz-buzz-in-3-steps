package uk.gov.ho.fizzbuzz;

import java.io.IOException;
import java.io.Writer;

class StatisticsService {
    private final Writer output;
    private int fizzCounter;
    private int buzzCounter;
    private int fizzBuzzCounter;
    private int luckCounter;
    private int numberCounter;

    public StatisticsService(Writer output) {
        this.output = output;
    }

    public void printStatistics() {
        try {
            output.write("\n");
            output.write("fizz: " + fizzCounter + "\n");
            output.write("buzz: " + buzzCounter + "\n");
            output.write("fizzbuzz: " + fizzBuzzCounter + "\n");
            output.write("luck: " + luckCounter + "\n");
            output.write("number: " + numberCounter + "\n");
        } catch (IOException e) {
            throw new FizzBuzzException("Unable to write output", e);
        }
    }

    public void writtenOutput(String outputToWrite) {
        if (outputToWrite.equals("fizzbuzz")) {
            fizzBuzzCounter++;
        } else if (outputToWrite.equals("fizz")) {
            fizzCounter++;
        } else if (outputToWrite.equals("buzz")) {
            buzzCounter++;
        } else if (outputToWrite.equals("luck")) {
            luckCounter++;
        }
        else {
            numberCounter++;
        }
    }
}
