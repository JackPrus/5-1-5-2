package by.jonline.module5_2.task2;

public class Task02 {

	/*
	 * Создать класс Payment с внутренним классом, с помощью объектов которого можно
	 * сформировать покупку из нескольких товаров.
	 */

	public static void main(String[] args) {
		
        Payment payment = new Payment(1000);

        try {

            payment.newPurchase(Payment.PurchaseType.CAR);
            payment.newPurchase(Payment.PurchaseType.BOAT);
            payment.newPurchase(Payment.PurchaseType.HOUSE);

        } catch (NotEnoughMoneyException |
                UnsupportedOperationException |
                IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(payment.print());

	}

}
