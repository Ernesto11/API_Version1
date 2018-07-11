DROP DATABASE db_erp;
CREATE DATABASE db_erp;
USE db_erp;
# Tabla
CREATE TABLE Usuario(
    nombreUsuario VARCHAR(30) NOT NULL, 
    contrasenna VARCHAR(12) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    PRIMARY KEY (nombreUsuario)
);

CREATE TABLE Administrador(
	fk_nombreUsuario VARCHAR(30) NOT NULL, 
    puesto VARCHAR(25) NOT NULL
);

CREATE TABLE Empleado(
	fk_nombreUsuario VARCHAR(30) NOT NULL, 
    puesto VARCHAR(25) NOT NULL
);

CREATE TABLE Empresa(
	id_empresa int NOT NULL AUTO_INCREMENT ,
    fk_usuario VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL, 
    PRIMARY KEY (id_empresa)
);

CREATE TABLE EmpleadoXEmpresa(
	fk_nombreUsuario VARCHAR(30) NOT NULL,
    fk_empresa int NOT NULL,
    FOREIGN KEY (fk_nombreUsuario) REFERENCES Usuario(nombreUsuario),
    FOREIGN KEY (fk_empresa) REFERENCES Empresa(id_empresa)
);

CREATE TABLE Medio_Pago(
	id_medio_pago int NOT NULL AUTO_INCREMENT ,
    tipo VARCHAR(10) NOT NULL, 
    PRIMARY KEY (id_medio_pago)
);

CREATE TABLE Factura(
	id_factura int NOT NULL AUTO_INCREMENT ,
    fk_nombreUsuario VARCHAR(30) NOT NULL,
    fk_medio_pago int NOT NULL,
    fk_empresa int NOT NULL,
    fecha_emision date NOT NULL,
    detalle VARCHAR(20) NOT NULL,
    total double,
    PRIMARY KEY (id_factura)
);

CREATE TABLE Unidad_Medida(
	id_unidad_medida int NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR(30) NOT NULL,
    simbolo VARCHAR(10) NOT NULL,
    PRIMARY KEY (id_unidad_medida)
);
CREATE TABLE Categoria(
	id_categoria int NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_categoria)
);
CREATE TABLE Marca(
	id_marca int NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_marca)
);
CREATE TABLE Producto (
    id_producto int NOT NULL AUTO_INCREMENT,
    fk_empresa int,
    fk_categoria int NOT NULL,
    fk_unidad_medida int,
    fk_marca int,
    nombre Varchar(50) NOT NULL,
	precio double not null,
    costo double,
    impuesto double,
    codigo_barra int,
    valor_unidad_medidad double,
	cantidad_disponible int NOT NULL,
    cantidad_minima int,
    cantidad_maxima int,
    url_image Varchar(50) NOT NULL,
    PRIMARY KEY (id_producto),
    FOREIGN KEY (fk_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE Desecho (
    fk_producto int NOT NULL,
    fecha date,
	cantidad int,
    FOREIGN KEY (fk_producto) REFERENCES Producto(id_producto)
);
CREATE TABLE Promocion (
    fk_producto int NOT NULL,
    fecha date,
	cantidad int,
    porcentaje double,
    FOREIGN KEY (fk_producto) REFERENCES Producto(id_producto)
);
CREATE TABLE Linea (
    fk_factura int NOT NULL,
    fk_combo_producto int NOT NULL,
    tipo Varchar(10) NOT NULL,
	subtotal double,
    cantidad int,
    FOREIGN KEY (fk_factura) REFERENCES Factura(id_factura)
);
CREATE TABLE Combo (
    id_combo int NOT NULL AUTO_INCREMENT,
    nombre Varchar(10) NOT NULL,
    fecha date not NULL,
    PRIMARY KEY (id_combo)
);
CREATE TABLE ComboXProducto (
    fk_combo int NOT NULL,
    fk_producto int NOT NULL,
    cantidad int,
    FOREIGN KEY (fk_combo) REFERENCES Combo(id_combo),
    FOREIGN KEY (fk_producto) REFERENCES Producto(id_producto)
);
