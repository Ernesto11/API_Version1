DROP PROCEDURE IF EXISTS db_erp.obtener_unidad_medida_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_unidad_medida_id(

    IN pId_unidad_medida INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from unidad_medida where id_unidad_medida = pId_unidad_medida;
    
    COMMIT;
END $$;
    
DELIMITER $$;
