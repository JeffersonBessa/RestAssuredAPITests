#language:pt

  @regressivo @regressivocategorias
  Funcionalidade: Consultar Categoria
    Testes Automatizados da API de Categoria de Filmes

  @consultarCategoriaComSucesso
  Cenario: Realizar Consulta de Categoria com Sucesso
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Categoria
    Quando realizo uma requisicao do tipo GET de Categoria
    Entao valido que recebo status 200 no response
    E valido que no campo "tipo[2]" possui o valor "Terror"

  @consultarCategoriaSemToken
  Cenario: Realizar Consulta de Categoria sem token de acesso
    Quando realizo uma requisicao do tipo GET de Categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  @consultarCategoriaComTokenInvalido
  Cenario: Realizar Consulta de Categoria com token de acesso invalido
    Dado que altero o campo "Authorization" para "invalido" do header de categoria
    Quando realizo uma requisicao do tipo GET de Categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"