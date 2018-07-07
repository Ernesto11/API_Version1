DROP PROCEDURE IF EXISTS db_erp.crear_unidad_medida;

DELIMITER $$
CREATE PROCEDURE db_erp.crear_unidad_medida(
    IN pNombre varchar(15),
    IN pSimbolo varchar(5)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear la unidad de medida';
	END;
    
    START TRANSACTION;
    
    INSERT INTO db_erp.unidad_medida(`nombre`,`simbolo`) values(pNombre,pSimbolo);


    COMMIT;
END $$;
    
DELIMITER $$;

