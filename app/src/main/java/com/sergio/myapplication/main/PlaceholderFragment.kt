package com.sergio.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sergio.myapplication.R

//Un Fragment que contiene un View sencillo

class PlaceholderFragment : Fragment() {

    //  Variable para utilizar la clase PageViewModel

    private lateinit var pageViewModel: PageViewModel

    /**
     * Llama a la clase PageViewModel para especificar el ViewModel,
     * utilizando la función setIndex de esa clase
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    // Llama al layout fragment_main para asignarle un numero para el TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        //El argumento del Fragment representa el número de sección para ese Fragment

        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Devuelve una nueva instancia de este fragment con el número especifico
         */

        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}