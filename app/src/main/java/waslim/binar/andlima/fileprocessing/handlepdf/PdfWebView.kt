package waslim.binar.andlima.fileprocessing.handlepdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_pdf_web_view.*
import waslim.binar.andlima.fileprocessing.R

class PdfWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_web_view)

        loadPdfWebView()
    }

    private fun loadPdfWebView(){
        viewPdfWebView.webViewClient = WebViewClient()
        viewPdfWebView.settings.setSupportZoom(true)
        viewPdfWebView.settings.javaScriptEnabled = true
        viewPdfWebView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + "https://kotlinlang.org/assets/kotlin-media-kit.pdf")
    }
}