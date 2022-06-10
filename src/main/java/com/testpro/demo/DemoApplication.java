package com.testpro.demo;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Scanner sc = new Scanner(System.in);  
		System.out.println("Insert 1 to convert human number to Roman");
		System.out.println("Insert 2 to convert galaxy number to human number");

		int opt = sc.nextInt();

		if(opt == 1){
			System.out.println("Insert number to be converted to Roman");
			int no = sc.nextInt();
			System.out.println("Number = " + no);
			String roman = integertoRomanConverter(no);
			System.out.println("Roman form : "+roman );
		}
		else if(opt == 2){
			System.out.println("Insert galaxy number to be converted to human number");
			Scanner sc2 = new Scanner(System.in);  

			String input = sc2.nextLine();
			// System.out.println("Input recorded : "+ input);
			String convertRes = galaxytoIntegerConverter(input);

			if(convertRes != null && convertRes.contains("no idea")){
				System.out.println(convertRes);
			}
			else{
				System.out.println(input +" is "+convertRes);
			}
		}
		else{
			System.out.println("Function is not available");
		}
	}


//integer to roman converter - starts ***************************************************************************
	public static String integertoRomanConverter(Integer number){
        
        String convertRes = "";
                
        double digitChecker = number/1000;
        // System.out.println("digit checker = " + digitChecker);
        
        if(digitChecker >= 1){
            int now = (int) digitChecker;
            // System.out.println("digit number = " + now);
            convertRes = thousandConvert(convertRes, now);
            
            number = number - (now * 1000);
        }
        
        digitChecker = number/100;
        
        // System.out.println("digit checker = " + digitChecker);
        
        if(digitChecker >= 1){
            int now = (int) digitChecker;
            // System.out.println("digit number = " + now);
            convertRes = hundredConvert(convertRes, now);
            
            number = number - (now * 100);
        }
        
        digitChecker = number/10;
        
        // System.out.println("digit checker = " + digitChecker);
        
        if(digitChecker >= 1){
            int now = (int) digitChecker;
            // System.out.println("digit number = " + now);
            convertRes = twoConvert(convertRes, now);
            
            number = number - (now * 10);
        }
        
        if(number >= 1){
            int now = number;
            // System.out.println("digit number = " + now);
            convertRes = oneConvert(convertRes, now);
            
            number = number - now;
        }
        
        // System.out.println("Result now = " + convertRes);

        return convertRes;
    }
    
    
    public static String thousandConvert(String convertRes, Integer numberNow){
        while(numberNow >= 1){
            convertRes = resCollector(convertRes, "M");
            numberNow--;
        }
        return convertRes;
    }
    
    
    public static String hundredConvert(String convertRes, Integer numberNow){
        while(numberNow >= 1){
            if(numberNow > 8){
              convertRes = resCollector(convertRes, "CM");
              numberNow -= 9;
            }
            else if(numberNow > 4){
              convertRes = resCollector(convertRes, "D");
              numberNow -= 5;
            }
            else if(numberNow > 3){
              convertRes = resCollector(convertRes, "CD");
              numberNow -= 4;
            }
            else{
              convertRes = resCollector(convertRes, "C");
              numberNow -= 1;
            }
        }
        return convertRes;
    }
    
    
    public static String twoConvert(String convertRes, Integer numberNow){
        while(numberNow >= 1){
            if(numberNow > 8){
              convertRes = resCollector(convertRes, "XC");
              numberNow -= 9;
            }
            else if(numberNow > 4){
              convertRes = resCollector(convertRes, "L");
              numberNow -= 5;
            }
            else if(numberNow > 3){
              convertRes = resCollector(convertRes, "XL");
              numberNow -= 4;
            }
            else{
              convertRes = resCollector(convertRes, "X");
              numberNow -= 1;
            }
        }
        return convertRes;
    }
    
    
    public static String oneConvert(String convertRes, Integer numberNow){
        while(numberNow >= 1){
            if(numberNow > 8){
              convertRes = resCollector(convertRes, "IX");
              numberNow -= 9;
            }
            else if(numberNow > 4){
              convertRes = resCollector(convertRes, "V");
              numberNow -= 5;
            }
            else if(numberNow > 3){
              convertRes = resCollector(convertRes, "IV");
              numberNow -= 4;
            }
            else{
              convertRes = resCollector(convertRes, "I");
              numberNow -= 1;
            }
        }
        return convertRes;
    }
    
    
    public static String resCollector(String res, String add){
        if(res == null || res.equals("")){
            res = add;
        }
        else{
            res = res+add;
        }
        return res;
    }

//integer to roman converter - ends ***************************************************************************

//integer to galaxy converter - starts ************************************************************************

	public static String galaxytoIntegerConverter(String galaxynumber){
        
		String convertRes = "";
		
		galaxynumber = galaxynumber.toLowerCase();

		String [] splitDigit = galaxynumber.split(" ");

		ArrayList<String> newdigit = new ArrayList<String>();

		Double tempvalue = 1.0;

		for(int i=0; i<splitDigit.length; i++){
			String digitnow = splitDigit[i];
			try{
				digitnow = digitnow.trim();
			}
			catch(Exception e){}

			if(digitnow != null && !digitnow.equals("")){
				if(digitnow.equals("gold")){
					tempvalue = 14450.0;
				}
				else if(digitnow.equals("silver")){
					tempvalue = 17.0;
				}
				else if(digitnow.equals("iron")){
					tempvalue = 195.5;
				}
				else{
					String newvalue = GStoRoman(digitnow);

					if(newvalue.equals("0")){
						return "I have no idea what you are talking about";
					}
					else{
						newdigit.add(newvalue);
					}
				}
			}	
		}

		Integer headNumber = 0;

		for(int j=0; j<newdigit.size();j++){
			String digitnow0 = newdigit.get(j);
			String digitnext0 = "";
			Integer digitnow = Integer.parseInt(digitnow0);

			try{
				digitnext0 = newdigit.get(j+1);

				digitnow = Integer.parseInt(digitnow0);
				Integer digitnext = Integer.parseInt(digitnext0);

				if(digitnow >= digitnext){
					headNumber = headNumber + digitnow;
				}
				else{
					headNumber = headNumber + (digitnext - digitnow);
					j++;
				}
			}
			catch(Exception e){
				headNumber = headNumber + digitnow;
			}
		}

		Double finalValue = headNumber * tempvalue;
		convertRes = finalValue.toString();

		if(tempvalue > 1){
			convertRes += " Credit";
		}

		return convertRes;
	}


	public static String GStoRoman (String gs){
		if(gs != null && gs.equals("glob")){
			return "1";
		}
		else if(gs != null && gs.equals("prok")){
			return "5";
		}
		else if(gs != null && gs.equals("pish")){
			return "10";
		}
		else if(gs != null && gs.equals("tegj")){
			return "50";
		}
		else{
			return "0";
		}
	}

}
