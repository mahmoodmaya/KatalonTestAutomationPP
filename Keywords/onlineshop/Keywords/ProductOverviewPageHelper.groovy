package onlineshop.Keywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.RenderingHints.Key
import java.lang.invoke.SwitchPoint

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByTagName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class ProductOverviewPageHelper {

	@Keyword
	def isProductOverviewPageTitleExist(String keyword) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/LabelofProductOverviewPage'));
		String str =  web.text;
		if(str.contains(keyword)) {
			System.out.println("The Product Overview page title is " + keyword);
			return true;
		}
		else {
			System.out.println("The Product Overview page title does not exist");
			return false;
		}
	}

	@Keyword
	def navigateTo(String countryId, String categoryName, String productNo) {
		String link = GlobalHelper.getMapperByCountryId(countryId, "link");

		WebDriver webDriver = DriverFactory.getWebDriver();
		webDriver.navigate().to(link + "/" + categoryName + "/c/" + productNo );
	}


	@Keyword
	def clickButtonMehrProdukteAnzeigen() {
		try {
			WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/ButtonMehrProdukteAnzeigen'));
			KeywordUtil.logInfo("Clicking the 'Mehr Produkte anzeigen' Button")
			web.click()
			KeywordUtil.markPassed("'Mehr Produkte anzeigen' Button has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("'Mehr Produkte anzeigen' Button not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	def currentProductCount() {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/NumberOfCurrentProductCount'));
		String str = web.text;
		return Integer.parseInt(str)
	}

	@Keyword
	def checkIfCurrentProductCountDoubled() {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/NumberOfCurrentProductCount'));
		String str = web.text;
		int currentCount = Integer.parseInt(str);
		int oldCount = currentProductCount();
		int doubledCount = oldCount * 2;
		if (currentCount == doubledCount) {
			System.out.println("The current product count has doubled to" + currentCount);
			return true;
		}
		else {
			return false;
		}
	}

	@Keyword
	def isNumberOfTotalProductsAndVariantsExist(String numberOfproducts, String variants) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/NumberOfTotalProductsAndVariants'));
		String str =  web.text;
		System.out.println("Output " + str);

		if(str.contains(numberOfproducts) && str.contains(variants)) {
			System.out.println("The total number of products and their variants exist");
			return true;
		}
		else {
			System.out.println("The total number of products and their variants don't exist");
			return false;
		}
	}

	@Keyword
	def isSliderForNavigationButtonsExist() {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/SliderForNavigationButtons'));
		String str = web.text;
		System.out.println("Output " + str);

		if(str) {
			System.out.println("The Navigation slider exists");
			return true;
		}
		else {
			System.out.println("The Navigation slider doesn't exist");
			return false;
		}
	}

	@Keyword
	def isNavigationFacetExist(String facetButtonLabels) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/NavigationFacet'));
		String str = web.text;
		System.out.println("Output " + str);

		if(str.contains(facetButtonLabels)) {
			System.out.println("The Navigation facet exists");
			return true;
		}
		else {
			System.out.println("The Navigation facet doesn't exist");
			return false;
		}
	}

	@Keyword
	def isTileImgExist() {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/ImgProductListTile'));
		String str =  web.getAttribute("srcset");
		if(str != null && !str.isEmpty()) {
			System.out.println("The Product tile image does not exist");
			return false;
		}
		else {
			System.out.println("The Product tile image does exists");
			return true;
		}
	}

	@Keyword
	def isTileTitleExist(String title) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/TitleProductListTile'));
		String str =  web.text;
		if(str.contains(title)) {
			System.out.println("The title of product tile is " + title);
			return true;
		}
		else {
			System.out.println("The title of product tile does not exist");
			return false;
		}
	}

	@Keyword
	def isTileAttributeExist(String attributes) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/AttributeProductListTile'));
		String str = web.text;

		if(str.contains(attributes)) {
			System.out.println("The Attributes exist: " + str);
			return true;
		}
		else {
			System.out.println("The Attributes don't exist: ");
			return false;
		}
	}

	@Keyword
	def isTilePriceTagExist(String priceTag) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/AttributeProductListTile'));
		String str = web.text;

		if(str.contains(priceTag)) {
			System.out.println("The Price tag exist: " + str);
			return true;
		}
		else {
			System.out.println("The Price tag doesn't exist: ");
			return false;
		}
	}

	@Keyword
	def isTileSalesUnitExist(String salesUnit) {
		WebElement web = WebUI.findWebElement(findTestObject('Object Repository/Onlineshop.pages/ProductOverviewPage/Elements/SalesUnitProductListTile'));
		String str = web.text;

		if(str.contains(salesUnit)) {
			System.out.println("The Sales Unit inside the product tile exists: " + str);
			return true;
		}
		else {
			System.out.println("The Sales Unit inside the product tile doesn't exist");
			return false;
		}
	}
}
