package br.com.fatec.modulo_lambda.utils.json;

import br.com.fatec.modulo_lambda.utils.json.exception.JsonHexConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class JsonHexUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonHexUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    // Impede instanciação
    private JsonHexUtil() {}

    public static String jsonResourceToHex(String resourcePath) {

        try (InputStream in = JsonHexUtil.class.getClassLoader().getResourceAsStream(resourcePath)) {

            if (in == null) {
                throw new JsonHexConversionException("Arquivo JSON não encontrado: " + resourcePath);
            }

            Object jsonObj = mapper.readValue(in, Object.class);

            String jsonMin = mapper.writeValueAsString(jsonObj);

            return stringToHex(jsonMin);

        } catch (JsonProcessingException e) {
            log.error("Falha ao processar JSON do arquivo {}: {}", resourcePath, e.getMessage(), e);
            throw new JsonHexConversionException("Falha ao processar JSON: " + resourcePath, e);

        } catch (IOException e) {
            log.error("Erro de I/O ao ler o arquivo {}: {}", resourcePath, e.getMessage(), e);
            throw new JsonHexConversionException("Falha de I/O ao ler arquivo: " + resourcePath, e);
        }
    }

    public static String stringToHex(String input) {
        if (input == null) {
            throw new JsonHexConversionException("String de entrada não pode ser nula.");
        }

        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        StringBuilder hex = new StringBuilder(bytes.length * 2);

        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }

        return hex.toString();
    }
}
