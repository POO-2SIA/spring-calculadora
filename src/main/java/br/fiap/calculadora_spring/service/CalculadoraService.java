package br.fiap.calculadora_spring.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service //Declara que essa classe é um service
public class CalculadoraService {
    public BigDecimal calcular(String valor1, String valor2, String operacao) {
        BigDecimal v1 = toBigDecimal(valor1);
        BigDecimal v2 = toBigDecimal(valor2);

        return switch (operacao) {
            case "soma" -> v1.add(v2);
            case "subtracao" -> v1.subtract(v2);
            case "multiplicacao" -> v1.multiply(v2);
            case "divisao" -> {
                if (v2.compareTo(BigDecimal.ZERO) == 0){
                    throw new IllegalArgumentException("Não existe divisão por 0!");
                }
                yield v1.divide(v2);
            }

            default -> throw new IllegalArgumentException("Operação Inválida");
        };
    }

    private BigDecimal toBigDecimal(String valor) {
        String aux = valor.trim().replace(",", ".");
        //Usamos o .trim para retirar espaços vazios no input e o replace para substituir eventuais , por .

        try {
            return new BigDecimal(valor);
        } catch (Exception e) {
            throw new IllegalArgumentException("O valor deve ser numérico");
        }
    }
}
