package MentorNotes.JavaProgramms;

public class Task3Palindrom {
    public static void main(String[] args) {
        String str1 = "Malayalam";
        String rev = new StringBuilder(str1).reverse().toString();
        if(str1.equalsIgnoreCase(rev)){
            System.out.println("Palindrom");
        }
        else{
            System.out.println("Not Palindrom");
        }
    }
}
