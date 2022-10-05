package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import model.BaseEntity;
import model.RecipeOwner;
import util.HibernateUtil;

public class GenericDao<T extends BaseEntity> {
	// salvando o objeto

	public void save(T obj) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.save(obj);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("save: abriu transaction mas falhou");
			}
		}
	}

	// atualizando o objeto (precisa ler o id do banco)
	public void update(T obj) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the object
			session.saveOrUpdate(obj);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Update: abriu transaction mas falhou");
			}
		}
	}

	public T getObjectById(T obj, long id) {
		Class classe = obj.getClass();
		// String className = classe.getSimpleName().toString();

		Transaction transaction = null;
		T retorno = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the object
			retorno = (T) session.get(classe, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
		return retorno;
	}

	public RecipeOwner getObjectByEmailAndPassword(String email, String password) {
		email = "gabrielseffrin29@gmail.com";
		password = "123";
		try {
			Session manager = HibernateUtil.getSessionFactory().openSession();
			RecipeOwner doBanco = (RecipeOwner) manager
					.createQuery("from recipeOwner where email = " + email + " and password = " + password);

			System.out.println("resultado" + doBanco);
			return doBanco;
		} catch (Exception e) {
			return null;
		}
	}

	// Lista todos os registros
	public List<T> listAll(T obj) {

		Class classe = obj.getClass();
		String className = classe.getSimpleName().toString();

		Transaction transaction = null;
		List<T> objects = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the objects
			objects = session.createQuery("from " + className).list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("ListALL - abriu transaction mas falhou");
			}
		}

		return objects;
	}

	public void delete(T obj) {

		Class classe = obj.getClass();
		// String className = classe.getSimpleName().toString();

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// delete the object
			session.delete(obj);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Delete - abriu transaction mas falhou");
			}
		}
	}

}