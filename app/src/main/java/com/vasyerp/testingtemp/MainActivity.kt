package com.vasyerp.testingtemp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.vasyerp.testingtemp.adapter.CAdapater
import com.vasyerp.testingtemp.databinding.ActivityMain2Binding
import com.vasyerp.testingtemp.databinding.ActivityMainBinding
import com.vasyerp.testingtemp.interfac.EditData
import com.vasyerp.testingtemp.model.ProfileDto

class MainActivity : AppCompatActivity(),EditData {

    private val bindin:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val mList=ArrayList<ProfileDto>()
    lateinit var profileAdapter:CAdapater


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindin.root)



        mList.add(ProfileDto(R.drawable.manone,"Shubham","Diwakar"))
        mList.add(ProfileDto(R.drawable.mantwo,"Abhisekh","soni"))
        mList.add(ProfileDto(R.drawable.manthree,"Dev","Aparnathii"))
        mList.add(ProfileDto(R.drawable.manfour,"Meet","Shah"))
        mList.add(ProfileDto(R.drawable.manfive,"Kriti","Soni"))
        mList.add(ProfileDto(R.drawable.manone,"Shubham","Diwakar"))
        mList.add(ProfileDto(R.drawable.mantwo,"Abhisekh","soni"))
        mList.add(ProfileDto(R.drawable.manthree,"Dev","Aparnathii"))
        mList.add(ProfileDto(R.drawable.manfour,"Meet","Shah"))
        mList.add(ProfileDto(R.drawable.manfive,"Kriti","Soni"))
        mList.add(ProfileDto(R.drawable.manone,"Shubham","Diwakar"))
        mList.add(ProfileDto(R.drawable.mantwo,"Abhisekh","soni"))
        mList.add(ProfileDto(R.drawable.manthree,"Dev","Aparnathii"))
        mList.add(ProfileDto(R.drawable.manfour,"Meet","Shah"))
        mList.add(ProfileDto(R.drawable.manfive,"Kriti","Soni"))
        mList.add(ProfileDto(R.drawable.manone,"Shubham","Diwakar"))
        mList.add(ProfileDto(R.drawable.mantwo,"Abhisekh","soni"))
        mList.add(ProfileDto(R.drawable.manthree,"Dev","Aparnathii"))
        mList.add(ProfileDto(R.drawable.manfour,"Meet","Shah"))
        mList.add(ProfileDto(R.drawable.manfive,"Kriti","Soni"))



        profileAdapter=CAdapater(this,mList,this)
        bindin.idRecymain.adapter=profileAdapter
        profileAdapter.notifyDataSetChanged()


    }

    override fun delete(position: Int) {
        mList.removeAt(position)

    }


}