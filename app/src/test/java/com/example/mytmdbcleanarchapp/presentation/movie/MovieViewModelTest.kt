package com.example.mytmdbcleanarchapp.presentation.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MovieViewModelTest{

    @Before
    fun setUp(){
        val movieRepo = Mockito.mock()
    }

    @Test
    fun demoTest(){
        val result = true
        assertTrue(result)
    }

}