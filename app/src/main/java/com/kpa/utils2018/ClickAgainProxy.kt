package com.kpa.utils2018

import android.view.View

/**
 *author: mr.kong
 *Date:2018/10/15
 *description:
 *project name:Utils20182
 **/
class ClickAgainProxy : View.OnClickListener {
    private var origin:View.OnClickListener
    private var lastClick = 0L
    private var times = 1000L
    private lateinit var again:IAgain

    constructor(origin: View.OnClickListener, times: Long, again: IAgain) {
        this.origin = origin
        this.times = times
        this.again = again
    }

    constructor(origin: View.OnClickListener) {
        this.origin = origin
    }


    override fun onClick(v: View) {
        if(System.currentTimeMillis() - lastClick >= times){
            origin.onClick(v)
            lastClick = System.currentTimeMillis()
        }else{
            if(again != null) again.onAngin()
        }
    }

    public interface IAgain{
        fun onAngin()
    }
}