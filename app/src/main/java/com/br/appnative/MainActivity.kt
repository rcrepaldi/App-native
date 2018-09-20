package com.br.appnative

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.br.appnative.infrastructure.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), HomePresenterContract.View {

    private lateinit var mPresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPresenter = HomePresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showProgress() {
        textViewResult.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        textViewResult.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showResult(phrase: String) {
        textViewResult.text = phrase
    }

    fun clickTextView(view: View) {
        if (Utils.isConnected(this)) {
            mPresenter.request()
        } else {
            // TODO not connection internet
        }
    }

}
