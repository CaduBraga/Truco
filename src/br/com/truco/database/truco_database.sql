CREATE DATABASE truco;
USE truco;

CREATE TABLE cartas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL CHECK ((numero BETWEEN 1 AND 7) OR (numero BETWEEN 10 AND 12)),
    naipe SET('paus', 'copas', 'espadas', 'ouros') NOT NULL
);

CREATE TABLE jogadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE equipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    jogador1_id INT NOT NULL,
    jogador2_id INT NOT NULL,
    FOREIGN KEY (jogador1_id) REFERENCES jogadores(id),
    FOREIGN KEY (jogador2_id) REFERENCES jogadores(id)
);

CREATE TABLE partida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equipe1_id INT NOT NULL,
    equipe2_id INT NOT NULL,
    pontuacaoEquipe1 INT NOT NULL,
    pontuacaoEquipe2 INT NOT NULL,
    vencedor_id INT,
    finalizada BOOLEAN DEFAULT FALSE,
    inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizada TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (equipe1_id) REFERENCES equipes(id),
    FOREIGN KEY (equipe2_id) REFERENCES equipes(id),
    FOREIGN KEY (vencedor_id) REFERENCES equipes(id)
);

CREATE TABLE rodada (
    id INT AUTO_INCREMENT PRIMARY KEY,
    partida_id INT NOT NULL,
    vencedor_id INT,
    valor INT CHECK (valor IN (1, 3, 6, 9, 12)),
    inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (partida_id) REFERENCES partida(id),
    FOREIGN KEY (vencedor_id) REFERENCES equipes(id)
);

INSERT INTO cartas (numero, naipe) VALUES
(1, 'paus'), (2, 'paus'), (3, 'paus'), (4, 'paus'), (5, 'paus'), (6, 'paus'), (7, 'paus'), (10, 'paus'), (11, 'paus'), (12, 'paus'),
(1, 'copas'), (2, 'copas'), (3, 'copas'), (4, 'copas'), (5, 'copas'), (6, 'copas'), (7, 'copas'), (10, 'copas'), (11, 'copas'), (12, 'copas'),
(1, 'espadas'), (2, 'espadas'), (3, 'espadas'), (4, 'espadas'), (5, 'espadas'), (6, 'espadas'), (7, 'espadas'), (10, 'espadas'), (11, 'espadas'), (12, 'espadas'),
(1, 'ouros'), (2, 'ouros'), (3, 'ouros'), (4, 'ouros'), (5, 'ouros'), (6, 'ouros'), (7, 'ouros'), (10, 'ouros'), (11, 'ouros'), (12, 'ouros');

CREATE INDEX idx_partida_equipe1_id ON partida(equipe1_id);
CREATE INDEX idx_partida_equipe2_id ON partida(equipe2_id);
CREATE INDEX idx_partida_vencedor_id ON partida(vencedor_id);
CREATE INDEX idx_partida_finalizada ON partida(finalizada);
CREATE INDEX idx_partida_inicio ON partida(inicio);
CREATE INDEX idx_equipes_nome ON equipes(nome);
CREATE INDEX idx_rodada_vencedor ON rodada(vencedor_id);
CREATE INDEX idx_rodada_inicio ON rodada(inicio);
CREATE INDEX idx_rodada_partida_id ON rodada(partida_id);

CREATE TRIGGER definir_vencedor_partida
BEFORE UPDATE ON partida
FOR EACH ROW
BEGIN
    IF NEW.pontuacaoEquipe1 >= 12 AND NEW.pontuacaoEquipe1 > NEW.pontuacaoEquipe2 THEN
        SET NEW.vencedor_id = NEW.equipe1_id;
        SET NEW.finalizada = TRUE;
    ELSEIF NEW.pontuacaoEquipe2 >= 12 AND NEW.pontuacaoEquipe2 > NEW.pontuacaoEquipe1 THEN
        SET NEW.vencedor_id = NEW.equipe2_id;
        SET NEW.finalizada = TRUE;
    END IF;
END;

CREATE VIEW partidas_completas AS
SELECT
    p.id AS partida_id,
    e1.nome AS equipe1_nome,
    j1.nome AS equipe1_jogador1,
    j2.nome AS equipe1_jogador2,
    e2.nome AS equipe2_nome,
    j3.nome AS equipe2_jogador1,
    j4.nome AS equipe2_jogador2,
    p.pontuacaoEquipe1,
    p.pontuacaoEquipe2,
    v.nome AS vencedor_nome,
    p.finalizada,
    p.inicio,
    p.atualizada
FROM partida p
JOIN equipes e1 ON p.equipe1_id = e1.id
JOIN equipes e2 ON p.equipe2_id = e2.id
JOIN jogadores j1 ON e1.jogador1_id = j1.id
JOIN jogadores j2 ON e1.jogador2_id = j2.id
JOIN jogadores j3 ON e2.jogador1_id = j3.id
JOIN jogadores j4 ON e2.jogador2_id = j4.id
LEFT JOIN equipes v ON p.vencedor_id = v.id;

 CREATE VIEW equipes_com_jogadores AS
SELECT
    e.id AS equipe_id,
    e.nome AS equipe_nome,
    j1.nome AS jogador1,
    j2.nome AS jogador2
FROM equipes e
JOIN jogadores j1 ON e.jogador1_id = j1.id
JOIN jogadores j2 ON e.jogador2_id = j2.id;

CREATE FUNCTION nome_vencedor_partida(partida_id INT)
RETURNS VARCHAR(50)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE nome_vencedor VARCHAR(50);

    SELECT e.nome
    INTO nome_vencedor
    FROM partida p
    JOIN equipes e ON p.vencedor_id = e.id
    WHERE p.id = partida_id;

    RETURN nome_vencedor;
END;

-- teste:
START TRANSACTION;

DELETE FROM rodada;
DELETE FROM partida;
DELETE FROM equipes;
DELETE FROM jogadores;

ALTER TABLE jogadores AUTO_INCREMENT = 1;
ALTER TABLE equipes AUTO_INCREMENT = 1;
ALTER TABLE partida AUTO_INCREMENT = 1;
ALTER TABLE rodada AUTO_INCREMENT = 1;

INSERT INTO jogadores (nome) VALUES ('Carlos'), ('João'), ('Marcos'), ('Felipe');

INSERT INTO equipes (nome, jogador1_id, jogador2_id) VALUES
('Time 1', 1, 2),
('Time 2', 3, 4);

INSERT INTO partida (equipe1_id, equipe2_id, pontuacaoEquipe1, pontuacaoEquipe2, finalizada)
VALUES (1, 2, 0, 0, FALSE);

INSERT INTO rodada (partida_id, vencedor_id, valor)
VALUES (1, 1, 3);

ROLLBACK;