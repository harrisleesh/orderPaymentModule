package com.bordercollie.test.paymentsystem.domain.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NaverPayApprovalVO {
    private String paymentId;
    private NaverPayDetailVO naverPayDetailVO;

}
