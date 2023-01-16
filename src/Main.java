import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Util data = new Util();
		for (int mese = 1; mese<= 12; mese++ ) {
			for (int giorno = 1; giorno<= 31; giorno++) {
				try {
					LocalDate date = LocalDate.of(2023, mese, giorno);
					System.out.println("Data attuale: " + date);
					System.out.println(data.generateInsertDate_bis(5,date));
				} catch(Exception e) {
					continue;	
				}
			}
		}
	}

}
