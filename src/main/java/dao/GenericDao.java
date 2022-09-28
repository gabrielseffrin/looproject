package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BaseEntity;
import util.HibernateUtil;


public class GenericDao<T extends BaseEntity> {
		// salvando o objeto
			
		public void save(T obj) {

				Transaction transaction = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					System.out.println("1");
					// start the transaction
					transaction = session.beginTransaction();
					System.out.println("2");

					// save the studendt object
					session.save(obj);
					System.out.println("3");

					// commit the transaction
					transaction.commit();
					System.out.println("4");


				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
						System.out.println("save: abriu transaction mas falhou");
					}
				}
			}
		//atualizando o objeto (precisa ler o id do banco)	
		public void update(T obj) {

			Transaction transaction = null;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				// start the transaction
				transaction = session.beginTransaction();
				// save the studendt object
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
			String className = classe.getSimpleName().toString();	
			
		    Transaction transaction = null;
		    T retorno = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//get the studendt object
			retorno = (T)session.get(classe, id);
			//commit the transaction
			transaction.commit();} 
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
		return retorno;
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
				// get the studendts
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
			String className = classe.getSimpleName().toString();
			
			Transaction transaction = null;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				// start the transaction
				transaction = session.beginTransaction();
				// delete the student object
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