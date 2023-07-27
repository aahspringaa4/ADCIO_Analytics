package com.corca.adcio_analytics.api.service

import com.corca.adcio_analytics.api.LogOption
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AdcioApi {

    @POST(AdcioUrl.EndPoint.impression)
    fun onProductImpressionEvent(
        @Body logOption: LogOption
    ): Call<Void>

    @POST(AdcioUrl.EndPoint.click)
    fun onProductClickEvent(
        @Body logOption: LogOption
    ): Call<Void>

    @POST(AdcioUrl.EndPoint.purchase)
    fun onProductPurChaseEvent(
        @Body logOption: LogOption
    ): Call<Void>
}