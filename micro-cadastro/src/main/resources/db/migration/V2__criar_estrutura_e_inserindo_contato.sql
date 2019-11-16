CREATE SEQUENCE contato_id_seq;
CREATE SEQUENCE contato_tipo_id_seq;


CREATE TABLE contato_tipo
(
    id bigint NOT NULL DEFAULT nextval('contato_tipo_id_seq'::regclass),
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    descricao character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT contato_tipo_pkey PRIMARY KEY (id)
);


CREATE TABLE contato
(
    id bigint NOT NULL DEFAULT nextval('contato_id_seq'::regclass),
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    contato character varying(80) COLLATE pg_catalog."default",
    nome character varying(50) COLLATE pg_catalog."default",
    principal boolean NOT NULL DEFAULT false,
    pessoa bigint NOT NULL,
    contato_tipo bigint,
    CONSTRAINT contato_pkey PRIMARY KEY (id),
    CONSTRAINT fk2h6l5bma9cyyjy8ytvky10n1c FOREIGN KEY (pessoa)
        REFERENCES pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkddqxmh0k4k3j8yly6x9grw6ce FOREIGN KEY (contato_tipo)
        REFERENCES contato_tipo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);


-- Inserção de tidos de contatos
INSERT INTO contato_tipo(descricao, ativo, excluido) VALUES ('Facebook', TRUE, FALSE);
INSERT INTO contato_tipo(descricao, ativo, excluido) VALUES ('Twitter', TRUE, FALSE);
INSERT INTO contato_tipo(descricao, ativo, excluido) VALUES ('Email', TRUE, FALSE);
INSERT INTO contato_tipo(descricao, ativo, excluido) VALUES ('Telefone', TRUE, FALSE);
INSERT INTO contato_tipo(descricao, ativo, excluido) VALUES ('Celular', TRUE, FALSE);
