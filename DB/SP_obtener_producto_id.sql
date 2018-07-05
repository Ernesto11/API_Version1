DROP PROCEDURE IF EXISTS db_erp.obtener_producto_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_producto_id(

    IN pId_producto INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from producto where id_producto = pId_producto;
    
    COMMIT;
END $$;
    
DELIMITER $$;
