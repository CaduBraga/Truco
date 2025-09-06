#!/bin/bash

echo "========================================"
echo "   Jogo de Truco - Projeto de Estudo"
echo "========================================"
echo ""
echo "Colaboradores: @danielSismer"
echo "Desenvolvido para fins educacionais"
echo ""
echo "========================================"
echo ""

# Verificar se o Java está instalado
if ! command -v java &> /dev/null; then
    echo "ERRO: Java não encontrado!"
    echo "Por favor, instale o Java 17 ou superior"
    echo "Download: https://adoptium.net/"
    exit 1
fi

# Verificar se o Maven está instalado
if ! command -v mvn &> /dev/null; then
    echo "ERRO: Maven não encontrado!"
    echo "Por favor, instale o Maven 3.6 ou superior"
    echo "Download: https://maven.apache.org/download.cgi"
    exit 1
fi

echo "Verificando dependências..."
echo ""

# Limpar e compilar o projeto
echo "Compilando o projeto..."
mvn clean compile
if [ $? -ne 0 ]; then
    echo "ERRO: Falha na compilação!"
    exit 1
fi

echo ""
echo "Compilação concluída com sucesso!"
echo ""

# Executar o jogo
echo "Iniciando o Jogo de Truco..."
echo ""
echo "========================================"
echo "   INSTRUÇÕES DO JOGO"
echo "========================================"
echo "1. O jogo criará automaticamente 4 jogadores"
echo "2. Clique nas cartas para jogá-las"
echo "3. Use o botão 'Truco!' para aumentar o valor"
echo "4. Aceite ou recuse os pedidos de truco"
echo "5. Primeira equipe a 12 pontos vence!"
echo "========================================"
echo ""

mvn exec:java -Dexec.mainClass="br.com.truco.main.Main"

echo ""
echo "========================================"
echo "   Jogo finalizado!"
echo "========================================"
echo ""
echo "Obrigado por jogar Truco!"
echo ""
echo "Para jogar novamente, execute este script novamente."
echo ""
