package com.example.incitystore.viewModel

import androidx.lifecycle.LiveData
import com.example.incitystore.Domain.CategoryModel

class DashboardViewModel {
    private val repository= DashboardViewModel()
    fun loadCategories(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategories()
    }
}