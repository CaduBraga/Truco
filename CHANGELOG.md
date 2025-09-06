# Changelog

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.0.0/),
e este projeto adere ao [Versionamento Semântico](https://semver.org/lang/pt-BR/).

## [1.0.0] - 2025-01-27

### ✨ Adicionado
- **Interface Gráfica Completa**
  - Interface moderna usando Java Swing
  - Visualização das cartas na mão do jogador
  - Placar em tempo real
  - Histórico de jogadas
  - Botões para ações do jogo (Truco, Aceitar, Recusar)

- **Sistema de Jogo Completo**
  - Implementação das regras oficiais do Truco
  - Sistema de turnos automático
  - Baralho completo com 44 cartas (sem 8 e 9)
  - Manilhas implementadas corretamente
  - Sistema de pontuação por equipe

- **Sistema de Truco, Seis, Nove, Doze**
  - Pedido de truco com validação
  - Aceitar ou recusar truco
  - Progressão automática de valores
  - Controle de estado das apostas

- **Persistência de Dados**
  - Conexão com banco de dados MySQL
  - Salvamento automático de partidas
  - Histórico de rodadas e jogadas
  - Estatísticas de jogadores

- **Arquitetura do Projeto**
  - Padrão MVC (Model-View-Controller)
  - Separação clara de responsabilidades
  - Classes de domínio bem definidas
  - DAO para acesso a dados

### 🏗️ Estrutura do Projeto
- **Model**: Classes de domínio (Partida, Jogador, Carta, Equipe, Rodada)
- **View**: Interface gráfica (TrucoGUI)
- **Service**: Lógica de negócio (GerenciadorJogo, RegrasTruco, Embaralhar)
- **DAO**: Acesso a dados (ConexaoDAO)
- **Database**: Scripts SQL e configuração de conexão

### 🎮 Funcionalidades do Jogo
- **4 Jogadores em 2 Equipes**
  - Equipe A: João e Maria
  - Equipe B: Pedro e Ana
  - Rotação automática de turnos

- **Sistema de Cartas**
  - Baralho com 44 cartas (1,2,3,4,5,6,7,10,11,12,13 de cada naipe)
  - Manilhas: 4 de Paus, 7 de Copas, Ás de Espadas, 7 de Ouros
  - Valores corretos para comparação de cartas

- **Mecânicas de Jogo**
  - Distribuição de 3 cartas por jogador
  - Jogada de cartas por turno
  - Determinação automática do vencedor da rodada
  - Sistema de pontuação (primeira equipe a 12 pontos vence)

- **Sistema de Truco**
  - Pedido de truco (3 pontos)
  - Seis (6 pontos)
  - Nove (9 pontos)
  - Doze (12 pontos)
  - Validação de regras de truco

### 💾 Banco de Dados
- **Tabelas Criadas**
  - `partidas`: Armazena informações das partidas
  - `rodadas`: Armazena informações das rodadas
  - `jogadas`: Armazena as cartas jogadas em cada rodada

- **Funcionalidades de Persistência**
  - Salvamento automático de partidas
  - Histórico completo de jogadas
  - Atualização de pontuações
  - Controle de estado das partidas

### 🛠️ Tecnologias Utilizadas
- **Java 17** - Linguagem de programação
- **Java Swing** - Interface gráfica
- **MySQL 8.0** - Banco de dados
- **Maven** - Gerenciamento de dependências
- **JDBC** - Conexão com banco de dados

### 📋 Arquivos de Configuração
- **pom.xml** - Configuração do Maven
- **run.bat** - Script para executar no Windows
- **LICENSE** - Licença MIT
- **CODE_OF_CONDUCT.md** - Código de conduta
- **CONTRIBUTING.md** - Guia de contribuição

### 🎯 Objetivos Alcançados
- ✅ Interface gráfica funcional e intuitiva
- ✅ Implementação completa das regras do Truco
- ✅ Sistema de persistência de dados
- ✅ Arquitetura bem estruturada
- ✅ Documentação completa
- ✅ Projeto pronto para uso educacional

### 👥 Colaboradores
- **@danielSismer** - [GitHub](https://github.com/danielSismer)
- **Desenvolvedor Principal** - Projeto de Estudo

### 📝 Notas
- Este é um projeto de estudo desenvolvido para fins educacionais
- O foco principal foi aprender conceitos de POO, interface gráfica e persistência
- O projeto está pronto para uso e pode ser expandido com novas funcionalidades

---

## [0.1.0] - 2025-01-27

### ✨ Adicionado
- Estrutura inicial do projeto
- Classes básicas do modelo de domínio
- Configuração do Maven
- Conexão básica com banco de dados
- Scripts SQL iniciais

### 🏗️ Estrutura Inicial
- **Model**: Classes básicas (Carta, Jogador, Partida, Equipe)
- **Database**: Configuração de conexão e scripts SQL
- **Service**: Classes de serviço básicas

### 📋 Arquivos Iniciais
- `pom.xml` - Configuração do Maven
- `src/br/com/truco/model/` - Classes de domínio
- `src/br/com/truco/database/` - Configuração do banco
- `src/br/com/truco/service/` - Serviços básicos

---

## [Unreleased]

### 🔮 Planejado
- Modo multiplayer online
- Estatísticas detalhadas
- Diferentes níveis de IA
- Temas visuais personalizáveis
- Sistema de torneios
- Replay de partidas
- Modo de jogo solo contra IA
- Sistema de ranking
- Chat entre jogadores
- Modo de treinamento

### 🐛 Correções Planejadas
- Melhorar validação de entrada
- Otimizar performance da interface
- Corrigir bugs menores de UI
- Melhorar tratamento de erros

### 🔧 Melhorias Planejadas
- Refatorar código para melhor legibilidade
- Adicionar mais testes unitários
- Melhorar documentação do código
- Otimizar consultas ao banco de dados

---

**Nota**: Este changelog é mantido automaticamente e reflete todas as mudanças significativas no projeto.
