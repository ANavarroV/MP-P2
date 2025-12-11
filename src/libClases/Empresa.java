package libClases;

import java.util.Scanner;

public class Empresa implements Cloneable {

	private int nClientes;
	private Cliente[] clientes;

	public Empresa() {

		clientes = new Cliente[10];
		nClientes = 0;
	}

	public Empresa(Empresa e) {

		nClientes = e.nClientes;
		clientes = new Cliente[this.nClientes];

		for (int i = 0; i < this.nClientes; i++) {
			clientes[i] = (Cliente) e.clientes[i].clone();
		}
	}

	@Override
	public Empresa clone() {
		
		return new Empresa(this);
	}

	private int buscaDNI(String dni) {

		for (int i = 0; i < nClientes; i++) {
			if (clientes[i] != null && clientes[i].getNif().equals(dni)) {
				return i; // Devuelve la posición del cliente encontrado
			}
		}

		return -1; // Devuelve -1 si no ha encontrado un cliente con el mismo dni
	}

	private void ampliarCapacidad() {

		int nuevaCapacidad = clientes.length + 10;

		Cliente[] nuevo = new Cliente[nuevaCapacidad];

		for (int i = 0; i < nClientes; i++) {
			nuevo[i] = clientes[i];
		}

		clientes = nuevo;
	}

	public int nClienteMovil() {

		int cont = 0;

		for (int i = 0; i < nClientes; i++) {

			if (clientes[i] instanceof ClienteMovil) {
				cont++;
			}

		}

		return cont;
	}

	public int getN() {
		return nClientes;
	}

	public void alta() {

		Scanner sc = new Scanner(System.in);

		int opc = -1;

		System.out.print("DNI: ");
		String nDNI = sc.nextLine();

		int clienteBuscado = buscaDNI(nDNI);

		if (clienteBuscado == -1) {

			System.out.print("Nombre: ");
			String nNombre = sc.nextLine();

			System.out.println("Fecha Nacimiento: ");
			Fecha nFN = Fecha.pedirFecha();

			System.out.println("Fecha Alta: ");
			Fecha nFA = Fecha.pedirFecha();

			System.out.print("Minutos que habla al mes: ");
			float nMinutos = sc.nextFloat();

			sc.nextLine(); // Controla error de salto de linea

			do {

				System.out.print("Indique tipo de cliente (1-Movil, 2-Tarifa Plana): ");
				opc = sc.nextInt();

			} while (opc != 1 && opc != 2);

			switch (opc) {

			case 1: {

				System.out.print("Precio por minuto: ");
				float precioMin = sc.nextFloat();
				System.out.println("Fecha fin permanencia: ");
				Fecha finPermanencia = Fecha.pedirFecha();

				ClienteMovil cM = new ClienteMovil(nDNI, nNombre, nFN, nFA, finPermanencia, nMinutos, precioMin);

				if (nClientes == clientes.length) {
					ampliarCapacidad();
				}

				clientes[nClientes++] = cM;

				break;
			}

			case 2: {

				String nacionalidad = sc.nextLine();

				ClienteTarifaPlana cTP = new ClienteTarifaPlana(nDNI, nNombre, nFN, nFA, nMinutos, nacionalidad);

				if (nClientes == clientes.length) {
					ampliarCapacidad();
				}

				clientes[nClientes++] = cTP;

				break;
			}
			}

		} else {

			System.out.println("Ya existe un cliente con ese dni: ");
			System.out.println(clientes[clienteBuscado].toString());
		}

		// sc.close();

	}

	public void alta(Cliente c) {

		if (buscaDNI(c.getNif()) == -1) {

			if (nClientes == clientes.length) {
				ampliarCapacidad();
			}

			clientes[nClientes++] = c;

		}

	}

	public void baja() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca nif cliente a dar de baja: ");
		String bajaNIF = sc.nextLine();

		int pos = buscaDNI(bajaNIF);

		if (pos != -1) {

			System.out.println(clientes[pos].toString());

			boolean ok = false;

			do {

				System.out.print("¿Seguro que desea eliminarlo (s/n)?");
				String opc = sc.nextLine();

				if (opc.equals("s")) {

					Cliente eliminado = clientes[pos];
					clientes[pos] = clientes[nClientes - 1];
					clientes[nClientes - 1] = null;
					nClientes--;

					System.out.println(
							"El cliente " + eliminado.getNombre() + " con nif " + bajaNIF + " ha sido eliminado");
					ok = true;

				} else if (opc.equals("n")) {
					System.out.println("El cliente con nif " + bajaNIF + " no se elimina");

					ok = true;

				} else {
					System.out.println("Introduzca opcion valida!");
				}

			} while (!ok);

		}

	}

	public void baja(String nif) {

		int pos = buscaDNI(nif);

		if (pos != -1) {

			clientes[pos] = clientes[nClientes - 1];
			clientes[nClientes - 1] = null;
			nClientes--;

		}

	}

	public float factura() {

		float factura = 0;

		for (int i = 0; i < nClientes; i++) {
			
			factura += clientes[i].factura();
		}

		return factura;
	}

	/**
	 * El método descuento(int dto)que permita reducir el precio por minuto 
	 * a los clientes de tarifa Movil de la Empresa aplicando al precio original 
	 * que tenían el descuento indicado por parámetro
	 * @param desc
	 */
	public void descuento(int desc) {

		for(int i = 0; i < nClientes; i++) {
			
			if(clientes[i] instanceof ClienteMovil) {

			}
		}
	}

	@Override
	public String toString() {

		String s = "";

		for (int i = 0; i < nClientes; i++) {
			s += clientes[i].toString() + "\n";
		}

		return s;
	}

}
