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
	
	@Override
	public String toString() {
		return this.sign + this.exponent + this.mantissa;
	}
	
}
