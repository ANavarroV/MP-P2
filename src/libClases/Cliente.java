package libClases;

public class Cliente {

	private final String nif; //dni del cliente (letra incluida) (NO puede cambiar)
	private final int codCliente; //codigo único (y fijo) generado por la aplicación
	private String nombre; //nombre completo del cliente (SI se puede modificar)
	private final Fecha fechaNac; //fecha nacimiento del cliente (NO se puede cambiar)
	private final Fecha fechaAlta; //fecha de alta del cliente (SI se puede modificar)
	
	public Cliente (String nif, String nom, Fecha fNac, Fecha fAlta) {
		
		this.nif = nif;
		nombre = nom;
		fechaNac = fNac;
		fechaAlta = fAlta;
	
	} //constructor
	
	public Cliente (String NIF, String nom, Fecha fNac); //constructor
	public String toString(); //devuelve una cadena con la información del cliente
	
}
