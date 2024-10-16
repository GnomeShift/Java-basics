public interface PaymentSystem {
    void pay();
    void refund();
}

class CreditCard implements PaymentSystem {
    @Override
    public void pay() {
        System.out.println("Оплата кредиткой");
    }

    @Override
    public void refund() {
        System.out.println("Возврат на кредитку");
    }
}

class PayPal implements PaymentSystem {
    @Override
    public void pay() {
        System.out.println("Оплата PayPal");
    }

    @Override
    public void refund() {
        System.out.println("Возврат на PayPal");
    }
}

class Main9 {
    public static void main(String[] args) {
        CreditCard cc = new CreditCard();
        cc.pay();
        cc.refund();

        PayPal pp = new PayPal();
        pp.pay();
        pp.refund();
    }
}
