import java.util.Scanner;

interface Payment {
    double calculateFee(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 2.0 / 100.0;
    }
}

class UpiPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.5 / 100.0;
    }
}

class WalletPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 1.0 / 100.0;
    }
}

public class OnlinePaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paymentType = sc.nextInt();
        double paymentAmount = sc.nextDouble();

        Payment payment;
        switch (paymentType) {
            case 1:
                payment = new CreditCardPayment();
                break;
            case 2:
                payment = new UpiPayment();
                break;
            default:
                payment = new WalletPayment();
        }

        double fee = payment.calculateFee(paymentAmount);
        double finalAmount = paymentAmount + fee;

        System.out.printf("Payment Amount: %.2f%n", paymentAmount);
        System.out.printf("Transaction Fee: %.2f%n", fee);
        System.out.printf("Final Amount: %.2f%n", finalAmount);

        sc.close();
    }
}
