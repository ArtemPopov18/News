package com.example.news.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.api.NewsRepository
import com.example.news.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {

    init {
        getSavedArticles()
    }

    fun getSavedArticles() = viewModelScope.launch(Dispatchers.IO) {
        repository.getFavoriteArticle()
    }

    fun saveFavoriteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO){
        repository.addToFavorite(article = article)
    }
}