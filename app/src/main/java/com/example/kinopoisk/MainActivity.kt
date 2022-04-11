package com.example.kinopoisk

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinopoisk.databinding.ActivityMainBinding
import com.example.kinopoisk.databinding.PreviewItemBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object ArrayFilms {

    lateinit var Objects: PreviewList
    lateinit var Objects2: PreviewList
    lateinit var Objects3: PreviewList
    lateinit var Objects4: PreviewList

}

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var bindingClass: PreviewItemBinding
    private val adapter = PreviewAdapter()

//    var cardView: CardView = findViewById(R.id.Card)
 //   var Line: LinearLayout = findViewById(R.id.Linear)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = PreviewItemBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, PreviewListFragment())
            .commit()

        init()
//        Line.setOnClickListener {
//            Line.visibility = View.INVISIBLE
//        }

    }

    private fun init() {

        var i = 0
        binding.apply {
            rcMainView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcMainView.adapter = adapter
            buttonadd.setOnClickListener {
                buttonadd.visibility = View.GONE
                while (i < 20) {
                    val preview = ArrayFilms.Objects.films[i]
                    adapter.addPreview(preview)
                    i++
                }
                i = 0
                while (i < 20) {
                    val preview = ArrayFilms.Objects2.films[i]
                    adapter.addPreview(preview)
                    i++
                }
                i = 0
                while (i < 20) {
                    val preview = ArrayFilms.Objects3.films[i]
                    adapter.addPreview(preview)
                    i++
                }
                i = 0
                while (i < 20) {
                    val preview = ArrayFilms.Objects4.films[i]
                    adapter.addPreview(preview)
                    i++
                }
                i = 0
           }

//            bindingClass.buttonTest.setOnClickListener {
//                bindingClass.buttonTest.visibility = View.INVISIBLE
//            }


//            cardView.setOnClickListener{
//                cardView.visibility = View.INVISIBLE
//            }
        }

    }
}



class PreviewListViewModel(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchPreviewList(previewApi: PreviewApi?) {
        Log.i("test", "FETCH")
        previewApi?.let {
            compositeDisposable.add(previewApi.getPreviewList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ArrayFilms.Objects = it
                    Log.e("test", it.films.last().nameRu.toString())
                    Log.e("test", ArrayFilms.Objects.films.first().nameRu.toString())
                }, {

                }))
        }
    }

    fun fetchPreviewList2(previewApi: PreviewApi2?) {
        Log.i("test", "FETCH")
        previewApi?.let {
            compositeDisposable.add(previewApi.getPreviewList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ArrayFilms.Objects2 = it
                    Log.e("test", it.films.last().nameRu.toString())
                    Log.e("test", ArrayFilms.Objects2.films.first().nameRu.toString())
                }, {

                }))
        }
    }

    fun fetchPreviewList3(previewApi: PreviewApi3?) {
        Log.i("test", "FETCH")
        previewApi?.let {
            compositeDisposable.add(previewApi.getPreviewList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ArrayFilms.Objects3 = it
                    Log.e("test", it.films.last().nameRu.toString())
                    Log.e("test", ArrayFilms.Objects3.films.first().nameRu.toString())
                }, {

                }))
        }
    }

    fun fetchPreviewList4(previewApi: PreviewApi4?) {
        Log.i("test", "FETCH")
        previewApi?.let {
            compositeDisposable.add(previewApi.getPreviewList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ArrayFilms.Objects4 = it
                    Log.e("test", it.films.last().nameRu.toString())
                    Log.e("test", ArrayFilms.Objects4.films.first().nameRu.toString())
                }, {

                }))
        }
    }
}

class PreviewListFragment: Fragment(R.layout.activity_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var previewListViewModel = ViewModelProvider(this).get(PreviewListViewModel::class.java)
        previewListViewModel.fetchPreviewList((activity?.application as? MyApp)?.previewApi)

        previewListViewModel = ViewModelProvider(this).get(PreviewListViewModel::class.java)
        previewListViewModel.fetchPreviewList2((activity?.application as? MyApp)?.previewApi2 as PreviewApi2?)

        previewListViewModel = ViewModelProvider(this).get(PreviewListViewModel::class.java)
        previewListViewModel.fetchPreviewList3((activity?.application as? MyApp)?.previewApi3 as PreviewApi3?)

        previewListViewModel = ViewModelProvider(this).get(PreviewListViewModel::class.java)
        previewListViewModel.fetchPreviewList4((activity?.application as? MyApp)?.previewApi4 as PreviewApi4?)
    }
}