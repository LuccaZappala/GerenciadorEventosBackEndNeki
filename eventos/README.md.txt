# 📅 Gerenciador de Eventos API - Neki

API RESTful desenvolvida como parte do processo seletivo da Neki. O sistema permite o gerenciamento de eventos por administradores autenticados, utilizando segurança JWT.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Security & JWT** (io.jsonwebtoken)
* **Spring Data JPA**
* **PostgreSQL** (Banco de dados)
* **Swagger (SpringDoc OpenAPI)** (Documentação)
* **Maven** (Gerenciador de dependências)

## 🔐 Funcionalidades e Segurança

A API implementa um sistema de autenticação **Stateless** via Token JWT:
- **Cadastro e Login**: Rotas públicas para registro de novos administradores e autenticação.
- **Proteção de Rotas**: Todas as operações de eventos exigem o envio do token no Header `Authorization: Bearer <seu_token>`.
- **Relacionamento**: Cada evento é vinculado obrigatoriamente a um administrador.

## 🛠️ Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/LuccaZappala/GerenciadorEventosBackEndNeki.git
    ```

2.  **Configuração do Banco de Dados:**
    Certifique-se de que o PostgreSQL está rodando e ajuste as credenciais no arquivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/eventos_db
    spring.datasource.username=postgres
    spring.datasource.password=123456
    ```

3.  **Execute a aplicação:**
    Utilizando sua IDE (Eclipse/IntelliJ) ou via terminal:
    ```bash
    mvn spring-boot:run
    ```

## 📖 Documentação (Swagger)

Com a aplicação rodando, acesse a documentação interativa para testar os endpoints:
`http://localhost:8080/swagger-ui/index.html`

> **Dica para teste:** Para acessar as rotas de eventos no Swagger, clique em **Authorize**, insira o token gerado no login (apenas o código) e clique em confirmar.

## 📌 Endpoints Principais

| Método | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- |
| POST | `/administradores/cadastrar` | Registra um novo admin | Público |
| POST | `/administradores/login` | Autentica e retorna o Token | Público |
| GET | `/eventos` | Lista eventos do admin logado | Privado |
| POST | `/eventos` | Cria um novo evento | Privado |
| PUT | `/eventos/{id}` | Atualiza data/localização | Privado |
| DELETE | `/eventos/{id}` | Remove um evento | Privado |

---
Desenvolvido por **Lucca Zappala Jurado** 🚀