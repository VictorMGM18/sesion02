package main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbTipo;
import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===JPA CRUD===");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01");
		EntityManager em = fabrica.createEntityManager();

		List<TbUsuario> lstUsuario = em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		System.out.println("El numero de Usuarios es: "+ lstUsuario.size());
		
		//Listar todos los usuarios
		System.out.println("Lista de usuarios:");
		System.out.println("-----------------");
		for(TbUsuario u: lstUsuario){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " "+ u.getClaUsua());
		}
		System.out.println("==============================================");
		
		
		/*Búsqueda de usuario con id=2*/
		/*System.out.println("Buscar usuario con id=2");
		System.out.println("-----------------------");
		TbUsuario us = em.find(TbUsuario.class,2);
		System.out.println(us);
		System.out.println("Codigo: " + us.getCodUsua());
		System.out.println("Nombre: " +us.getNomUsua());
		System.out.println("Apellido: " +us.getApeUsua());
		System.out.println("==============================================");*/
		
		/*Insertar nuevo usuario*/
		/*System.out.println("Insertar nuevo usuario: Pepe Perez, de Tipo = 2 (cliente) y cla_usua=1001");
		System.out.println("-------------------------------------------------------------------------");
		
		em.getTransaction().begin();
		TbUsuario usuario = new TbUsuario();
		Date fecha = new Date();
		TbTipo tipo = em.find(TbTipo.class, 2);//Tipo Cliente: Buscar en la tabla TbTipo
		usuario.setCodUsua(6);
		usuario.setNomUsua("Andrea");
		usuario.setApeUsua("Nicol");
		usuario.setUsrUsua("andreaperez");
		usuario.setFnaUsua(fecha);
		usuario.setTbTipo(tipo);
		usuario.setEstUsua(1);
		em.persist(usuario);
		em.getTransaction().commit();
		System.out.println("==============================================");*/
		
		/*Actualizar usuario*/
		/*System.out.println("Actualizamos usuario con id=6: y actualizamos campo cla_usua=10001");
		System.out.println("-------------------------------------------------------------------");
		em.getTransaction().begin();
		TbUsuario usuarioActualizar = em.find(TbUsuario.class, 6);
		usuarioActualizar.setClaUsua("10001");
		em.persist(usuarioActualizar);
		em.getTransaction().commit();
		System.out.println("==============================================");*/
		
		/*Eliminar usuario*/
		/*System.out.println("Eliminar usuario con id=6");
		System.out.println("-------------------------");
		em.getTransaction().begin();
		TbUsuario usuarioEliminar = em.find(TbUsuario.class, 6);
		em.remove(usuarioEliminar);
		em.getTransaction().commit();
		System.out.println("==============================================");*/
			
		//Cerrando la conexión a la Base de datos
		fabrica.close();
		em.close();

	}

}
