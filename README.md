# API RESTful com Java - myContacts

Este README está disponível em [English](README.en.md).

### O que é esse projeto?

Este projeto é um estudo sobre API RESTful usando o Java. Ele é bem simples porque eu não tinha nenhuma pretensão além de absorver o conteúdo e botar em prática, então eu basicamente tenho: 

- Uma classe Contact que cria um objeto com os atributos id, nome, telefone e email;
- Uma classe ContactHelper que contém um array de objetos do tipo Contact mais alguns métodos pra eu poder manipulá-lo;
- E uma classe ContactResource com os métodos GET, POST, PUT e DELETE.

### O que eu usei?

Pra esse projeto eu usei:
- Maven
- JDK 8
- Tomcat v8.5.

### Sobre o projeto

O material que eu estudei enquanto desenvolvia esse negócio cobria um pouco de conceitos de POO até o básico de REST, então eu não lidei com banco de dados (por isso que tem um array fazendo esse papel). Vale notar que existem dois métodos GET, um deles recebe um parâmetro *id* pra retornar um contato específico (o DELETE também usa, só que pra localizar um contato e removê-lo). Eu usei o Jersey (1.19.4) pra implementar o REST e usei o Weld (2.2.16) junto com o RESTEasy (3.1.4) pra injeção de dependências. Eu vi também um pouco de testes unitários e tratamento de excessões mas não quis ir muito a fundo porque eu vou fazer um outro projeto pra mexer com banco de dados e coisa e tal. Foi usado o JUnit (4.13.1) e o Mockito (1.10.19).

Acho que isso é tudo.

Éde