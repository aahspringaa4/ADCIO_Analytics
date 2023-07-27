package com.corca.adcio_analytics.api.repository

import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.api.service.adcioApi

interface AdcioRepository {

    fun sendImpressionData(logOption: LogOption): Int

    fun sendClickData(logOption: LogOption): Int

    fun sendPurchaseData(logOption: LogOption): Int
}

class AdcioRepositoryImpl: AdcioRepository {

    override fun sendImpressionData(logOption: LogOption): Int {
        val response = adcioApi.onProductImpressionEvent(logOption)
        return response.execute().code()
    }

    override fun sendClickData(logOption: LogOption): Int {
        val response = adcioApi.onProductClickEvent(logOption)
        return response.execute().code()
    }

    override fun sendPurchaseData(logOption: LogOption): Int {
        val response = adcioApi.onProductPurChaseEvent(logOption)
        return response.execute().code()
    }
}
