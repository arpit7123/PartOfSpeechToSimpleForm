/**
 * File : SimpleForm.java
 * Author : Arpit Sharma
 * Functionality : This class has a method toSimpleForm(String s,String pos) which converts the string s to its simple
 * form
 * 
 */

public class SimpleForm{
	
	public static void main(String[] args){
	
	  System.out.println("Simple form of caught is " + toSimpleForm("caught","v"));
	
	}
	
	/**
	 * Method to convert String s to its simple form
	 * @param s (the string to be converted to simple form)
	 * @param pos (the string which specifies POS tag of s, for example "v" for verb and "n" for s to be noun)
	 * @return
	 */
	public static String toSimpleForm(String s,String pos){
  	String newString = "";
  	String[] command = new String[3];
  	command[0] = "/bin/bash";
  	command[1] = "-c";
  	command[2] = "echo '" + s + pos.toUpperCase() | ./rasp3os/morph/morpha -f ./rasp3os/morph/verbstem.list";
  	try{
  		Process process = Runtime.getRuntime().exec(command);
  		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
  	  newString = input.readLine();
  		newString = newString.split("_")[0].trim();
  	}
  	catch(Exception e){e.printStackTrace();}
  	return newString;
	}
	
}
		
		
