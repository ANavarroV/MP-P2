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

	}

	@Override
	public Empresa clone() {
		// TODO Auto-generated method stub
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

	/*private Fecha pedirFecha(Scanner sc) {
		Fecha fecha = null;
		boolean valida = false;
		int dia, mes, anio;

		do {
			System.out.print("Introduce la Fecha (dd/mm/aaaa): ");
			String cadena = sc.next(); // o nextLine(), según cómo leas el resto
			String[] tokens = cadena.split("/");

			try {
				if (tokens.length != 3) {
					throw new NumberFormatException();
				}

				dia = Integer.parseInt(tokens[0]);
				mes = Integer.parseInt(tokens[1]);
				anio = Integer.parseInt(tokens[2]);

				fecha = new Fecha(dia, mes, anio);

				// validación básica
				if (fecha.getDia() != dia || fecha.getMes() != mes) {
					throw new NumberFormatException();
				}

				valida = true;
			} catch (NumberFormatException e) {
				System.out.println("Fecha no válida");
			}
		} while (!valida);

		return fecha;
	}*/

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

	public int factura() {

		int factura = 0;
		
		for(int i = 0; i < nClientes; i++) {
			
		}

		return factura;
	}

	public void descuento(int desc) {

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
