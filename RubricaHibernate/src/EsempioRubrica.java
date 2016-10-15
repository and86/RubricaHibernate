import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;
import servizi.ServizioRubrica;


public class EsempioRubrica {

	public static void main(String[] args) {

		 ServizioRubrica sRub= new ServizioRubrica();
		 RubricaDao rDao = new RubricaDao();
		 VoceDao vDao = new VoceDao();
		 
		 sRub.registraRubrica("Andrea");
//		System.out.println("rubrica  è stata creata ? "+sRub.registraRubrica("Andrea"));
				
		Rubrica r = rDao.leggiRubricaConId(1);
//		System.out.println(r.getNome() + " " + r.getId_Rubrica());
		
		 sRub.aggiungiVoce(r,"aaa","aaaa","111");
		 sRub.aggiungiVoce(r,"bbb","bbbb","222");
		 sRub.aggiungiVoce(r,"ccc","cccc","333");
		 sRub.aggiungiVoce(r,"ddd","dddd","444");
		 
		 Voce v1=sRub.getVoce(r, "aaa", "aaaa");
//		 System.out.println(v1.getId_voce()+" "+v1.getNome()+" "+v1.getCognome()+" "+ v1.getTelefono());
		 
		 for(Voce v:sRub.getTutteVoci(r)){
			 System.out.println(v.getId_voce()+" "+v.getNome()+" "+v.getCognome()+" "+ v.getTelefono());
		 }
		 
		boolean aggiornata=sRub.aggiornaVoce(r, v1, "aggiornata", "nuovoCognome", "0101001");
		System.out.println("voce  è stata aggiornata ? "+aggiornata);
		
		Voce v2=sRub.getVoce(r, "ddd", "dddd");
		boolean eliminata=sRub.rimuoviVoce(v2);
		System.out.println("voce  è stata eliminata ? "+eliminata);
				 
		 }

}
