package com.example.keronpola.DiscTest.Util

import android.content.res.Resources

object Utility {

    fun hexString(res: Resources): String {
        val resImpl = getPrivateField("android.content.res.Resources", "mResourcesImpl", res)
        val o = resImpl ?: res
        return "@" + Integer.toHexString(o.hashCode())
    }

    fun getPrivateField(className: String, fieldName: String, `object`: kotlin.Any?): Any? {
        try {
            val c = Class.forName(className)
            val f = c.getDeclaredField(fieldName)
            f.isAccessible = true
            return f.get(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        }

    }
}