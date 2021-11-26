package com.example.generateqrcode

import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.example.generateqrcode.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            qrGen.setOnClickListener {
                generateQRCode("994206278")
            }
        }
    }

    fun generateQRCode(text:String){
        val qrgEncoder = QRGEncoder(text, null, QRGContents.Type.PHONE, 500)
        try {
            val bitmap = qrgEncoder.bitmap
            binding.image.setImageBitmap(bitmap)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}