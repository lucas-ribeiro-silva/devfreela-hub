# DevFreela Hub 🚀

![Status do Projeto](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

Plataforma SaaS para gestão de carreira de desenvolvedores freelancers, construída como um projeto de estudo e portfólio com Java e Spring Boot.

## 📝 Sobre o Projeto

O DevFreela Hub nasceu da necessidade de centralizar a vida de um desenvolvedor freelancer: prospecção de clientes, gerenciamento de projetos, controle financeiro e desenvolvimento de carreira. A plataforma visa ser a ferramenta definitiva para freelancers de tecnologia que buscam profissionalismo e crescimento.

Este projeto está sendo construído com uma arquitetura evolutiva, utilizando as melhores práticas do ecossistema Spring.

## ✨ Tecnologias e Conceitos Chave

* **Backend:** Java 17, Spring Boot, Spring Data JPA
* **Banco de Dados:** PostgreSQL (gerenciado com Docker)
* **Design de API:** RESTful, DTOs (Data Transfer Objects)
* **Validação:** Validação de negócio (email único)
* **Tratamento de Exceções:** Handler global com `@RestControllerAdvice` para respostas de erro padronizadas.
* **Build:** Maven

## 🏁 Como Iniciar

Para rodar este projeto localmente, você precisará ter as seguintes ferramentas instaladas:

* Java JDK 17 ou superior
* Maven 3.8 ou superior
* Git
* Docker

**Passos para configuração:**

### 1. Clone o Repositório

```bash
git clone [https://github.com/lucas-ribeiro-silva/devfreela-hub.git](https://github.com/lucas-ribeiro-silva/devfreela-hub.git)
cd devfreela-hub
```

### 2. Inicie o Banco de Dados

```bash
docker run --name devfreela-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=devfreela -p 5432:5432 -d postgres
```

### 3. Configure as Variáveis de Ambiente

Dentro da pasta `src/main/resources`, copie o arquivo `application-dev.properties.example` e renomeie a cópia para `application-dev.properties`. Os valores padrão já funcionarão com o comando Docker acima.

### 4. Execute a Aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 📡 Endpoints da API

A seguir estão os endpoints disponíveis na API.

### Recursos de Usuário (`/users`)

| Funcionalidade | Método HTTP | Endpoint | Corpo da Requisição (Exemplo) | Resposta de Sucesso |
| :--- | :--- | :--- | :--- | :--- |
| Criar Usuário | `POST` | `/users` | `{ "name": "Ada Lovelace", "email": "ada@email.com", "password": "123" }` | `200 OK` + JSON do usuário criado (DTO) |
| Listar Usuários | `GET` | `/users` | N/A | `200 OK` + Array de usuários (DTO) |
| Buscar por ID | `GET` | `/users/{id}` | N/A | `200 OK` + JSON do usuário (DTO) |
| Atualizar Usuário | `PUT` | `/users/{id}` | `{ "name": "Ada King", "email": "ada.king@email.com" }` | `200 OK` + JSON do usuário atualizado (DTO) |
| Deletar Usuário | `DELETE` | `/users/{id}` | N/A | `204 No Content` |

Exportar para as Planilhas

### Recursos de Projeto (`/projects`)

| Funcionalidade | Método HTTP | Endpoint | Corpo da Requisição (Exemplo) | Resposta de Sucesso |
| :--- | :--- | :--- | :--- | :--- |
| Criar Projeto | `POST` | `/projects` | `{ "title": "Novo Projeto", "description": "Descrição...", "totalCost": 5000, "ownerId": 1 }` | `200 OK` + JSON do projeto criado (DTO) |

Exportar para as Planilhas

## 🤝 Como Contribuir

Este é um projeto de estudo, mas feedbacks e sugestões são sempre bem-vindos! Sinta-se à vontade para abrir uma `Issue` para relatar um bug ou sugerir uma nova funcionalidade.