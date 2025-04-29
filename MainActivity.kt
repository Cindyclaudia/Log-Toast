package com.example.implicit

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Website
        val websiteEditText: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener {
            val websiteURL = websiteEditText.text.toString()
            Log.v("cekString", websiteURL)
            Toast.makeText(applicationContext, websiteURL, Toast.LENGTH_SHORT).show()
            openWebsite(websiteURL)
        }

        // Lokasi
        val localEditText: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_button)
        locationButton.setOnClickListener {
            val locationName = localEditText.text.toString()
            Log.v("cekString", locationName)
            Toast.makeText(applicationContext, locationName, Toast.LENGTH_SHORT).show()
            openLocation(locationName)
        }

        // Share Text
        val shareEdit: EditText = findViewById(R.id.share_edit_text)
        val shareButton: Button = findViewById(R.id.share_text_button)
        shareButton.setOnClickListener {
            val text = shareEdit.text.toString()
            Log.v("cekString", text)
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
            shareText(text)
        }
    }

    private fun openLocation(location: String) {
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun openWebsite(websiteURL: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteURL))
        startActivity(intent)
    }

    private fun shareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "Share Text"))
    }
}
