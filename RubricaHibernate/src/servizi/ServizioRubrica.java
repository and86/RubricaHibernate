package servizi;

import java.util.HashSet;
import java.util.Set;

import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;

public class ServizioRubrica {

	// Riferimenti ai DAO
	private VoceDao vDao = new VoceDao();
	private RubricaDao rDao = new RubricaDao();

	public boolean registraRubrica(String nome) {
		boolean res = false;

		Rubrica r = new Rubrica(nome);
		res = rDao.creaRubrica(r);
		
		return res;
	}

	public boolean aggiungiVoce(Rubrica r, String nome, String cognome,
			String telefono) {
		boolean res = false;

		Voce v = new Voce(nome, cognome, telefono);
		v.setRubrica(r);
		r.aggiungiVoce(v);
		res = vDao.creaVoce(v);
		rDao.aggiornaRubrica(r);

		return res;
	}
	
	public boolean aggiornaVoce(Rubrica r,Voce v, String nome,String cognome,String telefono){
		boolean res=false;
		
		Voce v1=vDao.leggiVoceConId(v.getId_voce());
		v1.setNome(nome);
		v1.setCognome(cognome);
		v1.setTelefono(telefono);
		res=vDao.aggiornaVoce(v1);
		
		return res;
	}
	
	public Voce getVoce(Rubrica r, String nome,String cognome){
		Voce v1=vDao.leggiVoce(r, nome, cognome);
		
		return v1;
	}
	
	public Set<Voce> getTutteVoci(Rubrica r){
		Set <Voce> listaVoci=null;
		
		listaVoci=vDao.leggiTutteLeVoci(r);
		
		return listaVoci;
	}
	
	public boolean rimuoviVoce(Voce v){
		boolean res=false;
		
		res=vDao.eliminaVoce(v);
		
		return res;
		
	}
	
}
