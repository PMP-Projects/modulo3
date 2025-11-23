package br.com.fatec.modulo_lambda;

import br.com.fatec.modulo_lambda.utils.json.JsonHexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModuloLambdaApplication {

    private static final Logger log = LoggerFactory.getLogger(ModuloLambdaApplication.class);


    public static void main(String[] args) {

        SpringApplication.run(ModuloLambdaApplication.class, args);

        /*
        * Uso de classe auxiliar APENAS para apoiar no envio de um partition no offset explorer
        * No caso a seguir, ele exibe um hexadecimal ajustado aos valores que você insere no pessoa.json, em resources
        */
        String hex = JsonHexUtil.jsonResourceToHex("payload/pessoa.json");

        log.info("KEY AUXILIAR PARA ENVIO: 6D6579");
        log.info("HEX do payload carregado: {}", hex);
	}

}
