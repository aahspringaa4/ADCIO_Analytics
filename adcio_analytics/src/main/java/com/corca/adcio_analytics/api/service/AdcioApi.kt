package com.corca.adcio_analytics.api.service

import com.corca.adcio_analytics.api.LogOption
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AdcioApi {

    @POST(AdcioUrl.EndPoint.impression)
    fun onAdImpressionEvent(
        @Body logOption: LogOption
    ): Call<Void>

    @POST(AdcioUrl.EndPoint.click)
    fun onAdClickEvent(
        @Body logOption: LogOption
    ): Call<Void>

    @POST(AdcioUrl.EndPoint.purchase)
    fun onAdPurChaseEvent(
        @Body logOption: LogOption
    ): Call<Void>
}