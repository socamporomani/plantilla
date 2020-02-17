package com.sergio.myapplication.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sergio.myapplication.R

/**
Para modificar los nombres de las pestañas es en res>values>strings.xml
 */
private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

//Un [FragmentPagerAdapter] que devuelve un Fragment correspondiente a cada una de las pestañas

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem es llamado para instanciar un Fragment usando el método newInstance de PlaceholderFragment
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Va a mostrar 2 pestañas
        return 2
    }
}