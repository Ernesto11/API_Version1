DROP PROCEDURE IF EXISTS db_erp.eliminar_producto;

DELIMITER $$
CREATE PROCEDURE db_erp.eliminar_producto(

    IN pId_producto INT
    )

BEGIN
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		ROLLBACK;
        SELECT 'Error, El producto no se puede eliminar';
	END;
    
    Delete from db_erp.producto where id_producto = pId_producto;

    COMMIT;
END $$;
    
DELIMITER $$;

