package br.com.fatec.modulo_lambda.function;


import br.com.fatec.modulo_lambda.function.dto.LambdaMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
public class PessoaCreatedFunction {

    @Bean
    public Consumer<LambdaMessage> lambdaKafkaConsumer() {
         return consumer -> {
            System.out.println("Recebendo cadastro do cliente: \n" + "Nome do Cliente: " + consumer.nome() + "\nData de Nascimento: " + consumer.dataNascimento());
        };
    }
}