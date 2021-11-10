# Pokedex - Mvvm

#### Nesse repositório, decidi abrigar uma abordagem peculiar ao tão conhecido mvvm.

O projeto consiste em uma pokedéx, onde fazemos buscas por fotos de pokémons, e também, conseguimos listar-os.

Para conseguirmos entender melhor a partir de agora, vamos ter a premissa que temos em mente um ponto principal ao pensar nessa aplicação.

* 1 - Ela precisa escalar 

## Arquitetura 

Quando pensamos em MVVM, um diagrama logo nos vem a cabeça onde : View < - > ViewModel < - Model | é o caminho mais fácil/comum.

Nessa abordagem, entretanto, pensamos no mesmo fluxo dividido em duas camadas | Feature e Plugin

Onde: 

* Feature -> Views e ViewsModel
* Plugin -> Plug que te conecta ao backend | model

`Dado uma funcionalidade ela fica embarcada no seu próprio contexto, conectado a um plugin correspondente e aos utilitários convenientes`

#### Vejamos : 
![alt text](https://docs.google.com/uc?export=download&id=1JLO7W7wgKRPD2-gywmLs-3vi9ByaGgRS)

A imagem exemplifica a afirmação acima, e percebemos isso quando vemos views e viewsModels dentro da camada de feature e repository e services 
na camada de plugin e a conexão entre as duas é feito via injeção de dependência

#### Escalando, percebemos que: 
![alt text](https://docs.google.com/uc?export=download&id=1_RLcYOinlPsXKV5ptiR358u-wQ2pfYTd)

# Entendendo melhor a aplicação

Como já mencionado, aqui falamos sobre uma pokédex. Onde, dado o nome de um pokémon, buscamos via http request a url de uma imagem, e retornamos via
`observe` para a camada de view, onde mostramos ao usuário.

# Pontos incompletos : 

* Injeção de dependência | Pensando no fluxo simples da aplicação e necessidade de escalabilidade pode ser necessário avaliar outra lib de DI (como Koin, ou Hilt)
por causa do ônus de build e verbosidade gerado pelo dagger

* Testes unitários

* Feature/pokeList

* Validaação de firstOpen (LandingBottomSheet só deve aparecer para quem abre o app pela primeira vez)

* Pipeline de CI/CD com Firebase e a Lib wzieba/Firebase-Distribution-Github-Action@v1.2.1
