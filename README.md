
# 🧵 Forum API - Sistema de Discussões com Spring Boot

API RESTful desenvolvida com Spring Boot para gerenciamento de tópicos e respostas em um fórum de discussões. Oferece autenticação JWT, controle de usuários, respostas, tópicos por curso, além de boas práticas REST, validações e segurança.

---

## ✅ Funcionalidades

- 🔐 Autenticação via JWT
- 👥 Gerenciamento de usuários
- 🧵 Criação, listagem, edição e exclusão de tópicos
- 💬 Respostas a tópicos
- 🏷️ Filtro de tópicos por curso
- ✅ Marcar tópicos como resolvidos
- 🔎 Paginação e ordenação
- ⚠️ Validação de dados
- 📘 Documentação com Swagger/OpenAPI

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Flyway (migrations)
- JWT (Auth0)
- Swagger / OpenAPI
- Lombok

---

## 📦 Pré-requisitos

- Java 17+
- Maven 3.8+
- MySQL 8+

---

## ⚙️ Configuração

1. **Clone o projeto:**
```bash
git clone https://github.com/seu-usuario/forum-api.git
cd forum-api
````

3. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

As tabelas serão criadas automaticamente via Flyway.

---

## 🔐 Autenticação

A autenticação é baseada em tokens JWT.

### ➕ Login

**Endpoint:** `POST /login`
**Body:**

```json
{
  "username": "usuario",
  "senha": "senha"
}
```

**Resposta:**

```json
{
  "tokenJWT": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

Use o token nas requisições autenticadas:

```
Authorization: Bearer SEU_TOKEN
```

---

## 📚 Principais Endpoints

### 🔸 Tópicos

| Método | Rota                     | Ação                           |
| ------ | ------------------------ | ------------------------------ |
| GET    | `/topicos`               | Listar tópicos (paginação)     |
| GET    | `/topicos/{id}`          | Detalhar tópico                |
| GET    | `/topicos/curso/{curso}` | Filtrar por curso              |
| POST   | `/topicos`               | Criar novo tópico              |
| PUT    | `/topicos/{id}`          | Atualizar tópico               |
| DELETE | `/topicos/{id}`          | Excluir tópico                 |
| DELETE | `/topicos/resolved/{id}` | Marcar como resolvido (lógico) |

### 🔸 Usuários

| Método | Rota             | Ação                   |
| ------ | ---------------- | ---------------------- |
| POST   | `/usuarios`      | Cadastrar novo usuário |
| GET    | `/usuarios`      | Listar usuários        |
| PUT    | `/usuarios/{id}` | Atualizar usuário      |
| DELETE | `/usuarios/{id}` | Deletar usuário        |

---

## 🧪 Testando a API

* **Swagger UI:** `http://localhost:8080/swagger-ui.html`
* **Postman/Insomnia:** Utilize os endpoints e tokens JWT gerados

---

## 📁 Estrutura de Pastas

```bash
src/
├── controller      # Camada REST
├── dto            # Data Transfer Objects
├── model          # Entidades JPA
├── repository     # Acesso a dados
├── service        # Lógica de negócio
├── configurations # Segurança, exceções
└── ForumApplication.java
```

---

## 🔐 Segurança

* Senhas criptografadas com `BCrypt`
* Token JWT assinado com HMAC-256
* Expiração de token configurada via `application.properties`

---

:octocat:   SOBRE A DESENVOLVEDORA  

![Isabela Marques](https://github.com/user-attachments/assets/76a8e0d4-8a08-45cd-9e9b-18f70cc0122c)

🎓 Isabela Cavalcante Marques  
💼 Estudante no programa Oracle ONE + Alura  
🌐 GitHub: [@Isabelaestuda](https://github.com/Isabelaestuda)  



