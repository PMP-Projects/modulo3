package br.com.fatec.modulo_lambda.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonHexUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonHexUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String jsonResourceToHex(String resourcePath) {
        try (InputStream in = JsonHexUtil.class.getClassLoader().getResourceAsStream(resourcePath)) {

            if (in == null) {
                throw new RuntimeException("Arquivo JSON não encontrado: " + resourcePath);
            }

            Object jsonObj = mapper.readValue(in, Object.class);
            String jsonMin = mapper.writeValueAsString(jsonObj);

            return stringToHex(jsonMin);

        } catch (Exception e) {
            log.error("Erro ao converter JSON para HEX: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static String stringToHex(String input) {
        StringBuilder hex = new StringBuilder();
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);

        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }

        return hex.toString();
    }
}
