 import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Util {
	private int year;
	private int month;
	private int day = 1;
	//private LocalDate date = LocalDate.now();
	public String generateInsertDate(int Nr, LocalDate date) {
		return date.with(TemporalAdjusters.firstDayOfMonth()).minusMonths(Nr).toString();
	}
	public String generateInsertDate_bis(int Nr, LocalDate date) {
		if (Nr<0 || Nr > 12) {
			throw new RuntimeException("Nr deve essere compreso tra 1 e 12");
		}
		if(Nr == date.getMonthValue()) {
			year = date.getYear()-1;
			month = 12;
		} else if(Nr > date.getMonthValue()) {
			year = date.getYear()-1;
			month = 12-(Nr - date.getMonthValue());
		} else {
			year = date.getYear();
			month = date.getMonthValue()-Nr;
		}
		LocalDate dateQuery = LocalDate.of(year, month, day);
		return dateQuery.toString();
	}
	public static String generateInsertDate1 (int csvReportPreviousMonthNr, LocalDate date) {
		String dataInserimento = null;
		int yearPrec = date.getYear() - 1;
		int monthPrec = date.getMonthValue() - csvReportPreviousMonthNr;
		int addMonth = monthPrec + 12;

		if (monthPrec > 0 && monthPrec <= 9) {
			dataInserimento = date.getYear() + "-0" + monthPrec + "-01";
		} else if (monthPrec > 9) {
			dataInserimento = date.getYear() + "-" + monthPrec + "-01";
		} else if (monthPrec <= 0 && monthPrec > -3) {
			dataInserimento = yearPrec + "-" + addMonth + "-01";
		} else if (monthPrec <=-3) {
			dataInserimento = yearPrec + "-0" + addMonth + "-01";
		}
		return dataInserimento;
	}
}

