CREATE TABLE cliente (
    id_cliente serial NOT NULL,
    dt_virou_cliente date,
    email_cliente character varying(255),
    nm_cliente character varying(80),
    senha_cliente character varying(255),
    tel_cliente character varying(10),
    id_endereco integer
);
CREATE TABLE empregado (
    id_empregado serial NOT NULL,
    nm_empregado character varying(80),
    tel_empregado character varying(10),
    id_endereco integer
);
CREATE TABLE endereco (
    id_endereco serial NOT NULL,
    nm_bairro character varying(255),
    nm_rua character varying(50),
    nu_casa integer,
    nu_cep character varying(8),
    cd_estado character varying(255)
);
CREATE TABLE entrega (
    id_entrega serial NOT NULL,
    dt_entrega timestamp without time zone,
    prz_entrega timestamp without time zone,
    st_entregue boolean,
    empregado_id_empregado integer,
    pedido_id_pedido integer
);
CREATE TABLE estado (
    id_estado serial NOT NULL,
    cd_estado character varying(255),
    nm_estado character varying(255)
);
CREATE TABLE fornecedor (
    id_fornecedor serial NOT NULL,
    email_fornecedor character varying(255),
    nm_contato character varying(255),
    nm_fornecedor character varying(80),
    tel_fornecedor character varying(10)
);
CREATE TABLE fornecedor_enderecos (
    fornecedor_id_fornecedor integer NOT NULL,
    enderecos_id_endereco integer NOT NULL
);
CREATE TABLE fornecedor_produtos (
    fornecedores_id_fornecedor integer NOT NULL,
    produtos_id_produto integer NOT NULL
);
CREATE TABLE pedido (
    id_pedido serial NOT NULL,
    dt_pedido timestamp without time zone,
    cliente_id_cliente integer
);
CREATE TABLE pedido_produtos (
    pedido_id_pedido integer NOT NULL,
    produtos_id_produto integer NOT NULL
);
CREATE TABLE produto (
    id_produto serial NOT NULL,
    desc_produto character varying(280),
    nm_produto character varying(60),
    preco_produto double precision
);

ALTER TABLE cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);

ALTER TABLE empregado
    ADD CONSTRAINT empregado_pkey PRIMARY KEY (id_empregado);

ALTER TABLE  endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id_endereco);

ALTER TABLE  entrega
    ADD CONSTRAINT entrega_pkey PRIMARY KEY (id_entrega);

ALTER TABLE  estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id_estado);

ALTER TABLE fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id_fornecedor);

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido);

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);


ALTER TABLE ONLY fornecedor_produtos
    ADD CONSTRAINT id_fornecedor_fk FOREIGN KEY (fornecedores_id_fornecedor) REFERENCES fornecedor(id_fornecedor);

ALTER TABLE ONLY fornecedor_produtos
    ADD CONSTRAINT id_produto_fk FOREIGN KEY (produtos_id_produto) REFERENCES produto(id_produto);

ALTER TABLE ONLY empregado
    ADD CONSTRAINT id_endereco_fk FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);

ALTER TABLE ONLY entrega
    ADD CONSTRAINT id_empregado_fk FOREIGN KEY (empregado_id_empregado) REFERENCES empregado(id_empregado);

ALTER TABLE ONLY fornecedor_enderecos
    ADD CONSTRAINT id_endereco_fk FOREIGN KEY (enderecos_id_endereco) REFERENCES endereco(id_endereco);

ALTER TABLE ONLY fornecedor_enderecos
    ADD CONSTRAINT id_fornecedor_fk FOREIGN KEY (fornecedor_id_fornecedor) REFERENCES fornecedor(id_fornecedor);

ALTER TABLE ONLY pedido_produtos
    ADD CONSTRAINT id_pedido_fk FOREIGN KEY (pedido_id_pedido) REFERENCES pedido(id_pedido);

ALTER TABLE ONLY pedido_produtos
    ADD CONSTRAINT id_produto_fk FOREIGN KEY (produtos_id_produto) REFERENCES produto(id_produto);

ALTER TABLE ONLY cliente
    ADD CONSTRAINT id_endereco_fk FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);


ALTER TABLE ONLY endereco
    ADD CONSTRAINT cd_estado_fk FOREIGN KEY (cd_estado) REFERENCES estado(cd_estado);


ALTER TABLE ONLY entrega
    ADD CONSTRAINT id_pedido_fk FOREIGN KEY (pedido_id_pedido) REFERENCES pedido(id_pedido);


ALTER TABLE ONLY pedido
    ADD CONSTRAINT id_cliente_fk FOREIGN KEY (cliente_id_cliente) REFERENCES cliente(id_cliente);
