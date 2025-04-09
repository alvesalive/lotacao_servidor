
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
