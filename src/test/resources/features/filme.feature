#language:pt

  @regressivo @regressivofilmes
  Funcionalidade: CRUD Filme
    Testes Automatizados da API de Filmes

    Contexto:
      Dado que tenha realizado o login com dados validos
      E que tenha um payload valido da API de Filme

    @cadastrarFilme
    Cenario: Cadastro de Filme
      Quando envio uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
      E armazeno o id que recebo do response de Filme

    @consultarFilme
    Cenario: Consulta de Filme cadastrado
      Quando realizo uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

    @alterarFilme
    Cenario: Alteracao de Filme
      E altero o indice 1 da lista de categorias do filme com os valores
        | tipo | Terror |
      Quando realizo uma requisicao do tipo PUT de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

    @consultarFilmeAposAlteracao
    Cenario: Consulta Filme apos alteracao
      Quando realizo uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

    @excluirFilme
    Cenario: Exclusao de Filme
      Quando realizo uma requisicao do tipo Delete de Filme
      Entao valido que recebo status 200 no response

    @consultarFilmeAposExclusao
    Cenario: Consulta Filme apos exclusao
      Quando realizo uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que recebo uma lista vazia no response