# Projeto E-Diarista

Projeto desenvolvido durante o treinamento da [TreinaWeb](http://treinaweb.com.br) utilizando Java e Spring Boot


## Dependencias do projeto
- Spring Boot
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- Bean Validation

## Dependências de Desenvolvimento
- Spring Boot Dev Tools
- Lombok

## Requisitos
- Java 17
- Maven 4.0.0

## Como testar este projeto na minha máquina?

Clone este repositório e entre na pasta do projeto.

```sh
git clone https://github.com/qalintana/e-diarista.**git**
cd e-diaristas
```

Atualize as configurações de acesso ao banco de dados no arquivo [application.properties](src/main/resources/application.properties)
```properties

spring.datasource.url=jdbc:mysql://host:porta/dbname?useTimezone=true&serverTimezone=Africa/Luanda
spring.datasource.username=usuario
spring.datasource.password=senha


#hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#thymeleaf
spring.thymeleaf.cache=false
```