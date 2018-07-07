DROP PROCEDURE IF EXISTS db_erp.obtener_categoria_id;

DELIMITER $$
CREATE PROCEDURE db_erp.obtener_categoria_id(

    IN pId_categoria INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No se puede procesar la consulta';
	END;
    
    START TRANSACTION;
    Select * from categoria where id_categoria = pId_categoria;
    
    COMMIT;
END $$;
    
DELIMITER $$;
