package MentorNotes;

public class Singleton {
   private static Singleton instance;
   private Singleton(){
       System.out.println("Intilized....");
   }
   public static Singleton getInstance(){
       if(instance==null){
           System.out.println("check...");
           instance = new Singleton();
       }
       return instance;
   }

   public void bookingTickets(String movieName, int seats){
       System.out.println(movieName+" : "+seats+"  ");
   }
}

class check{
    static void main() {
        Singleton s = Singleton.getInstance();
        s.bookingTickets("DoomsDay",3);

        Singleton s1 = Singleton.getInstance();
        s1.bookingTickets("DUNE",2);
    }

}
