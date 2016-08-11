package uk.gov.ho.fizzbuzz;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class StatisticsServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_print_fizz_statistics() {
        final StringWriter output = new StringWriter();
        final StatisticsService statisticsService = new StatisticsService(output);

        statisticsService.writtenOutput("1");
        statisticsService.writtenOutput("fizz");
        statisticsService.writtenOutput("fizz");
        statisticsService.writtenOutput("7");
        statisticsService.printStatistics();

        assertThat(output.toString(), containsString("fizz: 2\n"));
    }

    @Test
    public void should_handle_IOException() throws IOException {
        exception.expect(FizzBuzzException.class);
        exception.expectMessage(equalTo("Unable to write output"));

        new StatisticsService(exceptionThrowingWriterMock()).printStatistics();
    }

    private Writer exceptionThrowingWriterMock() throws IOException {
        final Writer writerMock = mock(Writer.class);
        doThrow(new IOException()).when(writerMock).write(anyString());
        return writerMock;
    }

    @Test
    public void should_print_buzz_statistics() {
        final StringWriter output = new StringWriter();
        final StatisticsService statisticsService = new StatisticsService(output);

        statisticsService.writtenOutput("1");
        statisticsService.writtenOutput("buzz");
        statisticsService.writtenOutput("buzz");
        statisticsService.writtenOutput("buzz");
        statisticsService.printStatistics();

        assertThat(output.toString(), containsString("buzz: 3\n"));
    }

    @Test
    public void should_print_fizzbuzz_statistics() {
        final StringWriter output = new StringWriter();
        final StatisticsService statisticsService = new StatisticsService(output);

        statisticsService.writtenOutput("1");
        statisticsService.writtenOutput("fizzbuzz");
        statisticsService.writtenOutput("buzz");
        statisticsService.printStatistics();

        assertThat(output.toString(), containsString("fizzbuzz: 1\n"));
    }

    @Test
    public void should_print_luck_statistics() {
        final StringWriter output = new StringWriter();
        final StatisticsService statisticsService = new StatisticsService(output);

        statisticsService.writtenOutput("1");
        statisticsService.writtenOutput("luck");
        statisticsService.writtenOutput("luck");
        statisticsService.printStatistics();

        assertThat(output.toString(), containsString("luck: 2\n"));
    }

    @Test
    public void should_print_number_statistics() {
        final StringWriter output = new StringWriter();
        final StatisticsService statisticsService = new StatisticsService(output);

        statisticsService.writtenOutput("1");
        statisticsService.writtenOutput("2");
        statisticsService.writtenOutput("3");
        statisticsService.printStatistics();

        assertThat(output.toString(), containsString("number: 3\n"));
    }
}