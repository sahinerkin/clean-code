package dependencyinversion;

public class GoodPractice {

    static class PaymentProcessor {
        // PaymentChannel arayüzü sayesinde yüksek seviye sınıfımız olan PaymentProcessor,
        // düşük seviyedeki sınıflarla ilgilenmiyor. Sadece arayüzün pay() metodunu kullanıyor.

        // Yeni ödeme yöntemi ekleneceği zaman PaymentChannel arayüzünden implement edilmesi yeterli.
        // Bağımlılık kaldırıldığından üst sınıfta bir değişiklik yapılmasına gerek kalmıyor.

        PaymentChannel pc;

        PaymentProcessor(PaymentChannel pc) {
            this.pc = pc;
        }

        private void processPayment(int amountInDollars) {
            pc.pay(amountInDollars);
        }
    }

    private interface PaymentChannel {
        public void pay(int amountInDollars);
    }

    static class GizaInc implements PaymentChannel {

        @Override
        public void pay(int amountInDollars) {
            System.out.println("Payment of $" + amountInDollars + " performed successfully with Giza!");
        }
    }

    static class FasterCard implements PaymentChannel {

        @Override
        public void pay(int amountInDollars) {
            System.out.println("FasterCard processed your payment of $" + amountInDollars + "!");
        }
    }

    public static void main(String[] args) {
        PaymentProcessor pp1 = new PaymentProcessor(new GizaInc());
        pp1.processPayment(150);

        PaymentProcessor pp2 = new PaymentProcessor(new FasterCard());
        pp2.processPayment(85);
    }
}
