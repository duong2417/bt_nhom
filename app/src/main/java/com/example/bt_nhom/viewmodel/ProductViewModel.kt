package com.example.bt_nhom.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bt_nhom.data.NhacCu

class ProductViewModel : ViewModel() {

    private val _listNhacCu = mutableListOf<NhacCu>()

    fun getAll(): List<NhacCu> {
        return _listNhacCu
    }

    fun add(nhacCu: NhacCu) {
        _listNhacCu.add(nhacCu)
    }

    fun getById(id: Int): NhacCu? {
        return _listNhacCu.find { it.id == id }
    }
}