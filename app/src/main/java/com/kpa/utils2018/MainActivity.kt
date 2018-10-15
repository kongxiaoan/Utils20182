package com.kpa.utils2018

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(ClickProxy(View.OnClickListener {
            Toast.makeText(this, "使用代理后的防重复点击事件", Toast.LENGTH_SHORT).show()
        }))

        button.setOnClickListener(ClickAgainProxy(View.OnClickListener {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }, 1000, object : ClickAgainProxy.IAgain {
            override fun onAngin() {
                //提示重复操作
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }))
    }
}
