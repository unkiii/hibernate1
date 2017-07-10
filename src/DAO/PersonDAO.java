package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tablas.Person;
import utils.HibernateUtils;

public class PersonDAO {
	
	private Session session; 
    private Transaction tx;  
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{
	    tx.rollback();
	    throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
	
	// ABRIR session con Hibernate
	public void obrir(){
		session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	
	// CERRAR session con Hibernate
	public void tancar(){
		tx.commit();
		session.close();
	}
	public void tancar2(){
		session.close();
	}
	
	
	// CREAR PERSONA
	public void createPerson(Person p){
		obrir();
		Person pn = new Person(p.getId(), p.getName(), p.getAddress(), p.getAge());
		session.save(pn);
		tancar();
	}
	
	
	// CONSULTAR PERSONES 'TOTES'
	@SuppressWarnings("unchecked")
	public List<Person> obtenListaContactos() throws HibernateException 
    { 
        List<Person> listaContactos = null;  

        try 
        { 
            obrir();
            listaContactos = session.createQuery("from Person").list(); 
        } finally 
        { 
        	tancar();
        }  
        

        return listaContactos; 
    }  
	
	// CONSULTAR 1 PERSONA
	public Person obtenContacto(int dni) throws HibernateException
	{ 
		Person contacto = null;  

	    try 
	    { 
	        obrir();
	        contacto = (Person) session.get(Person.class, dni); 
	    } finally 
	    { 
	        tancar();
	    }  
	    return contacto; 
	}
	
	// MODIFICAR PERSONA
	public void actualizaPersona(Person contacto) throws HibernateException 
    { 
        try 
        { 
            obrir(); 
            session.update(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            tancar2();
        } 
    } 

	
	public void eliminaContacto(Person contacto) throws HibernateException 
    { 
        try 
        { 
            obrir();
            session.delete(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
        	tancar2(); 
        } 
    }  
}
