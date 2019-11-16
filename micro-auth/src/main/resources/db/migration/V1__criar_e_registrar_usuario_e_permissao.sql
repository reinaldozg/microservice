CREATE SEQUENCE usuario_id_seq;

CREATE TABLE usuario
(
  id BIGINT NOT NULL DEFAULT NEXTVAL('usuario_id_seq'),
  nome CHARACTER VARYING(50) NOT NULL, 
  email CHARACTER VARYING(50) NOT NULL,
  senha CHARACTER VARYING(200) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

CREATE TABLE permissao
(
  id BIGINT NOT NULL,
  descricao CHARACTER VARYING(50) NOT NULL, 
  CONSTRAINT permissao_pkey PRIMARY KEY (id)
);

CREATE TABLE usuario_permissao
(
  usuario_id BIGINT NOT NULL,
  permissao_id BIGINT NOT NULL, 
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  FOREIGN KEY (permissao_id) REFERENCES permissao(id),
  CONSTRAINT usuario_permissao_pkey PRIMARY KEY (usuario_id, permissao_id)  
);

INSERT INTO usuario(id, nome, email, senha) VALUES (1, 'Administrador', 'adm@email.com', '$2a$10$W0wSDvIndEbL2l0.1wt/tOcMQJey0s97egaApJpskI.fUeNkwmnMe');
INSERT INTO usuario(id, nome, email, senha) VALUES (2, 'Basico', 'basico@email.com', '$2a$10$wLVdTjERINPUF7LQeLXgLOs0Zzsuu0RX6eigP3DvcShz0ci9zlEDO');

INSERT INTO permissao(id, descricao) VALUES (1, 'ROLE_PESQUISAR_PAPEL');
INSERT INTO permissao(id, descricao) VALUES (2, 'ROLE_CADASTRAR_PAPEL');
INSERT INTO permissao(id, descricao) VALUES (3, 'ROLE_ATUALIZAR_PAPEL');
INSERT INTO permissao(id, descricao) VALUES (4, 'ROLE_REMOVER_PAPEL');

INSERT INTO permissao(id, descricao) VALUES (5, 'ROLE_PESQUISAR_HISTORICO_DIARIO');
INSERT INTO permissao(id, descricao) VALUES (6, 'ROLE_CADASTRAR_HISTORICO_DIARIO');
INSERT INTO permissao(id, descricao) VALUES (7, 'ROLE_ATUALIZAR_HISTORICO_DIARIO');
INSERT INTO permissao(id, descricao) VALUES (8, 'ROLE_REMOVER_HISTORICO_DIARIO');

INSERT INTO permissao(id, descricao) VALUES (9, 'ROLE_PESQUISAR_CRON_SCHEDULE');
INSERT INTO permissao(id, descricao) VALUES (10, 'ROLE_ATUALIZAR_CRON_SCHEDULE');
INSERT INTO permissao(id, descricao) VALUES (11, 'ROLE_ADMINISTRADOR');

INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (1, 9);

INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 1);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 2);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 3);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 4);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 11);
