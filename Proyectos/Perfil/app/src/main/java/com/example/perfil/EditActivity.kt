package com.example.perfil

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.example.perfil.databinding.ActivityEditBinding
import com.example.perfil.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    private var imgUri: Uri? = null

    private val galleryResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            imgUri = it.data?.data
            imgUri?.let {
                val contentResolver = applicationContext.contentResolver
                val takeflags = Intent.FLAG_GRANT_READ_URI_PERMISSION or
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                contentResolver.takePersistableUriPermission(it, takeflags)
                updateImage()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        with(binding){
            intent.extras?.let {
                imgUri = Uri.parse(it.getString(getString(R.string.key_image)))
                updateImage()
                etName.setText(it.getString(getString(R.string.key_name)))
                etEmail.setText(it.getString(getString(R.string.key_email)))
                etWebsite.setText(it.getString(getString(R.string.key_website)))
                etPhone.setText(it.getString(getString(R.string.key_phone)))
                etLatitud.setText(it.getDouble(getString(R.string.key_latitud)).toString())
                etLongitud.setText(it.getDouble(getString(R.string.key_longitud)).toString())
            }

            etEmail.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){ etEmail.text?.let { etEmail.setSelection(it.length) } }
            }
            etWebsite.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){ etWebsite.text?.let { etWebsite.setSelection(it.length) } }
            }
            etPhone.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){ etPhone.text?.let { etPhone.setSelection(it.length) } }
            }
            etLatitud.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){ etLatitud.text?.let { etLatitud.setSelection(it.length) } }
            }
            etLongitud.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){ etLongitud.text?.let { etLongitud.setSelection(it.length) } }
            }
            btnSelectPhoto.setOnClickListener {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "image/jpeg"
                }
                //startActivityForResult(intent, RC_GALLERY)
                galleryResult.launch(intent)
            }

        }

       /* intent.extras?.let {
            binding.etName.setText(it.getString(getString(R.string.key_name)))
            binding.etEmail.setText(it.getString(getString(R.string.key_email)))
            binding.etWebsite.setText(it.getString(getString(R.string.key_website)))
            binding.etPhone.setText(it.getString(getString(R.string.key_phone)))
            binding.etLatitud.setText(it.getDouble(getString(R.string.key_latitud)).toString())
            binding.etLongitud.setText(it.getDouble(getString(R.string.key_longitud)).toString())
        }

        binding.etWebsite.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.etWebsite.text?.let {
                    binding.etWebsite.setSelection(it.length)
                }
            }
        }*/

        /*binding.etName.setText(intent.extras?.getString(getString(R.string.key_name)))
        binding.etEmail.setText(intent.extras?.getString(getString(R.string.key_email)))
        binding.etWebsite.setText(intent.extras?.getString(getString(R.string.key_website)))
        binding.etPhone.setText(intent.extras?.getString(getString(R.string.key_phone)))
        binding.etLatitud.setText(intent.extras?.getDouble(getString(R.string.key_latitud)).toString())
        binding.etLongitud.setText(intent.extras?.getDouble(getString(R.string.key_longitud)).toString())*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressedDispatcher.onBackPressed()
            R.id.action_save -> sendData()
        }

        /*if(item.itemId == R.id.action_save){
            sendData()
        }else if(item.itemId == android.R.id.home){
            onBackPressedDispatcher.onBackPressed()
        }*/
        return super.onOptionsItemSelected(item)
    }


    private fun updateImage(){
        binding.imgProfile.setImageURI(imgUri)
    }

    private fun sendData() {
        val intent = Intent()

        with(binding){
            intent.apply {
                putExtra(getString(R.string.key_image), imgUri.toString())
                putExtra(getString(R.string.key_name), etName.text.toString())
                putExtra(getString(R.string.key_email), etEmail.text.toString())
                putExtra(getString(R.string.key_website), etWebsite.text.toString())
                putExtra(getString(R.string.key_phone), etPhone.text.toString())
                putExtra(getString(R.string.key_latitud), etLatitud.text.toString().toDouble())
                putExtra(getString(R.string.key_longitud), etLongitud.text.toString().toDouble())
            }
        }

        /*intent.putExtra(getString(R.string.key_name), binding.etName.text.toString())
        intent.putExtra(getString(R.string.key_email), binding.etEmail.text.toString())
        intent.putExtra(getString(R.string.key_website), binding.etWebsite.text.toString())
        intent.putExtra(getString(R.string.key_phone), binding.etPhone.text.toString())
        intent.putExtra(getString(R.string.key_latitud), binding.etLatitud.text.toString().toDouble())
        intent.putExtra(getString(R.string.key_longitud), binding.etLongitud.text.toString().toDouble())*/

        setResult(RESULT_OK,intent)
        finish()
    }

    companion object{
        private const val RC_GALLERY = 22
    }
}