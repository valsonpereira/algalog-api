# AlgaLog-API 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/valsonpereira/projeto-sds3/blob/master/LICENSE) 

# Sobre o projeto

AlgaLog é uma API REST desenvolvida utilizando Spring Boot para gerenciamento de serviços de entrega. A aplicação foi implementada durante o evento gratuito Mergulho Spring REST promovido pela AlgaWorks.

### Link da API em Produção 
https://algalog-api-valson.herokuapp.com/swagger-ui.html

Obs.: Em razão do deploy do back-end ser realizado utilizando o plano gratuito do Heroku, o dashboard pode levar alguns segundos para exibir os dados.

## Modelo conceitual
![Modelo Conceitual](https://github.com/valsonpereira/my-assets/blob/main/modelo-conceitual-algalog.jpg)

# Tecnologias utilizadas
## API REST
- Java 17
- Spring Boot
- Spring Data JPA 
- Spring Validation
- Flyway
- Lombok
- Swagger
- ModelMapper
- Maven

## Implantação em produção
- Heroku
- Banco de dados: PostgreSQL 14

# Como executar o projeto

## Pré-requisitos
- Java 17
- Banco de dados PostgreSQL 14

```bash
# clonar repositório
git clone https://github.com/valsonpereira/algalog-api.git

# entrar na pasta do projeto back-end
cd algalog-api

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Valson Pereira

https://www.linkedin.com/in/valson-pereira/
