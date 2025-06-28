# API de Autenticação com JWT (Spring Boot 3.1.0)

## ✅ Funcionalidades
- Login com usuário e senha
- Geração e validação de JWT
- Endpoints protegidos por token
- Controle de acesso por role
- Banco em memória (H2)
- Testes com JUnit
- Documentação com Swagger

## 🚀 Como rodar
```bash
./mvnw spring-boot:run
```

## 🌐 Acesse
- Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 👤 Usuários iniciais
| Username | Senha     | Role  |
|----------|-----------|-------|
| admin    | 123456    | ADMIN |
| user     | password  | USER  |

## 🧪 Testes
Execute:
```bash
./mvnw test
```

## 📂 Estrutura
- `src/main`: Código da aplicação
- `src/test`: Testes de integração
- `application.yml`: Configurações
- `pom.xml`: Dependências

## 📸 Prints Recomendados
- Swagger com token gerado
- Validação de token
- Endpoint `/api/hello` com token
- Teste JUnit passando
