package pe.com.glovo.soap.util;

import java.util.Date;

public class Util {

	/***** Metodos particulares *****/
	public static boolean validarDecimales(String cad) {

		boolean hayPunto = false;
		StringBuffer parteEntera = new StringBuffer();
		StringBuffer parteDecimal = new StringBuffer();
		int i = 0, posicionDelPunto;

		try {

			for (i = 0; i < cad.length(); i++)
				if (cad.charAt(i) == '.') // Detectar si hay un punto decimal en la cadena
					hayPunto = true;
			if (hayPunto) // Si hay punto guardar la posicion donde se encuentra el carater punto
				posicionDelPunto = cad.indexOf('.'); // (si la cadena tiene varios puntos, detecta donde esta el
														// primero).
			else
				return false; // Si no hay punto; no es decimal

			if (posicionDelPunto == cad.length() - 1 || posicionDelPunto == 0) // Si el punto esta al final o al
																				// principio
																				// no es un decimal
				return false;

			for (i = 0; i < posicionDelPunto; i++)
				parteEntera.append(cad.charAt(i)); // Guardar la parte entera en una variable

			for (i = 0; i < parteEntera.length(); i++)
				if (!Character.isDigit(parteEntera.charAt(i))) // Si alguno de los caracteres de la parte entera no son
																// digitos no es decimal
					return false;

			for (i = posicionDelPunto + 1; i < cad.length(); i++)
				parteDecimal.append(cad.charAt(i)); // Guardar la parte decimal en una variable

			for (i = 0; i < parteDecimal.length(); i++)
				if (!Character.isDigit(parteDecimal.charAt(i))) // Si alguno de los caracteres de la parte decimal no es
																// un
																// digito no es decimal
					return false; // Incluye el caso en el que la cadena tenga dos o mas puntos

			return true;

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

	}

	public static boolean validarRangoDeFechas(Date fechaInicial, Date fechaFinal) {

		boolean isCorrecto = false;
		
		try {

			System.out.println("fechaInicial.getTime() " + fechaInicial.getTime());
			System.out.println("fechaFinal.getTime() " + fechaFinal.getTime());
			
			
			if(fechaInicial.getTime() > fechaFinal.getTime() ) {
				isCorrecto = false;
			}else {
				isCorrecto = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isCorrecto;
	}

}
