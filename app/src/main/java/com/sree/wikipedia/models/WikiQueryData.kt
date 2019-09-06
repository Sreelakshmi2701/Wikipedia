package com.sree.wikipedia.models

import com.google.gson.annotations.SerializedName

class WikiQueryData {
    //val pages: WikiPage = WikiPage()
    val pages: Map<String, WikiPage> = HashMap<String, WikiPage>()   //  WikiPage = WikiPage()
}