package bm.selenium;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();

	}

	public static void readCSV() {
		String filename = "C:\\Users\\bmenn\\Documents\\SeleniumJavaPractice\\heroku_test_login_csv.csv";
		List <String[]> records = utilities.CSV.get(filename);
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
		
	}
	
	public static void readXLS() {
		String filename = "C:\\Users\\bmenn\\Documents\\SeleniumJavaPractice\\herokuData2.xls";
		String[][] data = utilities.Excel.get(filename);
//		for (String[] record : data) {
//			System.out.println("\nNEW RECORD:"); 
//			System.out.println(record[0]);
//			System.out.println(record[1]);
//			
//		}
		
		for(int i=0;i<3;i++){
			
			for(int j=0;j<2;j++){
				
				System.out.println(data[i][j]);
			}
		}
	}
}
