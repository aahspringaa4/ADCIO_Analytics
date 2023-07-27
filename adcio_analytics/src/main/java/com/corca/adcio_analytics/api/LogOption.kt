package com.corca.adcio_analytics.api

data class LogOption(
    val requestId: String = "",
    val cost: Int = 0,
    val sessionId: String = "",
    val memberId: String = "",
    val campaignId: String = "",
    val productId: String = "",
    val price: Int = 0,
    val fromAgent: Boolean = false
)
