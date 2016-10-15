import model.Rubrica;
import dao.RubricaDao;
import servizi.ServizioRubrica;


public class EsempioRubrica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ServizioRubrica sRub= new ServizioRubrica();
//		
//		System.out.println("rubrica stato creato ? "+sRub.registraRubrica("Vahid"));
//		
//		
     RubricaDao rDao=new RubricaDao();

     Rubrica r=rDao.leggiRubricaConId(2);
     
  
     
     System.out.println(r.getNome()+" "+r.getId_Rubrica());
     
//		
//		sRub.aggiungiVoce(r, nome, cognome, tel)
	}

}
