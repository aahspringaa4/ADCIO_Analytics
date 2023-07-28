package com.corca.adcio_analytics.api.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(AdcioUrl.baseUrl)
    addConverterFactory(GsonConverterFactory.create())
}.build()

internal val adcioApi: AdcioService by lazy {
    retrofit.create(AdcioService::class.java)
}