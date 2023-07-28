package com.corca.adcio_analytics

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.sdk.AdcioAnalytics
import com.corca.adcio_analytics.sdk.init

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btImpression = findViewById<Button>(R.id.btImpression)
        val btClick = findViewById<Button>(R.id.btClick)
        val btPurchase = findViewById<Button>(R.id.btPurchase)

        /** init Example */
        init(envFileName = null, urlKey = null, sessionId = Build.ID)

        btImpression.setOnClickListener {
            Thread {
                Log.d("eventTag", "impression request ${impressionEvent()}")
            }.start()
        }

        btClick.setOnClickListener {
            Thread {
                Log.d("eventTag", "click request ${clickEvent()}")
            }.start()
        }

        btPurchase.setOnClickListener {
            Thread {
                Log.d("eventTag", "purchase request ${purchaseEvent()}")
            }.start()
        }
    }

    // EXAMPLE
    private val option = LogOption(
        requestId = "",
        cost = 0,
        sessionId = "",
        memberId = "",
        campaignId = "",
        productId = "",
        price = 0,
        fromAgent = true,
    )

    private fun impressionEvent(): Int = AdcioAnalytics().impressionLogEvent(option) // 상품을 일정 시간동안 조회했을 때

    private fun clickEvent(): Int = AdcioAnalytics().clickLogEvent(option) // 상품을 클릭하였을 떄

    private fun purchaseEvent(): Int = AdcioAnalytics().purchaseLogEvent(option) // 상품을 구매하였을 때
}