package br.com.fatec.modulo_lambda;

import br.com.fatec.modulo_lambda.function.PessoaCreatedFunction;
import br.com.fatec.modulo_lambda.function.dto.LambdaMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.function.Consumer;

class PessoaCreatedFunctionTest {

    @Test
    void deveConsumirLambdaMessageEImprimirNoConsole() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PessoaCreatedFunction function = new PessoaCreatedFunction();
        Consumer<LambdaMessage> consumer = function.lambdaKafkaConsumer();

        LambdaMessage message = new LambdaMessage("Julio", LocalDate.of(2000, 10, 10)
        );

        consumer.accept(message);

        String consoleOutput = outputStream.toString();

        Assertions.assertTrue(consoleOutput.contains("Nome do Cliente: Julio"));
        Assertions.assertTrue(consoleOutput.contains("Data de Nascimento: 2000-10-10"));
    }
}
