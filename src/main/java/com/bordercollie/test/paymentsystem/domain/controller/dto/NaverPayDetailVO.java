package com.bordercollie.test.paymentsystem.domain.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NaverPayDetailVO {
    private String paymentId;
    private String payHistId;
    private String merchantId;
    private String merchantName;
    private String merchantPayKey;
    private String merchantUserKey;
    private String admissionTypeCode;
    private Long totalPayAmount;
}
