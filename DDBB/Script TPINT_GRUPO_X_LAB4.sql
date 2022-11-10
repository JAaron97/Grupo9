USE SYS;

CREATE SCHEMA TPINT_GRUPO_X_LAB4;

USE TPINT_GRUPO_X_LAB4;

CREATE TABLE IF NOT EXISTS Provincias (

ID INT AUTO_INCREMENT,
Descripcion VARCHAR(80) NOT NULL,

CONSTRAINT PK_PROVINCIAS PRIMARY KEY (ID),
CONSTRAINT UNIQUE_NAME_PROVINCIAS UNIQUE (Descripcion)
);

CREATE TABLE IF NOT EXISTS Localidades (

ID INT AUTO_INCREMENT,
ID_Provincia INT,
Descripcion VARCHAR(80) NOT NULL,

CONSTRAINT PK_LOCALIDADES PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS Nacionalidades (

ID INT AUTO_INCREMENT,
Descripcion VARCHAR(80) NOT NULL,

CONSTRAINT PK_NACIONALIDADES PRIMARY KEY (ID),
CONSTRAINT UNIQUE_NAME_NACIONALIDADES UNIQUE (Descripcion)
);

CREATE TABLE IF NOT EXISTS Telefonos (

ID INT AUTO_INCREMENT,
Telefono_1 VARCHAR(15) NOT NULL,
Telefono_2 VARCHAR(15),
Telefono_3 VARCHAR(15),
Telefono_4 VARCHAR(15),

CONSTRAINT PK_TELEFONOS PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS Usuarios (

DNI VARCHAR(10),
Nombre VARCHAR(50) NOT NULL,
Apellido VARCHAR(50) NOT NULL,
ID_Nacionalidades INT NOT NULL,
ID_Localidades INT NOT NULL,
CUIL VARCHAR(15) NOT NULL,
Sexo TINYINT(1) DEFAULT 0 NOT NULL,
Fecha_Nacimiento DATE NOT NULL,
Direccion VARCHAR(100) NOT NULL,
Mail VARCHAR(250) NOT NULL,
ID_Telefonos INT NOT NULL,
Password VARCHAR(512) NOT NULL,
Tipo_user TINYINT(1) DEFAULT 0 NOT NULL,

CONSTRAINT PK_USUARIOS PRIMARY KEY (DNI)
);

CREATE TABLE IF NOT EXISTS Tipo_Cuentas (

ID INT AUTO_INCREMENT,
Descripcion VARCHAR(80) NOT NULL,

CONSTRAINT PK_TIPO_CUENTA PRIMARY KEY (ID),
CONSTRAINT UNIQUE_NAME_TIPO_CUENTA UNIQUE (Descripcion)
);

CREATE TABLE IF NOT EXISTS Cuentas (

Numero_Cuenta VARCHAR(10),
DNI_Usuario VARCHAR(10) NOT NULL,
Fecha_Creacion DATE NOT NULL,
ID_Tipo_Cuenta INT NOT NULL,
CBU VARCHAR(15) NOT NULL,
Saldo DECIMAL(15,2) NOT NULL,

CONSTRAINT PK_CUENTAS PRIMARY KEY (Numero_Cuenta)
);

CREATE TABLE IF NOT EXISTS Tipo_Movimientos (

ID INT AUTO_INCREMENT,
Descripcion VARCHAR(80) NOT NULL,

CONSTRAINT PK_TIPO_MOVIMIENTO PRIMARY KEY (ID),
CONSTRAINT UNIQUE_NAME_TIPO_MOVIMIENTO UNIQUE (Descripcion)
);

CREATE TABLE IF NOT EXISTS Movimientos (

ID VARCHAR(20),
Fecha DATE NOT NULL,
ID_Tipo_Movimiento INT NOT NULL,
Importe DECIMAL(15,2) NOT NULL,
Cuenta_Origen VARCHAR(10) NOT NULL,
Cuenta_Destino VARCHAR(10) NOT NULL,

CONSTRAINT PK_MOVIMIENTOS PRIMARY KEY (ID),
CONSTRAINT CHK_CUENTA CHECK (Cuenta_Origen != Cuenta_Destino)
);

CREATE TABLE IF NOT EXISTS Numero_Cuotas (

ID INT AUTO_INCREMENT,
Descripcion VARCHAR(20) NOT NULL,

CONSTRAINT PK_NUMERO_CUOTAS PRIMARY KEY (ID),
CONSTRAINT UNIQUE_NAME_NUMERO_CUOTAS UNIQUE (Descripcion)
);

CREATE TABLE IF NOT EXISTS Solicitud_Prestamo (

ID INT AUTO_INCREMENT,
DNI_Usuario VARCHAR(10) NOT NULL,
Importe_Solicitado DECIMAL(15,2) NOT NULL,
ID_Numero_Cuotas INT NOT NULL,
Cuenta_Destinataria VARCHAR(10) NOT NULL,
Fecha DATE NOT NULL,
Estado TINYINT(2) DEFAULT 0 NOT NULL,

CONSTRAINT PK_SOLICITUD_PRESTAMO PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS Prestamos (

ID INT AUTO_INCREMENT,
DNI_Usuario VARCHAR(10) NOT NULL,
ID_Solicitud_Prestamo INT NOT NULL,
Cuenta_Destinataria VARCHAR(10) NOT NULL,
Fecha DATE NOT NULL,
Importe_Interes DECIMAL(15,2) NOT NULL,

CONSTRAINT PK_PRESTAMOS PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS Cuotas (

ID INT,
ID_Prestamo INT,
Importe DECIMAL(15,2) NOT NULL,
Estado_Pago TINYINT(1) DEFAULT 0 NOT NULL,
Fecha DATE,

CONSTRAINT PK_CUOTAS PRIMARY KEY (ID,ID_Prestamo)
);

ALTER TABLE Localidades ADD CONSTRAINT FK_PROVINCIAS_LOCALIDADES FOREIGN KEY (ID_Provincia) REFERENCES Provincias (ID);

ALTER TABLE Usuarios ADD CONSTRAINT FK_NACIONALIDADES_USUARIOS FOREIGN KEY (ID_Nacionalidades) REFERENCES Nacionalidades (ID);

ALTER TABLE Usuarios ADD CONSTRAINT FK_LOCALIDADES_USUARIOS FOREIGN KEY (ID_Localidades) REFERENCES Localidades (ID);

ALTER TABLE Usuarios ADD CONSTRAINT FK_TELEFONOS_USUARIOS FOREIGN KEY (ID_Telefonos) REFERENCES Telefonos (ID);

ALTER TABLE Cuentas ADD CONSTRAINT FK_DNI_CUENTAS FOREIGN KEY (DNI_Usuario) REFERENCES Usuarios (DNI);

ALTER TABLE Cuentas ADD CONSTRAINT FK_TIPOCUENTA_CUENTA FOREIGN KEY (ID_Tipo_Cuenta) REFERENCES Tipo_Cuentas (ID);

ALTER TABLE Movimientos ADD CONSTRAINT FK_TIPOMOVIMIENTOS_MOVIMIENTOS FOREIGN KEY (ID_Tipo_Movimiento) REFERENCES Tipo_Movimientos (ID);

ALTER TABLE Movimientos ADD CONSTRAINT FK_CUENTAS_MOVIMIENTO1 FOREIGN KEY (Cuenta_Origen) REFERENCES Cuentas (Numero_Cuenta);

ALTER TABLE Movimientos ADD CONSTRAINT FK_CUENTAS_MOVIMIENTO2 FOREIGN KEY (Cuenta_Destino) REFERENCES Cuentas (Numero_Cuenta);

ALTER TABLE Solicitud_Prestamo ADD CONSTRAINT FK_SOLICITUD_DNI FOREIGN KEY (DNI_Usuario) REFERENCES Usuarios (DNI);

ALTER TABLE Solicitud_Prestamo ADD CONSTRAINT FK_SOLICITUD_NUMERO_CUOTAS FOREIGN KEY (ID_Numero_Cuotas) REFERENCES Numero_Cuotas (ID);

ALTER TABLE Solicitud_Prestamo ADD CONSTRAINT FK_SOLICITUD_CUENTAS FOREIGN KEY (Cuenta_Destinataria) REFERENCES Cuentas (Numero_Cuenta);

ALTER TABLE Prestamos ADD CONSTRAINT FK_PRESTAMOS_DNI FOREIGN KEY (DNI_Usuario) REFERENCES Usuarios (DNI);

ALTER TABLE Prestamos ADD CONSTRAINT FK_PRESTAMOS_SOLICITUD FOREIGN KEY (ID_Solicitud_Prestamo) REFERENCES Solicitud_Prestamo (ID);

ALTER TABLE Prestamos ADD CONSTRAINT FK_PRESTAMOS_CUENTAS FOREIGN KEY (Cuenta_Destinataria) REFERENCES Cuentas (Numero_Cuenta);

ALTER TABLE CUOTAS ADD CONSTRAINT FK_CUOTAS_PRESTAMOS FOREIGN KEY (ID_Prestamo) REFERENCES Prestamos (ID);







