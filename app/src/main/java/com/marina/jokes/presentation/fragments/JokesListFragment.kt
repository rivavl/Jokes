package com.marina.jokes.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.marina.jokes.R
import com.marina.jokes.databinding.FragmentJokesListBinding
import com.marina.jokes.domain.JokesListFragmentViewModel
import com.marina.jokes.presentation.recycler_view.JokesAdapter

class JokesListFragment : Fragment(R.layout.fragment_jokes_list) {

    private lateinit var binding: FragmentJokesListBinding
    private lateinit var jokesAdapter: JokesAdapter
    private lateinit var viewModel: JokesListFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentJokesListBinding.bind(view)
        setOnClickListeners()
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[JokesListFragmentViewModel::class.java]
        viewModel.jokes.observe(viewLifecycleOwner) {
            jokesAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        val rvJokeList = view?.findViewById<RecyclerView>(R.id.jokes_list_rv)

        with(rvJokeList) {
            jokesAdapter = JokesAdapter()
            this?.adapter = jokesAdapter
        }
    }

    fun setOnClickListeners() {
        binding.btnReloadJokes.setOnClickListener {
            val count = binding.textCount.text.toString().toInt()
            viewModel.getJokes(count)
        }
    }
}