DROP PROCEDURE IF EXISTS db_erp.crear_usuario;

DELIMITER $$
CREATE PROCEDURE db_erp.crear_usuario(
    IN pNombre varchar(10),
    IN pContrasenna varchar(10),
    IN pTipo varchar(10)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear el usuario';
	END;
    
    START TRANSACTION;
    
    INSERT INTO db_erp.usuario(`nombre`,`contrasenna`,`tipo`) values(pNombre, pContrasenna,pTipo);


    COMMIT;
END $$;
    
DELIMITER $$;

