# Entryway Project

Este é um projeto Spring chamado Entryway, que utiliza o Spring Boot para facilitar o desenvolvimento de uma aplicação Java.

## Pré-requisitos

Certifique-se de ter os seguintes itens instalados em sua máquina antes de iniciar o projeto:

- Java JDK 8 ou superior
- PostgreSQL instalado localmente
- Maven

## Configuração do Banco de Dados

O projeto utiliza o PostgreSQL como banco de dados. Certifique-se de ter um banco de dados PostgreSQL em execução localmente.

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/entryway
    driver-class-name: org.postgresql.Driver
    username: entryway
    password: entryway
  jpa:
    properties.hibernate:
      generate_statistics: false
      order_by:
        default_null_ordering: last
    hibernate:
      dialect: org.hibernate.dialect.PostgreSQL95alect
      ddl-auto: validate
    open-in-view: true
    show-sql: false
  liquibase:
    change-log: classpath:db/changelog/changeLog.entryway.default.xml
    default-schema: public