package servizi;

import dao.RubricaDao;
import dao.VoceDao;
import model.Rubrica;
import model.Voce;

public class ServizioRubrica {
	
	private VoceDao vDao=new VoceDao();
	private RubricaDao rDao=new RubricaDao();
	
	public boolean registraRubrica(String nome){
		
		boolean res=false;
				
		Rubrica r=new Rubrica(nome);
				
		res=rDao.creaRubrica(r);
				
		return res;
	}
	
	public boolean aggiungiVoce(Rubrica r,String nome, String cognome,String tel){
		
		boolean res= false;
				    
		Voce v= new Voce(nome,cognome,tel);
		
		v.setRubrica(r);
		
		r.aggiungiVoce(v);
		
		
		res=vDao.creaVoce(v);
		
		rDao.aggiornaRubrica(r);
		
		
		return res;
	}
	
	

}
