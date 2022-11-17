CREATE TABLE IF NOT EXISTS usuarios (
	id_usuario integer PRIMARY KEY,
	nombre_usuario varchar (100) NOT NULL,
	email varchar (200) NOT NULL,
	contraseña varchar (50) NOT NULL,
	ubicacion varchar (100) NOT NULL
	);
	
CREATE TABLE IF NOT EXISTS elementos (
	id_elemento integer PRIMARY KEY,
	nombre_elemento varchar(100) NOT NULL,
	categoria integer NOT NULL,
	valor real NOT NULL,
	estado boolean NOT NULL,
	peso real NOT NULL,
	alto real NOT NULL,
	largo real NOT NULL,
	ancho real NOT NULL,
	id_usuario integer REFERENCES usuarios (id_usuario) NOT NULL
);


CREATE TABLE IF NOT EXISTS operadores_logisticos (
	id_operador_logistico integer PRIMARY KEY,
	razon_social varchar (200) NOT NULL,
	nit integer NOT NULL,
	email varchar (200) NOT NULL,
	contraseña varchar (50) NOT NULL,
	precioPorKilometro Real NOT NULL, 
	precioPorKilogramo Real NOT NULL,
	precioPorMetroCubico Real NOT NULL
	);

CREATE TABLE IF NOT EXISTS administradores (
	id_administrador integer PRIMARY KEY,
	nombre_administrador varchar (100) NOT NULL,
	email varchar (200) NOT NULL,
	contraseña varchar (50) NOT NULL
	);
	
CREATE TABLE IF NOT EXISTS trueques (
	id_trueque integer,
	fecha_trueque date,
	estado smallint NOT NULL,
	id_usuario1 integer REFERENCES usuarios (id_usuario) NOT NULL, 
	id_elemento1 integer REFERENCES elementos (id_elemento) NOT NULL,
	id_usuario2 integer REFERENCES usuarios (id_usuario) NOT NULL,
	id_elemento2 integer REFERENCES elementos (id_elemento) NOT NULL,
	id_operador_logistico integer REFERENCES operadores_logisticos (id_operador_logistico) NOT NULL,
	PRIMARY KEY (id_trueque, fecha_trueque)
	);

CREATE TABLE IF NOT EXISTS tokens (
	id_token varchar(50) PRIMARY KEY,
	timestampGeneracion varchar (50) NOT NULL,
	expirationTime varchar (50) NOT NULL,
	active varchar (50) NOT NULL,
	id_usuario integer REFERENCES usuarios (id_usuario),
	id_administrador integer REFERENCES administradores (id_administrador),
	id_operador_logistico integer REFERENCES operadores_logisticos (id_operador_logistico)
	);
	
CREATE TABLE IF NOT EXISTS notificaciones_elemento (
	id_notificacion_elemento integer PRIMARY KEY,
	tipo boolean NOT NULL,
	mensaje varchar (200) NOT NULL,
	id_administrador integer REFERENCES administradores (id_administrador)NOT NULL,
	id_elemento integer REFERENCES elementos (id_elemento) NOT NULL
);

CREATE TABLE IF NOT EXISTS notificaciones_trueque (
	id_notificacion_trueque integer PRIMARY KEY,
	id_administrador integer REFERENCES administradores (id_administrador)NOT NULL,
	id_trueque integer NOT NULL,
	fecha_trueque date NOT NULL,
	FOREIGN KEY (id_trueque, fecha_trueque) REFERENCES trueques (id_trueque, fecha_trueque)
);
	

