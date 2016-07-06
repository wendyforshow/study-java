/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.poi
 * 功能：
 * 时间：2016-07-05 9:38
 * 作者：Mr.Kiwi
 */
public class PoiTest {

    public static void main(String[] args) throws IOException {

        System.err.println(excel2Map("C:\\Users\\Administrator\\Desktop\\超级网银号v20160608.xlsx"));
    }

    public static List<Map<String, Object>> excel2Map(String fileName) throws IOException {


        List<Map<String, Object>> list = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetAt1 = workbook.getSheetAt(0);
        for (Row cells : sheetAt1) {

            XSSFRow cells1 = (XSSFRow) cells;

            Map<String, Object> map = new HashMap<>();
            for (Cell cell : cells1) {

                if (0 == cell.getRowIndex())
                    continue;

                int columnIndex = cell.getColumnIndex();
                if (columnIndex == 0)
                    map.put("bankNo", cell.getStringCellValue());
                else if (columnIndex == 1)
                    map.put("bankName", cell.getStringCellValue());
                else
                    map.put("bankLongName", cell.getStringCellValue());

            }

            if (!map.isEmpty()) {
//                System.err.println(map);
                list.add(map);
            }
        }

        return list;
    }

}
