# Pokedex - Mvvm

#### Nesse repositório, decidi abrigar uma abordagem peculiar ao tão conhecido mvvm.

O projeto consiste em uma simples pokedéx, onde fazemos buscas por fotos de pokémons, e também, conseguimos listar-os.

Para conseguirmos entender melhor a partir de agora, vamos ter a premissa que temos em mente um ponto principal ao pensar nessa aplicação.

* 1 - Ela precisa escalar 

Isso quer dizer que todas as práticas adotadas nesse projeto são altamente escaláveis ? ( Infelizmente não rsrs.)

## Arquitetura 

Quando pensamos em mvvm, um diagrama logo nos vem a cabeça onde : View < - > ViewModel < - Model | é o caminho mais fácil/comum. Mas, desde a
primeira vez que tive contato com o mesmo, contrariado fiquei por questionar constantemente a negativa influência na produtividade que várias
classes de contextos diferentes em camadas iguais fariam.

Com esse ímpeto, depois de muitas pesquisas em fórums, consegui me deparar com um modelo claro onde o mvvm poderia escalar em um contexto 
modularizado, dividindo a aplicação em duas camadas principais, sendo, 'Feature' e 'Plugin'

Quando pensamos em Feature :
* nova feature, nova task, nova implementação, jira, trello ... ? e por aí vai

Quando pensamos em Plugin :
* Plugar a aplicação ? Plug de dados ? ....

Mas o que realmente queremos abordar aqui é: 

## Dado uma funcionalidade, ela fica isolada em seu próprio contexto, respeitando sua posição no fluxo da arquitetura mvvm.

##### Vejamos : 
![alt text](https://docs.google.com/uc?export=download&id=1JLO7W7wgKRPD2-gywmLs-3vi9ByaGgRS)

A imagem exemplifica a afirmação acima, e percebemos isso quando vemos views e viewsModels dentro da camada de feature.

Mas, e o resto da aplicação não seria uma feature também ? 

A resposta é NÃO e eu vou explicar.

* Quando pegamos o nosso liquidificador para fazer o que quer que seja, precisamos `plugá-lo` na tomada, não é mesmo ?

Com essa pequena anedota eu digo : 
