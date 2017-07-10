package programa;

import java.util.List;

import DAO.PersonDAO;
import EntradaDatos.EntrarPersona;
import tablas.Person;


public class Prueba {
	static EntrarPersona ep = new EntrarPersona();
	
	public static void main(String[] args) {
		//buscar(12345678);
		//entrarPersona();
		//actualitzarPersona(98765432);
		eliminarPersona();
	}
	
	
	public static void entrarPersona(){
		ep.crearPersona();
	}
	
	public void llistat(){
		PersonDAO pdao = new PersonDAO();
		List<Person> llistat = pdao.obtenListaContactos();
		System.out.println("DNI \t\t NOM \t\t DIRECCIO \t\t EDAT");
		for(int i=0;i<llistat.size();i++){
		    System.out.println(llistat.get(i).toString());
		} 
	}
	
	public static void buscar(int dni){
		PersonDAO pdao = new PersonDAO();
		Person contacte = pdao.obtenContacto(dni);
		System.out.println("DNI \t\tNOM \t\tDIRECCIO \t\tEDAT");
		System.out.print(contacte.getId());
		System.out.print("\t");
		System.out.print(contacte.getName());
		System.out.print("\t\t");
		System.out.print(contacte.getAddress());
		System.out.print("\t\t");
		System.out.print(contacte.getAge());
	}
	
	public static void actualitzarPersona(int dni){
		ep.modificarPersona(dni);
	}
	
	
	public static void eliminarPersona(){
		ep.eliminarPersona();
	}
	
	
	
	
}
