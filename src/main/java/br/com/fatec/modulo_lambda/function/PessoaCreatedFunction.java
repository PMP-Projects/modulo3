package br.com.fatec.modulo_lambda.function;

import br.com.fatec.modulo_lambda.function.dto.LambdaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
public class PessoaCreatedFunction {

    private static final Logger log = LoggerFactory.getLogger(PessoaCreatedFunction.class);

    @Bean
    public Consumer<LambdaMessage> lambdaKafkaConsumer() {
        return consumer ->
                log.info(
                        "Recebendo cadastro do cliente:\nNome do Cliente: {}\nData de Nascimento: {}",
                        consumer.nome(),
                        consumer.dataNascimento()
                );
    }
}
