package com.br.appnative.network

import com.br.appnative.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitProvider {
    companion object {
        fun getRetrofitProvider(): PhraseService? {
            val baseUrl = BuildConfig.SERVER_URL
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build()

            return retrofit.create(PhraseService::class.java)
        }
    }
}