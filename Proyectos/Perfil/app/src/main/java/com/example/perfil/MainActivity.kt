package com.example.perfil

import android.app.SearchManager
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.edit
import androidx.core.view.updateLayoutParams
import androidx.preference.PreferenceManager
import com.example.perfil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var imgUri : Uri

    private var latitud: Double =0.0
    private var longitud: Double = 0.0

    private val editResult =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            imgUri = Uri.parse(it.data?.getStringExtra(getString(R.string.key_image)))
            val name = it.data?.getStringExtra(getString(R.string.key_name))
            val email = it.data?.getStringExtra(getString(R.string.key_email))
            val website = it.data?.getStringExtra(getString(R.string.key_website))
            val phone = it.data?.getStringExtra(getString(R.string.key_phone))
            latitud = it.data?.getDoubleExtra(getString(R.string.key_latitud), 0.0) ?: 0.0
            longitud = it.data?.getDoubleExtra(getString(R.string.key_longitud), 0.0) ?: 0.0

            //updateUI(name!!,email!!, website!!,phone!!)
            saveUserData(name, email, website, phone)

        }
    }

    private fun saveUserData(name: String?, email: String?, website: String?, phone: String?) {
        sharedPreferences.edit {
            putString(getString(R.string.key_image), imgUri.toString())
            putString(getString(R.string.key_name), name)
            putString(getString(R.string.key_email), email)
            putString(getString(R.string.key_website), website)
            putString(getString(R.string.key_phone), phone)
            putString(getString(R.string.key_latitud), latitud.toString())
            putString(getString(R.string.key_longitud), longitud.toString())
            apply()
        }
        updateUI(name!!,email!!, website!!,phone!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        //updateUI()
        getUserData()
        setupIntents()

    }

    override fun onResume() {


        super.onResume()
        refreshPreferences()

        /*with(binding){
            tvName.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
            tvEmail.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
            tvWebsite.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
            tvPhone.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
            tvLocation.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
            tvSettings.isEnabled = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
        }*/
    }

    private fun refreshPreferences() {
        val isEnable = sharedPreferences.getBoolean(getString(R.string.preferences_key_enable_clicks),true)
        with(binding){
            tvName.isEnabled = isEnable
            tvEmail.isEnabled = isEnable
            tvWebsite.isEnabled = isEnable
            tvPhone.isEnabled = isEnable
            tvLocation.isEnabled = isEnable
            tvSettings.isEnabled = isEnable
        }
        val imgSize = sharedPreferences.getString(getString(R.string.preferences_key_ui_img_size),"")
        val sizeValue = when(imgSize){
            getString(R.string.preferences_key_img_size_small) -> {
                resources.getDimensionPixelSize(R.dimen.profile_image_size_small)
            }
            getString(R.string.preferences_key_img_size_medium) -> {
                resources.getDimensionPixelSize(R.dimen.profile_image_size_medium)
            }else -> {
                resources.getDimensionPixelSize(R.dimen.profile_image_size_large)
            }
        }
        binding.imgProfile.updateLayoutParams {
            width = sizeValue
            height = sizeValue
        }


        getUserData()
    }


    private fun setupIntents() {
        binding.tvName.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, binding.tvName.text)
            }
            launchIntents(intent)
        }
        binding.tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(binding.tvEmail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT,"From Kotlin Basic Course")
                putExtra(Intent.EXTRA_TEXT,"HI¡ My name is Jorge Antonio I´m learning Kotlin for a new job")
            }
            launchIntents(intent)
        }
        binding.tvWebsite.setOnClickListener {
            val webPage = Uri.parse(binding.tvWebsite.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            launchIntents(intent)
        }
        binding.tvPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL).apply {
                val phone = (it as TextView).text
                data = Uri.parse("tel:$phone")
            }
            launchIntents(intent)
        }
        binding.tvLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$latitud,$longitud(JORGE)")
                `package` =  "com.google.android.apps.maps"
            }
            launchIntents(intent)
        }
        binding.tvSettings.setOnClickListener {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }

    }
    private fun launchIntents(intent: Intent){
        if (intent.resolveActivity(packageManager)!= null){
            startActivity(intent)
        }else{
            Toast.makeText(this, getString(R.string.profile_error_no_resolve), Toast.LENGTH_SHORT).show()
        }
    }
    private fun getUserData() {
        imgUri = Uri.parse(sharedPreferences.getString(getString(R.string.key_image),""))
        val name = sharedPreferences.getString(getString(R.string.key_name), null)
        val email = sharedPreferences.getString(getString(R.string.key_email), null)
        val website = sharedPreferences.getString(getString(R.string.key_website), null)
        val phone = sharedPreferences.getString(getString(R.string.key_phone), null)
        latitud = sharedPreferences.getString(getString(R.string.key_latitud), "0.0")!!.toDouble()
        longitud = sharedPreferences.getString(getString(R.string.key_longitud), "0.0")!!.toDouble()

        updateUI(name, email, website, phone)
    }

    private fun updateUI(name:String?, email:String?, website:String?, phone:String?) {

        with(binding){
            imgProfile.setImageURI(imgUri)
            tvName.text = name ?: "Jorge Antonio Delfin Santos"
            tvEmail.text = email ?: "tonydelfin743@gmail.com"
            tvWebsite.text = website ?: "https://www.facebook.com/tony.delfin.9"
            tvPhone.text = phone ?: "4981210770"
        //        latitud= 23.847534555757978
        //        longitud =-103.13219355679655
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.action_edit ->{
                    val intent = Intent(this,EditActivity::class.java)
                    intent.putExtra(getString(R.string.key_image), imgUri.toString())
                    intent.putExtra(getString(R.string.key_name), binding.tvName.text)
                    intent.putExtra(getString(R.string.key_email), binding.tvEmail.text.toString())
                    intent.putExtra(getString(R.string.key_website), binding.tvWebsite.text.toString())
                    intent.putExtra(getString(R.string.key_phone), binding.tvPhone.text)
                    intent.putExtra(getString(R.string.key_latitud), latitud)
                    intent.putExtra(getString(R.string.key_longitud), longitud)

                    //startActivityForResult(intent, RC_EDIT)
                    editResult.launch(intent)

                }
                R.id.action_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }
            }
            return super.onOptionsItemSelected(item)
    }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode== RESULT_OK){
//            if (requestCode == RC_EDIT){
//                val name = data?.getStringExtra(getString(R.string.key_name))
//                val email = data?.getStringExtra(getString(R.string.key_email))
//                val website = data?.getStringExtra(getString(R.string.key_website))
//                val phone = data?.getStringExtra(getString(R.string.key_phone))
//                latitud = data?.getDoubleExtra(getString(R.string.key_latitud), 0.0) ?: 0.0
//                longitud = data?.getDoubleExtra(getString(R.string.key_longitud), 0.0) ?: 0.0
//                updateUI(name!!,email!!, website!!,phone!!)
//            }
//
//        }
//    }


}