package epam.com.game.parsfactory.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import epam.com.game.parsfactory.AbstractFactory;

public class CitiesEXELParser extends AbstractFactory {

	@Override
	public ArrayList cityesDocumentParser() {

		InputStream in;
		HSSFWorkbook workBook = null;
		try {
			in = new FileInputStream("src\\main\\resources\\cities.xls");
			workBook = new HSSFWorkbook(in);
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> it = sheet.iterator();
			while (it.hasNext()) {
				Row row = it.next();

				Iterator<Cell> cells = row.iterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();
					int cellType = cell.getCellType();
					switch (cellType) {
					case Cell.CELL_TYPE_STRING:
						cities.add(cell.getStringCellValue().toLowerCase());
						break;
					}

				}
			}
			workBook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cities;
	}

}