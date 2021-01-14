package ieee.encryptor;

public class Encryptor {
	
	public static IEEEFloat encryptIEEEFloat(float decimal) {
		String sign;
		String exponent;
		String mantissa = "";
		
		if (decimal >= 0) {
			sign = "0";
		} else {
			sign = "1";
			decimal *= -1;
		}
		
		int exponentOf2 = 0;
		while (decimal >= 2 || decimal < 1) {
			if (decimal >= 2) {
				decimal /= 2;
				exponentOf2 += 1;
			} else {
				decimal *= 2;
				exponentOf2 -= 1;
			}
		}
		
		exponent = binaryEncryptInt(127 + exponentOf2);
		decimal--;
		
		float powerOf2 = 0.5f;
		while (mantissa.length() < 23+3) {
			if (decimal >= powerOf2) {
				mantissa = mantissa + "1";
				decimal -= powerOf2;
			} else {
				mantissa = mantissa + "0";
			}
			powerOf2 /= 2;
		}
		
		// TODO Rounding
		mantissa = mantissa.substring(0, 23);
		
		return new IEEEFloat(sign, exponent, mantissa);
	}
	
	public static float decryptIEEEFloat(IEEEFloat binary) {
		int sign = decryptBinaryInt(binary.getSign());
		if (sign == 0) {
			sign = 1;
		} else {
			sign = -1;
		}
			
		int exponent = decryptBinaryInt(binary.getExponent());
		String mantissa = binary.getMantissa();
		
		float count = (float) Math.pow(2.0f, exponent - 127);
		
		for (int i = 0; i < mantissa.length(); i++) {
			if (mantissa.charAt(i) == '1') {
				count += (float) Math.pow(2.0f, exponent - 128 - i);
			}
		}
		
		return sign * count; //(float) Math.pow(mantissa, exponent - 127 - 23);
	}
	
	
	public static int decryptBinaryInt(String binary) {
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(binary.length() - i - 1) == '1') {
				count += Math.pow(2, i);
			}
		}
		return count;
	}
	
	public static String binaryEncryptInt(int decimal) {
		if (decimal == 0) {
			return "0";
		}
		String binary = "";
		int power2 = 1;
		while (power2 <= decimal) {
			power2 *= 2;
		}
		power2 /= 2;
		while (power2 >= 1) {
			if (power2 <= decimal) {
				decimal -= power2;
				binary = binary + "1"; 
			} else {
				binary = binary + "0"; 
			}
			power2 /= 2;
		} 
		
		return binary;
	} 

	public static boolean isBinary(String binary) {
		for (int i = 0; i < binary.length(); i++) {
			if (!(binary.charAt(i) == '0' || binary.charAt(i) == '1')) {
				return false;
			}
		}
		
		return true;
	}
	
	public static IEEEFloat getIEEEFloat(String binary) {
		if (binary.length() == 32 && isBinary(binary)) {
			return new IEEEFloat(binary.substring(0, 1), binary.substring(1, 10), binary.substring(10, 32));
		}
		return null;
	}
}
