

CREATE DATABASE dynamo_journals;

CREATE TABLE usuario(
nombre VARCHAR(40) NOT NULL,
apellido VARCHAR(40) NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
contrasenia VARCHAR(40) NOT NULL,
informacion VARCHAR(255) NOT NULL,
codigo_area INT NOT NULL,
CONSTRAINT PK_ADMIN PRIMARY KEY(nombre_usuario)
);


CREATE TABLE informacion(
nombre_usuario VARCHAR(20) NOT NULL,
informacion VARCHAR(255) NOT NULL,
CONSTRAINT PK_INFO PRIMARY KEY(nombre_usuario)
);


CREATE TABLE interes(
codigo INT NOT NULL AUTO_INCREMENT,
nombre_usuario VARCHAR(20) NOT NULL,
etiqueta VARCHAR(40) NOT NULL,
CONSTRAINT PK_INTERES PRIMARY KEY(codigo)
);


CREATE TABLE revista(
codigo_revista INT NOT NULL,
nombre_revista VARCHAR(50) NOT NULL,
nombre_editor VARCHAR(20),
categoria VARCHAR(35) NOT NULL,
descripcion VARCHAR(255) NOT NUll,
precio_sub DECIMAL(7,2) NOT NULL,
interaccion BOOLEAN NOT NULL,
bloqueo_sub BOOLEAN NOT NULL,
fecha_creacion DATE NOT NULL,
CONSTRAINT PK_REVISTA PRIMARY KEY(codigo_revista),
CONSTRAINT FK_TO_USER FOREIGN KEY(nombre_editor)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE etiqueta(
codigo INT NOT NULL AUTO_INCREMENT, 
nombre_etiqueta VARCHAR(30),
CONSTRAINT PK_ETIQUETA PRIMARY KEY(codigo)
);

CREATE TABLE categoria(
codigo INT NOT NULL AUTO_INCREMENT,
nombre_categoria VARCHAR(30) NOT NULL,
CONSTRAINT PK_CATEGORIA PRIMARY KEY(codigo)
);


CREATE TABLE comentario(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
comentario VARCHAR(255) NOT NULL,
fecha_comentario DATE NOT NULL,
CONSTRAINT PK_COMENTARIO PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTAC FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista),
CONSTRAINT FK_TO_SUSCRIPTORC FOREIGN KEY(nombre_usuario)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE costo_revista(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
costo_dia DECIMAL(7,2),
fecha_asignacion DATE NOT NULL,
CONSTRAINT PK_PORCENTAJE PRIMARY KEY(codigo)
);


CREATE TABLE costoglobal_revista(
codigo INT NOT NULL AUTO_INCREMENT, 
costo_dia DECIMAL(7,2) NOT NULL,
fecha_asignacion DATE NOT NULL,
CONSTRAINT PK_COSTOGLOB PRIMARY KEY(codigo)
);


CREATE TABLE edicion_revista(
codigo INT NOT NULL AUTO_INCREMENT,    
codigo_revista INT NOT NULL,
direccion VARCHAR(255) NOT NULL,
fecha_creacion DATE NOT NULL,
CONSTRAINT PK_EDICION PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTA FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista)
);


CREATE TABLE etiqueta_revista(
codigo INT NOT NULL AUTO_INCREMENT, 
codigo_revista INT NOT NULL,
etiqueta VARCHAR(30) NOT NULL,
CONSTRAINT PK_ETIQUETAR PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTAE FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista)
);


CREATE TABLE ganancias_suscripciones(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_revista VARCHAR(50) NOT NULL,
usuario_editor VARCHAR(20) NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
fecha_suscripcion DATE NOT NULL,
ingreso_sub DECIMAL(7,2) NOT NULL,
ganancia DECIMAL(7,2) NOT NULL,
CONSTRAINT PK_SUSCRIPCION PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTA2 FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista),
CONSTRAINT FK_TO_USUARIO1 FOREIGN KEY(nombre_usuario)
REFERENCES usuario(nombre_usuario)
);




CREATE TABLE megusta(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
fecha_megusta DATE NOT NULL,
CONSTRAINT PK_MEGUSTA PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTAM FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista),
CONSTRAINT FK_TO_SUSCRIPTORM FOREIGN KEY(nombre_usuario)
REFERENCES usuario(nombre_usuario)
);


CREATE TABLE porcentaje_ganancias(
codigo INT NOT NULL AUTO_INCREMENT,
porcentaje_usuario INT NOT NULL,
porcentaje_sistema INT NOT NULL,
fecha_asignacion DATE NOT NULL,
CONSTRAINT PK_PORCENTAJE PRIMARY KEY(codigo)
);


CREATE TABLE suscriptores_revista(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_revista INT NOT NULL,
nombre_revista VARCHAR(50) NOT NULL,
usuario_editor VARCHAR(20) NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
fecha_suscripcion DATE NOT NULL,
tipo_suscripcion VARCHAR(20) NOT NULL,
ganancia DECIMAL(7,2) NOT NULL,
CONSTRAINT PK_SUSCRIPCION PRIMARY KEY(codigo),
CONSTRAINT FK_TO_REVISTA1 FOREIGN KEY(codigo_revista)
REFERENCES revista(codigo_revista),
CONSTRAINT FK_TO_USUARIO FOREIGN KEY(nombre_usuario)
REFERENCES usuario(nombre_usuario)
);



INSERT INTO categoria (nombre_categoria) VALUES ('deporte'),('religion'),('espectaculo'),('cocina'),('viajes'),('politica'),('ciencia'),('casa'),('economia'),('cultura'),('entretenimiento'),('historia'),('fotografia'),('tecnologia'),('videojuegos'),('gastronomia'),('moda'),('musica'),('medicina'),('academico'),('industria'),('vehiculos');
INSERT INTO etiqueta (nombre_etiqueta) VALUES ('deporte'),('economia'),('electronica'),('cocina'),('hogar'),('naturaleza'),('artista'),('pinturas'),('reciclaje'),('vida'),('salud'),('historia');
INSERT INTO costoglobal_revista (costo_dia,fecha_asignacion) VALUES (2,'2021-10-26');
INSERT INTO porcentaje_ganancias (porcentaje_usuario,porcentaje_sistema,fecha_asignacion) VALUES (50,50,'2021-10-26');
INSERT INTO usuario (nombre,apellido,nombre_usuario,contrasenia,informacion,codigo_area) VALUES ('admin','admin','admin','5f4dcc3b5aa765d61d8327deb882cf99','admin',3);




CREATE USER 'system32'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT , INSERT
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP
    -> ON dynamo_journals.*
    -> TO 'system32'@'localhost';

    FLUSH PRIVILEGES;