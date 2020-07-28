package com.bordercollie.test.paymentsystem.domain.service;

import com.bordercollie.test.paymentsystem.domain.controller.dto.KakaoPayApprovalVO;
import com.bordercollie.test.paymentsystem.domain.controller.dto.NaverPayApprovalVO;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Log
@Service
public class NaverPayService {
    private static final String HOST = "https://dev.apis.naver.com";
    private NaverPayApprovalVO naverPayApprovalVO;
    public Object naverPayApprove(String paymentId) {
        log.info("naverPayApprove............................................");
        log.info("-----------------------------");

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("data-client-id", "u86j4ripEt8LRfPGzQ8");
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("paymentId", paymentId);

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {
            naverPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/naverpay-partner/naverpay/payments/v2.2/apply/payment"), body, NaverPayApprovalVO.class);
            log.info("" + naverPayApprovalVO);

            return naverPayApprovalVO;

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
