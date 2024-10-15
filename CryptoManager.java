
/*
 * Class: CMSC203 21475
 * Instructor: Prof G
 * Description: Encryption/decryption program
 * Due: 10/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: David Pichardo
*/


public class CryptoManager(){

	
	private static final char LOWER_RANGE = ' '; //ASCII value 32
	private static final char UPPER_RANGE = '_'; //ASCII value 95
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	//use of for loops with arrays used
	//look at slides for clarification on how encryptions work w/ ASCII codes

	
	public static Boolean isStringInBounds (String plainText){
		
		char ch; //char to check range for plainText at (i)

		for(int i = 0; i < plainText.length(); i++){
			ch = plainText.charAt(i);
			
			if(ch < LOWER_RANGE || ch > UPPER_RANGE){
				return false;
			}
		}

		return true;	
	}

	public static String caesarEncryption(String plainText, int key){
		

		//array for encrypted chars using Caesar encryption
		char[] encryptedCae = new char[plainText.length()];
		
		char currentChar; //char for the plainText char at (i)
		int shift; //int variable for the shift
	
		if(!isStringInBounds(plainText)){
			return "The Selected string is not in bounds, try again.";
			
		}
			
		for (int i = 0; i < plainText.length(); i++){
			currentChar = plainText.charAt(i);
			shift = (currentChar - LOWER_RANGE + key) % RANGE;
			
			
			
			encryptedCae[i] = (char) (LOWER_RANGE + shift);

			
		}

		String encryptedString = new String(encryptedCae);			

		return encryptedString;
	}


	
	public static String bellasoEncryption (String plainText, String bellasoStr){
		char[] encryptedBella = new char[plainText.length()]; //array for final encrypted chars
		
		char currentChar; //char for the plaintext char at (i)
		char keyChar; //char for the bellasoStr char at (i)
		int shift; // Int variable for the shift
				
		if(!isStringInBounds(plainText)){
			return "The selected string is not in bounds, Try again.";
		}
		
		//encryption process
		for (int i = 0; i < plainText.length(); i++ ){
			currentChar = plainText.charAt(i);
			keyChar = bellasoStr.charAt(i % bellasoStr.length());
			shift = (currentChar - LOWER_RANGE + keyChar) % RANGE;

			
		
			encryptedBella[i] = (char) (LOWER_RANGE + shift);
		}
		
		
		String encryptedString = new String(encryptedBella);
	
		return encryptedString;

			
	}

	public static String caesarDecryption (String encryptedText, int key){
		char[] decryptedCae = new char[encryptedText.length()];
		
		char currentChar; 
		int shift;

		//decryption logic
		for (int i = 0; i < encryptedText.length(); i++) {
			currentChar = encryptedText.charAt(i);
			shift = (currentChar - LOWER_RANGE - (key % RANGE) + RANGE) % RANGE; 

			while (shift < 0){
				shift += RANGE;
			}				
			
			while (shift += RANGE) {
				shift -= RANGE;
			}

			decryptedCae[i] = (char) (LOWER_RANGE + shift);
		}
		String decryptedString = new String(decryptedCae);

		return decryptedString;
	}

	public static String bellasoDecryption(String encryptedText, String bellasoStr){
		char[] decryptedBella = new char[encryptedText.length()];
		char currentChar;
		char keyChar;
		
		int shift;

		for (int i = 0; i < encryptedText.length(); i++) {
			currentChar = encryptedText.charAt(i);
			keyChar = bellasoStr.charAt(i % bellasoStr.length());
			
			shift = (currentChar - keyChar + RANGE);

			while(shift < LOWER_RANGE) {
				shift += RANGE;
			}

			while (shift > UPPER_RANGE){
				shift -= RANGE;
			}

			decryptedBella[i] = (char) shift;
			
		}
		String decryptedString = new String(decryptedBella);
		
		return decryptedString;
	}

	

}