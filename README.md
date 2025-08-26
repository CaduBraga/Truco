# br.com.truco.main.Truco

![br.com.truco.main.Truco](https://img.shields.io/badge/Projeto-Truco-blueviolet?style=flat-square)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![Java Swing](https://img.shields.io/badge/Java_Swing-007396?style=flat-square&logo=java&logoColor=white)
![Banco de Dados](https://img.shields.io/badge/Banco_de_Dados-SQL-blue?style=flat-square)

---

## 🃏 Sobre o Projeto

Projeto pessoal desenvolvido por **Carlos Eduardo Braga** e **Daniel Sismer** com o intuito de treinar habilidades de banco de dados, programação em Java e Java Swing, estruturação de projetos utilizando boas práticas de POO e versionamento. O projeto consiste em um programa que simula uma partida de br.com.truco.main.Truco para 4 jogadores (duplas), incluindo lógica, interface gráfica e persistência.

---

## 🚀 Funcionalidades

- Simulação completa de partidas de br.com.truco.main.Truco (4 jogadores, duplas)
- Interface gráfica intuitiva com Java Swing
- Gerenciamento de jogadores e pontuação
- Regras, distribuição de cartas e lógica do br.com.truco.main.Truco implementadas
- Persistência dos dados das partidas e jogadores em banco de dados

---

## 🛠️ Tecnologias Utilizadas

- **Java** — lógica e regras de negócio
- **Java Swing** — interface gráfica (GUI)
- **SQL** — persistência dos dados
- **Git & GitHub** — versionamento

---

## 📂 Estrutura do Projeto

```
br.com.truco.main.Truco/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ... (código-fonte)
│   │   └── resources/
│   └── test/
│       └── java/
├── database/
│   └── ... (scripts SQL)
├── README.md
└── ... (outros arquivos)
```

---

## ▶️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/CaduBraga/br.com.truco.main.Truco.git
   ```

2. **Configure o banco de dados:**
   - Utilize os scripts SQL em `/database` para criar o banco e as tabelas.
   - Atualize as configurações de conexão conforme seu ambiente.

3. **Compile e execute o projeto:**
   - Via IDE (IntelliJ/Eclipse/NetBeans) ou terminal:
     ```bash
     javac -d bin src/main/java/**/*.java
     java -cp bin Main
     ```

---

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

1. Faça um fork
2. Crie uma branch (`git checkout -b feature/nome-da-feature`)
3. Commit (`git commit -m 'feat: minha nova feature'`)
4. Push (`git push origin feature/nome-da-feature`)
5. Abra um Pull Request

---

## 👥 Colaboradores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/CaduBraga">
        <img src="https://avatars.githubusercontent.com/u/197653689?v=4" width="100px;" alt="Carlos Eduardo Braga"/><br />
        <sub><b>Carlos Eduardo Braga</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/danielSismer">
        <img src="https://avatars.githubusercontent.com/u/74731847?v=4" width="100px;" alt="Daniel Sismer"/><br />
        <sub><b>Daniel Sismer</b></sub>
      </a>
    </td>
  </tr>
</table>

---

> Projeto desenvolvido como prática de programação orientada a objetos, banco de dados e versionamento.<br>
> Inspirado no tradicional jogo brasileiro **br.com.truco.main.Truco** para aprendizado e diversão!
