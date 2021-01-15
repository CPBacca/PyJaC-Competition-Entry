package ieee.encryptor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncryptorTest {

	@Test
	void testDecryptBinaryInt0() {
		
		int integer = Encryptor.decryptBinaryInt("0");
		assertEquals(0, integer);
	}
	
	@Test
	void testDecryptBinaryInt1() {
		
		int integer = Encryptor.decryptBinaryInt("1");
		assertEquals(1, integer);
	}
	
	@Test
	void testDecryptBinaryInt2() {
		int integer = Encryptor.decryptBinaryInt("10");
		assertEquals(2, integer);
	}
	
	@Test
	void testDecryptBinaryIntmultiple0s() {
		int integer = Encryptor.decryptBinaryInt("0000");
		assertEquals(integer, 0);
	}
	
	@Test
	void testDecryptBinaryInt31() {
		int integer = Encryptor.decryptBinaryInt("11111");
		assertEquals(integer, 31);
	}
	
	@Test
	void testDecryptBinaryIntBig1() {
		int integer = Encryptor.decryptBinaryInt("110101010");
		assertEquals(426, integer);
	}
	
	@Test
	void testDecryptBinaryIntBig2() {
		int integer = Encryptor.decryptBinaryInt("1010110111");
		assertEquals(695, integer);
	}
	
	/* ================================================================= */
	
	@Test
	void testBinaryEncryptInt0() {
		String binary = Encryptor.binaryEncryptInt(0);
		assertEquals("0", binary);
	}

	@Test
	void testBinaryEncryptInt1() {
		String binary = Encryptor.binaryEncryptInt(1);
		assertEquals("1", binary);
	}

	@Test
	void testBinaryEncryptInt2() {
		String binary = Encryptor.binaryEncryptInt(2);
		assertEquals("10", binary);
	}

	@Test
	void testBinaryEncryptInt5() {
		String binary = Encryptor.binaryEncryptInt(5);
		assertEquals("101", binary);
	}

	@Test
	void testBinaryEncryptInt31() {
		String binary = Encryptor.binaryEncryptInt(31);
		assertEquals("11111", binary);
	}

	@Test
	void testBinaryEncryptInt64() {
		String binary = Encryptor.binaryEncryptInt(64);
		assertEquals("1000000", binary);
	}

	@Test
	void testBinaryEncryptIntBig1() {
		String binary = Encryptor.binaryEncryptInt(752);
		assertEquals("1011110000", binary);
	}

	@Test
	void testBinaryEncryptIntBig2() {
		String binary = Encryptor.binaryEncryptInt(161);
		assertEquals("10100001", binary);
	}

	@Test
	void testBinaryEncryptIntBig3() {
		String binary = Encryptor.binaryEncryptInt(286);
		assertEquals("100011110", binary);
	}
	
	/* ================================================================= */

	@Test
	void testBinaryBinaryPlusOne0() {
		String binary = Encryptor.binaryPlusOne("0");
		assertEquals("1", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOne1() {
		String binary = Encryptor.binaryPlusOne("1");
		assertEquals("10", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOne2() {
		String binary = Encryptor.binaryPlusOne("10");
		assertEquals("11", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOne3() {
		String binary = Encryptor.binaryPlusOne("11");
		assertEquals("100", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOne4() {
		String binary = Encryptor.binaryPlusOne("100");
		assertEquals("101", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOneBig1() {
		String binary = Encryptor.binaryPlusOne("11110110");
		assertEquals("11110111", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOneBig2() {
		String binary = Encryptor.binaryPlusOne("11110111");
		assertEquals("11111000", binary);
	}
	
	@Test
	void testBinaryBinaryPlusOneBig3() {
		String binary = Encryptor.binaryPlusOne("111111111");
		assertEquals("1000000000", binary);
	}

	/* ================================================================= */

	@Test
	void testEncryptIEEEFloat0() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(0);
		assertEquals(binary.toString(), "00000000000000000000000000000000");
	}
	
	@Test
	void testEncryptIEEEFloatPosInfin() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(Float.POSITIVE_INFINITY);
		assertEquals(binary.toString(), "01111111100000000000000000000000");
	}
	
	@Test
	void testEncryptIEEEFloatNegInfin() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(Float.NEGATIVE_INFINITY);
		assertEquals(binary.toString(), "11111111100000000000000000000000");
	}
	
	@Test
	void testEncryptIEEEFloatNaN() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(0);
		assertEquals(binary.toString(), "01111111100000000000000000000001");
	}
	
	@Test
	void testEncryptIEEEFloat1() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(1);
		assertEquals(binary.toString(), "00111111100000000000000000000000");
	}
	
	@Test
	void testEncryptIEEEFloat() {
		IEEEFloat binary = Encryptor.encryptIEEEFloat(14.1416015625f);
		assertEquals(binary.toString(), "01000001011000100100010000000000");
	}
	
	
	/* ================================================================= */

	@Test
	void testDecryptIEEEFloat0() {
		IEEEFloat ieee = new IEEEFloat("0", "00000000", "00000000000000000000000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(0, floating);
	}
	
	@Test
	void testDecryptIEEEFloat1() {
		IEEEFloat ieee = new IEEEFloat("0", "01111111", "00000000000000000000000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(1, floating);
	}
	
	@Test
	void testDecryptIEEEFloatPosInfin() {
		IEEEFloat ieee = new IEEEFloat("0", "11111111", "00000000000000000000000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(Float.POSITIVE_INFINITY, floating);
	}
	
	@Test
	void testDecryptIEEEFloatNegInfin() {
		IEEEFloat ieee = new IEEEFloat("1", "11111111", "00000000000000000000000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(Float.NEGATIVE_INFINITY, floating);
	}
	
	@Test
	void testDecryptIEEEFloatNaN() {
		IEEEFloat ieee = new IEEEFloat("0", "11111111", "00000000000000000001000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(Float.NaN, floating);
	}
	
	@Test
	void testDecryptIEEEFloat() {
		IEEEFloat ieee = new IEEEFloat("0", "10000010", "11000100100010000000000"); 
		float floating = Encryptor.decryptIEEEFloat(ieee);
		assertEquals(14.1416015625, floating);
	}
	
	
	
	
}
