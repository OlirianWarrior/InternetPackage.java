import java.util.Scanner;

public class Main {
  
  // hours is static because passing between all of the function isn't need for a smaller program
  static double hours;
  
  public static void main(String[] args) {
    
    Scanner userInput = new Scanner (System.in);
     while (true)
     {
       showMonthlyfee(calculatefee(getHours(userInput), menu (userInput)));
     }
    
  }
  
  //Get hours
  public static double getHours(Scanner userInput)
    {
      System.out.print("Please enter the hours used: ");
      		hours = userInput.nextDouble();

        return hours;
    }
    
    
    //Display menu and user input package
    public static int menu (Scanner userInput)
    {
      int packageChoice;
      
      System.out.println("\n[1] Package A");
      System.out.println("[2] Package B");
      System.out.println("[3] Package C");
      System.out.println("Please select your package.");
      packageChoice = userInput.nextInt();
      
      return packageChoice;

    }
    
    //Calculate fee
    public static double calculatefee(double hours, int packageChoice)
    {
      switch(packageChoice)
      {
       case 1:
         return packageRateA(hours);
         
       case 2:
         return packageRateB(hours);
       case 3:
         return packageRateC();
         
        default:
        System.out.println("\nInvalid input!");
        
        return 0;
      }
    }
    
    //Prints fee and if there is savings
    public static void showMonthlyfee(double fee)
    {
      if (fee != 0)
      {
        System.out.printf("\nYour monthly fee is $%.2f\n", fee);
        getSavings(fee);
        System.out.printf("\n\n");
      }
      
      else 
      System.out.printf("\n");
    }
    
    //Gets fee if user has Package A
    public static double packageRateA(double hours)
    {
      if (hours < 10)
      {
        return 9.95;
      }
      
      else 
      {
        return (hours - 10)*2 + 9.95;
      }
    }
    
    
        //Gets fee if user has Package B
    public static double packageRateB(double hours)
    {
      if (hours < 20)
      {
        return 13.95;
      }
      
      else 
      {
        return (hours - 20) + 13.95;
      }
    }
    
        //Gets fee if user has Package C
    public static double packageRateC()
    {
        return 29.99;
    }
    
    //Check if savings are applicable and displays potential savings to user
    public static void getSavings(double fee)
    {
      if(fee > packageRateA(hours)){
      System.out.printf("With package A, you'd save $%.2f\n", fee - packageRateA(hours));
      }
      if (fee > packageRateB(hours))
      {
        System.out.printf("With package B, you'd save $%.2f\n", fee - packageRateB(hours));
      }
      
      if (fee > packageRateC())
      {
        System.out.printf("With package C, you'd save $%.2f\n", fee - packageRateC());
      } 
    }

  }


