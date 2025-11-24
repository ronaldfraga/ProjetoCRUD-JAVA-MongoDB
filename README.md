📘 Projeto CRUD em Java com MongoDB

Este projeto implementa um CRUD completo (Create, Read, Update, Delete) utilizando Java e MongoDB como banco de dados NoSQL.
É um sistema simples em console, ideal para estudo de DAO, arquitetura organizada e integração com banco NoSQL.

📌 Tecnologias Utilizadas

Java 17+

MongoDB 6+

Driver MongoDB Java (mongo-java-driver-3.12.14.jar)

Arquitetura DAO (Data Access Object)

Paradigma Orientado a Objetos

📁 Estrutura do Projeto
ProjetoCRUD-JAVA-MongoDB/
│
├── src/
│   ├── application/
│   │   └── Program.java
│   ├── db/
│   │   └── MongoDB.java
│   ├── model/
│   │   ├── dao/
│   │   │   ├── DaoFactory.java
│   │   │   ├── UserDao.java
│   │   │   └── impl/UserDaoMongoDB.java
│   │   └── entities/
│   │       └── User.java
│
├── lib/
│   └── mongo-java-driver-3.12.14.jar
│
└── README.md

⚙️ Como Executar o Projeto
1. Instalar e iniciar o MongoDB

O banco precisa estar rodando localmente em:

mongodb://localhost:27017


Se estiver no Windows, abrir:

services.msc
→ MongoDB Server → Start

2. Importar o projeto no Eclipse ou VS Code

Certifique-se de adicionar o driver MongoDB na pasta lib/

Adicione o .jar ao Build Path

3. Executar o Program.java

O sistema exibirá o menu:

===============================================
               SISTEMA DE USUÁRIOS
===============================================
  1 - Inserir Usuário
  2 - Listar Usuários
  3 - Buscar Usuário por ID
  4 - Atualizar Usuário
  5 - Deletar Usuário
  0 - Sair
===============================================

🗂️ Funcionalidades
✔ Inserir Usuário

Nome

Email
Gera automaticamente o _id do MongoDB.

✔ Listar Usuários

Mostra todos os documentos da coleção user.

✔ Buscar por ID

Pesquisa utilizando um ObjectId.

✔ Atualizar Usuário

Atualiza nome e email baseado no _id.

✔ Deletar Usuário

Remove um documento do MongoDB.

🧱 Arquitetura
DAO Pattern

Para desacoplar a aplicação da camada de banco.

MongoDB Connection

Implementado na classe:

db/MongoDB.java


Retorna a conexão:

MongoDatabase db = client.getDatabase("estudo");

UserDaoMongoDB

Implementação de CRUD usando:

MongoCollection<Document>

🧪 Exemplo de Documento no MongoDB
{
  "_id": ObjectId("6924cb337d80675414ecca7e"),
  "name": "Jubiscleuso",
  "email": "jubiscleuso@jubis.com"
}

📦 Dependência

Coloque no seu lib/:

mongo-java-driver-3.12.14.jar

📝 Autor

Ronald Fraga
Projeto para estudo de Java com MongoDB.
