package libClases;

public class ClienteTarifaPlana extends Cliente implements Cloneable, Proceso{
	
	private String nacionalidad;
	private float minHablados;
	private static float precioTP = 20;
	private static float minutosTP = 300;
	
	public ClienteTarifaPlana (String NIF, String nom, Fecha fNac, Fecha fAlta, float mH, String nac) {
		super(NIF, nom, fNac, fAlta);
		
		minHablados = mH;
		nacionalidad = nac;
	}
	
	public ClienteTarifaPlana (String NIF, String nom, Fecha fNac, float mH, String nac) {
		super(NIF, nom, fNac);
		
		minHablados = mH;
		nacionalidad = nac;
	}
	
	public ClienteTarifaPlana (ClienteTarifaPlana cTP) {
		super(cTP);
		
		nacionalidad = cTP.nacionalidad;
		minHablados = cTP.minHablados;
		
	}
	
	@Override
	public ClienteTarifaPlana clone() {
		// TODO Auto-generated method stub
		return new ClienteTarifaPlana(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public static float getLimite() {
		return minutosTP;
	}
	
	public static float getTarifa() {
		return precioTP;
	}
	
	public void setNacionalidad(String nac) {
		nacionalidad = nac;
	}
	
	public void setMinutos(float min) {
		minHablados = min;
	}
	
	public static void setTarifa(float minTP, float preTP) {
		minutosTP = minTP;
		precioTP = preTP;
	}
	
	public float factura() {
		
		float f = precioTP;
		float excesoMin = minHablados - minutosTP;
		
		if(excesoMin > 0) {
			
			f = (float) (precioTP + (excesoMin * 0.15f));
		}
		
		return f;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += nacionalidad + " [" + minutosTP + " por " + precioTP + "] " + minHablados + " --> " + factura();
		return s;
	}
	
	public void ver() {
		System.out.println(this.toString());
	}
	
	
}
