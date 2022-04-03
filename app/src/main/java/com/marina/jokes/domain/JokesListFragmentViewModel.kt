package com.marina.jokes.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.jokes.data.repository.JokesListRepositoryImpl
import com.marina.jokes.domain.entity.Joke
import com.marina.jokes.domain.usecase.GetJokesListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokesListFragmentViewModel : ViewModel() {

    private val repository = JokesListRepositoryImpl()
    private val getJokesListUseCase = GetJokesListUseCase(repository)

    private var _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>>
        get() = _jokes

    fun getJokes(amount: Int) {

        var list: List<Joke>
        viewModelScope.launch(Dispatchers.IO) {
            list = withContext(Dispatchers.Default) {
                getJokesListUseCase.invoke(amount)
            }
             withContext(Dispatchers.Main) {
                 _jokes.value = list
             }
         }

    }
}