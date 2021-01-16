package ieee.encryptor;

public class IEEEFloat {
	
	private String sign;
	private String exponent;
	private String mantissa;
	
	public IEEEFloat(String sign, String exponent, String mantissa)  {
		
		this.sign = sign;
		this.exponent = exponent;
		this.mantissa = mantissa;
	}
	
	public String getSign() {
		return this.sign;
	}
	
	public String getExponent() {
		return this.exponent;
	}
	
	public String getMantissa() {
		return this.mantissa;
	}
	
	public String isSpecial() {
		if (this.exponent == "00000000" && this.mantissa == "00000000000000000000000") {
			return "Zero";
		} else if (this.exponent == "11111111" && this.mantissa == "00000000000000000000000") {
			if (this.sign == "0") {
				return "Positive Infinity";
			} else {
				return "Negative Infinity";
			}
		} else if (this.exponent == "11111111") {
			return "Not a Number";
		} else {
			return "Not Special";
		}
		
	}
	
	public float getDecimalValue() {
		return Encryptor.decryptIEEEFloat(this);
	}
	
	@Override
	public String toString() {
		return this.sign + this.exponent + this.mantissa;
	}
	
}
