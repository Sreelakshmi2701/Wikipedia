package com.sree.wikipedia.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.sree.wikipedia.models.WikiResult
import java.io.Reader
import com.google.gson.Gson
import com.sree.wikipedia.models.Urls

class ArticleDataProvider {
    init {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Sree Wikipedia")
    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result: WikiResult) -> Unit?) {
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikipediaDataDeserializer()) { _, response, result ->
                if (response.httpStatusCode != 200) {
                    throw Exception("Unable to get articles")
                }
                val (data,_ )= result
                responseHandler.invoke(data as WikiResult)

            }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?) {
        Urls.getRandomUrl(take).httpGet()
            .responseObject(WikipediaDataDeserializer()) { _, response, result ->
                if (response.httpStatusCode != 200) {
                    throw Exception("Unable to get articles")
                }
                val (data, _) = result
                responseHandler.invoke(data )
            }
    }

    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult::class.java)
    }




}


