package com.example.bt_nhom.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bt_nhom.data.NhacCu

class NhacCuViewModel : ViewModel() {

    private val listNhacCu = mutableListOf<NhacCu>()

    fun getAll(): List<NhacCu> = listNhacCu

    fun getById(id: Int): NhacCu? {
        return listNhacCu.find { it.id == id }
    }

    fun add(nhacCu: NhacCu) {
        listNhacCu.add(nhacCu)
    }

    fun delete(id: Int) {
        listNhacCu.removeAll { it.id == id }
    }

    fun updateQuantity(id: Int, newQuantity: Int) {
        val item = getById(id)
        item?.let {
            val newItem = it.copy(soLuongTon = newQuantity)
            val index = listNhacCu.indexOfFirst { it.id == id }
            listNhacCu[index] = newItem
        }
    }
}