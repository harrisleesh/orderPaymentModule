package com.bordercollie.test.paymentsystem.domain.controller;

import com.bordercollie.test.paymentsystem.domain.service.NaverPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Log
@RestController
@RequiredArgsConstructor
public class NaverPayController {

    private final NaverPayService naverPayService;

    @GetMapping("/naverPaySuccess")
    public ModelAndView naverPaySuccess(@RequestParam("paymentId") String paymentId) {
        log.info("naverPaySuccess get............................................");
        log.info("naverPaySuccess paymentId : " + paymentId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("info", naverPayService.naverPayApprove(paymentId));
        modelAndView.setViewName("naverPaySuccess.html");
        return modelAndView;
    }
}
