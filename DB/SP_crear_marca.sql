DROP PROCEDURE IF EXISTS db_erp.crear_marca;

DELIMITER $$
CREATE PROCEDURE db_erp.crear_marca(
    IN pNombre varchar(50)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear la marca';
	END;
    
    START TRANSACTION;
    
    INSERT INTO db_erp.marca(`nombre`) values(pNombre);


    COMMIT;
END $$;
    
DELIMITER $$;

