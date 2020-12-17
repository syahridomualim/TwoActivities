package com.mualim.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val TEXT_REQUEST = 1
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            Log.d(TAG, "Button clicked")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE, edt_message.text.toString())
            startActivityForResult(intent, TEXT_REQUEST)
            Toast.makeText(this, "Second Activity", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                txt_header_reply.visibility = View.VISIBLE
                txt_message_reply.text = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                txt_message_reply.visibility = View.VISIBLE
            }
        }
    }
}