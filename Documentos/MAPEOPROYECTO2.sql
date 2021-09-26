
CREATE DATABASE revistas_digitales;

CREATE TABLE administrador(
nombre_usuario VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
contraseña VARCHAR(12) NOT NULL,
bloqueado BOOLEAN NOT NULL,
CONSTRAINT PK_ADMIN PRIMARY KEY(nombre_usuario)
);

CREATE TABLE suscriptor(
nombre_usuario VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
contraseña VARCHAR(12) NOT NULL,
CONSTRAINT PK_SUSCRIPTOR PRIMARY KEY(nombre_usuario)
);

CREATE TABLE editor(
nombre_usuario VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
contraseña VARCHAR(12) NOT NULL,
CONSTRAINT PK_EDITOR PRIMARY KEY(nombre_usuario)
);


CREATE TABLE revista(
codigo INT NOT NULL,
direccion VARCHAR(100) NOT NULL,
nombre VARCHAR(25) NOT NULL,
categoria VARCHAR(25) NOT NULL,
CONSTRAINT PK_REVISTA PRIMARY KEY(codigo)
);

CREATE TABLE suscriptores_revista(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
fecha_suscripcion DATE NOT NULL,
prcio INT NOT NULL,
CONSTRAINT PK_SUSCRIPCION PRIMARY KEY(codigo)
CONSTRAINT FK_TO_REVISTA FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo)
CONSTRAINT FK_TO_CLIENTE FOREIGN KEY(nombre_usuario)
REFERENCES suscriptor(nombre_usuario)
)

CREATE TABLE etiqueta_revista(
codigo_revista INT NOT NULL,
codigo INT NOT NULL,
etiqueta VARCHAR(30) NOT NULL,
CONSTRAINT PK_ETIQUETA PRIMARY KEY(codigo_revista)
CONSTRAINT FK_TO_REVISTA FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo)
);

CREATE TABLE edicion_revista(
codigo INT NOT NULL AUTO_INCREMENT,    
codigo_revista INT NOT NULL,
direccion VARCHAR(100) NOT NULL,
nombre VARCHAR(25) NOT NULL,
CONSTRAINT PK_EDICION PRIMARY KEY(codigo)
CONSTRAINT FK_TO_REVISTA1 FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo)
);


CREATE TABLE comentario(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
comentario VARCHAR(100) NOT NULL,
CONSTRAINT PK_COMENTARIO PRIMARY KEY(codigo)
CONSTRAINT FK_TO_REVISTA FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo)
CONSTRAINT FK_TO_SUSCRIPTOR FOREIGN KEY(nombre_usuario)
REFERENCES suscriptor(nombre_usuario)
);

CREATE TABLE megusta(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
CONSTRAINT PK_MEGUSTA PRIMARY KEY(codigo)
CONSTRAINT FK_TO_REVISTA FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo)
CONSTRAINT FK_TO_SUSCRIPTOR FOREIGN KEY(nombre_usuario)
REFERENCES suscriptor(nombre_usuario)
);