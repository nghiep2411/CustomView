package com.example.customview

import com.example.customview.model.Language

class LanguageDataUtils {

    fun getLanguages(): List<Language> {
        val javascript = Language(1, "Javascript", 67.7f)
        val htmlCss = Language(2, "HTML/CSS", 63.1f)
        val sql = Language(3, "SQL", 54.7f)
        val python = Language(4, "Python", 44.1f)
        val java = Language(5, "Java", 40.2f)
        val list: MutableList<Language> = ArrayList<Language>()
        list.add(javascript)
        list.add(htmlCss)
        list.add(sql)
        list.add(python)
        list.add(java)
        return list
    }
}