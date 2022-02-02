package com.charls.quizjusto

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex


class JustoApp : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}