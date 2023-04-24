package modelo;

import java.sql.Date;

public class ModeloH {
// modeloH se creó para sacar en una lista el resultSet de la query que viene en HuespedesDAO
	private int id;
	private String nombre;
	private String apellido;
	private Date fecha_de_nacimiento;
	private String nacionalidad;
	private String telefono;
	private int idReserva;
//el constructor solo existe recibiendo todos los parámetros porque no podemos dejar un espacio o dejar un elemento sin recibir	
	public ModeloH(int id, String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad, String telefono, int idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_de_nacimiento= fecha_de_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono= telefono;
		this.idReserva= idReserva;
	}

public String[] getParametros(){
	String ret[]= new String[7];
	ret[0]=id+"";
	ret[1]=nombre+"";
	ret[2]=apellido+"";
	ret[3]=fecha_de_nacimiento+"";
	ret[4]=nacionalidad+"";
	ret[5]=telefono+"";
	ret[6]=idReserva+"";
	
    return ret;

}
//se relaciona con el método buscar datos, permite identificar un dato en cualquiera de los paràmetros del modelo
public boolean consultaDato(String dato) {
	boolean ret = false;
	//System.out.println("Comparaciones: "+dato);
	//System.out.println("Comparaciones: "+id);
	//System.out.println("Comparaciones: "+nombre);
	//System.out.println("Comparaciones: "+apellido);
	if (dato.equals(id + ""))
		ret = true;
	else if (nombre.indexOf(dato)!=-1)
		ret = true;
	else if (apellido.indexOf(dato)!=-1)
		ret = true;
	else if (dato.equals(fecha_de_nacimiento + ""))
		ret = true;
	else if (dato.equals(nacionalidad + ""))
		ret = true;
	else if (dato.equals(telefono + ""))
		ret = true;
	else if (dato.equals(idReserva + ""))
		ret = true;
	
	return ret;
}
}
