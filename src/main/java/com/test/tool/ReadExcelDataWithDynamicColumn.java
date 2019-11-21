package com.test.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*
 * @Chanchal CSK
 * 
 * 
 */

<<<<<<< HEAD

=======
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
//https://www.journaldev.com/2315/java-json-example
//http://www.appsdeveloperblog.com/java-into-json-json-into-java-all-possible-examples/
public class ReadExcelDataWithDynamicColumn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file path e.g  .xlsx file");
		String excelFilePath = input.nextLine();
		CopyExcelSheet ces = new CopyExcelSheet();
		// String excelFilePath = "C:/Users/MahiWay/Desktop/Tool/Test1.xlsx";
		String copySheetName = "Sheet1";
		List<List<String>> selectedRowDataList = ces.getExcelData(excelFilePath, copySheetName);
		ces.createExcelSheetWithData(excelFilePath, selectedRowDataList);

		creteJSONFileFromExcel(excelFilePath);
	}

	private static String dataToJSON(List<List<String>> dataTable)
			throws JsonGenerationException, JsonMappingException, IOException {
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		jsonBuilder.add("dist_refid", "");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		jsonBuilder.add("date_updated", dtf.format(now));

		System.out.println(dtf.format(now));
		String ret = "";
		String indented = "";
		if (dataTable != null) {
			int rowCount = dataTable.size();
<<<<<<< HEAD
			if (rowCount > 1) {	
=======
			if (rowCount > 1) {
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
				List<String> headerRow = dataTable.get(0);
				int columnCount = headerRow.size();
				JsonArrayBuilder pbuilder = Json.createArrayBuilder();
				for (int i = 1; i < rowCount; i++) {
<<<<<<< HEAD
					// Get current row data.
=======
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
					JsonObjectBuilder jsonBuilder1 = Json.createObjectBuilder();
					List<String> dataRow = dataTable.get(i);
					for (int j = 0; j < columnCount; j++) {
						String columnName = headerRow.get(j);
<<<<<<< HEAD
						String columnValue = dataRow.get(j);		
=======
						String columnValue = dataRow.get(j);
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
						jsonBuilder1.add(columnName, columnValue);
					}
					pbuilder.add(jsonBuilder1);
				}
				jsonBuilder.add("whitelisted_ids", pbuilder);
				JsonObject empObj = jsonBuilder.build();
				StringWriter strWtr = new StringWriter();
				JsonWriter jsonWtr = Json.createWriter(strWtr);
				jsonWtr.writeObject(empObj);
				jsonWtr.close();
				ret = strWtr.toString().replace("\\", "").replace("\"[", "[").replace("]\"", "]");
				System.out.println(ret);
				ObjectMapper mapper = new ObjectMapper();
				Object json = mapper.readValue(ret, Object.class);
				indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
//				System.out.println(indented);
			}
		}
		return indented;
	}

<<<<<<< HEAD
	public static void main(String[] args) {
		// You can specify your excel file path.
		String excelFilePath = "D:\\chanchal\\AutomationTool\\Spring Tool Suite 4\\JsonTool\\JsonTool\\Json.xls";

		// "C:\Users\MahiWay\Desktop\Test.xls"

		// This method will read each sheet data from above excel file and create a JSON
		// and a text file to save the sheet data.
		creteJSONAndTextFileFromExcel(excelFilePath);
	}

	private static void creteJSONAndTextFileFromExcel(String filePath) {
=======
	private static void creteJSONFileFromExcel(String filePath) {
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
		try {
			FileInputStream fInputStream = new FileInputStream(filePath.trim());

			Workbook excelWorkBook = new XSSFWorkbook(fInputStream);
			int totalSheetNumber = excelWorkBook.getNumberOfSheets();
<<<<<<< HEAD

			// Loop in all excel sheet.
			for (int i = 0; i < totalSheetNumber; i++) {
				// Get current sheet.
				Sheet sheet = excelWorkBook.getSheetAt(i);

				// Get sheet name.
				String sheetName = sheet.getSheetName();

				if (sheetName != null && sheetName.length() > 0) {
					// Get current sheet data in a list table.
					List<List<String>> sheetDataTable = getSheetDataList(sheet);

					// Generate JSON format of above sheet data and write to a JSON file.

					dataToJSON(sheetDataTable);
					String jsonString = dataToJSON(sheetDataTable);
					String jsonFileName = sheet.getSheetName() + ".json";
					writeStringToFile(jsonString, jsonFileName);

					// Generate text table format of above sheet data and write to a text file.
					/*
					 * String textTableString = getTextTableStringFromList(sheetDataTable); String
					 * textTableFileName = sheet.getSheetName() + ".txt";
					 * writeStringToFile(textTableString, textTableFileName);
					 */

=======
			// for (int i = 0; i < totalSheetNumber; i++) {
//				Sheet sheet = excelWorkBook.getSheetAt(i);
			Sheet sheet = excelWorkBook.getSheetAt(1);
			String sheetName = sheet.getSheetName();

			if (sheetName != null && sheetName.length() > 0) {
				List<List<String>> sheetDataTable = getSheetDataList(sheet);
				String jsonString = dataToJSON(sheetDataTable);

				System.out.println(filePath);
				Pattern patternFilepath = Pattern.compile("(.*/)(.*)(.xlsx)");
				Matcher matcherFilepath = patternFilepath.matcher(filePath);
				String jsonFilePath = "";
				if (matcherFilepath.find()) {
					jsonFilePath = matcherFilepath.group(1);
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
				}
				System.out.println(jsonFilePath);
				String jsonFileName = jsonFilePath + sheet.getSheetName() + ".json";
				writeStringToFile(jsonString, jsonFileName);
			}
			// }
			excelWorkBook.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static List<List<String>> getSheetDataList(Sheet sheet) {
		List<List<String>> ret = new ArrayList<List<String>>();
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		if (lastRowNum > 0) {
			for (int i = firstRowNum; i < lastRowNum + 1; i++) {
				Row row = sheet.getRow(i);
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				List<String> rowDataList = new ArrayList<String>();
				for (int j = firstCellNum; j < lastCellNum; j++) {
					Cell cell = row.getCell(j);
					int cellType = cell.getCellType().getCode();
					if (cellType == CellType.NUMERIC.getCode()) {
						double numberValue = cell.getNumericCellValue();
						String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();
						rowDataList.add(stringCellValue);
					} else if (cellType == CellType.STRING.getCode()) {
						String cellValue = cell.getStringCellValue();
						rowDataList.add(cellValue);
					}
				}
				ret.add(rowDataList);
			}
		}
		return ret;
	}

<<<<<<< HEAD
	/* Return a JSON string from the string list. */
	/*
	 * private static String getJSONStringFromList(List<List<String>> dataTable) {
	 * String ret = "";
	 * 
	 * if (dataTable != null) { int rowCount = dataTable.size();
	 * 
	 * if (rowCount > 1) { // Create a JSONObject to store table data. JSONObject
	 * tableJsonObject = new JSONObject();
	 * 
	 * // The first row is the header row, store each column name. List<String>
	 * headerRow = dataTable.get(0);
	 * 
	 * int columnCount = headerRow.size();
	 * 
	 * // Loop in the row data list. JSONObject rowJsonObject = new JSONObject();
	 * for (int i = 1; i < rowCount; i++) { // Get current row data. List<String>
	 * dataRow = dataTable.get(i); for (int j = 0; j < columnCount; j++) { String
	 * columnName = headerRow.get(j); String columnValue = dataRow.get(j);
	 * rowJsonObject.put(columnName, columnValue); }
	 * 
	 * tableJsonObject.put("Row " + i, rowJsonObject); }
	 * 
	 * // Return string format data of JSONObject object. ret =
	 * tableJsonObject.toString().replaceAll("Row ([0-9]{1})", "");
	 * 
	 * } } return ret; }
	 */
	/* Return a text table string from the string list. */
	private static String getTextTableStringFromList(List<List<String>> dataTable) {
		StringBuffer strBuf = new StringBuffer();

		if (dataTable != null) {
			// Get all row count.
			int rowCount = dataTable.size();

			// Loop in the all rows.
			for (int i = 0; i < rowCount; i++) {
				// Get each row.
				List<String> row = dataTable.get(i);

				// Get one row column count.
				int columnCount = row.size();

				// Loop in the row columns.
				for (int j = 0; j < columnCount; j++) {
					// Get column value.
					String column = row.get(j);

					// Append column value and a white space to separate value.
					strBuf.append(column);
					strBuf.append("    ");
				}

				// Add a return character at the end of the row.
				strBuf.append("\r\n");
			}

		}
		return strBuf.toString();
	}

	/* Write string data to a file. */
	private static void writeStringToFile(String data, String fileName) {
		try {

			String filePath = "D:\\chanchal\\AutomationTool\\Spring Tool Suite 4\\JsonTool\\JsonTool" + fileName;

			// Create File, FileWriter and BufferedWriter object.
			File file = new File(filePath);

=======
	private static void writeStringToFile(String data, String jsonFilePath) {
		try {
			// String filePath = "C:/Users/MahiWay/Desktop/Tool/" + fileName;
			File file = new File(jsonFilePath);
>>>>>>> 5cb85a51e0255dbf9f9438876adc0e9c8cd9591b
			FileWriter fw = new FileWriter(file);
			BufferedWriter buffWriter = new BufferedWriter(fw);
			buffWriter.write(data);
			buffWriter.flush();
			buffWriter.close();
			System.out.println(jsonFilePath + " has been created.");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
