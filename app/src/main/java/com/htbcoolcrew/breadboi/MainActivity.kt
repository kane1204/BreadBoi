package com.htbcoolcrew.breadboi

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val enableCamera =
            findViewById<Button>(R.id.enableCamera)
        enableCamera.setOnClickListener {
            if (hasCameraPermission()) {
                enableCamera()
            } else {
                requestPermission()
            }
        }
    }

    private fun hasCameraPermission(): Boolean {
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                &&(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, CAMERA_PERMISSION, CAMERA_REQUEST_CODE)

    }

    private fun enableCamera() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
        private const val CAMERA_REQUEST_CODE = 10

    }
}