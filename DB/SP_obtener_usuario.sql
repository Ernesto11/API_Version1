DROP PROCEDURE IF EXISTS db_erp.obtener_producto_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_usuario(
    IN pNombre varchar(10)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from usuario where nombre = pNombre;
    
    COMMIT;
END $$;
    
DELIMITER $$;
