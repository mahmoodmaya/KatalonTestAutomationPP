package onlineshop.Keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.java.util.jar.pack.Instruction

import internal.GlobalVariable as Mapper

public class GlobalHelper {

	public static getCountryId(String countryId) {
		Map<String,String> countryIds = new HashMap<String,String>();
		countryIds.put("DE", "https://pps-qs-intern.bauhaus.info");
		countryIds.put("AT", "https://pps-qs-intern.bauhaus.at");
		countryIds.put("NL", "https://pps-qs-intern.nl.bauhaus");
		countryIds.put("ES", "https://pps-qs-intern.bauhaus.es");
		countryIds.put("HR", "https://pps-qs-intern.bauhaus.hr");
		countryIds.put("CZ", "https://pps-qs-intern.bauhaus.cz");

		return countryIds.get(countryId);
	}

	public static getMapperByCountryId(String countryId, String key) {
		Map links = new HashMap();
		String link = new String();

		switch (countryId) {
			case "DE":
				links =  (Map) Mapper.DE;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
			case "AT":
				links =  (Map) Mapper.AT;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
			case "NL":
				links =  (Map) Mapper.NL;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
			case "ES":
				links =  (Map) Mapper.ES;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
			case "HR":
				links =  (Map) Mapper.HR;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
			case "CZ":
				links =  (Map) Mapper.CZ;
				System.out.println(links);
				link = links.get(key);
				System.out.print(link);
				break;
		}

		return link;
	}


	def static mapCountryId(String countryId) {

		//Map countryIds = GlobalVariable.Onlineshop_CountryIds;
		//return countryIds.get(countryId);
		//retrun GlobalVariable.Onlineshop_CountryIds[countryId];
	}
}
