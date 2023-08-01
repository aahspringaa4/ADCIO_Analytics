package com.corca.adcio_analytics.api.repository

import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.api.service.adcioApi

interface AdcioRepository {

    fun sendImpressionData(logOption: LogOption)

    fun sendClickData(logOption: LogOption)

    fun sendPurchaseData(logOption: LogOption)
}

class AdcioRepositoryImpl: AdcioRepository {

    override fun sendImpressionData(logOption: LogOption) {
        adcioApi.onAdImpressionEvent(logOption)
    }

    override fun sendClickData(logOption: LogOption) {
        adcioApi.onAdClickEvent(logOption)
    }

    override fun sendPurchaseData(logOption: LogOption) {
        adcioApi.onAdPurChaseEvent(logOption)
    }
}
