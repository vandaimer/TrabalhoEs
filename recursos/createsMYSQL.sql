--DROP TABLE baralho;
--DROP TABLE carta;
--DROP TABLE jogador;

CREATE TABLE jogador
(
  id integer NOT NULL AUTO_INCREMENT,
  nome character varying(40) NOT NULL UNIQUE,
  senha character varying(30) NOT NULL,
  CONSTRAINT jogadorpk_id PRIMARY KEY (id),
  CONSTRAINT jogadorunique_nome UNIQUE KEY (nome)
);
  
CREATE TABLE carta
(
  id integer NOT NULL AUTO_INCREMENT,
  nome character varying(20),
  ataque integer,
  defesa integer,
  efeito integer,
  inteligencia integer,
  forca integer,
  agilidade integer,
  CONSTRAINT cartapk_id PRIMARY KEY (id),
  CONSTRAINT cartaunique_nome UNIQUE KEY (nome)
);

CREATE TABLE baralho
(
  id_jogador integer NOT NULL,
  id_carta integer NOT NULL,
  CONSTRAINT baralhofk_idcarta_carta_id FOREIGN KEY (id_carta) REFERENCES carta (id),
  CONSTRAINT baralhofk_idjogador_jogador_id FOREIGN KEY (id_jogador) REFERENCES jogador (id)
);

INSERT INTO jogador (NOME,SENHA) VALUES ( 'admin','admin' );
INSERT INTO carta (NOME) VALUES ( 'LarmanMon');
INSERT INTO carta (NOME) VALUES ( 'PombaMon');
INSERT INTO carta (NOME) VALUES ( 'TibiaMon');
INSERT INTO carta (NOME) VALUES ( 'PMelloMon');
INSERT INTO baralho (ID_JOGADOR,ID_CARTA) VALUES ( 1,1 );
INSERT INTO baralho (ID_JOGADOR,ID_CARTA) VALUES ( 1,2 );
INSERT INTO baralho (ID_JOGADOR,ID_CARTA) VALUES ( 1,3 );
INSERT INTO baralho (ID_JOGADOR,ID_CARTA) VALUES ( 1,3 );
INSERT INTO baralho (ID_JOGADOR,ID_CARTA) VALUES ( 1,1 );
