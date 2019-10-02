package com.example.androidlabs


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    val ACTIVITY_NAME = "PROFILE_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        emailTextProfile.setText(intent.getStringExtra("emailAddress"))
        imageButton.setOnClickListener {
            dispatchTakePictureIntent()
        }
        Log.e(ACTIVITY_NAME, "In function: onCreate()" )
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageButton.setImageBitmap(imageBitmap)
        }
        Log.e(ACTIVITY_NAME, "In function: onActivityResult()" )
    }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.e(ACTIVITY_NAME, "In function: onPause()" )
    }

    override fun onStop() {
        super.onStop()
        Log.e(ACTIVITY_NAME, "In function: onStop()" )
    }

    override fun onStart() {
        super.onStart()
        Log.e(ACTIVITY_NAME, "In function: onStart()" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(ACTIVITY_NAME, "In function: onDestroy()" )
    }

    override fun onResume() {
        super.onResume()
        Log.e(ACTIVITY_NAME, "In function: onResume()" )
    }
}


