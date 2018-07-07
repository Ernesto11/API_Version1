package api.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
	private static Configuracion configuracion;
	private String PORT;

	/*
	 * Archivo con configuraciones basicas del proyecto
	 * utiliza los archivos tipo propierties https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
	 * 
	 * Archivo Configuracion.properties
	 * 
	 * ->se debe crear un archivo Configuracion.properties en  /api/controlador/Configuracion.properties
	 * -> Estructura del archivo
	 PORT=3333
	 *-> Se debe dar gitignore al archivo
	 *
	 *Se deben guardar configuraciones que afecten el entorno del otro
	 *
	 */
	private Configuracion(){
		Properties prop = new Properties();
		InputStream input = null;
		
		String Directorio  = getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
		try {
			input = new FileInputStream(Directorio+"api/controlador/Configuracion.properties");
		    prop.load(input);
		    PORT=prop.getProperty("PORT");
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	public static synchronized Configuracion getConfiguracion() {
		if(configuracion == null){
			configuracion = new Configuracion();
		}
		return configuracion;
	}
	public String getPORT() {
		return PORT;
	}

	
}
