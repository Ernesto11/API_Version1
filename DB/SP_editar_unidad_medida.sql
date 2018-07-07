DROP PROCEDURE IF EXISTS db_erp.editar_unidad_medida;

DELIMITER $$
CREATE PROCEDURE db_erp.editar_unidad_medida(
	IN pId_unidad_medida int,
    IN pNombre varchar(15),
    IN pSimbolo varchar(15)
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La unidad de medida no se actualizo correctamente';
	END;
    
    START TRANSACTION;
    
    Update db_erp.unidad_medida set nombre=pNombre,simbolo = pSimbolo where id_unidad_medida=pId_unidad_medida;


    COMMIT;
END $$;
    
DELIMITER $$;
