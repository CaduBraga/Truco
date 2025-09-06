# Jogo de Truco - Projeto de Estudo

Um jogo de Truco completo desenvolvido em Java com interface gráfica Swing, criado como projeto de estudo em dupla.

## Sobre o Projeto

Este é um projeto pessoal desenvolvido com fins educacionais para aprender e praticar conceitos de programação orientada a objetos, interface gráfica e persistência de dados em Java.

## Funcionalidades

### Interface Gráfica
- Interface moderna e intuitiva usando Java Swing
- Visualização das cartas na mão do jogador
- Placar em tempo real
- Histórico de jogadas
- Botões para ações do jogo (Truco, Aceitar, Recusar)

### Mecânicas do Jogo
- **Sistema de Turnos**: Rotação automática entre jogadores
- **Sistema de Cartas**: Baralho completo com 44 cartas (sem 8 e 9)
- **Manilhas**: Implementação correta das manilhas do Truco
- **Sistema de Pontuação**: Controle de pontos por equipe
- **Truco, Seis, Nove, Doze**: Sistema completo de apostas

### Persistência de Dados
- Conexão com banco de dados MySQL
- Salvamento automático de partidas
- Histórico de rodadas e jogadas
- Estatísticas de jogadores

### Arquitetura
- **Model**: Classes de domínio (Partida, Jogador, Carta, etc.)
- **View**: Interface gráfica (TrucoGUI)
- **Service**: Lógica de negócio (GerenciadorJogo, RegrasTruco)
- **DAO**: Acesso a dados (ConexaoDAO)

## Tecnologias Utilizadas

- **Java 17**
- **Java Swing** - Interface gráfica
- **MySQL** - Banco de dados
- **Maven** - Gerenciamento de dependências
- **JDBC** - Conexão com banco de dados

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## Instalação e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/CaduBraga/truco-java.git
cd truco-java
```

### 2. Configure o banco de dados

#### Verificar Instalações

**Java**
```bash
java -version
```

**Maven**
```bash
mvn -version
```

**MySQL**
```bash
mysql --version
```

#### Configurar MySQL

1. **Iniciar o MySQL**:
```bash
# Windows
net start mysql

# Linux/macOS
sudo systemctl start mysql
# ou
brew services start mysql
```

2. **Criar banco de dados**:
```sql
CREATE DATABASE truco_db;
USE truco_db;
```

3. **Executar script SQL**:
```bash
mysql -u root -p truco_db < src/main/resources/truco_database.sql
```

### 3. Configure as credenciais do banco
Edite o arquivo `src/br/com/truco/database/conexao/Conexao.java` com suas credenciais:
```java
private static final String URL = "jdbc:mysql://localhost:3306/truco_db";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 4. Compile e execute

#### Execução Rápida

**Windows**
```bash
run.bat
```

**Linux/macOS**
```bash
./run.sh
```

#### Execução Manual
```bash
# Compilar o projeto
mvn clean compile

# Executar o jogo
mvn exec:java -Dexec.mainClass="br.com.truco.main.Main"
```

## Como Jogar

1. **Inicie o jogo** - O jogo criará automaticamente 4 jogadores em 2 equipes
2. **Jogue suas cartas** - Clique nas cartas da sua mão para jogá-las
3. **Peça Truco** - Use o botão "Truco!" para aumentar o valor da rodada
4. **Aceite ou Recuse** - Responda aos pedidos de truco da equipe adversária
5. **Vença a partida** - Primeira equipe a atingir 12 pontos vence!

## Estrutura do Projeto

```
src/
├── br/com/truco/
│   ├── main/
│   │   └── Main.java
│   ├── model/
│   │   ├── deck/
│   │   │   ├── Carta.java
│   │   │   ├── Mao.java
│   │   │   └── Naipe.java
│   │   ├── Equipe.java
│   │   ├── Jogador.java
│   │   ├── Partida.java
│   │   └── Rodada.java
│   ├── service/
│   │   ├── Embaralhar.java
│   │   ├── GerenciadorJogo.java
│   │   ├── JogoTruco.java
│   │   └── RegrasTruco.java
│   ├── view/
│   │   └── TrucoGUI.java
│   └── database/
│       ├── conexao/
│       │   ├── Conexao.java
│       │   └── TesteConexao.java
│       └── dao/
│           └── ConexaoDAO.java
├── main/resources/
│   └── truco_database.sql
├── pom.xml
├── README.md
├── CHANGELOG.md
├── LICENSE
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── run.bat
├── run.sh
├── config.properties
├── config.properties.example
└── .gitignore
```

## Regras do Truco

### Cartas e Valores
- **Manilhas** (em ordem): 4 de Paus, 7 de Copas, Ás de Espadas, 7 de Ouros
- **Cartas normais**: Ás, 2, 3, 4, 5, 6, 7, 10, Valete, Dama, Rei
- **Naipe de trunfo**: Varia a cada partida

### Sistema de Pontuação
- **Truco**: 3 pontos
- **Seis**: 6 pontos
- **Nove**: 9 pontos
- **Doze**: 12 pontos
- **Partida**: 12 pontos para vencer

### Ações do Jogo
- **Jogar carta**: Clique na carta desejada
- **Pedir truco**: Aumentar o valor da rodada
- **Aceitar**: Concordar com o truco
- **Recusar**: Desistir da rodada

## Solução de Problemas

### Erro: "mvn não encontrado"
```bash
# Instale o Maven e adicione ao PATH
# Windows: Baixe de https://maven.apache.org/download.cgi
# Linux: sudo apt install maven
# macOS: brew install maven
```

### Erro: "java não encontrado"
```bash
# Instale o Java 17+
# Windows: Baixe de https://adoptium.net/
# Linux: sudo apt install openjdk-17-jdk
# macOS: brew install openjdk@17
```

### Erro de Conexão com Banco
```bash
# Verifique se o MySQL está rodando
# Windows: net start mysql
# Linux: sudo systemctl start mysql
# macOS: brew services start mysql
```

### Erro de Compilação
```bash
# Limpe o projeto e recompile
mvn clean
mvn compile
```

### Erro de Dependências
```bash
# Baixe as dependências novamente
mvn clean
mvn dependency:resolve
mvn compile
```

## Executando sem Maven

Se você não conseguir instalar o Maven, pode executar diretamente com o Java:

### 1. Compilar Manualmente
```bash
# Criar diretório de classes
mkdir -p target/classes

# Compilar todas as classes
javac -cp "lib/*" -d target/classes src/br/com/truco/**/*.java
```

### 2. Executar
```bash
java -cp "target/classes:lib/*" br.com.truco.main.Main
```

## Arquivos Importantes

- `run.bat` - Executar no Windows
- `run.sh` - Executar no Linux/macOS
- `config.properties` - Configurações do jogo
- `src/main/resources/truco_database.sql` - Script do banco

## Objetivos de Aprendizado Alcançados

### Programação Orientada a Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Abstração
- Interfaces e Classes Abstratas

### Interface Gráfica
- Java Swing
- Event Handling
- Layout Management
- Componentes GUI

### Persistência de Dados
- JDBC
- MySQL
- CRUD Operations
- Connection Management

### Arquitetura de Software
- Padrão MVC
- Separação de Responsabilidades
- Injeção de Dependência
- Clean Code

## Conceitos Aprendidos

### Java
- Classes e Objetos
- Herança e Polimorfismo
- Interfaces e Enums
- Collections e Generics
- Exception Handling

### Swing
- JFrame e JPanel
- Event Listeners
- Layout Managers
- Custom Components

### Database
- SQL Queries
- JDBC Connection
- Prepared Statements
- Result Sets

### Maven
- Dependency Management
- Build Lifecycle
- Plugins
- Project Structure

## Estatísticas do Projeto

- **Linhas de Código**: ~2,000+
- **Classes**: 15+
- **Métodos**: 100+
- **Arquivos**: 25+
- **Tempo de Desenvolvimento**: 1 dia

## Próximas Funcionalidades

- Modo multiplayer online
- Estatísticas detalhadas
- Diferentes níveis de IA
- Temas visuais personalizáveis
- Sistema de torneios
- Replay de partidas

## Contribuindo

Este é um projeto de estudo, mas sugestões e melhorias são bem-vindas!

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- **@CaduBraga** - [GitHub](https://github.com/CaduBraga)
- **@danielSismer** - [GitHub](https://github.com/danielSismer)

---

**Projeto de Estudo - Desenvolvido em dupla**