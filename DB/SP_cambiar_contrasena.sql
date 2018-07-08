DROP PROCEDURE IF EXISTS db_erp.cambiar_contrasena;

DELIMITER $$
CREATE PROCEDURE db_erp.cambiar_contrasena(
    IN pId_usuario INT,
    IN pContrasena varchar(10)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible cambiar la contraseña';
	END;
    
    START TRANSACTION;
    
    Update db_erp.usuario set contrasenna=pContrasena where id_usuario = pId_usuario;


    COMMIT;
END $$;
    
DELIMITER $$;
