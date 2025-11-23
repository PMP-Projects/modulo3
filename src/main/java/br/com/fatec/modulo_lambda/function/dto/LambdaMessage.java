package br.com.fatec.modulo_lambda.function.dto;

import java.time.LocalDate;

public record LambdaMessage(
        String nome,
        LocalDate dataNascimento
) {
}