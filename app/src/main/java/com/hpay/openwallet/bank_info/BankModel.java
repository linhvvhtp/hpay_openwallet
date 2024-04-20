package com.hpay.openwallet.bank_info;

public class BankModel {

    public String bankName, numberCard;
    public Boolean isDefault;

    public BankModel(String bankName, String numberCard, Boolean isDefault) {

        this.bankName = bankName;
        this.numberCard = numberCard;
        this.isDefault = isDefault;
    }
}
