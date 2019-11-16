CREATE SEQUENCE cargo_id_seq;
CREATE SEQUENCE pessoa_id_seq;


CREATE TABLE pessoa
(
    id bigint NOT NULL DEFAULT nextval('pessoa_id_seq'::regclass),
    cnpj_ou_cpf character varying(14) COLLATE pg_catalog."default",
    data_nascimento timestamp without time zone,
    insc_estadual_ou_est_civil character varying(20) COLLATE pg_catalog."default",
    insc_municipal_ou_rg character varying(20) COLLATE pg_catalog."default",
    nome_fantasia_ou_sexo character varying(50) COLLATE pg_catalog."default",
    nome_ou_razao_social character varying(80) COLLATE pg_catalog."default",
    pessoa_tipo character varying(8) COLLATE pg_catalog."default",
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);


CREATE TABLE cliente
(
    id bigint NOT NULL,
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    bloqueado boolean NOT NULL DEFAULT false,
    inicio timestamp without time zone,
    limite_compras numeric(19,2),
    observacao character varying(200) COLLATE pg_catalog."default",
    recebe_email boolean NOT NULL DEFAULT false,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT fka710hls1tg15o3d4ok5biathy FOREIGN KEY (id)
        REFERENCES pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);


CREATE TABLE fornecedor
(
    id bigint NOT NULL,
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    bloqueado boolean NOT NULL DEFAULT false,
    codigo_rural character varying(50) COLLATE pg_catalog."default",
    fabricante boolean NOT NULL DEFAULT false,
    observacao character varying(200) COLLATE pg_catalog."default",
    responsavel character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT fornecedor_pkey PRIMARY KEY (id),
    CONSTRAINT fk4fumwc92qrfurlo1g6jhos1sq FOREIGN KEY (id)
        REFERENCES pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);


CREATE TABLE cargo
(
    id bigint NOT NULL DEFAULT nextval('cargo_id_seq'::regclass),
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    descricao character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cargo_pkey PRIMARY KEY (id)
);


CREATE TABLE funcionario
(
	id bigint NOT NULL,
    ativo boolean NOT NULL DEFAULT false,
    excluido boolean NOT NULL DEFAULT false,
    data_inclusao timestamp without time zone,
    ultima_atualizacao timestamp without time zone,
    banco_agencia character varying(10) COLLATE pg_catalog."default",
    banco_numero_conta character varying(10) COLLATE pg_catalog."default",
    cpts character varying(10) COLLATE pg_catalog."default",
    cpts_data_emissao timestamp without time zone,
    cpts_serie character varying(10) COLLATE pg_catalog."default",
    data_admissao timestamp without time zone,
    data_demissao timestamp without time zone,
    demissao_motivo character varying(200) COLLATE pg_catalog."default",
    matricula character varying(10) COLLATE pg_catalog."default",
    pis character varying(15) COLLATE pg_catalog."default",
    reservista_data_in timestamp without time zone,
    reservista_ra character varying(15) COLLATE pg_catalog."default",
    titulo_data_admissao timestamp without time zone,
    titulo_inscricao character varying(15) COLLATE pg_catalog."default",
    titulo_secao character varying(5) COLLATE pg_catalog."default",
    titulo_zona character varying(5) COLLATE pg_catalog."default",
    cargo bigint NOT NULL,
    CONSTRAINT funcionario_pkey PRIMARY KEY (id),
    CONSTRAINT fk92othhhe25gno2qtus5woc6ys FOREIGN KEY (cargo)
        REFERENCES cargo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkpjvvctvfjm69dvye3aea5k56f FOREIGN KEY (id)
        REFERENCES pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

