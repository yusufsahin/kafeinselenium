package tr.com.kafein.googlesearchdatadriven;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;


public class GoogleSearch {

    private WebDriver driver;

    private Workbook workbook;


    @BeforeEach
    public void setUp() throws IOException {
        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.tr");

       // src/test/resources/data.xlsx
        FileInputStream fis= new FileInputStream(new File("C:\\Projects\\KafeinSelenium\\GoogleSearchDataDriven\\src\\test\\resources\\data.xlsx"));
        workbook= new XSSFWorkbook(fis);
    }

    @Test
    public void search() throws InterruptedException {
        Sheet sheet= workbook.getSheetAt(0);
        Iterator<Row> rowIterator= sheet.rowIterator();
        if(rowIterator.hasNext()){
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row= rowIterator.next();

            Cell cell = row.getCell(0);
            String searchQuery= cell.getStringCellValue();

            WebElement searchBox= driver.findElement(By.name("q"));

            // 3 | click | name=q |
            searchBox.click();
            searchBox.clear();
            // 4 | type | name=q | Kafein
            searchBox.sendKeys(searchQuery);
            // 5 | click | name=btnK |
           searchBox.submit();

            String expectedTitle=searchQuery+ " - Google'da Ara";
            String actualTitle= driver.getTitle();

            Assertions.assertEquals(expectedTitle,actualTitle);
        }


    }

    @AfterEach
    public void tearDown() {
       if(driver!=null) {
           driver.quit();}
    }
}
