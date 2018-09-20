package com.br.appnative

interface HomePresenterContract {

    interface Presenter {
        fun request()
    }

    interface View {

        fun showProgress()

        fun hideProgress()

        fun showResult(phrase: String)
    }
}