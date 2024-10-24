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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Order Page/Button Checkout'))

WebUI.setText(findTestObject('Order Page/Input First Name'), 'Rayhan')

WebUI.setText(findTestObject('Order Page/Input Last Name'), 'Arif')

WebUI.setText(findTestObject('Order Page/Input Postal Code'), '63283')

WebUI.click(findTestObject('Order Page/Button Continue'))

String itemTotalText = WebUI.getText(findTestObject('Order Page/Item Total'))

String taxText = WebUI.getText(findTestObject('Order Page/Tax'))

String totalText = WebUI.getText(findTestObject('Order Page/Total'))

// Remove unwanted characters and convert to BigDecimal for accurate calculations
BigDecimal itemTotal = new BigDecimal(itemTotalText.replaceAll('[^\\d.]', ''))

BigDecimal tax = new BigDecimal(taxText.replaceAll('[^\\d.]', ''))

BigDecimal total = new BigDecimal(totalText.replaceAll('[^\\d.]', ''))

// Calculate the expected total
BigDecimal expectedTotal = itemTotal + tax

WebUI.comment("Item Total: $itemTotal")

WebUI.comment("Tax: $tax")

WebUI.comment("Calculated Total (Item Total + Tax): $expectedTotal")

WebUI.comment("Displayed Total: $total")

// Verify if the calculated total matches the total displayed on the page
if (expectedTotal.compareTo(total) == 0) {
    WebUI.comment('Verification successful: Item total + Tax equals Total.')
} else {
    WebUI.comment('Verification failed: Item total + Tax does not equal Total.')
}

WebUI.takeFullPageScreenshot('C:\\Disk C\\BelajarKatalon\\Screenshoot\\Sauce Demo Login Success\\screenshot3.png')

WebUI.click(findTestObject('Order Page/Button Finish'))

