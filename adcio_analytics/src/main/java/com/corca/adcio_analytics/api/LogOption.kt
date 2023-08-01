package com.corca.adcio_analytics.api

import android.os.Build
import com.google.gson.annotations.SerializedName

data class LogOption(
    @field:SerializedName("requestId") val requestId: String,
    @field:SerializedName("cost") val cost: Int,
    @field:SerializedName("sessionId") val sessionId: String = Build.ID,
    @field:SerializedName("memberId")  val memberId: String,
    @field:SerializedName("campaignId") val campaignId: String,
    @field:SerializedName("productId") val productId: String,
    @field:SerializedName("price") val price: Int,
    @field:SerializedName("fromAgent") val fromAgent: Boolean,
)
