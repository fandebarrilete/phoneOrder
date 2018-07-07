package mobile.order.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mobile.order.model.InternalErrorResponse;
import mobile.order.model.Order;
import mobile.order.model.OrderAmount;
import mobile.order.model.Phone;
import mobile.order.model.PhoneAmount;
import mobile.order.service.PhoneAvailableService;
import mobile.order.service.PhoneOrderService;

@Service
public class PhoneOrderServiceImpl  implements PhoneOrderService {

	private static final Logger log = LoggerFactory.getLogger(PhoneOrderServiceImpl.class);

	@Autowired
	private PhoneAvailableService phoneAvailableService;

	@Override public OrderAmount buyPhone(Order body) throws InternalErrorResponse {
		validate(body.getListPhones());

		OrderAmount orderAmount = new OrderAmount();
		orderAmount.setListPhoneAmount(body.getListPhones().stream().map(PhoneOrderServiceImpl::getPhoneAmount).collect(Collectors.toList()));
		orderAmount.setTotalAmount(body.getListPhones().stream().map(src -> src.getNumber() * src.getPrice()).reduce(0.0, (a, b) -> a + b));

		log.info("Order=", orderAmount);
		return orderAmount;
	}

	private void validate(List<Phone> listPhones) throws InternalErrorResponse {
		List<LinkedHashMap> listValid = phoneAvailableService.getPhonesAvailable();
		for (Phone phone : listPhones) {
			List<LinkedHashMap> phoneSearched = listValid.stream().filter(ph -> String.valueOf(ph.get("id")).equals(String.valueOf(phone.getId()))).collect(Collectors.toList());
			if (phoneSearched.size() != 1) {
				throw new InternalErrorResponse("Phone not exist", "001");
			}
			if (!phoneSearched.get(0).get("price").equals(phone.getPrice())) {
				throw new InternalErrorResponse("Price is not valid", "002");
			}
		}
		listValid.stream();
	}

	private static PhoneAmount getPhoneAmount(Phone phone) {
		PhoneAmount phoneAmount = new PhoneAmount();
		phoneAmount.setId(phone.getId());
		phoneAmount.setName(phone.getName());
		phoneAmount.setDescription(phone.getDescription());
		phoneAmount.setPrice(phone.getPrice());
		phoneAmount.setNumber(phone.getNumber());
		phoneAmount.setTotalAmount(phone.getNumber() * phone.getPrice());
		return phoneAmount;
	}
}
