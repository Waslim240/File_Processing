package waslim.binar.andlima.fileprocessing.handlepdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pdf_asset_view.*
import waslim.binar.andlima.fileprocessing.R

class PdfAssetView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_asset_view)

        showPdfFromAsset(getpdfName())
    }

    private fun showPdfFromAsset(pdfName : String){
        pdfasset.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError{page, _ ->
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
            .load()
    }

    private fun getpdfName() : String{
        return "kotlin-media-kit.pdf"
    }
}