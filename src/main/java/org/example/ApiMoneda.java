package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class ApiMoneda{
    private String baseCode;
    private String targetCode;
    private BigDecimal conversionRate;
    private BigDecimal conversionResult;

    public ApiMoneda(){}

    public ApiMoneda(String baseCode, String targetCode, BigDecimal conversionRate, BigDecimal conversionResult) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(BigDecimal conversionResult) {
        this.conversionResult = conversionResult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApiMoneda apiMoneda = (ApiMoneda) o;
        return Objects.equals(baseCode, apiMoneda.baseCode) && Objects.equals(targetCode, apiMoneda.targetCode) && Objects.equals(conversionRate, apiMoneda.conversionRate) && Objects.equals(conversionResult, apiMoneda.conversionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseCode, targetCode, conversionRate, conversionResult);
    }

    @Override
    public String toString() {
        return "ApiMoneda{" +
                "baseCode='" + baseCode + '\'' +
                ", targetCode='" + targetCode + '\'' +
                ", conversionRate=" + conversionRate +
                ", conversionResult=" + conversionResult +
                '}';
    }
}