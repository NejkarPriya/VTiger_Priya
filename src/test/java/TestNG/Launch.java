package TestNG;

import org.testng.annotations.Test;

public class Launch {
public static void main(String[] args) {
	System.out.println("i am main");
}
@Test
public void main() {
System.out.println("i am testNG");
}
}