import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Content{

  private ArrayList<String> response;
  private ArrayList<String> filer;

  private String answer;
  
  public Content(){
    this("apple"); // instantuates apple
  }
  public Content(String answer){
    this.answer = answer; //instantuates answer
    loadFiles();
  }

  private void loadFiles() {
    try {
      List<String> data = Files.readAllLines(Paths.get("dataBase.txt"));
      response = new ArrayList<>(data);
    } catch (IOException e) {
      response = new ArrayList<>();
      e.printStackTrace();
    }
    try {
      List<String> data = Files.readAllLines(Paths.get("Bull.txt"));
      filer = new ArrayList<>(data);
    } catch (IOException e) {
      filer = new ArrayList<>();
      e.printStackTrace();
    }
  }

  public String fi(){
    if (filer == null || filer.isEmpty()) return "";
    int ran = (Math.random() < 0.5) ? 0 : 1;// gets either a 0 or a one, the "?" is the same thing as an if statement  
    // ensure index is valid
    ran = Math.min(ran, filer.size() - 1);
    return filer.get(ran); //returns the random statement
  }

  public String chat(){
    int likeness = 0;
    String current = "Apple"; 
    String A = "A";
    String B = "A";//makes it easier on my eyes so I made these 2 strings
    String corection = "Apple";
    int max = 0;
    if (response == null) return corection;
    for(int inner = 0; inner < response.size(); inner++){
      current = response.get(inner);
      // compare up to the minimum available length and up to 4 chars
      int len = Math.min(4, Math.min(current.length(), answer.length()));
      likeness = 0;
      for(int outer = 0; outer < len; outer++){ // 4 is repersenting the characters of the word that are being checked
        A = current.substring(outer,outer + 1);
        B = answer.substring(outer,outer + 1);
        if (A.equals(B)){ // If a = b then the likeness is incremented
          likeness++;
          if(likeness > max){
            max = likeness; //the highest likeness in the list will be the corection
            corection = response.get(inner);
          }
        }
      }
    }
    return corection; //returns corection 
  }
}