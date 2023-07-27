package com.corca.adcio_analytics.sdk

import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.api.error.NotInitializedError
import com.corca.adcio_analytics.api.service.AdcioUrl

/**

 HTTP Response Code Information

 201: HTTP Response Code = Success // Request Success
 400: HTTP Response Code = BadRequestException // Request Type Error
 500: HTTP Response Code = ServerException // Server Down or Unhandled client's error

 You should go through initialize and be authenticated before using Adcio Analytics.
 If you are uninitialized, return 0

 You don't need to repeat most parameters unless you have to. But, the only parameter that you have to include is the "sessionId(device id)".
 [You can get sessionId "val sessionId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)"]

 */

internal var bool: Boolean = false

class AdcioAnalytics {

    fun impressionLogEvent(logOption: LogOption): Int {
        if(!bool) {
            return 0
        }
        return processEvent(ProductImpressionEvent(logOption))
    }

    fun clickLogEvent(logOption: LogOption): Int {
        if(!bool) {
            return 0
        }
        return processEvent(ProductClickEvent(logOption))
    }

    fun purchaseLogEvent(logOption: LogOption): Int {
        if(!bool) {
            return 0
        }
        return processEvent(ProductPurchaseEvent(logOption))
    }
}

fun processEvent(analyticsType: AnalyticsType): Int {
    return analyticsType.processEvent()
}

// TODO("ENV 파일 로직 필요")
fun init(
    envFileName: String?,
    urlKey: String?,
    sessionId: String,
) {
    if (envFileName != null) {

    }
    if (urlKey != null) {
        AdcioUrl.baseUrl = urlKey
    }
    bool = true
}