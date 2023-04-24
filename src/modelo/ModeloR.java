package modelo;

import java.sql.Date;

public class ModeloR {
	//modeloR se creó para sacar en una lista el resultSet de la query que viene en ReservaDAO
	private int id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private double valor;
	private int formaPago;
	//el constructor solo existe recibiendo todos los parámetros porque no podemos dejar un espacio o dejar un elemento sin recibir	
	public ModeloR(int id, Date fechaEntrada, Date fechaSalida, double valor, int formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public String[] getParametros() {
		String ret[] = new String[5];
		ret[0] = id + "";
		ret[1] = fechaEntrada + "";
		ret[2] = fechaSalida + "";
		ret[3] = valor + "";
		switch (formaPago) {
		case 0:
			ret[4] = "Tarjeta de Crédito";
			break;
		case 1:
			ret[4] = "Tarjeta de Débito";
			break;
		case 2:
			ret[4] = "Dinero en efectivo";
			break;
		}
		return ret;
	}
	//se relaciona con el método buscar datos, permite identificar un dato en cualquiera de los paràmetros del modelo
	public boolean consultaDato(String dato) {
		boolean ret = false;
		if (dato.equals(id + ""))
			ret = true;
		else if (dato.equals(fechaEntrada + ""))
			ret = true;
		else if (dato.equals(fechaSalida + ""))
			ret = true;
		else if (dato.equals(valor + ""))
			ret = true;
		else { 
			String compararFPago[]=new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"};
			if (dato.equals(compararFPago[formaPago]))
				ret = true;
		}
			
		
		return ret;
	}
}
