package waslim.binar.andlima.fileprocessing.handlepdf

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pdf_storage.*
import waslim.binar.andlima.fileprocessing.R

class PdfStorage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_storage)

        selectpdfstorage()
    }

    fun showPdfstorage(uri : Uri){
        pdfstorage.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    fun selectpdfstorage(){
        val browsefile = Intent(Intent(Intent.ACTION_GET_CONTENT))
        browsefile.type = "application/pdf"
        browsefile.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browsefile, "select pdf"), 99)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 99 && resultCode == Activity.RESULT_OK){
            val selectPdf = data!!.data
            showPdfstorage(selectPdf!!)
        }
    }

}