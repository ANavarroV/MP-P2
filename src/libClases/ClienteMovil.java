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
	
	public ClienteMovil(ClienteMovil cM) {
		super(cM);
		
		fechaPermanencia = (Fecha)cM.fechaPermanencia.clone();
		minHablados = cM.minHablados;
		precioMin = cM.precioMin;
	}
	
	@Override
	public ClienteMovil clone() {
		// TODO Auto-generated method stub
		return new ClienteMovil(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public Fecha getFPermanencia() {
		
		return fechaPermanencia;
	}
	
	public float getMinHablados() {
		
		return minHablados;
	}
	
	public float precioMin() {
		
		return precioMin;
	}
	
	public void setMinHablados(float mH) {
		
		minHablados = mH;
	}
	
	public void setPreciomin(float pM) {
		
		precioMin = pM;
	}
	
	public void setFPermanencia(Fecha f) {
		
		fechaPermanencia = (Fecha) f.clone();
	}
	
	@Override
	public String toString() {
		
		String s = super.toString();
		s += fechaPermanencia + " " + minHablados + " x " + precioMin + " --> " + minHablados*precioMin;
		return s;
	}
	
	public void ver() {
		
		System.out.println(this.toString());
	}
}
