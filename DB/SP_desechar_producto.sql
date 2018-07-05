DROP PROCEDURE IF EXISTS db_erp.desechar_producto;

DELIMITER $$
CREATE PROCEDURE db_erp.desechar_producto(
	
    IN pId_producto INT,
    IN pCantidadDesecho INT
    )

BEGIN
	
    DECLARE pCantidad_disponible INT;
    DECLARE pCantidad_actual INT;
     
	
    START TRANSACTION;
    Select @pCantidad_actual := (cantidad_disponible-pCantidadDesecho) From db_erp.producto where id_producto = pId_producto;
    
    INSERT INTO db_erp.desecho(`fk_producto`,`fecha`,`cantidad`) values(pId_producto,CURDATE(),pCantidadDesecho);
    
    if (@pCantidad_actual >= 0) then
		Update db_erp.producto set cantidad_disponible=@pCantidad_actual where id_producto = pId_producto;
	else
		Update db_erp.producto set cantidad_disponible=0 where id_producto = pId_producto;
    end if;
    COMMIT;
END $$;
    
DELIMITER $$;