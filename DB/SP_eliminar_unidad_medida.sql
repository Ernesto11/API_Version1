DROP PROCEDURE IF EXISTS db_erp.eliminar_unidad_medida;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_unidad_medida(

    IN pId_unidad_medida INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, La unidad de medida no se puede eliminar';
	END;
    
    Delete from db_erp.unidad_medida where id_unidad_medida = pId_unidad_medida;

    COMMIT;
END $$;
    
DELIMITER $$;
