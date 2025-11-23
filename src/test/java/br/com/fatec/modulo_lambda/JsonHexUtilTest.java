package br.com.fatec.modulo_lambda;

import br.com.fatec.modulo_lambda.utils.json.JsonHexUtil;
import br.com.fatec.modulo_lambda.utils.json.exception.JsonHexConversionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class JsonHexUtilTest {

    @Test
    void deveConverterJsonDeResourceParaHex() {
        String hex = JsonHexUtil.jsonResourceToHex("payload/teste_pessoa.json");

        String expectedHex = "7b226e6f6d65223a224a756c696f222c22646174614e617363696d656e746f223a22323030302d31302d3130227d";

        Assertions.assertEquals(expectedHex, hex);
    }

    @Test
    void deveConverterStringParaHex() {
        String input = "ABC";
        String expected = "414243";

        Assertions.assertEquals(expected, JsonHexUtil.stringToHex(input));
    }

    @Test
    void deveLancarErroQuandoArquivoNaoExiste() {
        JsonHexConversionException exception = Assertions.assertThrows(
                JsonHexConversionException.class,
                () -> JsonHexUtil.jsonResourceToHex("payload/inexistente.json")
        );

        Assertions.assertTrue(exception.getMessage().contains("Arquivo JSON não encontrado"));
    }

    @Test
    void deveLancarErroQuandoStringNula() {
        JsonHexConversionException exception = Assertions.assertThrows(
                JsonHexConversionException.class,
                () -> JsonHexUtil.stringToHex(null)
        );

        Assertions.assertEquals("String de entrada não pode ser nula.", exception.getMessage());
    }
}
