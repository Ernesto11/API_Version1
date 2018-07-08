DROP PROCEDURE IF EXISTS db_erp.obtener_empresa_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_empresa_id(

    IN pId_empresa INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from empresa where id_empresa = pId_empresa;
    
    COMMIT;
END $$;
    
DELIMITER $$;
