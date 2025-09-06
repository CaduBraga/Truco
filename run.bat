@echo off
echo ========================================
echo    Jogo de Truco - Projeto de Estudo
echo ========================================
echo.
echo Colaboradores: @danielSismer
echo Desenvolvido para fins educacionais
echo.
echo ========================================
echo.

REM Verificar se o Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERRO: Java nao encontrado!
    echo Por favor, instale o Java 17 ou superior
    echo Download: https://adoptium.net/
    pause
    exit /b 1
)

REM Verificar se o Maven está instalado
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERRO: Maven nao encontrado!
    echo Por favor, instale o Maven 3.6 ou superior
    echo Download: https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo Verificando dependencias...
echo.

REM Limpar e compilar o projeto
echo Compilando o projeto...
mvn clean compile
if %errorlevel% neq 0 (
    echo ERRO: Falha na compilacao!
    pause
    exit /b 1
)

echo.
echo Compilacao concluida com sucesso!
echo.

REM Executar o jogo
echo Iniciando o Jogo de Truco...
echo.
echo ========================================
echo    INSTRUCOES DO JOGO
echo ========================================
echo 1. O jogo criara automaticamente 4 jogadores
echo 2. Clique nas cartas para joga-las
echo 3. Use o botao "Truco!" para aumentar o valor
echo 4. Aceite ou recuse os pedidos de truco
echo 5. Primeira equipe a 12 pontos vence!
echo ========================================
echo.

mvn exec:java -Dexec.mainClass="br.com.truco.main.Main"

echo.
echo ========================================
echo    Jogo finalizado!
echo ========================================
echo.
echo Obrigado por jogar Truco!
echo.
echo Para jogar novamente, execute este arquivo novamente.
echo.
pause
