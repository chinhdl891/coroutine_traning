package com.example.coroutine_training

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.CoroutineContext


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var job: Job? = null
    private var job2: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imv_main_url)
        runBlocking {
            val start = System.currentTimeMillis()
            delay(2000)
            val end = System.currentTimeMillis() - start
            Log.d(TAG, "onCreate: $end")
            loadAnh()
        }
        Thread.sleep(500)
        onClick()
    }

    private fun onClick() {
        val i = Intent()
        i.action = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        i.addCategory(Intent.CATEGORY_DEFAULT)
        i.data = Uri.parse("package:" + packageName)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        this.startActivity(i)
    }

    suspend fun loadAnh() {
        delay(200)
        imageView?.setImageResource(R.drawable.ic_launcher_background)
    }

//        val myScope = MyScope(Dispatchers.IO)
//        val jobTotal = myScope.launch {
//            job = GlobalScope.launch(Dispatchers.IO) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(applicationContext, "Đang tải ảnh 1", Toast.LENGTH_SHORT)
//                        .show()
//                }
//                val loadImage: Deferred<Bitmap> =
//                    async { getImage("https://1.bp.blogspot.com/-_-WXkvUs5sU/X8z0rNesQwI/AAAAAAAAlak/8hZrKMLPJyQtiCuumD7tujjsetqj6H6XgCNcBGAsYHQ/s0/3b45be8a65f14c935ba1cea67d9cefb5.jpg") }
//                withContext(Dispatchers.Main) {
//                    with(imageView) { this?.setImageBitmap(loadImage.await()) }
//                }
//
//            }
//            job2 = GlobalScope.launch(Dispatchers.IO) {
//                job?.join()
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(applicationContext, "Đang tải ảnh", Toast.LENGTH_SHORT)
//                        .show()
//                }
//                val loadImage: Deferred<Bitmap> =
//                    async { getImage("https://1.bp.blogspot.com/-hN0NCoAmEDY/X8z1OcRjXmI/AAAAAAAAlc0/hHqbHzqOPhIABiVomzpYacPeEufV816QQCNcBGAsYHQ/s0/hinh-nen-may-cuc-dep.jpg") }
//                withContext(Dispatchers.Main) {
//                    with(imageView) { this?.setImageBitmap(loadImage.await()) }
//                    Toast.makeText(applicationContext, "Đang tải ảnh 2", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//        }
}

private fun getImage(url: String): Bitmap {
    return try {
        val url = URL(url)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()
        val input: InputStream = connection.inputStream
        val myBitmap = BitmapFactory.decodeStream(input)
        myBitmap
    } catch (e: IOException) {
        return null as Bitmap
    }
}

class MyScope(override val coroutineContext: CoroutineContext) : CoroutineScope