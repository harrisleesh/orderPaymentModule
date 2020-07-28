package com.bordercollie.test.paymentsystem.domain.controller.dto;

import lombok.Data;

@Data
public class KakaoPayAmountVO {
    private Integer total, tax_free, vat, point, discount;
}
