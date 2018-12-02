package com.example.gautam.poker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.camerakit.CameraKitView
import android.R.attr.button
import android.widget.Button
import android.R.attr.button
import android.content.Intent
import android.view.View





class MainActivity : AppCompatActivity() {

    private var cameraKitView: CameraKitView? = null
    var cam = findViewById<Button>(R.id.push_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraKitView = findViewById(R.id.camera)

        /*cam.setOnClickListener(object : View.OnClickListener {
            @Override
            fun onClick(v: View) {
                val intent = Intent(this, ResultsActivity::class.java)
                startActivity(intent)

        })*/

        cam.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        cameraKitView!!.onStart()
    }

    override fun onResume() {
        super.onResume()
        cameraKitView!!.onResume()
    }

    override fun onPause() {
        cameraKitView!!.onPause()
        super.onPause()
    }

    override fun onStop() {
        cameraKitView!!.onStop()
        super.onStop()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        cameraKitView!!.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


}
