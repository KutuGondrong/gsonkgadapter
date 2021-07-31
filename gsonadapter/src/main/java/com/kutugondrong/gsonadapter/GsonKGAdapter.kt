package com.kutugondrong.gsonadapter

import com.google.gson.Gson
import com.kutugondrong.networkkgadapter.ConverterNetworkKGAdapter
import java.lang.reflect.ParameterizedType
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
            return getGsonList(json, classOf)
        }
        return Gson().fromJson(json, classOf.java)
    }

    override fun toJson(value: Any): String? {
        return Gson().toJson(value)
    }

    private fun <T: Any> getGsonList(json: String, kclass: KClass<T>) : List<T> {
        return Gson().fromJson<List<T>>(json, ListOfSomething<T>(kclass.java))
    }

    internal class ListOfSomething<X>(wrapped: Class<X>) : ParameterizedType {

        private val wrapped: Class<*>

        init {
            this.wrapped = wrapped
        }

        override fun getActualTypeArguments(): Array<Type> {
            return arrayOf<Type>(wrapped)
        }

        override fun getRawType(): Type {
            return ArrayList::class.java
        }

        override fun getOwnerType(): Type? {
            return null
        }
    }

}