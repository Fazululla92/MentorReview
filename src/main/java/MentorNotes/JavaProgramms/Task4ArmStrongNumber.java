package MentorNotes.JavaProgramms;

public class Task4ArmStrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int temp=num;
        int arm=0;
        while(num>0){
            int n = num%10;
            arm=arm+(n*n*n);
            num=num/10;
        }
        if(temp==arm){
            System.out.println("arm strong number");
        }
        else {
            System.out.println("not arm strong number");
        }
    }
}
