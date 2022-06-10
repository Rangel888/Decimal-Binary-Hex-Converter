import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

class MTest {
	
	@Test
	void toDecimalTest() {
		var t = new M();
		
		t.toDecimal("1010");
		String screen1 = M.screen1.getText();
		assertEquals("10",screen1);
		
		t.toDecimal("11111");
		screen1 = M.screen1.getText();
		assertEquals("31", screen1);
		
		t.toDecimal("10110110000110");
		screen1 = M.screen1.getText();
		assertEquals("11654", screen1);
		
		t.toDecimal("1");
		screen1 = M.screen1.getText();
		assertEquals("1", screen1);
	}
	
	@Test
	void toBinaryTest() {
		var t = new M();
		
		//Decimal to binary
		t.toBinary("57", 1);
		String screen2 = M.screen2.getText();
		assertEquals("111001", screen2);
		
		t.toBinary("19991", 1);
		screen2 = M.screen2.getText();
		assertEquals("100111000010111",screen2);
		
		t.toBinary("15",1);
		screen2 = M.screen2.getText();
		assertEquals("1111",screen2);
		
		t.toBinary("100", 1);
		screen2 = M.screen2.getText();
		assertEquals("1100100",screen2);
		
		//HexaDecimal to binary
		t.toBinary("F", 3);
		screen2 = M.screen2.getText();
		assertEquals("1111",screen2);
		
		t.toBinary("106F", 3);
		screen2 = M.screen2.getText();
		assertEquals("1000001101111",screen2);
		
		t.toBinary("FF1", 3);
		screen2 = M.screen2.getText();
		assertEquals("111111110001",screen2);
		
		t.toBinary("111", 3);
		screen2 = M.screen2.getText();
		assertEquals("100010001",screen2);	
	}
	
	@Test
	void tohexaDecimal() {
		var t = new M();
		
		t.tohexaDecimal("11111");
		String screen3 = M.screen3.getText();
		assertEquals("1F",screen3);
		
		t.tohexaDecimal("1010101010");
		screen3 = M.screen3.getText();
		assertEquals("2AA",screen3);
		
		t.tohexaDecimal("101010111100110111101111");
		screen3 = M.screen3.getText();
		assertEquals("ABCDEF",screen3);
		
		t.tohexaDecimal("1111111100001111");
		screen3 = M.screen3.getText();
		assertEquals("FF0F",screen3);
	}
	
	/*@Test
	void ActionPreformedTest() {
		var t = new M();
		
		
		
		M.screen2.setText("1010 1");
		t.Convert.doClick();
		System.out.println(t.error.getText());
		assertEquals("The value entered must be in binary format", t.error.getText());
		
		
	}*/

}
