/**
 * Copyright (c) 2017, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.poi
 * 功能：
 * 时间：2017-04-05 17:13
 * 作者：Mr.Kiwi
 */
public class ExcelReader {



    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;

    private String fileFullPath;

    private int sheetNo;



    public ExcelReader(String fileFullPath, int sheetNo) {
        super();
        this.fileFullPath = fileFullPath;
        this.sheetNo = sheetNo;
    }

    /**
     * 读取Excel数据内容

     * @return Map 包含单元格数据内容的Map对象
     */
    public List<Map<String,Object>> readExcel() {
        sheetNo--;//从1开始及从0开始
        InputStream is = null;
        try {
            is = new FileInputStream(fileFullPath);
        } catch (FileNotFoundException e1) {
        }
        Map<String,Object> dataMap = null;
        List<Map<String,Object>> dataList= new ArrayList<>();
        String value = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
        }
        sheet = wb.getSheetAt(sheetNo);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] keyArray = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            keyArray[i] = getCellFormatValue(row.getCell((short) i));
        }
        int rowNum = sheet.getLastRowNum();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 2; i <= rowNum; i++) {
            dataMap= new HashMap<>();
            row = sheet.getRow(i);
            if(row!=null){
                int j = 0;
                while (j < colNum) {
                    //这里把列循环到Map
                    if(row.getCell((short) j)!=null){
                        value = getCellFormatValue(row.getCell((short) j)).trim();
                        dataMap.put(keyArray[j],value);
                    }
                    j++;
                }
                value = "";
                dataList.add(dataMap);
            }
        }
        try {
            if(is!=null)
                is.close();
        } catch (IOException e) {
        }
        return dataList;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        DecimalFormat df = new DecimalFormat("0");
                        String dfStr = df.format(cell.getNumericCellValue());
                        cellvalue = dfStr;
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static void main(String[] args) {
        List<Map<String, Object>> dataList;
        // 对读取Excel表格标题测试
        ExcelReader excelReader = new ExcelReader("/Users/kiwi/Downloads/银联商户进件（模版）.xlsx",1);
        dataList = excelReader.readExcel();
        for(Map<String,Object> theMap:dataList){
            System.out.println(theMap);
        }
    }

}
