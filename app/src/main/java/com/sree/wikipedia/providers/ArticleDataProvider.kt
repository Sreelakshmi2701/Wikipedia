package com.sree.wikipedia.providers

import android.util.Log
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.sree.wikipedia.models.WikiResult
import java.io.Reader
import com.google.gson.Gson
import com.sree.wikipedia.MyApplication
import com.sree.wikipedia.models.Urls
import com.sree.wikipedia.models.WikiSearchResult

class ArticleDataProvider {
    val TAG:String = "ArticleDataProvider"
    init {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Sree Wikipedia")

    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result: WikiSearchResult) -> Unit?) {
        MyApplication.FROM_SEARCH =true;
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikipediaDataSearchDeserializer()) { _, response, result ->
                if (response.httpStatusCode != 200) {
                    throw Exception("Unable to get articles")
                }
                val (data,_ )= result
                responseHandler.invoke(data as WikiSearchResult)

            }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?) {
        MyApplication.FROM_RANDOM = true
        Urls.getRandomUrl(take).httpGet()
            .responseObject(WikipediaDataDeserializer()) { _, response, result ->
                if (response.httpStatusCode != 200) {
                    throw Exception("Unable to get articles")
                }
                Log.d(TAG,"response::->>"+response.toString())
                Log.d(TAG,"response::->>"+result.toString())
                val (data,_) = result
                responseHandler.invoke(data as WikiResult)
            }
    }

    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult::class.java)
    }

    class WikipediaDataSearchDeserializer : ResponseDeserializable<WikiSearchResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiSearchResult::class.java)
    }




}


