package Listener1;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.DWSBaseListener;
@Listeners(com.crm.Listener1.BasicListners.class)
public class TestCaseBasic extends DWSBaseListener{
@Test
public void main1() {
String expected_result = "https://demowebshop.tricentis.com/";
String actual_result = driver.getCurrentUrl();
assertEquals(expected_result, actual_result);
}
@Test
public void main2() {
	String expected_result = "https://demowebshop.tricentis.com";
	String actual_result = driver.getCurrentUrl();
	assertEquals(expected_result, actual_result);
}
}