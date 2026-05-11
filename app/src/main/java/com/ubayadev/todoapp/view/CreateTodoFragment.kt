package com.ubayadev.todoapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.ubayadev.todoapp.R
import com.ubayadev.todoapp.databinding.FragmentCreateTodoBinding
import com.ubayadev.todoapp.databinding.FragmentTodoListBinding
import com.ubayadev.todoapp.model.Todo
import com.ubayadev.todoapp.viewmodel.DetailTodoViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [CreateTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateTodoFragment : Fragment() {
    private lateinit var binding: FragmentCreateTodoBinding
    private lateinit var viewModel: DetailTodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateTodoBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailTodoViewModel::class.java]

        binding.btnAdd.setOnClickListener {
            var todo = Todo(
                binding.txtTitle.text.toString(),
                binding.txtNotes.text.toString()
            )
            val list = listOf(todo)
            viewModel.addTodo(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            it.findNavController().popBackStack()
        }
    }
}