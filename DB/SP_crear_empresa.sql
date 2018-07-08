DROP PROCEDURE IF EXISTS db_erp.crear_empresa;

DELIMITER $$
CREATE PROCEDURE db_erp.crear_empresa(
    IN pFk_usuario int,
    IN pNombre varchar(20)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear la empresa';
	END;
    
    START TRANSACTION;
    
    INSERT INTO db_erp.empresa(`fk_usuario`,`nombre`) values(pFk_usuario,pNombre);


    COMMIT;
END $$;
    
DELIMITER $$;

