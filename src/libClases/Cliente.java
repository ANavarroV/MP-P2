package libClases;

public class Cliente {

	private final String nif; //dni del cliente (letra incluida) (NO puede cambiar)
	private final int codCliente; //codigo único (y fijo) generado por la aplicación
	private String nombre; //nombre completo del cliente (SI se puede modificar)
	private final Fecha fechaNac; //fecha nacimiento del cliente (NO se puede cambiar)
	private Fecha fechaAlta; //fecha de alta del cliente (SI se puede modificar)
	
	private static int contador = 1;
	private static Fecha fechaPorDefecto = new Fecha(01, 01, 2018);
	
	
	public Cliente (String NIF, String nom, Fecha fNac, Fecha fAlta) {
		
		nif = NIF;
		nombre = nom;
		fechaNac = fNac;
		fechaAlta = fAlta;
		
		codCliente = contador++;
	} 
	
	public Cliente (String NIF, String nom, Fecha fNac) {
		nif = NIF;
		nombre = nom;
		fechaNac = fNac;
		fechaAlta = fechaPorDefecto;
		codCliente = contador++;
	}
	
	public static Fecha getFechaPorDefecto() {
		
		return fechaPorDefecto;
	}
	
	public String toString() {
		String s = nif + " " + fechaNac + ": " + nombre + " (" + codCliente + " - " + fechaAlta + ")";
		return s;
	}
	
}

