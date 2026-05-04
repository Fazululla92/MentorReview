package JavaOopsAndCollection;

import java.util.*;
public class PaymentSystem {

    static abstract class PaymentMethod {
        protected String status = "Pending";

        public abstract void processPayment(double amount) throws Exception;

        public boolean validatePaymentDetails() {
            return true;
        }

        public String getPaymentStatus() {
            return status;
        }
    }

    static class CreditCardPayment extends PaymentMethod {
        String cardNumber, expiryDate, cvv;

        CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
        }

        @Override
        public boolean validatePaymentDetails() {
            return cardNumber.matches("\\d{16}") &&
                    expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}") &&
                    cvv.matches("\\d{3}");
        }

        @Override
        public void processPayment(double amount) throws Exception {
            if (!validatePaymentDetails())
                throw new InvalidPaymentDetailsException("Invalid Credit Card Details");

            if (amount > 10000)
                throw new InsufficientFundsException("Credit limit exceeded");

            System.out.println("Credit Card Payment of ₹" + amount + " processed.");
            status = "Success";
        }
    }

    static class PayPalPayment extends PaymentMethod {
        String email, password;

        PayPalPayment(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public boolean validatePaymentDetails() {
            return email.contains("@") && email.contains(".");
        }

        @Override
        public void processPayment(double amount) throws Exception {
            if (!validatePaymentDetails())
                throw new InvalidPaymentDetailsException("Invalid PayPal Email");

            if (amount > 5000)
                throw new InsufficientFundsException("Insufficient PayPal Balance");

            System.out.println("PayPal Payment of ₹" + amount + " processed.");
            status = "Success";
        }
    }

    static class BankTransfer extends PaymentMethod {
        String accountNumber, bankName;

        BankTransfer(String accountNumber, String bankName) {
            this.accountNumber = accountNumber;
            this.bankName = bankName;
        }

        @Override
        public boolean validatePaymentDetails() {
            return accountNumber.matches("\\d{10}") && !bankName.isEmpty();
        }

        @Override
        public void processPayment(double amount) throws Exception {
            if (!validatePaymentDetails())
                throw new InvalidPaymentDetailsException("Invalid Bank Details");

            if (amount > 20000)
                throw new InsufficientFundsException("Bank Balance Insufficient");

            System.out.println("Bank Transfer of ₹" + amount + " processed.");
            status = "Success";
        }
    }

    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String msg) {
            super(msg);
        }
    }

    static class InvalidPaymentDetailsException extends Exception {
        InvalidPaymentDetailsException(String msg) {
            super(msg);
        }
    }

    static class PaymentProcessor {
        List<String> history = new ArrayList<>();

        public void process(PaymentMethod method, double amount) {
            try {
                method.processPayment(amount);
                String log = "SUCCESS: " + method.getClass().getSimpleName() +
                        " | ₹" + amount;
                history.add(log);
                System.out.println(log);

            } catch (InvalidPaymentDetailsException e) {
                System.out.println("FAILED: Invalid Details - " + e.getMessage());

            } catch (InsufficientFundsException e) {
                System.out.println("FAILED: Insufficient Funds - " + e.getMessage());

            } catch (Exception e) {
                System.out.println("FAILED: Error - " + e.getMessage());
            }
        }

        public void showHistory() {
            System.out.println("\nTransaction History:");
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.process(new CreditCardPayment("4111111111111111", "12/25", "123"), 2000);
        processor.process(new CreditCardPayment("1234567890123456", "01/20", "abc"), 2000);

        processor.process(new PayPalPayment("user@example.com", "secure123"), 3000);
        processor.process(new PayPalPayment("invalidEmail", "pass"), 1000);

        processor.process(new BankTransfer("1234567890", "Bank of Java"), 15000);
        processor.process(new BankTransfer("abc1234567", ""), 5000);

        processor.showHistory();
    }
}
