DROP PROCEDURE IF EXISTS db_erp.eliminar_marca;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_marca(

    IN pId_marca INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La marca no se puede eliminar';
	END;
    
    Delete from db_erp.marca where id_marca = pId_marca;

    COMMIT;
END $$;
    
DELIMITER $$;
