# 💻 Projeto Final - LPOO 2025-1

**Disciplina:** Linguagem de Programação Orientada a Objetos  
**Nome:** Helen Zanco Neis  
**Professora:** Vanessa Lago Machado  

---

## 📌 Descrição do Sistema

Este sistema foi desenvolvido como projeto final da disciplina de LPOO e tem como objetivo principal **[Gerenciar um sistema de ordens de serviço de TI]**.

### ✨ Funcionalidades principais:

- Cadastro, edição e listagem de **usuários** (técnicos e funcionários)
- Cadastro e visualização de **ordens de serviço**
- Atribuição de técnicos e funcionários a cada OS
- Armazenamento e recuperação de dados via **JPA (Java Persistence API)**
- Interface gráfica desenvolvida com **Java Swing**
- Validações simples e tratamento de erros de entrada

---

## 🧭 Domínio da Aplicação

O domínio escolhido foi **[Gerenciamento de Ordens de Serviço]**, mais especificamente voltado para **[empresas que realizam manutenção técnica em equipamentos de informática]**.

---

## 🧩 Diagrama de Classes UML

O sistema foi modelado com base nos princípios da programação orientada a objetos, utilizando **herança**, **encapsulamento** e **relacionamentos entre entidades**.

### 📄 Diagrama de Classes:

![ClasseUML](https://github.com/user-attachments/assets/75394c26-9cee-46e8-8835-61f8731227cc)

---

## 🚀 Tecnologias Utilizadas

- Java SE 8+
- Java Swing
- JPA (Hibernate)
- PostgreSQL (ou outro SGBD relacional)
- NetBeans / IntelliJ IDEA
- Diagrama de classe feito no [lucid](https://lucid.app/users/login#/login).
---

## 🗂 Organização do Código

- `model/` → Classes de entidade (`Usuario`, `Tecnico`, `Funcionario`, `OrdemServico`, `SetorOS`, `StatusOS`)
- `control/` → Classe de persistência com JPA (`PersistenciaJPA`)
- `view/` → Interfaces gráficas com Swing (`UsuarioJF`, `OSJF`, `CadastroOSJD`, `CadastroUsuarioJD`, `PrincipalJF`)
- `test/` → Casos de teste JUnit

---

## 👩‍💻 Observações Finais

- O projeto segue o padrão MVC básico, com separação entre lógica de dados, persistência e interface.
- Todos os dados são persistidos em banco de dados real via JPA.
- A interface gráfica foi feita com base em boas práticas para garantir usabilidade e clareza.

---

> Projeto desenvolvido como parte da disciplina de LPOO – 2025/1.

