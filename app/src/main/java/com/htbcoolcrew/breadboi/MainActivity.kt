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
//                (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, CAMERA_PERMISSION, CAMERA_REQUEST_CODE)
        ActivityCompat.requestPermissions(this, NET_PERMS, NET_REQUEST_CODE)
        ActivityCompat.requestPermissions(this, WRITE_PERM, STORAGE_PERMISSION_CODE)

    }

    private fun enableCamera() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
        private val NET_PERMS = arrayOf(Manifest.permission.INTERNET)
        private val WRITE_PERM = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        private val READ_PERM = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        private const val CAMERA_REQUEST_CODE = 10
        private const val NET_REQUEST_CODE = 11
        private const val STORAGE_PERMISSION_CODE = 101
    }
}