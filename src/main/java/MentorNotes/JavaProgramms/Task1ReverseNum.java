package MentorNotes.JavaProgramms;

public class Task1ReverseNum {
    static void main() {
        int num = 12345656;
        int rev=0;
        //int count=0;
        while(num>0){
            int n = num%10;
            rev = (rev*10)+n;
            num=num/10;
            //count++;
        }
        System.out.println(rev);
    }
}
