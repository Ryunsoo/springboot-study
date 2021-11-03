package com.kh.spring.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("order")
public class OrderController {

	@GetMapping("order-form")
	public void orderForm() {}
	
	@PostMapping("order")
	public String order(@RequestParam(required = false) List<String> food
						,Model model) {
		
		Map<String, Integer> foodMap = new HashMap<String, Integer>();
		model.addAttribute("food", foodMap);
		
		if(food == null) return "order/receipt";
		
		for (String f : food) {
			foodMap.put(f, getPrice(f));
		}
		
		return "order/receipt";
	}
	
	private int getPrice(String name) {
		switch (name) {
		case "피자":
			return 22000;
		case "햄버거":
			return 5000;
		case "치킨":
			return 18000;
		case "회":
			return 20000;
		default:
			return 0;
		}
	}
	
}
