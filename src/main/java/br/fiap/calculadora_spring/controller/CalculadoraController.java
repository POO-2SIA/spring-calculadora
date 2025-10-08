package br.fiap.calculadora_spring.controller;

import br.fiap.calculadora_spring.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller //Declara que a classe é um controller
public class CalculadoraController {

    //Criamos essa variável para er acesso ao service, que é responsável pelos cálculos das operações
    private final CalculadoraService service;

    //Usamos o construtor para inicializar o service
    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @PostMapping ("/calcular") //Declara que é um método
    public String calcular(@RequestParam String valor1, @RequestParam String valor2, @RequestParam String operacao, Model model) {
        //O método retorna uma string pois estamos retornando o index.html
        //Utilizamos o parâmetro model para retornar os dados ao navegador

        BigDecimal resultado = service.calcular(valor1, valor2, operacao);
        model.addAttribute("resultado", resultado);

        return "index";
    }
}
