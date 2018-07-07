package mobile.order.service.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mobile.order.service.PhoneAvailableService;

@Service
public class PhoneAvailableServiceImpl implements PhoneAvailableService {

	@Value("${phone.available.url}")
	private String phoneUrl;

	public List<LinkedHashMap> getPhonesAvailable() {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		ResponseEntity<List> result = restTemplate.exchange(phoneUrl, HttpMethod.GET, null, List.class);

		return result.getBody();
	}
}
