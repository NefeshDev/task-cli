# 📋 Task Tracker CLI

> Uma aplicação de linha de comandos interativa para gestão de tarefas, construída com **Spring Boot** e **Spring Shell**.

---

## 📑 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias](#tecnologias)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Referência de Comandos](#referência-de-comandos)
- [Configuração](#configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Próximos Passos](#próximos-passos)

---

## 🚀 Sobre o Projeto

O **Task Tracker CLI** é uma ferramenta leve e eficiente para gerir as tuas tarefas diárias diretamente pelo terminal, sem a necessidade de interfaces gráficas ou aplicações externas.

O projeto assenta em três pilares:

- **Spring Shell** — fornece uma interface REPL interativa e extensível no terminal.
- **Spring Data JPA** — abstrai o acesso a dados com repositórios prontos a usar.
- **H2 Database (in-memory)** — garante arranque instantâneo e zero configuração de base de dados.

---

## 🛠 Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 3.3.5 |
| Spring Shell | 3.3.3 |
| Spring Data JPA | — |
| H2 Database | — |
| Lombok | — |
| Maven Wrapper | — |

---

## ✨ Funcionalidades

- ✅ Adicionar tarefas com descrição
- 📄 Listar todas as tarefas ou filtrá-las por estado
- 🔄 Marcar tarefas como *em progresso* ou *concluídas*
- ✏️ Editar a descrição de uma tarefa existente
- 🗑️ Remover tarefas do sistema

---

## ⚙️ Pré-requisitos

Antes de começar, garante que tens instalado na tua máquina:

- **Java 21** — [Download aqui](https://adoptium.net/)
- **Git** *(opcional, para clonar o repositório)*

Verifica a tua versão do Java:

```bash
java -version
```

---

## 🚀 Como Executar

**1. Clona o repositório** *(ou faz download do ZIP)*

```bash
git clone https://github.com/teu-utilizador/task-tracker-cli.git
cd task-tracker-cli
```

**2. Inicia a aplicação**

```bash
# Windows (PowerShell)
.\mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

**3. Começa a usar**

Quando o terminal mostrar o prompt `shell:>`, a aplicação está pronta:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

shell:> _
```

---

## 📖 Referência de Comandos

| Comando | Descrição | Exemplo |
|---|---|---|
| `add "descrição"` | Adiciona uma nova tarefa | `add "Estudar Spring Shell"` |
| `list` | Lista todas as tarefas | `list` |
| `list <status>` | Lista tarefas por estado | `list TODO` |
| `mark-in-progress <id>` | Marca a tarefa como em progresso | `mark-in-progress 3` |
| `mark-done <id>` | Marca a tarefa como concluída | `mark-done 3` |
| `update <id> "descrição"` | Atualiza a descrição da tarefa | `update 3 "Nova descrição"` |
| `delete <id>` | Remove a tarefa | `delete 3` |
| `help` | Mostra todos os comandos disponíveis | `help` |

### Estados disponíveis

```
TODO  →  IN_PROGRESS  →  DONE
```

---

## 💡 Configuração

O ficheiro de configuração encontra-se em `src/main/resources/application.properties`.

```properties
# Ativa o modo interativo do Spring Shell
spring.shell.interactive.enabled=true

# Configuração da base de dados H2 em memória (opcional — ativo por defeito)
spring.datasource.url=jdbc:h2:mem:taskdb
spring.h2.console.enabled=true
```

> **Nota:** Por ser uma base de dados em memória, os dados são reiniciados sempre que a aplicação é encerrada. Para persistência permanente, consulta a secção [Próximos Passos](#próximos-passos).

---

## 📁 Estrutura do Projeto

```
task-tracker-cli/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/exemplo/tasktracker/
│       │       ├── TaskTrackerApplication.java   # Ponto de entrada
│       │       ├── commands/
│       │       │   └── TaskCommands.java          # Definição dos comandos Shell
│       │       ├── model/
│       │       │   └── Task.java                  # Entidade JPA
│       │       ├── repository/
│       │       │   └── TaskRepository.java        # Repositório Spring Data
│       │       └── service/
│       │           └── TaskService.java           # Lógica de negócio
│       └── resources/
│           └── application.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

> 💡 **Dica:** Para adicionar novos comandos, basta criar um método anotado com `@Command` dentro de `TaskCommands.java`. O Spring Shell regista-o automaticamente.

---

## 🗺 Próximos Passos

Algumas ideias para evoluir o projeto:

- [ ] **Persistência em ficheiro** — guardar tarefas em JSON ou SQLite para sobreviverem ao reinício
- [ ] **Datas de vencimento** — adicionar campo `dueDate` com alertas para tarefas em atraso
- [ ] **Prioridades** — classificar tarefas como `LOW`, `MEDIUM` ou `HIGH`
- [ ] **Exportação** — exportar a lista de tarefas para CSV ou PDF
- [ ] **Testes automatizados** — cobertura com JUnit 5 e Spring Shell Test

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulta o ficheiro [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">
  Feito com ☕ e Spring Boot
</div>

https://roadmap.sh/projects/task-tracker
