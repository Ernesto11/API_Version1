DROP PROCEDURE IF EXISTS db_erp.editar_categoria;

DELIMITER $$
CREATE PROCEDURE db_erp.editar_categoria(
	IN pId_categoria int,
    IN pNombre varchar(15)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La categoría no se actualizo correctamente';
	END;
    
    START TRANSACTION;
    
    Update db_erp.categoria set nombre=pNombre where id_categoria=pId_categoria;


    COMMIT;
END $$;
    
DELIMITER $$;
