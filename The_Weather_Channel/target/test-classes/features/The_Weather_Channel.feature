# language: pt


Funcionalidade: Consultar Previsão do Tempo
    Eu como usuário, quero efetuar consultas sobre a previsão do tempo.

  Contexto:
    Dado que eu esteja no site do Weather Channel

  @Cenario01
  Cenário: Consultar a previsão do tempo pra daqui a 5 dias em Recife
    Quando eu pesquisar pela cidade de Recife
    Então o sistema irá exibir a previsão do tempo de Recife
    E eu clico na opção para a previsão do tempo para cinco dias a frente
    Então o sistema irá exibir a previsão do tempo para daqui a cinco dias

  @Cenario02
  Cenário: Visualiziar mapa em infravermelho da cidade do Recife
    Quando eu pesquisar pelo mapa da cidade do Recife
    E selecionar a opcao de Infravermelho
    Então o sistema ira exibir a camada de infravermelho sobre o mapa

  @Cenario3
  Cenario: Exibir previsão especial para rastrear alergias do dia de hoje
    Quando eu pesquisar pelo mapa de Recife
    E selecionar a opcao para rastrear alergias em previsoes especiais
    E selecioar a perspectiva diaria de respiracao
    Entao o sistema ira exibir as informacoes referentes a Temperatura, Uminade, Precipitacao e Vento.

  @Cenario4
  Cenario: Consultar qual foi a temperatura registrada em Recife no dia 01/12/2018
    Quando eu pesquisar pelo mapa da cidade do Recife
    E seleciona a opcao de Mensal
    E selecionar a data de um de janeiro de dois mil e dezenove
    Entao o sistema exibe a informacao da temperatura registrada.

  @Cenario5
  Cenario: Consultar qual a descrição da previsao do tempo para o proximo fim de semana em Recife
    Quando eu pesquisar pelo mapa da cidade do Recife
    E selecionar a opcao Fim de Semana
    E selecionar o dia de Sabado da lista de Proximo fim de semana
    Então o sistema exibe as informacoes Temperatura, Vento, Umidade e Indice UV