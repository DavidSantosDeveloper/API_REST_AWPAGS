## 📊 AWPAGS

### 📖 Descrição do Projeto
Este projeto consiste em uma API REST para a gestão de dados de parcelamento utilizando Hibernate, PostgreSQL e práticas de arquitetura DDD. A API oferece funcionalidades para operações CRUD sobre diferentes entidades, com validação de campos e versionamento de banco de dados com Flyway.

---

### ⚙️ Pré-requisitos
Antes de executar a aplicação, certifique-se de ter instalad:

- **Java 11+**
- **Maven** para gerenciamento de dependências
- **PostgreSQL 16+**
- **IDE** (Ex.: IntelliJ IDEA, Eclipse)

---

### 🚀 Instruções para Executar a Aplicação

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DavidSantosDeveloper/API_REST_AWPAGS.git
   cd API_REST_AWPAGS
   ```

2. **Configure o banco de dados PostgreSQL:**

   - Crie o banco de dados no PostgreSQL.
   - Atualize as configurações no arquivo `application.properties`:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     ```

3. **Compile e execute a aplicação:**

   ```bash
   mvn spring-boot:run
   ```

---

### 📘 Endpoints Disponíveis

A API oferece os seguintes endpoints para gerenciamento de dados:

#### 1. **Clientes**

- **GET /clientes**: Lista todos os clientes.
- **POST /clientes**: Cria um novo cliente.
- **PUT /clientes/{id}**: Atualiza um cliente existente.
- **DELETE /clientes/{id}**: Remove um cliente.

#### 2. **Parcelamentos**

- **GET /parcelamentos**: Lista todos os parcelamentos.
- **POST /parcelamentos**: Cria um novo parcelamento.
- **PUT /parcelamentos/{id}**: Atualiza um parcelamento existente.
- **DELETE /parcelamentos/{id}**: Remove um parcelamento.

--


### 📘 Exemplos de Endpoints

#### 1. **Clientes**

- **GET /clientes**
  Retorna todos os clientes cadastraos.

  **Exemplo de resposta:**

  ```json
  [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao@example.com",
      "telefone": "123456789"
    },
    {
      "id": 2,
      "nome": "Maria Oliveira",
      "email": "maria@example.com",
      "telefone": "987654321"
    }
  ]
  ```



- **POST /clientes**
  Cria um novo cliete.

  **Exemplo de corpo da requisição:**

  ```json
  {
    "nome": "Carlos Souza",
    "email": "carlos@example.com",
    "telefone": "1122334455"
  }
  ```



  **Exemplo de resposta:**

  ```json
  {
    "id": 3,
    "nome": "Carlos Souza",
    "email": "carlos@example.com",
    "telefone": "1122334455"
  }
  ```



- **PUT /clientes/{id}**
  Atualiza as informações de um cliente existete.

  **Exemplo de corpo da requisição:**

  ```json
  {
    "nome": "Carlos Souza Atualizado",
    "email": "carlos_atualizado@example.com",
    "telefone": "1122334455"
  }
  ```



  **Exemplo de resposta:**

  ```json
  {
    "id": 3,
    "nome": "Carlos Souza Atualizado",
    "email": "carlos_atualizado@example.com",
    "telefone": "1122334455"
  }
  ```



- **DELETE /clientes/{id}**
  Remove um cliente do sistema.

  **Exemplo de resposta:**

  ```json
  {
    "mensagem": "Cliente removido com sucesso."
  }
  ```



#### 2. **Parcelamentos**

- **GET /parcelamentos**
  Retorna todos os parcelamentos cadastraos.

  **Exemplo de resposta:**

  ```json
  [
    {
      "id": 1,
      "descricao": "Parcelamento em 3 vezes",
      "quantidadeParcelas": 3
    },
    {
      "id": 2,
      "descricao": "Parcelamento em 6 vezes",
      "quantidadeParcelas": 6
    }
  ]
  ```



- **POST /parcelamentos**
  Cria um novo parcelameto.

  **Exemplo de corpo da requisição:**

  ```json
  {
    "descricao": "Parcelamento em 12 vezes",
    "quantidadeParcelas": 12
  }
  ```



  **Exemplo de resposta:**

  ```json
  {
    "id": 3,
    "descricao": "Parcelamento em 12 vezes",
    "quantidadeParcelas": 12
  }
  ```



- **PUT /parcelamentos/{id}**
  Atualiza as informações de um parcelamento existete.

  **Exemplo de corpo da requisição:**

  ```json
  {
    "descricao": "Parcelamento em 18 vezes",
    "quantidadeParcelas": 18
  }
  ```



  **Exemplo de resposta:**

  ```json
  {
    "id": 3,
    "descricao": "Parcelamento em 18 vezes",
    "quantidadeParcelas": 18
  }
  ```



- **DELETE /parcelamentos/{id}**
  Remove um parcelamento do sistma.

  **Exemplo de resposta:**

  ```json
  {
    "mensagem": "Parcelamento removido com sucesso."
  }
  
  ```


--- 




