import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.navigateToUrl('https://testingjarkom.000webhostapp.com/admin/login.php')

WebUI.setText(findTestObject('Page_Login/input_Login Akun_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Page_Login/input_Login Akun_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('Page_Login/button_Login'))

WebUI.navigateToUrl('https://testingjarkom.000webhostapp.com/admin/dashboard.php')

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/a_Pasien'))

String expectedValue = 'A'

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//table/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

println('No. of rows: ' + Rows.size())

Boolean found = false

table: for (int i = 0; i < Rows.size(); i++) {
    List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

    for (int j = 0; j < Cols.size(); j++) {
        if (Cols.get(j).getText().equalsIgnoreCase(expectedValue)) {
            WebUI.comment(('kata ' + expectedValue) + ' ada')

            found = true

            break
        }
    }
    
    if (found == true) {
        break
    } else if ((i + 1) == Rows.size()) {
        KeywordUtil.markFailedAndStop('Data is not found!')
    }
}

WebUI.closeBrowser()

