# gespro-api

Backend base do Gespro, inicializada com Spring Boot 3.5.7, Spring Modulith 1.4.4 e Java 21. Esta fundação entrega o POM pai do backend, dependências comuns e o bootstrap necessário para evoluir a arquitetura modular.

## O que foi entregue no Issue #1
- POM pai em `backend/pom.xml` herdando de `spring-boot-starter-parent` e definindo `java.version=21`.
- Dependências core (web, actuator, validation, data, Lombok, MapStruct, Spring Modulith, SpringDoc) prontas para uso em todos os módulos.
- Gestão de versões para Testcontainers, Micrometer/OTel via BOM do Spring Modulith.
- Configuração do `spring-boot-maven-plugin` e plugins auxiliares (compiler, surefire) garantindo builds repetíveis.
- Bootstrap da aplicação com `GesproApiApplication` vazio capaz de iniciar via `mvn spring-boot:run`.

## Stack principal
- Java 21
- Spring Boot 3.5.7 + Spring Modulith 1.4.4
- Maven Wrapper 3.9.x
- Lombok, MapStruct, Springdoc OpenAPI
- JUnit 5 + Testcontainers (PostgreSQL, Kafka) para testes de integração

## Pré-requisitos
- JDK 21 instalado e configurado em `JAVA_HOME`.
- Docker (opcional, necessário apenas para executar Testcontainers localmente).
- Permissões de execução para o wrapper: `chmod +x mvnw`.

## Como executar
1. Entre no diretório do backend Maven:
   ```bash
   cd backend
   ```
2. Instale as dependências e compile todos os módulos:
   ```bash
   ./mvnw -q -DskipTests install
   ```
3. Suba a aplicação (módulo `platform/application-bootstrap`):
   ```bash
   ./mvnw -pl platform/application-bootstrap spring-boot:run
   ```
4. Valide o health check:
   ```bash
   curl http://localhost:8080/actuator/health
   ```

## Estrutura atual
- `backend/pom.xml` – POM pai multi-módulo (modules/ + platform/).
- `backend/modules/*-module` – módulos de domínio por bounded context (crm-clientes, finance-accounting, shared-kernel, etc.).
- `backend/platform/application-bootstrap` – aplicação Spring Boot Modulith que orquestra todos os módulos.
- `backend/platform/integration-tests` – suíte de testes de integração ponta a ponta.
- `docs/` – referências complementares (Spring Modulith, visão geral do backend).

## Próximos passos sugeridos
- Definir módulos Spring Modulith (por domínio) e boundaries explícitas.
- Ativar Banco (PostgreSQL) e migrações (Flyway) quando os primeiros agregados forem introduzidos.
- Acrescentar testes de contrato/integrados com Testcontainers para cada módulo.

## Troubleshooting rápido
- **Build falhou por versão do Java**: confirme `java -version` retorna 21.
- **Testcontainers não inicializa**: verifique se o Docker Engine está rodando e expondo as portas default.
- **Lombok não reconhecido pela IDE**: instale o plugin da IDE ou habilite annotation processing.
