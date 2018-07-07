package mobile.order.service;

import mobile.order.model.InternalErrorResponse;
import mobile.order.model.Order;
import mobile.order.model.OrderAmount;

public interface PhoneOrderService {
	OrderAmount buyPhone(Order body) throws InternalErrorResponse;
}
