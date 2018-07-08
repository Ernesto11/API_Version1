DROP PROCEDURE IF EXISTS db_erp.obtener_empresas;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_empresas()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from empresa;
    
    COMMIT;
END $$;
    
DELIMITER $$;