package uk.gov.ho.fizzbuzz;

class OutputDecisionService {

    public static final String LUCK = "luck";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";

    public String forGiven(int number) {
        if(contains3(number)) {
            return LUCK;
        }

        if(notMultiplesOf3And5(number)) {
            return Integer.toString(number);
        }

        return fizzBuzzOutput(number);
    }

    private String fizzBuzzOutput(int number) {
        final StringBuffer output = new StringBuffer();

        if(multipleOf3(number)) {
            output.append(FIZZ);
        }
        if(multipleOf5(number)) {
            output.append(BUZZ);
        }

        return output.toString();
    }

    private boolean notMultiplesOf3And5(int number) {
        return !multipleOf3(number) && !multipleOf5(number);
    }

    private boolean multipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean multipleOf3(int number) {
        return number % 3 == 0;
    }

    private boolean contains3(int number) {
        return Integer.toString(number).contains("3");
    }
}
