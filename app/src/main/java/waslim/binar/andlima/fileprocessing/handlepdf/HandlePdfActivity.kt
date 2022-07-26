package waslim.binar.andlima.fileprocessing.handlepdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_handle_pdf.*
import waslim.binar.andlima.fileprocessing.R

class HandlePdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_pdf)

        btn_pdfWebViewer.setOnClickListener {
            startActivity(Intent(this, PdfWebView::class.java))
        }

        btn_pdfStorage.setOnClickListener {
            startActivity(Intent(this, PdfStorage::class.java))
        }

        btn_pdfInternet.setOnClickListener {
            startActivity(Intent(this, PdfInternet::class.java))
        }

        btn_pdfAsset.setOnClickListener {
            startActivity(Intent(this, PdfAssetView::class.java))
        }
    }
}