DROP PROCEDURE IF EXISTS db_erp.editar_marca;

DELIMITER $$
CREATE PROCEDURE db_erp.editar_marca(
	IN pId_marca int,
    IN pNombre varchar(15)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La marca no se actualizo correctamente';
	END;
    
    START TRANSACTION;
    
    Update db_erp.marca set nombre=pNombre where id_marca=pId_marca;


    COMMIT;
END $$;
    
DELIMITER $$;
