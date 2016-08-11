package uk.gov.ho.fizzbuzz;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.Writer;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.hamcrest.core.IsEqual.equalTo;

public class FizzBuzzGameTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_handle_IOException() throws IOException {
        exception.expect(FizzBuzzException.class);
        exception.expectMessage(equalTo("Unable to write output"));

        new FizzBuzzGame(exceptionThrowingWriterMock()).printForGivenRange(1, 5);
    }

    private Writer exceptionThrowingWriterMock() throws IOException {
        final Writer writerMock = mock(Writer.class);
        doThrow(new IOException()).when(writerMock).write(anyString());
        return writerMock;
    }
}