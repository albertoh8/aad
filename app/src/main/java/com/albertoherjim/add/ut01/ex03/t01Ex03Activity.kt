package com.albertoherjim.add.ut01.ex03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.add.ut01.ex03.data.NewsLocalSource
import com.albertoherjim.add.ut01.ex03.domain.News
import com.albertoherjim.add.ut01.ex04.SecureSharedPreferences

class Ut01Ex03Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initWithList()
        secure()
    }

    private fun init() {
        val newsLocalSource = NewsLocalSource(
            getPreferences(MODE_PRIVATE)
        )

        val news1 = News(1, "Titulo1", "Subtitle1", "Summary1")
        val news2 = News(2, "Titulo2", "Subtitle2", "Summary2")
        val news3 = News(3, "Titulo3", "Subtitle3", "Summary3")

        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)

        val newNews1 = newsLocalSource.findById(2)

        Log.d("@dev", "News: $newNews1")

    }

    private fun initWithList() {
        val newsList: MutableList<News> = mutableListOf<News>(
            News(1, "Titulo1", "Subtitle1", "Summary1"),
            News(2, "Titulo2", "Subtitle2", "Summary2"),
            News(3, "Titulo3", "Subtitle3", "Summary3")
        )

        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        newsLocalSource.setNewsList(newsList)

        newsLocalSource.findAll()
    }

    private fun secure() {
        val secure = SecureSharedPreferences(applicationContext)
        secure.saveNews(News(1, "News1", "News1", "News1"))
    }
}