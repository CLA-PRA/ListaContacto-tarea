package negocios;
import datos.Lista;
import datos.Contacto;
import datos.PosicionIlegalException;
/**
 * Clase que representa una lista de contacos personales
 * @author lourdesarmenta
 *
 */

public class ListadeContactos {
	//Atributo
	private Lista<Contacto> contactos;
	//Metodos
	//Constructor
	public ListadeContactos() {
		contactos = new Lista<Contacto>();
	}
	/**
	 * Retorna una lista de todos los contactos
	 */
	public Lista<Contacto> mostrarTodosLosContactos(){
		try {
			   for (int i=0;i<contactos.getTamanio();i++) {
				   System.out.print("Num: "+i+"-> ");
				   //Corriga el siguiente código
				  System.out.println(contactos.getValor(i)+" "+
				                   contactos.getValor(i)+ " "+
						           contactos.getValor(i)+ " "+
				                   contactos.getValor(i)+" "+
						           contactos.getValor(i)+" "+
				                   contactos.getValor(i));
			   }
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return contactos;
	}
	/**
	 * Agregar un nuevo contacto a la lista, si todavia no hay ningun contacto
	 * con los nombres y los apellidos dados
	 */
	public boolean agregarContacto(String nombres, 
		    String apellidos, String direccion, String correo,
			String telefono,String celular) throws PosicionIlegalException{
			Contacto con = buscarContacto(nombres,apellidos);
			if (con==null) //se puede agregar el contacto
			{
				Contacto nuevo = new Contacto(nombres,apellidos,
						direccion,correo,telefono,celular);
				//Coloque aquí el código faltante
				
				return true;
			}else {
				return false;
			}
		}
	/**
	 * Elimina un contacto dados sus nombres y apellidos
	 * si el usuario existe en la lista se elimina y regresa true
	 * falso si no lo encuentra
	 * @param nombres
	 * @param apellidos
	 * @return
	 * @throws PosicionIlegalException
	 */
	public boolean eliminarContacto(String nombres,String apellidos)
	        throws PosicionIlegalException{
		Contacto con = buscarContacto(nombres,apellidos);
		if(con != null) {
			for(int i=0;i<this.contactos.getTamanio();i++) {
				Contacto contAux = contactos.getValor(i);
				if(contAux.getNombres().equals(nombres) && 
						contAux.getApellidos().equals(apellidos))
				{
					contactos.remover(i);
				}
				
			}
			return true;
			
		}else
			return false;	
	}
	/**
	 * busca un contactp dado sus nombres y apellido
	 * 
	 */
	public Contacto buscarContacto(String nombres,String apellidos) 
			throws PosicionIlegalException{
		for(int i=0;i<contactos.getTamanio();i++) {
			Contacto con = contactos.getValor(i);
			if(nombres.equals(con.getNombres()) && 
					apellidos.equals(con.getApellidos())) {
				return con;
			}
			
		}
		return null;//No lo encontro, devuelve nulo
		
	}
	public boolean modificarContacto(String nombres, String apellidos,
			String direccion, String correo, String telefono, String celular)
	     throws PosicionIlegalException{
		//Verificar que el contacto exista
		Contacto con = buscarContacto(nombres,apellidos);
		if(con == null) {
			return false;
		}
		//Modificar el contacto con los nombres nuevos
		con.setNombres(nombres);
		con.setApellidos(apellidos);
		con.setDireccion(direccion);
		con.setCorreo(correo);
		con.setTelefono(telefono);
		con.setCelular(celular);
		return true;	
	}
	/**
	 * 
	 * @return el tamaño de la lista
	 */
	
	public int tamanio() {
		return contactos.getTamanio();
	}
	
}
