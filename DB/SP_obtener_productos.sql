DROP PROCEDURE IF EXISTS db_erp.obtener_productos;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_productos()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from producto;
    
    COMMIT;
END $$;
    
DELIMITER $$;