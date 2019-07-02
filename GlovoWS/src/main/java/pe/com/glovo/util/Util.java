package pe.com.glovo.util;

public class Util {

	// Metodos particulares
	public static boolean validarLongitudDNI(String nroDoc) {

		boolean ok = false;

		try {

			int longitud = nroDoc.length();

			if (longitud == Constantes.LONGITUD_DNI) {
				ok = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public static boolean validarLongitudRUC(String nroRUC) {

		boolean ok = false;

		try {

			int longitud = nroRUC.length();

			if (longitud == Constantes.LONGITUD_RUC) {
				ok = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;

	}

}
