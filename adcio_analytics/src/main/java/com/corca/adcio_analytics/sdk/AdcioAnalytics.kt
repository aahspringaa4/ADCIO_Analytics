package com.corca.adcio_analytics.sdk

import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.api.error.NotInitializedException
import com.corca.adcio_analytics.api.service.AdcioUrl
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv

/**

 HTTP Response Code Information

 201: HTTP Response Code = Success // Request Success
 400: HTTP Response Code = BadRequestException // Request Type Error
 500: HTTP Response Code = ServerException // Server Down or Unhandled client's error

 You should go through initialize and be authenticated before using Adcio Analytics.
 If you are uninitialized, HTTP Response Code will be throw NoInitializedError

 You don't need to repeat most parameters unless you have to. But, the only parameter that you have to include is the "sessionId(device id)".

 */

internal var bool: Boolean = false

class AdcioAnalytics {
    constructor()

    fun impressionLogEvent(logOption: LogOption) {
        if (!bool) {
            throw NotInitializedException()
        }
        processEvent(AdImpressionEvent(logOption))
    }

    fun clickLogEvent(logOption: LogOption) {
        if(!bool) {
            throw NotInitializedException()
        }
        processEvent(AdClickEvent(logOption))
    }

    fun purchaseLogEvent(logOption: LogOption) {
        if(!bool) {
            throw NotInitializedException()
        }
        processEvent(AdPurchaseEvent(logOption) )
    }
}

fun processEvent(analyticsType: AnalyticsType) {
    return analyticsType.processEvent()
}

/**
 envFile and urlKey are optional
 If you don't override them, they will go into our default value.
 */
fun init(
    envFileName: Dotenv = dotenv {
        directory = "/assets"
        filename = "env"
    },
    urlKey: String? = null,
) {
    if (urlKey != null) {
        AdcioUrl.baseUrl = urlKey
    }
    bool = true
}