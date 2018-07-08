DROP PROCEDURE IF EXISTS db_erp.editar_empresa;

DELIMITER $$
CREATE PROCEDURE db_erp.editar_empresa(
	IN pId_empresa int,
    IN pNombre varchar(20)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La empresa no se actualizo correctamente';
	END;
    
    START TRANSACTION;
    
    Update db_erp.empresa set nombre=pNombre where id_empresa=pId_empresa;


    COMMIT;
END $$;
    
DELIMITER $$;
