package com.br.appnative

import com.br.appnative.model.Message
import com.br.appnative.network.PhraseServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class HomePresenter constructor(val view: HomePresenterContract.View) : HomePresenterContract.Presenter {

    private val DELAY = 2000L
    private val mView: HomePresenterContract.View = view

    fun IntRange.random() =
            Random().nextInt((endInclusive + 1) - start) + start

    override fun request() {

        mView.showProgress()

        val random = (0..100).random()
        val call: Call<Message> = PhraseServiceImpl().getMessage(random)
        call.enqueue(object : Callback<Message> {
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                val data = response.body()
                if (data != null) {
                    mView.showResult(data.phrase)
                }
                mView.hideProgress()
            }

            override fun onFailure(call: Call<Message>, t: Throwable?) {
                // TODO implements error response
            }
        })
    }
}