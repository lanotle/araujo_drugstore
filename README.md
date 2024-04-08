## api-automation-test-with-rest-assured

## Descrição
Este código foi desenvolvido para o desafio técnico da Drogaria Araujo. Estas instruções fornecerão uma cópia do projeto para execução e alteração em sua máquina local para fins de desenvolvimento e teste. Consulte as instruções abaixo para saber como baixar e executar o projeto.

## Frameworks e tecnologias
-   [Java](https://www.oracle.com/java/technologies/downloads/): Java é uma linguagem de programação orientada a objetos;
-   [Eclipse](https://www.eclipse.org/downloads/): Eclipse é uma IDE para desenvolvimento Java, porém suporta várias outras linguagens a partir de plugins como C/C++, PHP, ColdFusion, Python, Scala e Kotlin;
-   [Maven](https://maven.apache.org/download.cgi): O apache Maven ou Maven é uma ferramenta de automação de compilação;
-   [RestAssured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted): Rest-Assured é uma ferramenta que foi desenvolvida para facilitar a criação de testes automatizados para APIS Rest. Está oferece suporte para validar protocolo HTTP e requisições em JSON;
-   [TestNG](https://testng.org/#_download): TestNG é uma estrutura de teste para a linguagem java.
-   [java-faker](https://github.com/ReGYChang/java-faker): É uma biblioteca poderosa e flexível para gerar dados fictícios para vários casos de uso, como testes, prototipagem ou preenchimento de bancos de dados.

## Realizar download do Projeto

Acesse meu [GitHub](https://github.com/lanotle/araujo_drugstore), e clone o repositório para sua máquina.

## Importando o Projeto no Eclipse IDE
- No Eclipse, na barra de _menu_ clique em _File >> Import_, no painel _Import_, clique em _General >> Existing Projects into Workspace >> Next_.
- Clique em _Browse_… para informar o caminho da _workspace_ onde se encontra o projeto. A própria IDE identificará o projeto a ser importado. Isto no caso de só haver um projeto para importar.
- Uma vez concluída a importação, o projeto poderá ser localizado na  _view Project-Explorer_. Note que ele exibe um ponto de exclamação, indicando haver alguma inconsistência.
- Para resolver este problema realizaremos algumas configurações, assim, clique com o botão direito sobre o projeto que acabou de importar e vá em  _Properties_.
- No painel de propriedades do projeto importado em _Resource >> Java Build Path_, escolha a aba _Libraries_, selecione a opção do _JRE System Library [jdk] (unbound)_ e clique em _Edit_.
- No painel _Edit Library_, marque a opção _Alternate JRE_ e clique em _Finish_.
- Voltaremos ao _menu Properties,_ confirme clicando em _Apply_ e depois em _Apply and close_. Observe que o ponto de exclamação terá desaparecido.

## Descrição das classes e testes implementados neste repositório

- Classe **SetupGenericBase**: 
Esta classe contém configurações comuns e inicializações necessárias para todos os testes. 

- Classe **PetTest**: 
Esta classe testa operações relacionadas aos pets, como pesquisa por status, atualização e verificação de pets inexistentes.

- Classe **StoreTest**: 
Esta classe testa operações relacionadas aos pedidos na loja, como fazer um pedido e verificar a resposta para um pedido inválido.

Cenários no formato BDD (Behavior-Driven Development), linguagem mais descritiva e orientada para o comportamento e Gherkin.

Os métodos de teste na classe `PetTest` e `StoreTest` se alinham com a estrutura "_given, when, then_".

- **_Given_**: Esta parte do teste define o estado inicial ou as condições necessárias para executar o teste. 

- **_When_**: Nesta seção, a ação que está sendo testada é realizada. Normalmente, é onde a solicitação é feita à API que está sendo testada ou a função/algoritmo que está sendo testado é chamado.

- **_Then_**: Esta é a parte do teste onde o resultado é verificado. Verifica-se aqui se resposta da solicitação atende às expectativas, se os resultados são os esperados ou se as ações foram executadas com sucesso.

Em _PetTest_ temos:

    Feature: Operações relacionadas a Pets na API
    
    Scenario: Pesquisar pets com status pendente
        Given que um usuário deseja pesquisar pets com status pendente
        When a API é consultada para encontrar pets com status pendente
        Then os pets retornados devem todos ter o status pendente
    
    Scenario: Pesquisar por um pet inexistente
        Given que um usuário deseja pesquisar por um pet inexistente
        When a API é consultada para encontrar o pet com ID inválido
        Then a API deve retornar um código de status 404
    
    Scenario: Atualizar informações de um pet existente
        Given que um usuário deseja atualizar informações de um pet existente
        When a API é consultada para atualizar os detalhes do pet
        Then a API deve retornar um código de status 200 e o status do pet deve ser alterado para disponível

Em _StoreTest_ temos: 

    Feature: Operações relacionadas a pedidos na loja na API
    
    Scenario: Fazer um pedido válido na loja
        Given que um usuário deseja fazer um pedido válido na loja
        When a API é consultada para fazer um pedido
        Then a API deve retornar um código de status 200 e o status do pedido deve ser 'placed'
    
    Scenario: Fazer um pedido inválido na loja
        Given que um usuário deseja fazer um pedido inválido na loja
        When a API é consultada para fazer um pedido com dados inválidos
        Then a API deve retornar um código de status 400

## Executando os testes

Clique com o botão direito sobre _RestAssuredAutomation_, abrirá uma janela e nela, clique em _Run As >> Maven clean_ feito isso, clique novamente em _Run As >> Maven install_, neste momento os testes serão executados e você poderá verificar os resultados na aba console do Eclipse, ou navegar até a pasta _**target**_ >> _**sufire-reports**_, nela contém vários arquivos, um de nome _**index.html**_. Clique nele com o botão direito do mouse e na janela que se abrir, clique em _Open With_ >> _Web Browser_, neste momento, será aberto uma aba em seu navegador e nele será exibido o relatório da execução dos testes que você acabou de executar.
Em _Results_, em _Passed methods_, você pode clicar em _(show)_ e ter acesso a mais detalhes dos testes executados.

## Autor

Elton Lima - _Quality Assurance Analyst_
-   [GitHub](https://github.com/lanotle)
-   [Linkedin](https://www.linkedin.com/in/lanotle)
