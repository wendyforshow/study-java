/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.poi
 * 功能：
 * 时间：2016-07-05 9:38
 * 作者：Mr.Kiwi
 */
public class PoiTest {

    public static void main(String[] args) throws IOException {

        List<Map<String, Object>> x = excel2Map("/Users/kiwi/Downloads/银联商户进件（模版）.xlsx");
        List<String> sqlList = new ArrayList<>();
        for (Map<String, Object> map : x) {

            int size = map.size();
            StringBuffer tempStr = new StringBuffer();
            for (int i = 0; i < size; i++) {

                tempStr.append("?" + i + " , ");
            }
            StringBuffer extStr = new StringBuffer();
            for (int i = size; i < size * 2; i++) {

                extStr.append("?" + i + " , ");
            }


            String zwf = StringUtils.removeEnd(tempStr.toString(), ", ");
            String ext = StringUtils.removeEnd(extStr.toString(), ", ");

            String sql = "INSERT INTO pcl_unionpay_merchant ( "+ zwf +" ) VALUES ( "+ext + " )";
            String cv = "";
            String cloum = "";
            String value = "";
            for (String s : map.keySet()) {

                cloum += s + ",";
                value += map.get(s) + ",";
            }

            cloum = StringUtils.removeEnd(cloum, ",");
            value = StringUtils.removeEnd(value, ",");

            sqlList.add(StringUtils.replaceEach(sql, (zwf + "," + ext).split(","),(cloum + "," + value).split(",")));
        }


        System.out.println(sqlList);
        System.err.println(x);
    }

    public static List<Map<String, Object>> excel2Map(String fileName) throws IOException {


        List<Map<String, Object>> list = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 2; i <= sheet.getLastRowNum(); i++) {

            XSSFRow row = sheet.getRow(i);
            Map<String, Object> map = new LinkedHashMap<>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {

                XSSFCell cell = row.getCell(j);

                if (cell == null) continue;

                int columnIndex = cell.getColumnIndex();
                if (columnIndex == 0)
                    map.put("unipay_merchant", cell.getStringCellValue());
                else if (columnIndex == 1)
                    map.put("terminal_no", cell.getStringCellValue());
                else if (columnIndex == 2)
                    map.put("service_users_id", cell.getNumericCellValue());
                else if (columnIndex == 14)
                    map.put("province_code", cell.getNumericCellValue());
                else if (columnIndex == 15)
                    map.put("city_code", cell.getNumericCellValue());


            }
            if (!map.isEmpty()) {
                //                System.err.println(map);
                list.add(map);
            }
        }
       /* for (Row row : sheet) {

            XSSFRow rowCell = (XSSFRow) row;

            for (int i = 2; i < rowCell.getRowNum(); i++) {

                Map<String, Object> map = new LinkedHashMap<>();
                for (Cell cell : rowCell) {

                    int columnIndex = cell.getColumnIndex();
                    if (columnIndex == 0)
                        map.put("unipay_merchant", cell.getStringCellValue());
                    else if (columnIndex == 1)
                        map.put("terminal_no", cell.getStringCellValue());
                    else if (columnIndex == 2)
                        map.put("service_users_id", cell.getStringCellValue());
                    else if (columnIndex == 14)
                        map.put("province_code", cell.getNumericCellValue());
                    else if (columnIndex == 15)
                        map.put("city_code", cell.getNumericCellValue());

                }

                if (!map.isEmpty()) {
                    //                System.err.println(map);
                    list.add(map);
                }
            }
        }*/

        return list;
    }

}
