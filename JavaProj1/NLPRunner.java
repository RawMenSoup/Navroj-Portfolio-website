import java.util.Scanner; //imports the scanner

public class NLPRunner {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in); //creates the scanner object
    Content fil = new Content();//  creates a nre object called fil
    System.out.println(fil.fi());// prints the opening sentence. 
    String l = input.nextLine();//  // the object to make the next line

    
    Content lebron = new Content(l); // creates the lebron object
    System.out.print("did you mean: " + lebron.chat()); //prints the results 




    
  
    
  }
}