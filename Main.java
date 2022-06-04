import java.util.*;

class Main {

	static char[] inputArray = null;
	static LinkedList<Character> usedCharList = new LinkedList<>();
	static LinkedList finalList = new LinkedList<>();
	
  public static void main(String[] args) {

		String inputString = System.console().readLine("Enter of Input String : ");
		System.out.println("Input String : " + inputString);

		//Encoding
		inputArray = inputString.toCharArray();
		String outputString = "";
		
		for(int i=0 ; i < inputArray.length; i++){
			int frequency = 0;
			
			for(int j=i+1 ; j < inputArray.length ; j++){
				if(inputArray[i] == inputArray[j]){
					frequency++;
				}
			}

			if(frequency >= 3 && !usedCharList.contains(inputArray[i])){
				usedCharList.add(inputArray[i]);
				finalList.add(inputArray[i]);
				finalList.add("!");
				finalList.add(frequency+1);
			}
			else if(!finalList.contains(inputArray[i])){
				finalList.add(inputArray[i]);
			}
			frequency = 0;
		}

		//Print Encoded Data
		System.out.print("Encoded String : ");
		for(Object o : finalList){
			System.out.print(o + " ");
		}
    System.out.println();

		
		//Decoding
		System.out.print("Decodded String : ");
		ListIterator itr = finalList.listIterator();
		while(itr.hasNext()){
			Object obj = itr.next();

			if(obj.equals("!")){
				int n = (Integer) itr.next();

				itr.previous();
				itr.previous();
				
				char ch = (char) itr.previous();
				//< and not <= coz one c is already printed
				for(int i = 1 ; i < n ; i++){
					System.out.print(ch);
				}

				itr.next();
				itr.next();
				itr.next();
			}
			else System.out.print(obj);
		}	
}
}