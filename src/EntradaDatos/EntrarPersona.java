package EntradaDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DAO.PersonDAO;
import tablas.Person;

public class EntrarPersona {
	
	PersonDAO pdao = new PersonDAO();
	Person p = null;
	
	
	public void crearPersona(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String entrada = "";
		p = new Person();
		
		
		int laid = 0;
		String elnom = "";
		String ladire = "";
		int laedat = 0;
		
		System.out.println("Crear Persona");
		
		// laid "DNI"
		System.out.println("Entra el NIF 'Sense lletra':");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		laid = Integer.parseInt(entrada);
				
		
		// NOM
		System.out.println("Entra el nom:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elnom = entrada;
		
		
		// DIRECCIO
		System.out.println("Entra la direccio:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ladire = entrada;
		
		
		// EDAD
		System.out.println("Entra la edad:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		laedat = Integer.parseInt(entrada);
		
		
		// Creamos la persona con datos introducidos
		p.setId(laid);
		p.setName(elnom);
		p.setAddress(ladire);
		p.setAge(laedat);
		pdao.createPerson(p);
		
		
		
	}

		
	
	public void modificarPersona(int laid){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String entrada = "";
		p = new Person();
		
		
		String elnom = "";
		String ladire = "";
		int laedat = 0;
		

		System.out.println("Modificar Persona");		
		
		// NOM
		System.out.println("Entra el nom:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elnom = entrada;
		
		
		// DIRECCIO
		System.out.println("Entra la direccio:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ladire = entrada;
		
		
		// EDAD
		System.out.println("Entra la edad:");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		laedat = Integer.parseInt(entrada);
		
		
		// Creamos la persona con datos introducidos
		p.setId(laid);
		p.setName(elnom);
		p.setAddress(ladire);
		p.setAge(laedat);
		pdao.actualizaPersona(p);
		
		
		
	}
	
	
	
	public void eliminarPersona(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String entrada = "";
		p = new Person();
		
		
		int laid = 0;

		
		System.out.println("Eliminar Persona");
		
		// laid "DNI"
		System.out.println("Entra el NIF 'Sense lletra':");
		br = new BufferedReader (isr);
		entrada = null;
		try {
			entrada = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		laid = Integer.parseInt(entrada);
		p.setId(laid);
		pdao.eliminaContacto(p);
	}
	
	
	
	
	
	
	
	
	
	
}
