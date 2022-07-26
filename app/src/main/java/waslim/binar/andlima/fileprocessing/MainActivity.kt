package waslim.binar.andlima.fileprocessing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.fileprocessing.HandleVideo.HandlingVideoPlay
import waslim.binar.andlima.fileprocessing.handleimage.HandlingImage
import waslim.binar.andlima.fileprocessing.handlepdf.HandlePdfActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handlePdf.setOnClickListener {
            startActivity(Intent(this, HandlePdfActivity::class.java))
        }

        handleVideo.setOnClickListener {
            startActivity(Intent(this, HandlingVideoPlay::class.java))
        }

        handleImage.setOnClickListener {
            startActivity(Intent(this, HandlingImage::class.java))
        }
    }
}