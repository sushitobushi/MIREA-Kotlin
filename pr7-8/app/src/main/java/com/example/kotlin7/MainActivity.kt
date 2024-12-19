package com.example.kotlin7

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var editTextUrl: EditText
    lateinit var buttonDownload: Button
    lateinit var imageView: ImageView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUrl = findViewById(R.id.editTextUrl)
        buttonDownload = findViewById(R.id.buttonDownload)
        imageView = findViewById(R.id.imageView)

        buttonDownload.setOnClickListener {
            val imageUrl = editTextUrl.text.toString()
            downloadAndSaveImage(imageUrl,this)
        }
    }

    fun downloadAndSaveImage(imageUrl: String, context: Context) {
        CoroutineScope(Dispatchers.Main).launch {
            val bitmapDeferred = downloadImage(imageUrl)
            val bitmap = bitmapDeferred.await()
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap)
                saveImageToDisk(bitmap, context)
            } else {
                Toast.makeText(context, "Ошибка загрузки изображения", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun downloadImage(imageUrl: String): Deferred<Bitmap?> {
        return CoroutineScope(Dispatchers.IO).async {
            try {
                val url = URL(imageUrl)
                val connection = url.openConnection()
                connection.doInput = true
                connection.connect()
                val input = connection.getInputStream()
                BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    fun saveImageToDisk(bitmap: Bitmap, context: Context): Job {
        return CoroutineScope(Dispatchers.IO).async {
            try {
                val file = File(
                    context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "downloaded_image.jpg"
                )
                FileOutputStream(file).use { outputStream ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                    outputStream.flush()
                }
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Изображение сохранено",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Ошибка сохранения изображения", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}