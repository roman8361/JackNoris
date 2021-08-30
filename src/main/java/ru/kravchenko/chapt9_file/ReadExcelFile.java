package ru.kravchenko.chapt9_file;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        File excelFile = new File("test1.xlsx");
        List<Employee> list1 = getList(excelFile);
        List<Employee> list2 = getList(new File("test2.xlsx"));
        compareTwoList(list1, list2);
    }

    private static List<Employee> getList(File excelFile) {
        List<Employee> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelFile);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)
        ) {
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            Iterator<Row> rowIt = sheetAt.iterator();
            while (rowIt.hasNext()) {
                Row row = rowIt.next();
                Employee employee = Employee.builder()
                        .firstName(row.getCell(0) == null ? "" : row.getCell(0).toString())
                        .lastName(row.getCell(1) == null ? "" : row.getCell(1).toString())
                        .email(row.getCell(2) == null ? "" : row.getCell(2).toString())
                        .dataOfBirth(row.getCell(3) == null ? "" : row.getCell(3).toString())
                        .hash(row.getCell(4) == null ? "" : row.getCell(4).toString())
                        .build();
                result.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.remove(0);
        return result;
    }

    private static void compareTwoList(List<Employee> list1, List<Employee> list2) {
        try (FileWriter writer = new FileWriter("compare.log", true)) {
            if (list1.equals(list2)) {
                writer.write("All data is equals\n");
                writer.write("list1 size: " + list1.size() + "\n");
                writer.write("list1 size: " + list2.size() + "\n");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list1.size(); i++) {
            compareToEmployee(list1.get(i), list2.get(i));
        }
    }

    private static void compareToEmployee(Employee e1, Employee e2) {
        try (FileWriter writer = new FileWriter("compare.log", true)) {
            for (int i = 0; i < e1.getAllData().size(); i++) {
                if (compareTwoValuesFromEmployee(e1.getAllData().get(i), e2.getAllData().get(i))) {
                    writer.write("Hash: " + e1.getHash() + "\n");
                    writer.write("Values not equals: " + e1.getAllData().get(i) + " " + e2.getAllData().get(i) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean compareTwoValuesFromEmployee(String v1, String v2) {
        return !v1.equals(v2);
    }

}
