package com.example.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excelparser {
    public static List<Excelentity> parseExcel(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        List<Excelentity> dataList = new ArrayList<>();
        for (Row row : sheet) {
            Excelentity data = new Excelentity();
           data.setName(row.getCell(0).getStringCellValue());
           data.setEmail(row.getCell(1).getStringCellValue());
           data.setPhone_num(row.getCell(2).getNumericCellValue());
            dataList.add(data);
        }
        workbook.close();
        return dataList;
    }
}

