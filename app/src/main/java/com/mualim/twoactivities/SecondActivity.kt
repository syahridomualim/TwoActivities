package com.mualim.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "extra_reply"
        private val TAG = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txt_message.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        btn_reply.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EXTRA_REPLY, edt_message_reply.text.toString())
            setResult(RESULT_OK, intent)
            Log.d(TAG, "End SecondActivity")
            finish()
        }
    }
}