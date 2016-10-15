package dao;

import java.util.HashSet;
import java.util.Set;

import hibernateUtil.HibernateUtil;
import model.Rubrica;
import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {

	// 1- Create

	public boolean creaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(v);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

	// 2 - Read (con Id)
	public Voce leggiVoceConId(long v_id) {
		
		Voce v = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			v = session.get(Voce.class, v_id);

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}

	// 3 - Read (con nome,cognome)
	public Voce leggiVoce(Rubrica r,String nome, String cognome) {
		Voce v = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			Query query = session
					.createQuery("from Voce where id_Rubrica=:idRubricaInserito and"
							+ " nome=:nomeInserito and"
							+ "cognome=:cognomeInserito and"
							+ "tel=:telefonoInserito");

			query.setLong("idRubricaInserito", r.getId_Rubrica());
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			v = (Voce) query.uniqueResult();
			
			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}
	
	// 4 - Read (con id_rubrica)
	
	@SuppressWarnings("unchecked")
	public Set<Voce> leggiTutteLeVoci(Rubrica r) {
			Set<Voce> listaVoci=null;
			
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				Query query = session
						.createQuery("from Voce where id_Rubrica=:idRubricaInserito");

				query.setLong("idRubricaInserito", r.getId_Rubrica());
				listaVoci=(Set<Voce>) query.list();
				
				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return listaVoci;

		}

	// 5 - Update
	public boolean aggiornaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(v);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

	// 6- Delete

	public boolean eliminaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(v);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

}
