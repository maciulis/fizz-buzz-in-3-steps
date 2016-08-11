package uk.gov.ho.fizzbuzz;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class FizzBuzzDemo {

    public static void main(String ...args) throws IOException {
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        new FizzBuzzGame(output).printForGivenRange(1, 20);
        output.flush();
        output.close();
    }
}
