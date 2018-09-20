package com.br.appnative.network

import com.br.appnative.model.Message
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhraseService {

    @GET("chuck_norris/frases/{random}.json")
    fun getMessage(@Path("random") random: Int): Call<Message>

}