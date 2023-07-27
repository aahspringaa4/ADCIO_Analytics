package com.corca.adcio_analytics.api.service

object AdcioUrl {

    var baseUrl = "https://receiver-dev.adcio.ai/"

    const val Performance = "performance"

    object EndPoint {
        const val impression = "$Performance/impression"
        const val click = "$Performance/click"
        const val purchase = "$Performance/purchase"
    }
}