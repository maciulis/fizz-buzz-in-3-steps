package uk.gov.ho.fizzbuzz;

class OutputDecisionService {
    public String forGiven(int number) {
        if(number % 3 != 0 && number % 5 != 0) {
            return Integer.toString(number);
        }

        return fizzBuzzOutput(number);
    }

    private String fizzBuzzOutput(int number) {
        final StringBuffer output = new StringBuffer();

        if(number % 3 == 0) {
            output.append("fizz");
        }
        if(number % 5 == 0) {
            output.append("buzz");
        }

        return output.toString();
    }
}
