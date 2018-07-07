DROP PROCEDURE IF EXISTS db_erp.obtener_categorias;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_categorias()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from categoria;
    
    COMMIT;
END $$;
    
DELIMITER $$;