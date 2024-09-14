package com.cdc.democampay.services.valueobjects;

public record PaymentLinkData(int amount, String description, String txRef, String redirectUrl, String failedRedirectUrl) {
}
