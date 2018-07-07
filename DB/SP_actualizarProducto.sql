DROP PROCEDURE IF EXISTS db_erp.editar_producto;

DELIMITER $$
CREATE PROCEDURE db_erp.editar_producto(
	
    IN pId_producto INT,
    IN pFk_empresa INT,
    IN pFk_categoria INT,
    IN pFk_unidad_medida INT,
    IN pFk_marca INT,
    IN pNombre varchar(50),
    IN pPrecio double,
    IN pCosto double,
    IN pImpuesto double,
    IN pCodigo_barra int,
    IN pValor_unidad_medida double,
    IN pCantidad_disponible int,
    IN pCantidad_minima int,
    IN pCantidad_maxima int,
    IN pUrl_image varchar(50)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, los datos del producto no se insertaron correctamente';
	END;
    
    START TRANSACTION;
    
    Update db_erp.producto set fk_empresa=pFk_empresa,fk_categoria=pFk_categoria,fk_unidad_medida=pFk_unidad_medida,fk_marca=pFk_marca,nombre=pNombre,precio=pPrecio,
costo=pCosto,impuesto=pImpuesto,codigo_barra=pCodigo_barra,valor_unidad_medidad=pValor_unidad_medida,cantidad_disponible=pCantidad_disponible,
cantidad_minima=pCantidad_minima,cantidad_maxima=pCantidad_maxima,url_image=pUrl_image where id_producto=pId_producto;


    COMMIT;
END $$;
    
DELIMITER $$;
