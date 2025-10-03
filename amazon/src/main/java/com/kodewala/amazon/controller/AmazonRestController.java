package com.kodewala.amazon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.amazon.request.OrderRequest;

@RestController
public class AmazonRestController {

	@PostMapping("/placeOrder")
	public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest) {

		String itemName = orderRequest.getItemName();
		String price = orderRequest.getPrice();
		String qty = orderRequest.getQty();

		return ResponseEntity.status(201)
				.body(" Order recevied for " + itemName + ". Qty is " + qty + " and per item cost is " + price);
	}

}
