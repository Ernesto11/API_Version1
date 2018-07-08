DROP PROCEDURE IF EXISTS db_erp.eliminar_empresa;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_empresa(

    IN pId_empresa INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La empresa no se puede eliminar';
	END;
    
    Delete from db_erp.empresa where id_empresa = pId_empresa;

    COMMIT;
END $$;
    
DELIMITER $$;
