
##  API Rest
### Gestão (lotação) de Servidores - SEPLAG 

> **Willyan Alves da Silva**  


---

## 📌 Descrição

API desenvolvida em **Java 17 com Spring Boot 3** com as seguintes features:

- CRUD das entidades: ServidorEfetivo, Unidade, Lotação
- Upload de fotos para o **MinIO**
- Armazenamento em banco de dados **PostgreSQL**
- Autenticação com **JWT expira em 5 minutos** + **Refresh Token**
- **Docker Compose** para orquestração da aplicação
- Paginação e filtros em endpoints
- Swagger UI para documentação da API

---

## 🚀 Como executar

### Pré-requisitos

- Docker e Docker Compose instalados

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/alvesalive/lotacao_servidor
cd lotacao_servidor
```

```bash
# 2. Construa e suba os containers
docker compose up --build
```

## 🚀 Chamada a API

### 🔐 Autenticação

 ✅ POST /api/auth/login
```json
{
  "username": "admin",
  "password": "123456"
}
```
✅ POST /api/auth/refresh

```json
{
  "refreshToken": "..."
}

```

### 📋 Servidor Efetivo
✅ GET /api/servidores-efetivos
```json
Headers:
Authorization: Bearer <token>
```

✅ POST /api/servidores-efetivos
```json
{
  "pesNome": "João da Silva",
  "pesDataNascimento": "1990-05-01",
  "pesSexo": "Masculino",
  "pesMae": "Maria",
  "pesPai": "José",
  "seMatricula": "123456"
}

```


✅ PUT /api/servidores-efetivos/{id}
```json
{
  "pesNome": "João Atualizado",
  "pesDataNascimento": "1990-05-01",
  "pesSexo": "Masculino",
  "pesMae": "Maria",
  "pesPai": "José",
  "seMatricula": "123456"
}

```

✅ GET /api/servidores-efetivos/unidade/{unidId}
```json
{
  nome,
  idade,
  unidade,
  fotografia
}
```

### ⏱️ Servidor Temporário
✅ GET /api/servidores-temporarios

✅ POST /api/servidores-temporarios

```json
{
  "pesNome": "Carlos Temporário",
  "pesDataNascimento": "1985-10-01",
  "pesSexo": "Masculino",
  "pesMae": "Lucia",
  "pesPai": "Mario",
  "stDataAdmissao": "2023-01-01",
  "stDataDemissao": "2023-12-31"
}

```


### 🏢 Unidades
✅ GET /api/unidades

✅ POST /api/unidades
```json
{
  "unidNome": "Secretaria de Educação",
  "unidSigla": "SEDUC"
}

```
✅ PUT /api/unidades/{id}
✅ DELETE /api/unidades/{id}


### Endereço Funcional
✅ GET /api/enderecos-funcionais?nome=ana


### 📷 Upload de Foto Pessoa

✅ POST /api/fotos/upload/{pesId}
```json{
Tipo: multipart/form-data
Campo: file
Header: Authorization: Bearer <token>
```


### Para usar no Insomnia 
Importe o arquivo 'lotacao_collection.json'