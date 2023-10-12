package com.example.news

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.news.R.layout.activity_detail

//detailWebView.settings.javaScriptEnabled= true
//            detailWebView.settings.userAgentString="Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
//            detailWebView.webViewClient= object : WebViewClient(){
//                override fun onPageFinished(view: WebView?, url: String?) {
//                    super.onPageFinished(view, url)
//                    progressBar.visibility=View.GONE
//                    detailWebView.visibility=View.VISIBLE
//                }
//            }


class DetailActivity : AppCompatActivity() {


    var detailWebView =findViewById<WebView>(R.id.detailWebView)
    var progressBar=findViewById<ProgressBar>(R.id.progressBar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activity_detail)
        val url = intent.getStringExtra("URL")
        var package_name = "com.android.chrome"
        if (url!=null){
            val builder = CustomTabsIntent.Builder()
             builder.setShowTitle(true)
            builder.setInstantAppsEnabled(true)
            val customBuilder=builder.build()
            customBuilder.intent.setPackage(package_name)
            customBuilder.launchUrl(this, Uri.parse(url))
        }
    }
}