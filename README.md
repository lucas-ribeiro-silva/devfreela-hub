# DevFreela Hub 🚀

![Status do Projeto](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

Plataforma **SaaS** para gestão de carreira de desenvolvedores freelancers, construída como um projeto de estudo e portfólio.

---

## 📝 Sobre o Projeto

O **DevFreela Hub** nasceu da necessidade de centralizar a vida de um desenvolvedor freelancer: **prospecção de clientes, gerenciamento de projetos, controle financeiro e desenvolvimento de carreira**. A plataforma visa ser a ferramenta definitiva para freelancers de tecnologia que buscam **profissionalismo e crescimento**.

Este projeto está sendo construído com uma **arquitetura evolutiva**, começando como um **monolito modular com Spring Boot** e evoluindo futuramente para **microsserviços**, com o objetivo de aprendizado e escalabilidade.

---

## 🛠️ Tecnologias Utilizadas

- **Backend:** Java 17, Spring Boot, Spring Data JPA
- **Banco de Dados:** PostgreSQL
- **Infraestrutura:** Docker
- **Build:** Maven
- **Mensageria:** RabbitMQ *(planejado)*
- **Cloud:** Azure *(planejado)*
- **CI/CD:** GitHub Actions *(planejado)*

---

## 🏁 Como Iniciar

Para rodar este projeto localmente, você precisará ter as seguintes ferramentas instaladas:

- Java JDK 17 ou superior
- Maven 3.8 ou superior
- Git
- Docker (para rodar o banco de dados PostgreSQL)

### 🔧 Passos para Configuração

#### 1. Clone o Repositório

```bash
git clone https://github.com/{seu-usuario-github}/devfreela-hub.git
cd devfreela-hub
2. Inicie o Banco de Dados com Docker
Execute o seguinte comando para subir um container PostgreSQL:

bash
Copiar código
docker run --name devfreela-db \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_DB=devfreela \
  -p 5432:5432 \
  -d postgres
3. Configure as Variáveis de Ambiente
Navegue até a pasta src/main/resources

Copie o arquivo application-dev.properties.example

Renomeie a cópia para application-dev.properties

Edite o novo arquivo (se necessário) com as seguintes configurações:

properties
Copiar código
# Configurações para ambiente de desenvolvimento local
spring.datasource.username=admin
spring.datasource.password=admin
4. Execute a Aplicação
Você pode executar o projeto de duas formas:

Pela IDE: Localize a classe DevfreelaHubApplication e clique em "Run"

Via terminal com Maven:

bash
Copiar código
mvn spring-boot:run
A API estará disponível em: http://localhost:8080

🤝 Como Contribuir
Este é um projeto de estudo, mas feedbacks e sugestões são sempre bem-vindos!

Abra uma Issue para relatar bugs ou sugerir melhorias

Faça um fork do repositório, crie sua branch e envie um Pull Request

Compartilhe este projeto com outros devs freelancers!