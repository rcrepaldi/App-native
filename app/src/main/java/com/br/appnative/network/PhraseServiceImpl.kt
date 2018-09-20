package com.br.appnative.network

import com.br.appnative.model.Message
import retrofit2.Call

class PhraseServiceImpl : PhraseService {

    private val provider: PhraseService = RetrofitProvider.getRetrofitProvider()!!

    override fun getMessage(random: Int): Call<Message> {
        return provider.getMessage(random)
    }

}