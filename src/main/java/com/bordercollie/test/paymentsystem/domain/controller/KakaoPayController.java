package com.bordercollie.test.paymentsystem.domain.controller;

import com.bordercollie.test.paymentsystem.domain.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@RestController
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaopay;

    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("/kakaoPay")
    public void kakaoPay(HttpServletResponse response) throws IOException {
        log.info("kakaoPay post............................................");
        response.sendRedirect(kakaopay.kakaoPayReady());
    }

    @GetMapping("/kakaoPaySuccess")
    public ModelAndView kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        //model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("info", kakaopay.kakaoPayInfo(pg_token));
        modelAndView.setViewName("kakaoPaySuccess.html");
        return modelAndView;
    }

}
