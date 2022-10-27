package teste.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import br.com.project.report.util.DateUtils;

public class testeData {

	@Test
	public void testData() {
		try {
			assertEquals("26102022", DateUtils.getDateAtualReportName());
			assertEquals("'2022-10-26'", DateUtils.formaDateSql(Calendar.getInstance().getTime()));
			assertEquals("2022-10-26", DateUtils.formatDateSqlSimple(Calendar.getInstance().getTime()));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
