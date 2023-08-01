
# Desafio Técnico - Rodrigo Vidal

Desafio técnico que consiste em criar um Backend com Springboot ou Quarkus, se comunicar com uma API Externa, obter os dados e exibir em um formulário no Frontend usando Angular 9+.




## Clonar os dois Repositórios

[Backend](https://linktodocumentation)
[Frontend](https://github.com/rodrigovsousa/desafio-tecnico-frontend)

## Instalação Docker e Docker-Compose

[Windows](https://docs.docker.com/desktop/install/windows-install/)
[Linux](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/How-to-install-Docker-and-docker-compose-on-Ubuntu)

## Instalação Maven
[Windows](https://phoenixnap.com/kb/install-maven-windows)
[Linux](https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu)




## Deploy Backend

Instalação das dependências:

```bash
  mvn clean install
```

Criação do arquivo Jar:

```bash
  mvn clean package
```

Criação e download da Imagem Docker:

```bash
  docker build -t springio/gs-spring-boot-docker .
```
Executar na raiz do projeto o comando:

```bash
  docker-compose up
```
## Deploy Frontend

Instalação das dependências:

```bash
  npm install
```

Executar na raiz do projeto o comando:

```bash
  npm run start
```

Abrir a aplicação no navegador com o Link:

```bash
  http://localhost:4200/worldbank-indicators
```

## Testes Frontend e Backend

Executar para o Frontend:

```bash
  npm run test
```
Executar para o Backend:
```bash
  mvn test
```

## Swagger UI
```bash
  http://localhost:8080/swagger-ui/index.html#/poverty-data-controller/getAllPovertyIndicators
```
## Critérios de Aceite

- Dado um Usuário,
- QUANDO acessar a tela principal,
- E deverá visualizar um formulário com um Campo
- E o campo deverá ter um limite de até dois caracteres
- E deverá aprensentar a mensagem de erro caso submetido sem a sigla.


## Cenários de Teste
- Testar se a mensagem de field vazio aparece.
- Testar Limite de caracteres.
- Testar buscar de dados.
- Testar se o Dialog de erro é mostrado caso não ache dados para a sigla informada.
- Testar se o Dialog de erro é mostrado quando ocorre erro de servidor.(Esse cenário basta desligar o backend)
