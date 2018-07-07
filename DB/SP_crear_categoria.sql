DROP PROCEDURE IF EXISTS db_erp.crear_categoria;

DELIMITER $$
CREATE PROCEDURE db_erp.crear_categoria(
    IN pNombre varchar(50)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, No es posible crear la categoría';
	END;
    
    START TRANSACTION;
    
    INSERT INTO db_erp.categoria(`nombre`) values(pNombre);


    COMMIT;
END $$;
    
DELIMITER $$;

