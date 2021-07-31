package com.kutugondrong.gsonadapter


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kutugondrong.networkkgadapter.ConverterNetworkKGAdapter
import java.lang.reflect.Type
import kotlin.reflect.KClass

/**
 * KG KutuGondrong
 * This is the main class for create Gson Adapter
 * For convert json to object using Gson
 * @see Gson
 *
 *
 */

class GsonKGAdapter: ConverterNetworkKGAdapter(2) {

    companion object {
        fun create() : GsonKGAdapter{
            return GsonKGAdapter()
        }
    }

    override fun fromJson(json: String, classOf: KClass<*>, isList: Boolean): Any? {
        if (isList) {
            var list = createListOfType(classOf)
            list = Gson().fromJson(json, getTypeList(classOf))
            return list
        }
        return Gson().fromJson(json, classOf.java)
    }

    private fun <T : Any> createListOfType(clazz: KClass<T>?): ArrayList<T> {
        return ArrayList()
    }

    private fun <T : Any> getTypeList(clazz: KClass<T>?): Type {
        return object : TypeToken<ArrayList<T?>?>() {}.type
    }

}