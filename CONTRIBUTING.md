# Guia de Contribuição

Obrigado por considerar contribuir com o projeto de Truco! Este é um projeto de estudo, e todas as contribuições são bem-vindas.

## 🎯 Sobre o Projeto

Este é um projeto educacional desenvolvido para aprender e praticar conceitos de:
- Programação Orientada a Objetos
- Interface Gráfica com Java Swing
- Persistência de Dados com MySQL
- Arquitetura de Software

## 🤝 Como Contribuir

### 1. Fork e Clone

1. Faça um fork do repositório
2. Clone seu fork localmente:
```bash
git clone https://github.com/SEU_USUARIO/truco-java.git
cd truco-java
```

### 2. Configurar Ambiente

1. Instale o Java 17 ou superior
2. Instale o Maven 3.6+
3. Configure o MySQL 8.0+
4. Execute o script SQL para criar as tabelas

### 3. Criar Branch

```bash
git checkout -b feature/nome-da-feature
# ou
git checkout -b bugfix/descricao-do-bug
```

### 4. Fazer Mudanças

- Mantenha o código limpo e bem documentado
- Siga as convenções de nomenclatura Java
- Adicione comentários explicativos quando necessário
- Teste suas mudanças antes de fazer commit

### 5. Commit e Push

```bash
git add .
git commit -m "feat: adiciona nova funcionalidade"
git push origin feature/nome-da-feature
```

### 6. Pull Request

1. Abra um Pull Request no GitHub
2. Descreva claramente as mudanças feitas
3. Referencie issues relacionadas se houver
4. Aguarde a revisão

## 📋 Tipos de Contribuição

### 🐛 Correção de Bugs
- Corrija bugs existentes
- Melhore o tratamento de erros
- Otimize performance

### ✨ Novas Funcionalidades
- Adicione novas mecânicas de jogo
- Melhore a interface gráfica
- Implemente novos recursos

### 📚 Documentação
- Melhore a documentação existente
- Adicione exemplos de uso
- Corrija erros de documentação

### 🧪 Testes
- Adicione testes unitários
- Implemente testes de integração
- Melhore a cobertura de testes

### 🎨 Interface
- Melhore o design da interface
- Adicione novos temas visuais
- Otimize a experiência do usuário

## 🏗️ Estrutura do Projeto

```
src/
├── br/com/truco/
│   ├── main/           # Classe principal
│   ├── model/          # Classes de domínio
│   ├── service/        # Lógica de negócio
│   ├── view/           # Interface gráfica
│   └── database/       # Acesso a dados
├── pom.xml             # Configuração Maven
└── README.md           # Documentação principal
```

## 📝 Convenções de Código

### Nomenclatura
- **Classes**: PascalCase (ex: `TrucoGUI`)
- **Métodos**: camelCase (ex: `jogarCarta`)
- **Variáveis**: camelCase (ex: `jogadorAtual`)
- **Constantes**: UPPER_SNAKE_CASE (ex: `VALOR_TRUCO`)

### Comentários
```java
/**
 * Joga uma carta na rodada atual
 * @param carta Carta a ser jogada
 * @return true se a carta foi jogada com sucesso
 */
public boolean jogarCarta(Carta carta) {
    // Implementação
}
```

### Formatação
- Use 4 espaços para indentação
- Máximo de 120 caracteres por linha
- Espaço após vírgulas e operadores
- Quebra de linha antes de operadores

## 🧪 Testes

### Executar Testes
```bash
mvn test
```

### Adicionar Novos Testes
- Crie testes para novas funcionalidades
- Use JUnit 5
- Mantenha cobertura de código alta

## 📋 Checklist para Pull Request

- [ ] Código compila sem erros
- [ ] Testes passam
- [ ] Documentação atualizada
- [ ] Comentários adicionados quando necessário
- [ ] Convenções de código seguidas
- [ ] Mudanças testadas manualmente
- [ ] Commit messages descritivos

## 🐛 Reportar Bugs

### Como Reportar
1. Verifique se o bug já foi reportado
2. Use o template de issue
3. Inclua informações detalhadas:
   - Sistema operacional
   - Versão do Java
   - Passos para reproduzir
   - Comportamento esperado vs atual

### Template de Bug Report
```markdown
**Descrição do Bug**
Uma descrição clara do problema.

**Passos para Reproduzir**
1. Vá para '...'
2. Clique em '...'
3. Veja o erro

**Comportamento Esperado**
O que deveria acontecer.

**Screenshots**
Se aplicável, adicione screenshots.

**Informações do Sistema**
- OS: [ex: Windows 10]
- Java: [ex: 17.0.1]
- Maven: [ex: 3.8.1]
```

## 💡 Sugestões de Melhorias

### Ideias para Contribuir
- **Interface**: Melhorar design, adicionar temas
- **Jogo**: Novas mecânicas, modos de jogo
- **Performance**: Otimizar código, reduzir uso de memória
- **Documentação**: Melhorar README, adicionar tutoriais
- **Testes**: Aumentar cobertura, adicionar testes de integração

### Como Sugerir
1. Abra uma issue com label "enhancement"
2. Descreva detalhadamente a sugestão
3. Explique o benefício para o projeto
4. Aguarde discussão da comunidade

## 🎓 Aprendizado

### Recursos Úteis
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Maven Guide](https://maven.apache.org/guides/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

### Conceitos Importantes
- **POO**: Herança, Polimorfismo, Encapsulamento
- **Swing**: JFrame, JPanel, Event Handling
- **JDBC**: Connection, PreparedStatement, ResultSet
- **Maven**: Dependencies, Build Lifecycle

## 📞 Contato

- **@danielSismer** - [GitHub](https://github.com/danielSismer)
- **Issues**: Use o sistema de issues do GitHub
- **Discussions**: Use o sistema de discussões do GitHub

## 🙏 Agradecimentos

Obrigado a todos que contribuem para este projeto! Cada contribuição, por menor que seja, ajuda a tornar o projeto melhor e mais educativo.

---

**Última atualização**: 27 de Janeiro de 2025
