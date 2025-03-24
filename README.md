# 🌐 Microsserviços com Java e Spring Cloud ☁️🍃

Este projeto é um simples sistema de gerenciamento de tarefas baseado em arquitetura de microserviços utilizando **Spring Cloud**. Ele consiste em três serviços independentes que se comunicam entre si.

## 🛠️ Tecnologias Utilizadas

- **☕ Java** - Linguagem de programação utilizada no desenvolvimento dos serviços.
- **🍃 Spring Boot** - Framework para facilitar a configuração e o desenvolvimento de aplicações Java.
- **☁️ Spring Cloud** - Conjunto de ferramentas para construção de aplicações distribuídas.
- **🔎 Eureka Server (Service Discovery)** - Serviço de registro e descoberta de microserviços.
- **🔗 OpenFeign** - Biblioteca para comunicação entre microserviços de forma simplificada.
- **🐳 Docker** - Plataforma para containerizar os microsserviços, garantindo consistência no ambiente de execução.
- **🗄️ H2 Database** - Banco de dados em memória para armazenamento temporário.
- **📦 Maven** - Gerenciador de dependências e automação de builds.
- **✨ Lombok** - Biblioteca para reduzir código boilerplate em Java.

## 🏗️ Arquitetura

- 🔧 **Service Main**: Responsável por orquestrar os demais serviços.
- 📋 **Tasks Service**: Responsável por criar e gerenciar as tarefas.
- 🔔 **Notification Service**: Responsável por enviar notificações para tarefas que estão prestes a vencer.

## 🚀 Como Executar o Projeto

1. Clonar o repositório

    ```bash
    git clone https://github.com/joschonarth/java-microservices.git
    ```

2. Entrar no diretório do projeto:

    ```bash
    cd java-microservices
    ```

3. Subir os serviços com Docker Compose

    ```bash
    docker-compose up --build
    ```

  > Isso irá iniciar todos os serviços automaticamente.

## 🔗 Endpoint

### 📝 Criar Tarefa

- **Método:** `POST`

- **Rota:** `http://localhost:8081/tasks`

- **Descrição:** Permite a criação de uma nova tarefa no sistema.

- **Corpo da Requisição:**

  ```json
  {
    "title": "Tarefa de Teste",
    "email": "johndoe@example.com",
    "dueDate": "2025-03-24T15:00:00",
    "notified": false
  }
  ```

- **Resposta:**

  ```json
  {
    "id": 1,
    "title": "Tarefa de Teste",
    "email": "johndoe@example.com",
    "dueDate": "2025-03-24T15:00:00",
    "notified": false
  }
  ```

### 🔔 Log do Service Notification

Se a tarefa estiver prestes a vencer, o **Notification Service** irá gerar um log notificando o responsável:

  ```bash
  ===== ATENÇÃO ===== 
  -----------------------------
  SUA TAREFA "Tarefa de Teste" ESTÁ PRESTES A VENCER!
  -----------------------------
  ```

## 📡 Comunicação entre Microsserviços

- 🔍 **Eureka Server**: Todos os serviços se registram automaticamente no **Eureka Server** (Service Main), que atua como um servidor de descoberta. Isso permite que os microsserviços se localizem e se comuniquem dinamicamente, sem a necessidade de configuração manual de endpoints.

- 🌐 **Tasks Service e Notification Service**: O **Tasks Service** se comunica com o **Notification Service** utilizando **OpenFeign**. Isso facilita a chamada de APIs entre serviços de forma simples e declarativa, permitindo que o **Tasks Service** envie notificações para os usuários quando suas tarefas estiverem prestes a vencer.

## 🤝 Contribuição

Sinta-se à vontade para contribuir! Fique à vontade para abrir issues e pull requests.

## 📬 Contato

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joschonarth/)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:joschonarth@gmail.com)