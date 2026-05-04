package Task7;
import java.io.IOException;
import java.util.logging.*;

public class Loggs {
    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger(Loggs.class.getName());
            logger.setUseParentHandlers(false);
            FileHandler fh = new FileHandler("all_logs.log", true);
            fh.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMillis() + " | " +
                            record.getLevel() + " | " +
                            record.getSourceMethodName() + " | " +
                            record.getMessage() + "\n";
                }
            });
            logger.addHandler(fh);
            logger.fine("This is FINE (debug-like) message");
            logger.info("This is INFO message");
            logger.warning("This is WARNING message");
            logger.severe("This is SEVERE message");
            int a = 10, b = 0;
            logger.fine("Preparing to divide " + a + " by " + b);
            if (b == 0) {
                logger.severe("Cannot divide by zero!");
            } else {
                int result = a / b;
                logger.info("Division successful: " + result);
            }

            System.out.println("Logging done! Checking the loggs in the console.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
