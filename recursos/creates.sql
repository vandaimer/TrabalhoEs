DROP TABLE baralho;
DROP TABLE carta;
DROP TABLE jogador;
DROP SEQUENCE jogador_id;
DROP SEQUENCE carta_id;

CREATE SEQUENCE jogador_id START 1;
CREATE SEQUENCE carta_id START 1;

CREATE TABLE jogador
(
  id integer DEFAULT nextval('jogador_id') NOT NULL,
  nome character varying(40) NOT NULL UNIQUE,
  senha character varying(30) NOT NULL,
  CONSTRAINT jogadorpk_id PRIMARY KEY (id)
);
  
CREATE TABLE carta
(
  id integer DEFAULT nextval('carta_id') NOT NULL,
  nome character varying(20) UNIQUE,
  ataque integer,
  defesa integer,
  efeito integer,
  inteligencia integer,
  forca integer,
  agilidade integer,
  CONSTRAINT cartapk_id PRIMARY KEY (id)
);

CREATE TABLE baralho
(
  id_jogador integer NOT NULL,
  id_carta integer NOT NULL,
  CONSTRAINT baralhofk_idcarta_carta_id FOREIGN KEY (id_carta) REFERENCES carta (id),
  CONSTRAINT baralhofk_idjogador_jogador_id FOREIGN KEY (id_jogador) REFERENCES jogador (id)
);

INSERT INTO JOGADOR (NOME,SENHA) VALUES ( 'admin','admin' );
INSERT INTO CARTA (NOME) VALUES ( 'LarmanMon');
INSERT INTO CARTA (NOME) VALUES ( 'PombaMon');
INSERT INTO CARTA (NOME) VALUES ( 'TibiaMon');
INSERT INTO CARTA (NOME) VALUES ( 'PMelloMon');
INSERT INTO BARALHO (ID_JOGADOR,ID_CARTA) VALUES ( 1,1 );
INSERT INTO BARALHO (ID_JOGADOR,ID_CARTA) VALUES ( 1,2 );
INSERT INTO BARALHO (ID_JOGADOR,ID_CARTA) VALUES ( 1,3 );
INSERT INTO BARALHO (ID_JOGADOR,ID_CARTA) VALUES ( 1,3 );
INSERT INTO BARALHO (ID_JOGADOR,ID_CARTA) VALUES ( 1,1 );