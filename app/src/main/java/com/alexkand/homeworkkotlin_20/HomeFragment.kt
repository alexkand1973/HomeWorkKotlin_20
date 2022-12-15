package com.alexkand.homeworkkotlin_20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexkand.homeworkkotlin_20.data.network.retrofit.clients.ImageClient.retrofit
import com.alexkand.homeworkkotlin_20.data.network.retrofit.models.Image
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListeners()
    }

    fun setClickListeners() {
        btnDownloadImage.setOnClickListener {

            val imageResult = CoroutineScope(Dispatchers.IO).async {
                retrofit.getImage()
            }

            CoroutineScope(Dispatchers.Main).launch {
                imageResult.await().enqueue(object : retrofit2.Callback<List<Image>> {

                    override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>
                    ) { Glide.with(requireContext())
                        .load(response.body()?.get(0)?.url)
                        .into(ivMyImage)
                    }

                    override fun onFailure(call: Call<List<Image>>, t: Throwable) {

                    }

                })
            }
        }
    }
}