package waslim.binar.andlima.fileprocessing.HandleVideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import kotlinx.android.synthetic.main.activity_handling_video_play.*
import waslim.binar.andlima.fileprocessing.R

class HandlingVideoPlay : AppCompatActivity() {
    private var nPlayer : ExoPlayer?= null
    private val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handling_video_play)

        viewExoPlayer()
    }

    private fun viewExoPlayer(){
        nPlayer = ExoPlayer.Builder(this).build()
        viewPlayer.player = nPlayer
        nPlayer!!.setMediaSource(buildMediaSource())
        nPlayer!!.prepare()
    }

    private fun buildMediaSource(): MediaSource {
        // Create a data source factory.
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

        // Create a progressive media source pointing to a stream uri.
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videoUrl))

        return mediaSource
    }

    private fun releasePlayer(){
        if (nPlayer == null){
            return
        }

        nPlayer!!.release()
        nPlayer = null
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

}