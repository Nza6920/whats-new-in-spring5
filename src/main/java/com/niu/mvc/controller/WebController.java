package com.niu.mvc.controller;

import com.niu.mvc.service.StockPriceService;
import com.niu.mvc.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.niu.mvc.Constants.TEST_USER_EMAIL;

@Controller
public class WebController {

    @Autowired
    private SubscriptionService subscriptionServiceImpl;

    @Autowired
    private StockPriceService stockPriceService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("email", TEST_USER_EMAIL);
        model.addAttribute("stockPrices", stockPriceService.getPrice(TEST_USER_EMAIL));
        return "index";
    }
}
