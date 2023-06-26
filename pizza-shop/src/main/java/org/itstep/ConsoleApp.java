package org.itstep;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.itstep.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@Transactional
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    PizzaService pizzaService;

    public static void main(String[] args) {
        SpringApplication.run(org.itstep.Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        pizzaService.findAll().stream().forEach(pizza -> System.out.println(pizza));

        //Export to Excel
        /*
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Pizzas");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 20000);
        sheet.setColumnWidth(3, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Mass");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Desc");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Price");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        AtomicInteger counter = new AtomicInteger(1);
        pizzaService.findAll().stream().forEach(pizza->
        {
            Row row = sheet.createRow(counter.getAndIncrement());

            Cell cell = row.createCell(0);
            cell.setCellValue(pizza.getName());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(pizza.getMass());
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(pizza.getDesc());
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(pizza.getPrice());
            cell.setCellStyle(style);
        });

        File currDir = new File("src/main/resources");
        String path = currDir.getAbsolutePath();
        String fileLocation = path + "/pizzas.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
        */

        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(
                ParagraphAlignment.CENTER
        );
        XWPFRun titleRun = title.createRun();
        titleRun.setText("Pizzas");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        XWPFTable table = document.createTable();
        //Заголовок таблицы
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Name");
        tableRowOne.addNewTableCell().setText("Mass");
        tableRowOne.addNewTableCell().setText("Desc");
        tableRowOne.addNewTableCell().setText("Price");

        pizzaService.findAll().stream().forEach(pizza->
        {
            //create second row
            XWPFTableRow tableRow = table.createRow();
            tableRow.getCell(0).setText(pizza.getName());
            tableRow.getCell(1).setText(Integer.toString(pizza.getMass()));
            tableRow.getCell(2).setText(pizza.getDesc());
            tableRow.getCell(3).setText(Integer.toString(pizza.getPrice()));
        });

        File currDir = new File("src/main/resources");
        String path = currDir.getAbsolutePath();
        String fileLocationWord = path + "/pizzas.docx";
        FileOutputStream out = new FileOutputStream(fileLocationWord);
        document.write(out);
        out.close();
        document.close();
    }
}