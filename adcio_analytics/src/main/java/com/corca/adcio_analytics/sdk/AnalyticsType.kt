package com.corca.adcio_analytics.sdk

import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.api.repository.AdcioRepository
import com.corca.adcio_analytics.api.repository.AdcioRepositoryImpl

sealed class AnalyticsType {
    abstract fun processEvent(): Int
}

private val adcioRepository: AdcioRepository = AdcioRepositoryImpl()

data class ProductImpressionEvent(val logOption: LogOption): AnalyticsType() {
    override fun processEvent(): Int {
        return adcioRepository.sendImpressionData(logOption)
    }
}

data class ProductClickEvent(val logOption: LogOption): AnalyticsType() {
    override fun processEvent(): Int {
        return adcioRepository.sendClickData(logOption)
    }
}

data class ProductPurchaseEvent(val logOption: LogOption): AnalyticsType() {
    override fun processEvent(): Int {
        return adcioRepository.sendPurchaseData(logOption)
    }
}