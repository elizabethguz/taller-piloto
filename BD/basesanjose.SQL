CREATE TABLE CLIENTE
(
	id_cliente            INTEGER NOT NULL,
	dni_cliente           VARCHAR(20) NOT NULL,
	nombre_cliente        VARCHAR(50) NULL,
	sexo_cliente          VARCHAR(20) NULL,
	correo_cliente        VARCHAR(20) NULL,
	celular_cliente       INTEGER NULL,
	cargo_cliente         VARCHAR(20) NULL,
	descripcion_cliente   VARCHAR(50) NULL,
	id_tipocliente        INTEGER NOT NULL
)
;



ALTER TABLE CLIENTE
	ADD  PRIMARY KEY (id_cliente,id_tipocliente)
;



CREATE TABLE DETALLE_PEDIDO
(
	id_detallepedido      INTEGER NOT NULL,
	cantidad_detallepedido  INTEGER NULL,
	preciototal_detallepedido  INTEGER NULL,
	adelanto_detallepedido  INTEGER NULL,
	faltante_detallepedido  INTEGER NULL,
	id_servicio           INTEGER NOT NULL,
	id_pedido             INTEGER NOT NULL,
	cod_servicio          VARCHAR(20) NOT NULL,
	id_cliente            INTEGER NOT NULL,
	id_tipocliente        INTEGER NOT NULL
)
;



ALTER TABLE DETALLE_PEDIDO
	ADD  PRIMARY KEY (id_detallepedido,id_servicio,id_pedido,cod_servicio,id_cliente,id_tipocliente)
;



CREATE TABLE PEDIDO
(
	id_pedido             INTEGER NULL,
	fecha_pedido          DATE NULL,
	fechaentrega_pedido   DATE NULL,
	entregado_pedido      VARCHAR(20) NULL,
	tiporecibo_pedido     VARCHAR(20) NULL,
	descripcion_pedido    VARCHAR(50) NULL,
	id_cliente            INTEGER NOT NULL,
	id_tipocliente        INTEGER NOT NULL
)
;



ALTER TABLE PEDIDO
	ADD  PRIMARY KEY (id_pedido,id_cliente,id_tipocliente)
;



CREATE TABLE SERVICIO
(
	id_servicio           INTEGER NOT NULL,
	cod_servicio          VARCHAR(20) NULL,
	nombre_servicio       VARCHAR(50) NULL,
	preciounidad_servicio  INTEGER NULL
)
;



ALTER TABLE SERVICIO
	ADD  PRIMARY KEY (id_servicio,cod_servicio)
;



CREATE TABLE TIPO_CLIENTE
(
	id_tipocliente        INTEGER NULL,
	ruc_tipocliente       VARCHAR(20) NULL,
	nombre_tipocliente    VARCHAR(20) NULL,
	descripcion_tipocliente  VARCHAR(50) NULL
)
;



ALTER TABLE TIPO_CLIENTE
	ADD  PRIMARY KEY (id_tipocliente)
;



CREATE TABLE USUARIO
(
	id_usuario            INTEGER NULL,
	login_usuario         VARCHAR(20) NULL,
	password_usuario      VARCHAR(20) NULL
)
;



ALTER TABLE USUARIO
	ADD  PRIMARY KEY (id_usuario,password_usuario)
;



ALTER TABLE CLIENTE
	ADD FOREIGN KEY R_30 (id_tipocliente) REFERENCES TIPO_CLIENTE(id_tipocliente)
;



ALTER TABLE DETALLE_PEDIDO
	ADD FOREIGN KEY R_14 (id_servicio,cod_servicio) REFERENCES SERVICIO(id_servicio,cod_servicio)
;


ALTER TABLE DETALLE_PEDIDO
	ADD FOREIGN KEY R_15 (id_pedido,id_cliente,id_tipocliente) REFERENCES PEDIDO(id_pedido,id_cliente,id_tipocliente)
;



ALTER TABLE PEDIDO
	ADD FOREIGN KEY R_22 (id_cliente,id_tipocliente) REFERENCES CLIENTE(id_cliente,id_tipocliente)
;


ALTER TABLE PEDIDO
	ADD FOREIGN KEY R_26 (id_tipocliente) REFERENCES TIPO_CLIENTE(id_tipocliente)
;


