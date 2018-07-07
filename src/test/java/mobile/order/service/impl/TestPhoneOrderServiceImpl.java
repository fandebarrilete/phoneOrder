package mobile.order.service.impl;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import mobile.order.model.InternalErrorResponse;
import mobile.order.model.Order;
import mobile.order.model.OrderAmount;
import mobile.order.model.Phone;

@RunWith(MockitoJUnitRunner.class)
public class TestPhoneOrderServiceImpl {

	@InjectMocks
	private PhoneOrderServiceImpl phoneOrderService;

	@Test
	public void testBuyPhone() throws InternalErrorResponse {
		OrderAmount result = phoneOrderService.buyPhone(getDataTest());

		Assert.assertEquals(result.getTotalAmount(), new Double(400.0));
	}

	private Order getDataTest() {
		Order order = new Order();

		Phone phone1 = new Phone();
		phone1.setId(1l);
		phone1.setNumber(1);
		phone1.setPrice(200d);
		Phone phone2 = new Phone();
		phone2.setId(2l);
		phone2.setNumber(2);
		phone2.setPrice(100d);
		order.setListPhones(Arrays.asList(phone1, phone2));
		return order;
	}

}
