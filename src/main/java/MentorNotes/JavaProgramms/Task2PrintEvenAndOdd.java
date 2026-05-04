package MentorNotes.JavaProgramms;

public class Task2PrintEvenAndOdd {
    public static void main(String[] args) {
        //print 1 to 100 even number
        int addEven=0;
        for (int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                //add all even numbers
                addEven=addEven+i;
            }
//            odd numbers
//            else{
//                System.out.println(i);
//            }
        }
        System.out.println(addEven);
    }
}
