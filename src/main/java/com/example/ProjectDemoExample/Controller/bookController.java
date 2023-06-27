package com.example.ProjectDemoExample.Controller;

import com.example.ProjectDemoExample.Dao.BookRepo;
import com.example.ProjectDemoExample.Entity.Book;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @ResponseBody
    @PostMapping("/user/payment_order/")
    public String handlePostRequestOfSeatCount(Model model, @RequestBody String amountEntered) throws RazorpayException {
        String arr[] = amountEntered.split("=");
        System.out.println(arr[0]);
        int amt=Integer.parseInt(arr[0]);

        RazorpayClient razorpay=new RazorpayClient("rzp_test_tzAi2Ez969oxas","xYixh7VQzQ7K1lK3ASyjOMMP");
        JSONObject option=new JSONObject();
        option.put("amount", amt*100); // amount in the smallest currency unit
        option.put("currency", "INR");
//        StringBuilder stringBuilder = new StringBuilder("order_rcptid_");
//
//        long timestamp = System.currentTimeMillis();
//        stringBuilder.append(timestamp);
//
//        String orderReceiptId = stringBuilder.toString();
//        System.out.println(orderReceiptId);
        option.put("receipt","innovative_things_receipt");
        Order order=razorpay.orders.create(option);
        System.out.println("Order:"+order);
        Integer amtval=option.getInt("amount");
        String trncId=order.get("id");
        String currency=option.getString("currency");
        System.out.println(amtval);
        return order.toString();
    }



}
