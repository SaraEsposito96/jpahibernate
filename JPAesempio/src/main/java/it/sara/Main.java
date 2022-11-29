package it.sara;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("saraMysql");

	public static void main(String[] args) {

		create(1, "Sara", "Esposito", "matematica");
		create(2, "Luigi", "Esposito", "fisica");
		create(3, "Antonio", "Formisano", "italiano");
		create(4, "Virna", "Vitiello", "matematica");
		
		update(3, "Domenico", "Formisano", "italiano");
		update(4, "Virna", "Vitiello", "inglese");
		
		delete(1);

		ENTITY_MANAGER_FACTORY.close();
	}



	public static void create(int id, String nome, String cognome, String materia_insegnata) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Professore professore = new Professore();
			
			professore.setId(id);
			professore.setNome(nome);
			professore.setCognome(cognome);
			professore.setMateria_insegnata(materia_insegnata);

			manager.persist(professore);
			transaction.commit();
			
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static List<Professore> readAll() {

		List<Professore> professori = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();
			
			professori = manager.createNativeQuery("SELECT * FROM professore").getResultList();

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
		return professori;
	}


	public static void delete(int id) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Professore professore = manager.find(Professore.class, id);

			manager.remove(professore);

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static void update(int id, String nome, String cognome, String materia_insegnata) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();

			Professore professore = manager.find(Professore.class, id);
			professore.setNome(nome);
			professore.setCognome(cognome);
			professore.setMateria_insegnata(materia_insegnata);
			
			manager.persist(professore);
			
			transaction.commit();
			
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

}
