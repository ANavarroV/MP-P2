package libClases;

public class Cliente implements Cloneable{

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
		fechaNac = new Fecha(fNac);
		fechaAlta = new Fecha(fAlta);
		
		codCliente = contador++;
	} 
	
	public Cliente (String NIF, String nom, Fecha fNac) {
		
		nif = NIF;
		nombre = nom;
		fechaNac = new Fecha(fNac);
		fechaAlta = new Fecha(fechaPorDefecto);
		
		codCliente = contador++;
	}
	
	public Cliente(Cliente c) {
		
		this.nombre = c.nombre;
		this.nif = c.nif;
		this.fechaAlta = new Fecha(c.fechaAlta);
		this.fechaNac = new Fecha(c.fechaNac);
		
		this.codCliente = contador++;
	}
	
	/**
	 * No se utiliza super.clone() porque queremos que cada cliente tenga un codCliente
	 * diferente si o si, por lo tanto no se puede usar.
	 * 
	 * Utilizamos el cliente de copia para hacer el clone.
	 * 
	 * No haría falta implementar Cloneable 
	 */
	@Override
	public Cliente clone() {
        return new Cliente(this);
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;                // misma referencia
	    if (obj == null) return false;
	    
	    // MISMO TIPO EXACTO (Cliente, ClienteMovil, ClienteTarifaPlana...)
	    if (getClass() != obj.getClass()) return false;
	    
	    Cliente other = (Cliente) obj;
	    // IGUALES si tienen el mismo NIF
	    return this.nif.equals(other.nif);
	}
	
	@Override
	public int hashCode() {
		
		return nif.hashCode();
	}
	
	public String getNif(){
		
		return nif;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getCodCliente() {
		return codCliente;
	}
	
	public void setNombre(String nom) {
		
		nombre = nom;
	}
	
	/*
	 * Al ser mutable, los métodos getFecha( ) de la clase Cliente NO DEBEN
	 * devolver directamente la referencia del objeto Fecha que contienen sino una copia.
	 */
	public static Fecha getFechaPorDefecto() {
		
		return (Fecha)fechaPorDefecto.clone();
	}
	
	public Fecha getFechaAlta() {
		
		return (Fecha)fechaAlta.clone();
	}
	
	public Fecha getFechaNac() {
		
		return (Fecha)fechaNac.clone();
	}
	
	public void setFechaAlta(Fecha f) {
		
		fechaAlta = new Fecha(f);
	}
	
	public static void setFechaPorDefecto(Fecha f) {
		fechaPorDefecto = new Fecha(f);
	}
	
	public String toString() {
		String s = nif + " " + fechaNac + ": " + nombre + " (" + codCliente + " - " + fechaAlta + ") ";
		return s;
	}
	
	public void ver() {
		System.out.println(this.toString());
	}
	
}

