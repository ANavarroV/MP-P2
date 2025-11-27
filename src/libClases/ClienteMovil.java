package libClases;

public class ClienteMovil extends Cliente{
	
	private Fecha fechaPermanencia;
	private float minHablados;
	private float precioMin;
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, Fecha fAlta, Fecha fPer, float minH, float precioM) {
		super(NIF, nom, fNac, fAlta);
		
		fechaPermanencia = new Fecha(fPer);
		minHablados = minH;
		precioMin = precioM;
	}
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, float minH, float precioM) {
		super(NIF, nom, fNac);
		
		Fecha fAlta = super.getFechaAlta();
		fechaPermanencia = new Fecha(fAlta.getDia(), fAlta.getMes(), fAlta.getAnio()+1);
		minHablados = minH;
		precioMin = precioM;
	}

}
