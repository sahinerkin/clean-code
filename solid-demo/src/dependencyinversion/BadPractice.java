package dependencyinversion;

public class BadPractice {

    static class PaymentProcessor {

        // PaymentProcessor yüksek seviye sınıf, GizaInc ve FasterCard gibi düşük seviye sınıfları
        // bünyesinde ayrı ayrı kaydediyor ve doğrudan o sınıfların metotları ayrı ayrı çağırılıyor.

        // Yeni bir ödeme kanalı dizayn edildiğinde ve eklenmek istendiğinde PaymentProcessor
        // sınıfının da değiştirilmesi gerekli.

        private GizaInc gizaPay = null;
        private FasterCard fcPay = null;

        PaymentProcessor(GizaInc gizaPay) {
            this.gizaPay = gizaPay;
        }

        PaymentProcessor(FasterCard fcPay) {
            this.fcPay = fcPay;
        }

        private void processPayment(int amountInDollars) {
            if (gizaPay != null) {
                gizaPay.pay(amountInDollars);
            } else if (fcPay != null) {
                fcPay.pay(amountInDollars);
            }
        }
    }

    static class GizaInc {
        public void pay(int amountInDollars) {
            System.out.println("Payment of $" + amountInDollars + " performed successfully with Giza!");
        }
    }

    static class FasterCard {
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
