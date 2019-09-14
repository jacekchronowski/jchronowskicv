package jc.highapp.jccv.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

fun Context.loadJsonFileFromAssets(fileName : String) : String {
    var json: String? = null
    try {
        val inputStrem = this.assets.open(fileName)
        val size = inputStrem.available()
        val buffer = ByteArray(size)
        inputStrem.read(buffer)
        inputStrem.close()
        json = String(buffer, Charset.defaultCharset())
    } catch (ex: IOException) {
        ex.printStackTrace()
        return ""
    }

    return json
}