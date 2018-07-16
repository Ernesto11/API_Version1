DROP PROCEDURE IF EXISTS db_erp.obtener_usuarios;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_usuarios()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from usuario;
    
    COMMIT;
END $$;
    
DELIMITER $$;