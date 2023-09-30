# CP4-Parte2-Testes-Unitarios

Escolher 2 exercícios e desenvolver a logica com
todos os cenários de testes.

### Exercícios escolhidos:

## Verificar Palíndromo
Crie uma função que verifique se uma determinada string é um
palíndromo. Um palíndromo é uma palavra, frase, número ou outra sequência
de caracteres que lê o mesmo para a frente e para trás (ignorando espaços,
pontuação e capitalização).

Exemplo:
Entrada: "A man, a plan, a canal, Panama" = Verdadeiro

Entrada: "hello" = Falso

Solução:

![Solução de Palindromo](./images/01%20-%20Solução%20palindromo.png)

Explicação: 
1. Na linha 19 estou passando um regex que aceita apenas letras, e retirando todos os espaços que a String pode ter, assim tenho certeza que só vai ser passado apenas letras para verificar o palíndromo.
2. Entre as linhas 23 a 26 realizei um FOR para percorrer todas as possições da palavra, pegando seu caracter e adicionando sempre antes do que já estava na String reverso
3. Na linha 28 verifico se a palavra inicial é igual a palavra reversa


## Número Máximo de Consecutivos
Dado um array binário, encontre a máxima sequência de uns consecutivos.

Entrada: [1, 1, 0, 1, 1, 1]

Retorno: 3

Solução:

![Solução de Consecutivos](./images/02%20-%20Solução%20Consecutivo.png)

Explicação: 
1. Na Linha 42 crio um Foreach que vai percorrer a quantidade de elementos que tem no array e pegar o valor.
2. Na Linha 43 Verifico se o numero é Binário (0 ou 1), se não for devolvo uma Exception e um erro
3. Na Linha 47 Verifico se o numero que está percorrendo no array naquele momento é (1), se for verdadeiro ira acrescentar ao contador e se for falso retorna o contador para 0
4.  Na Linha 49 verifico se o contador é maior que a quantidade maxima encontrada anteriormente
5. Na Linha 56 retorno um Response Entity 200 (OK) e o numero de consecutivos total
<br><br>

[Código implementado](./src/main/java/br/com/fiap/checkpoint/controller/CheackpointController.java)
# Testes unitários

[Código dos Testes unitários](./src/test/java/br/com/fiap/checkpoint/controller/CheckpointControllerTest.java)

<br>

<img alt="LinkedIn" title="linkedIn" src="./images/linkedin.png" width="20vw" height="20vh"> - <a href="https://www.linkedin.com/in/luisfelipe-gm/">Luís Felipe Garcia Menezes</a>
