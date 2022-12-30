package min.core.order;

public interface OrderService {
    Order makeOrder(Long memberId, String itemName, int itemPrice);
}
