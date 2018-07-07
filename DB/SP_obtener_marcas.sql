DROP PROCEDURE IF EXISTS db_erp.obtener_marcas;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_marcas()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from marca;
    
    COMMIT;
END $$;
    
DELIMITER $$;