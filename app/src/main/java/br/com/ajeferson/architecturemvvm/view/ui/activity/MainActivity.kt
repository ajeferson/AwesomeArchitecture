package br.com.ajeferson.architecturemvvm.view.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.ajeferson.architecturemvvm.R
import br.com.ajeferson.architecturemvvm.service.model.Repository
import br.com.ajeferson.architecturemvvm.view.adapter.RepositoryRecyclerViewAdapter
import br.com.ajeferson.architecturemvvm.databinding.ActivityMainBinding
import br.com.ajeferson.architecturemvvm.service.common.CommonService
import br.com.ajeferson.architecturemvvm.service.common.MainService
import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * VIEW
 * Should be dumb
 * Should not contain any logic
 * Should not hold any data
 * Should have ViewModel reference
 * Should respond to changes on VIEW_MODEL
 * Responsibility: how the layout looks for different data and states
 * Shows the data
 * Informs the VIEW_MODEL about the user's actions
 * */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainService: MainService

    @Inject
    lateinit var commonService: CommonService

    private lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter by lazy {
        RepositoryRecyclerViewAdapter(listOf(), didTouchItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this, Observer<List<Repository>> { it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })

        Log.d(TAG, mainService.sayHello())
        Log.d(TAG, commonService.sayHello())

    }

    private val didTouchItem: (Int) -> Unit = {
        println("Touch $it")
    }

    companion object {

        private val TAG by lazy {
            MainActivity::class.java.simpleName
        }

    }

}
