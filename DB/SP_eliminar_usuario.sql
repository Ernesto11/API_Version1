DROP PROCEDURE IF EXISTS db_erp.eliminar_usuario;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_usuario(

    IN pNombreUsuario VARCHAR(30)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, El usuario no se puede eliminar';
	END;
    
    Delete from db_erp.usuario where nombreUsuario = pNombreUsuario;

    COMMIT;
END $$;
    
DELIMITER $$;
