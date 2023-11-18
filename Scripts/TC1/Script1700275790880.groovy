import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import com.kazurayam.ks.ToggleSmartWait

/**
 * automate signing-in to Microsoft Azure DevOps with Smart Wait
 */

TestObject makeTestObject(String id, String xpathExpression) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpathExpression)
	return tObj
}

// enable Smart Wait explicitly
ToggleSmartWait.toggleON()

String url = "https://dev.azure.com/${GlobalVariable.ACCOUNT}"
WebUI.openBrowser(url)
WebUI.setViewPortSize(800, 800)

TestObject loginfmt = makeTestObject("loginfmt", "//input[@name='loginfmt']")
WebUI.sendKeys(loginfmt, GlobalVariable.EMAIL)

TestObject nextButton = makeTestObject("Next", "//input[@id='idSIButton9']")
WebUI.click(nextButton)

TestObject passwd = makeTestObject("Passwd", "//input[@name='passwd']")
WebUI.sendKeys(passwd, GlobalVariable.PASSWD)

TestObject signinButton = makeTestObject("SignIn", "//input[@id='idSIButton9']")
WebUI.click(signinButton)

TestObject yesButton = makeTestObject("Yes", "//input[@id='idSIButton9']")
WebUI.click(yesButton)

WebUI.closeBrowser()

ToggleSmartWait.toggleOFF()
