package br.com.fiap.checkpoint.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheckpointControllerTest {

    private CheackpointController checkpointController = new CheackpointController();

    // Testes do EXERCICIO 7 - Verificar Palíndromo

    @Test
    public void testPalindromoEVerdadeiro(){
        String palindromo = "madam";
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(true, resposta);
    }

    @Test
    public void testPalindromoComFraseEVerdadeiro(){
        String palindromo = "A man, a plan, a canal, Panama";
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(true, resposta);
    }

    @Test
    public void testNaoPalindromoComCaracteresDiferentesReverso() {
        String palavra = "hello";
        boolean resposta = checkpointController.isPalindrome(palavra);
        assertEquals(false, resposta);
    }

    @Test
    public void testPalindromoComFraseEFalso(){
        String palindromo = "Digital Business Enablement";
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(false, resposta);
    }

    @Test
    public void testPalindromoComCaracteresEspeciaisNoMeio(){
        String palindromo = "p*&$%*a#-()_p*¨%"; // Utilizando o regex a palavra vai ser pap
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(true, resposta);
    }

    @Test
    public void testPalindromoComEspaçosEmBranco(){
        String palindromo = "A m a n , a p l a n, a c a n a l, P a n a m a";
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(true, resposta);
    }

    @Test
    public void testPalindromoComPalavraMaiusculasEMinusculas(){
        String palindromo = "DiGiTal BuSiNeSs EnAbLeMeNt";
        boolean resposta = checkpointController.isPalindrome(palindromo);
        assertEquals(false, resposta);
    }

    // Testes do EXERCICIO 5 - Número Máximo de Consecutivos

    @Test
    public void testMaiorQuantidadeDeUnsNoComeço(){
        int[] numeros = {1,1,1,0,0,1,1};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("3");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMaiorQuantidadeDeUnsNoMeio(){
        int[] numeros = {1,0,1,1,1,1,0,1};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("4");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMaiorQuantidadeDeUnsNoFinal(){
        int[] numeros = {1,0,1,1,0,0,1,1,1,1,1};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("5");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testEnviandoNumeroSemSerBinario(){
        int[] numeros = {1,0,1,1,0,2};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.badRequest().body("ACEITO APENAS 1 ou 0! Numero inválido: 2");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMatrixVazia(){
        int[] numeros = {};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("0");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMatrixApenasComZeros(){
        int[] numeros = {0,0,0,0,0};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("0");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMatrixApenasComUns(){
        int[] numeros = {1,1,1,1,1};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("5");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMatrixComZerosEUnsIntercalados(){
        int[] numeros = {0,1,0,1,0,1,0,1};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("1");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }

    @Test
    public void testMatrixComUmElemento(){
        int[] numeros = {0};
        ResponseEntity<String> maxConsecutivesOnes = checkpointController.findMaxConsecutivesOnes(numeros);
        ResponseEntity<String> expectedResponse = ResponseEntity.ok().body("0");

        assertEquals(expectedResponse.getStatusCode(), maxConsecutivesOnes.getStatusCode());
        assertEquals(expectedResponse.getBody(), maxConsecutivesOnes.getBody());
    }


}
