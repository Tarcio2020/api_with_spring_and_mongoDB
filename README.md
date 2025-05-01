# 📦 API com MongoDB

Este é um projeto de API RESTful desenvolvida com **Spring Boot** e **MongoDB**, com foco em operações CRUD para usuários e posts, incluindo comentários e autores.

## 📁 Estrutura do Projeto

```
apiWithMongodb/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.tarcioteles.apiWithMongodb/
│   │   │       ├── config/
│   │   │       ├── domain/
│   │   │       ├── dto/
│   │   │       ├── repositories/
│   │   │       ├── resources/
│   │   │       ├── services/
│   │   │       └── ApiWithMongodbApplication.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com.tarcioteles.apiWithMongodb/
├── .gitignore
├── pom.xml
└── README.md
```

## 🔗 Endpoints Disponíveis

### 🧑‍💻 Usuários (`/users`)

- `GET /users` – Lista todos os usuários.
- `GET /users/{id}` – Busca um usuário pelo ID.
- `POST /users` – Cria um novo usuário.
- `PUT /users/{id}` – Atualiza os dados de um usuário existente.
- `DELETE /users/{id}` – Remove um usuário.
- `GET /users/{id}/posts` – Lista os posts de um usuário.

### 📝 Posts (`/posts`)

- `GET /posts/{id}` – Retorna os detalhes de um post.

## 🗄️ Estrutura do Banco de Dados (MongoDB)

### 📄 Coleção `user`

- `id`: Identificador único.
- `name`: Nome do usuário.
- `email`: Email do usuário.
- `posts`: Lista de posts relacionados.

### 📄 Coleção `post`

- `id`: Identificador único.
- `date`: Data da postagem.
- `title`: Título do post.
- `body`: Conteúdo do post.
- `author`: Autor do post (referência ao usuário).
- `comments`: Lista de comentários.

## 📦 Classes DTO

As DTOs (Data Transfer Objects) simplificam a transferência de dados entre camadas da aplicação:

- **`UserDTO`** – Informações resumidas de um usuário.
- **`AuthorDTO`** – Informações básicas do autor de um post.
- **`CommentDTO`** – Representa um comentário com autor e data.

## ▶️ Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/apiWithMongodb.git
   cd apiWithMongodb
   ```

2. **Compile e execute o projeto usando Maven**:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acesse a API via navegador ou Postman**:
   ```
   http://localhost:8080
   ```

## 👨‍💻 Autor

Projeto desenvolvido por **Tarcio Teles**.

## 📄 Licença

Este projeto está licenciado sob a **Apache License 2.0**.

---
