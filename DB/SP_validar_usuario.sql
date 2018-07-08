DROP PROCEDURE IF EXISTS db_erp.validar_usuario;

DELIMITER $$
CREATE PROCEDURE db_erp.validar_usuario(
IN pNombre varchar(10),
IN pContrasenna VARCHAR(10)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear la categoría';
	END;
    
    START TRANSACTION;
    
      SELECT count(*) as usuario_valido
      FROM db_erp.usuario
      WHERE nombre= pNombre AND contrasenna = pContrasenna;  


    COMMIT;
END $$;
    
DELIMITER $$;