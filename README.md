# 🔐 Basic Login Auth - Java

Projeto simples de autenticação com cadastro e login em memória, utilizando boas práticas como:

- Hashing seguro de senha (SHA-256)
- Validação de senha mínima
- Separação de responsabilidades por classes

## 📚 Tecnologias Utilizadas

- Java 17+
- IntelliJ IDEA
- SHA-256 (via `MessageDigest`)
- Programação orientada a objetos

## 🚀 Funcionalidades

### ✅ Cadastro de usuário

- Solicita nome de usuário e senha
- Valida que a senha tenha no mínimo 8 caracteres
- Converte a senha para hash com SHA-256
- Armazena usuário + hash da senha em memória

### 🔐 Login

- Pede usuário e senha
- Compara senha digitada (convertida em hash) com hash salvo
- Mensagem de sucesso ou erro na autenticação

## 🧠 Estrutura do Projeto

```
src/
└── app/
    └── Main.java              # Ponto de entrada (cadastro + login)
└── auth/
    └── AuthService.java       # Regras de autenticação e registro
    └── Credencial.java        # Representa o usuário e senha (com hash)
    └── HashUtil.java          # Geração do hash SHA-256
    └── SenhaInvalidaException.java # Exceção personalizada para senha fraca
```

## 📝 Exemplo de Uso

```bash
=== CADASTRO ===
Usuário: gui
Senha: senha1234
✔ Registrado com sucesso!

=== LOGIN ===
Usuário: gui
Senha: senha1234
✅ Login bem-sucedido! Seja bem-vindo, gui
```

## ⚠️ Segurança

- A senha **não é salva em texto plano**.
- O sistema **não imprime o hash** no console para evitar exposição acidental.
- Você pode adicionar persistência em arquivo ou banco futuramente.

## 🛠️ Melhorias Futuras

- Salvar dados em arquivo ou banco de dados
- Interface gráfica (GUI)
- Lógica de múltiplas tentativas e bloqueio
- Registro de logs e auditoria

## 📁 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/GLBonfim/basic-login-auth.git
   ```

2. Abra no IntelliJ IDEA ou compile com:
   ```bash
   javac -d out src/**/*.java
   java -cp out app.Main
   ```

---

🧠 Projeto simples mas com base sólida para entender como funciona autenticação no mundo real!

---
## 👤 Autor

Desenvolvido por  [**Guilherme Bonfim**](https://www.linkedin.com/in/glbonfim)