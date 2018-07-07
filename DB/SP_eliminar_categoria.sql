DROP PROCEDURE IF EXISTS db_erp.eliminar_categoria;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_categoria(

    IN pId_categoria INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La categoría no se puede eliminar';
	END;
    
    Delete from db_erp.categoria where id_categoria = pId_categoria;

    COMMIT;
END $$;
    
DELIMITER $$;
