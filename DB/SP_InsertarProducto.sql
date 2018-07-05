DROP PROCEDURE IF EXISTS db_erp.insertar_producto;

DELIMITER $$
CREATE PROCEDURE db_erp.insertar_producto(

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
    
    INSERT INTO db_erp.producto(`fk_empresa`,`fk_categoria`,`fk_unidad_medida`,`fk_marca`,`nombre`,`precio`,
`costo`,`impuesto`,`codigo_barra`,`valor_unidad_medidad`,`cantidad_disponible`,
`cantidad_minima`,`cantidad_maxima`,`url_image`)
values(pFk_empresa,pFk_categoria,pFk_unidad_medida,pFk_marca,pNombre,pPrecio,pCosto,pImpuesto,pCodigo_barra,pValor_unidad_medida,pCantidad_disponible,pCantidad_minima,pCantidad_maxima,pUrl_image);


    COMMIT;
END $$;
    
DELIMITER $$;

