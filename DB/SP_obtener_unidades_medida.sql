DROP PROCEDURE IF EXISTS db_erp.obtener_unidades_medida;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_unidades_medida()

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from unidad_medida;
    
    COMMIT;
END $$;
    
DELIMITER $$;