package com.example.melinastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.melinastore.core.DogAdapter
import com.example.melinastore.databinding.ActivityHomeBinding
import com.example.melinastore.services.IService
import com.example.melinastore.services.Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        init()
    }

    private fun init() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun searchDog(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val callDog = Service.getRetrofit().create(IService::class.java).getDogs("$query/images")
            val dogs = callDog.body()

            runOnUiThread {
                if (callDog.isSuccessful) {
                    Log.d("Perros", dogs?.images.toString())

                    val images = dogs?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    errorInfo()
                }

                hideKeyboard()
            }
        }
    }

    fun errorInfo() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        if(!p0.isNullOrEmpty()) {
            searchDog(p0.lowercase())
        }

        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }

    private fun hideKeyboard() {
        val imn = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(this.binding.viewRoot.windowToken, 0)
    }
}