package com.kpa.utils2018

import android.view.View

/**
 *author: mr.kong
 *Date:2018/10/15
 *description: 原有代码逻辑没有改动,只是添加了代理类,这样大大减小了侵入性
当然还可以扩展一下,提供重复点击的回调和自定义间隔时间,增加一个构造函数
 *project name:Utils20182
 *
 * 最简单的
 **/
open class ClickProxy(private var origin: View.OnClickListener) : View.OnClickListener {

    private var lastTime = 0L
    private var times = 1000L

    override fun onClick(v: View) {
        if (System.currentTimeMillis() - lastTime >= times) {
            origin.onClick(v)
            lastTime = System.currentTimeMillis()
        }
    }


}