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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.openBrowser('')

WebUI.navigateToUrl('https://testingjarkom.000webhostapp.com/admin/login.php')

WebUI.setText(findTestObject('Page_Login/input_Login Akun_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Page_Login/input_Login Akun_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('Page_Login/button_Login'))

WebUI.navigateToUrl('https://testingjarkom.000webhostapp.com/admin/dashboard.php')

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/a_Pasien'))

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/a_Tambah'))

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nama_name'), nama)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nomor Rekam Medis_medical_record_number'), 
    nomorrekam)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nomor Telepon_phone_number'), nomorhp)

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Tanggal Lahir_dob'))

WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Tanggal Lahir_dob'), 
    30)

WebUI.executeJavaScript('arguments[0].value = \'1999-08-05\'', Arrays.asList(element))

WebUI.scrollToElement(findTestObject('Page_Sistem Antrian Disabilitas/input_Tanggal Lahir_dob'), 0)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/textarea_Alamat_address'), alamat)

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/button_Simpan'))

halaman_url = WebUI.getUrl()

WebUI.verifyMatch(halaman_url, 'https://testingjarkom.000webhostapp.com/admin/patients/index.php', false)

WebUI.closeBrowser()

