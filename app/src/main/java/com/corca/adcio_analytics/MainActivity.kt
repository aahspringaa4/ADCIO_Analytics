package com.corca.adcio_analytics

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.corca.adcio_analytics.api.LogOption
import com.corca.adcio_analytics.sdk.AdcioAnalytics
import com.corca.adcio_analytics.sdk.init
import io.github.cdimascio.dotenv.dotenv

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btImpression = findViewById<Button>(R.id.btImpression)
        val btClick = findViewById<Button>(R.id.btClick)
        val btPurchase = findViewById<Button>(R.id.btPurchase)

        val SETYOURURL = null

        /** init Example */
        init(
            envFileName = dotenv {
                directory = "/assets"
                filename = "env"
            },
            urlKey = "$SETYOURURL",
        )

        btImpression.setOnClickListener {
            Thread {
                AdcioAnalytics().impressionLogEvent(option)
            }.start()
        }

        btClick.setOnClickListener {
            Thread {
                AdcioAnalytics().clickLogEvent(option)
            }.start()
        }

        btPurchase.setOnClickListener {
            Thread {
                AdcioAnalytics().purchaseLogEvent(option)
            }.start()
        }
    }

    private val option = LogOption(
        requestId = "",
        cost = 0,
        memberId = "",
        campaignId = "",
        productId = "",
        price = 0,
        fromAgent = true,
    )
}