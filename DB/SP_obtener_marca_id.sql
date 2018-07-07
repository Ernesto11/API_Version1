DROP PROCEDURE IF EXISTS db_erp.obtener_marca_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_marca_id(

    IN pId_marca INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from marca where id_marca = pId_marca;
    
    COMMIT;
END $$;
    
DELIMITER $$;
