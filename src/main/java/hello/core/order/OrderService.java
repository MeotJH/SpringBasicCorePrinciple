package hello.core.order;

import hello.core.member.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
