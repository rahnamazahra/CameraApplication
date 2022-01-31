package com.rahnama.cameraapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahnama.cameraapplication.databinding.ActivityMainBinding
import androidx.core.app.ActivityCompat.startActivityForResult

import android.provider.MediaStore

import android.content.Intent

import android.view.View
import android.graphics.Bitmap
import android.widget.Toast

import android.content.ActivityNotFoundException
import androidx.activity.result.contract.ActivityResultContracts


private  lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnPhoto.setOnClickListener {
            val intent = Intent( MediaStore.ACTION_IMAGE_CAPTURE)
            resultLauncher.launch(intent)
    }

    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data

                val resultPhoto = data!!.extras!!["data"] as Bitmap?  //تبدیل به بیت مپ
                binding.imageView.setImageBitmap(resultPhoto)

        }
    }


}