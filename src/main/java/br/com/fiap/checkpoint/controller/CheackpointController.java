package br.com.fiap.checkpoint.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkpoint")
public class CheackpointController {


    // EXERCICIO 7 - Verificar Palíndromo
    @PostMapping("/is-palindrome")
    public boolean isPalindrome(@RequestBody String palavra){
        // Utilizando o Regex é permitido apenas letras
        String palindromo = palavra.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reverso = "";
        char caracter;

        for(int i=0; i < palindromo.length(); i++){
            caracter = palindromo.charAt(i);
            reverso = caracter + reverso;
        }

        if(palindromo.equals(reverso)){
            return true;
        } else {
            return false;
        }

    }

    // EXERCICIO 5 - Número Máximo de Consecutivos
    @PostMapping("/max-consecutive-one")
    public ResponseEntity<String> findMaxConsecutivesOnes(@RequestBody int[] numeros){
        int maximo = 0;
        int atual = 0;

        for(int numero : numeros){
            if(numero != 1 && numero != 0){
                String mensagemErro = "ACEITO APENAS 1 ou 0! Numero inválido: " + numero;
                return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
            }
            if(numero == 1){
                atual++;
                if (maximo < atual) {
                    maximo = atual;
                }
            } else {
                atual = 0;
            }
        }
        return new ResponseEntity<>(String.valueOf(maximo), HttpStatus.OK);
    }



}
