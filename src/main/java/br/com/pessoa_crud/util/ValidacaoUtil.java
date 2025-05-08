package br.com.pessoa_crud.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ValidacaoUtil {

    public static boolean validarIdade(Date dataNascimento) {
        if (dataNascimento == null) {
            return false;
        }

        LocalDate nascimento = dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate hoje = LocalDate.now();
        int idade = Period.between(nascimento, hoje).getYears();

        return idade >= 18 && idade <= 100;
    }
}
