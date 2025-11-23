package br.com.fatec.modulo_lambda;

import br.com.fatec.modulo_lambda.utils.json.JsonHexUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonHexUtilTest {

    @Test
    void deveConverterJsonDeResourceParaHex() {
        String hex = JsonHexUtil.jsonResourceToHex("payload/teste_pessoa.json");

        // Hex esperado do JSON minificado:
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
        Assertions.assertThrows(RuntimeException.class, () -> {
            JsonHexUtil.jsonResourceToHex("payload/inexistente.json");
        });
    }
}
