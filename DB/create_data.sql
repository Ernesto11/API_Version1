USE db_erp;
DELETE FROM empresa;
ALTER TABLE empresa AUTO_INCREMENT = 1;
DELETE FROM empleado;
ALTER TABLE empleado AUTO_INCREMENT = 1;
DELETE FROM administrador;
ALTER TABLE administrador AUTO_INCREMENT = 1;
DELETE FROM usuario;
ALTER TABLE usuario AUTO_INCREMENT = 1;
DELETE FROM producto;
ALTER TABLE producto AUTO_INCREMENT = 1;
DELETE FROM categoria;
ALTER TABLE categoria AUTO_INCREMENT = 1;
DELETE FROM marca;
ALTER TABLE marca AUTO_INCREMENT = 1;
DELETE FROM unidad_medida;
ALTER TABLE unidad_medida AUTO_INCREMENT = 1;


INSERT INTO usuario(`nombre`,`contrasenna`,`tipo`)VALUES
("usr1","12345","admin"),("usr2","12345","usuario"),("usr3","12345","admin"),("usr4","12345","usuario");

INSERT INTO empleado(`fk_usuario`,`nombre`)VALUES
(2,"nombre 1"),(4,"nombre 2");

INSERT INTO administrador(`fk_usuario`,`nombre`)VALUES
(1,"nombre 1"),(3,"nombre 2");

INSERT INTO empresa(`fk_usuario`,`nombre`)VALUES
(1,"nombre 1"),(3,"nombre 2");

INSERT INTO categoria (`nombre`) VALUES
("categoria 1"),("categoria 2"),("categoria 3"),("categoria 4");

INSERT INTO unidad_medida(`nombre`,`simbolo`)VALUES
("nombre 1","n1"),("nombre 2","n2"),("nombre 3","n3"),("nombre 4","n4");

INSERT INTO marca(`nombre`)VALUES
("none"),("Marca 1");


INSERT INTO producto(`fk_empresa`,`fk_categoria`,`fk_unidad_medida`,`fk_marca`,`nombre`,`precio`,
`costo`,`impuesto`,`codigo_barra`,`valor_unidad_medidad`,`cantidad_disponible`,
`cantidad_minima`,`cantidad_maxima`,`url_image`)
VALUES
(1,1,1,1,"nombre 1",1000,500,0,10,10,10,0,15,"none"),
(1,1,1,1,"nombre 2",1000,500,0,10,10,10,0,15,"none"),
(1,1,1,1,"nombre 3",1000,500,0,10,10,10,0,15,"none"),
(1,1,1,1,"nombre 4",1000,500,0,10,10,10,0,15,"none");

INSERT INTO combo(`nombre`)
VALUES
("combo 1"),("combo 2");


