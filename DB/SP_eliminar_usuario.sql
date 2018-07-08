DROP PROCEDURE IF EXISTS db_erp.eliminar_usuario;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_usuario(

    IN pId_usuario INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, El usuario no se puede eliminar';
	END;
    
    Delete from db_erp.usuario where id_usuario = pId_usuario;

    COMMIT;
END $$;
    
DELIMITER $$;
