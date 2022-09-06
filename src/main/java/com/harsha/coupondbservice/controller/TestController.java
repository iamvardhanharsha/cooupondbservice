package com.harsha.coupondbservice.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/hai")
	public ResponseEntity<String> hai(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "lastname", required = false) String lastname) {

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("name", "harsha");
		ResponseEntity<String> response = new ResponseEntity<String>("hai  --" + name + "=====" + lastname, hearder,
				HttpStatus.ACCEPTED);
		return response;
	}

	@GetMapping("/haipathparam/{id}/{id2}")
	public ResponseEntity<String> haipathparam(@PathVariable(name = "id") String token,
			@PathVariable(name = "id2") String newid, @RequestHeader("AppToken") String headerValue,
			@RequestHeader Map<String, String> headers) {

		headers.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "======   " + x.getValue()));

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("AppToken", headerValue);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"value  --" + token + "   " + newid + " ABC  Header  " + headers.get("abc"), hearder, HttpStatus.OK);
		return response;
	}

	@RequestMapping("/*")
	public String defaultMappling() {
		return "defaultMappling";
	}

}
