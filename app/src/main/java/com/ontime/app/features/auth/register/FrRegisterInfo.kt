package com.ontime.app.features.auth.register

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.ontime.app.R
import kotlinx.android.synthetic.main.fr_register_info.*

class FrRegisterInfo : Fragment(), AdapterView.OnItemSelectedListener {

    /*quitar los findviewbyid*/
    /*agregar los @string en los layout */
    private lateinit var vmRegisterInfo: VmRegisterInfo
    lateinit var v : View
    lateinit var emailText : EditText
    lateinit var nameText : EditText
    lateinit var phoneText : EditText
    lateinit var cuitText : EditText
    private val prefName = "myPreferences"
    private var spinner : Spinner? = null
    private var arrayAdapter: ArrayAdapter<String>? = null
    private lateinit var categorySelected: String
    private lateinit var categories : ArrayList<String>

    companion object {
        fun newInstance() = FrRegisterInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vmRegisterInfo = ViewModelProviders.of(this).get(VmRegisterInfo::class.java)
        categories=vmRegisterInfo.getCategories()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fr_register_info, container, false)
        nameText = v.findViewById(R.id.nameEditText)
        emailText = v.findViewById(R.id.emailEditText)
        phoneText = v.findViewById(R.id.phoneEditText)
        cuitText = v.findViewById(R.id.cuitEditText)
        spinner = v.findViewById(R.id.categorySpinner)

       // categories = comerceRegisterViewModel.getCategories()
        Log.d("categorias",categories.toString())
        Log.d("categorias!!",categories!!.toString())

        arrayAdapter =  ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,categories)
        arrayAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this

        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)

        val nameSharedPref = sharedPref.getString("NAME", "").toString()
        val emailSharedPref = sharedPref.getString("EMAIL", "").toString()

        Log.d("Este es el mail", emailSharedPref)
        Toast.makeText(activity, nameSharedPref, Toast.LENGTH_LONG).show()

        if(nameSharedPref!="") {
            nameText.setText(nameSharedPref)
        }
        if(emailSharedPref!="") {
            emailText.setText(emailSharedPref)
        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCompleteRegister.setOnClickListener {

            var name = if(nameText.text.trim().toString().isNotEmpty()) nameText.text.trim().toString() else ""
            var phone = if(phoneText.text.trim().toString().isNotEmpty()) phoneText.text.trim().toString() else ""
            var cuit= if(cuitText.text.trim().toString().isNotEmpty()) cuitText.text.trim().toString() else ""

            if (name != "" && phone != "" && cuit != "") {
                val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)
                val uid = sharedPref.getString("UID", "").toString()

                vmRegisterInfo.updateProfileCommerce(uid,name, categorySelected,phone,cuit)

                Navigation.findNavController(v)
                    .navigate(R.id.action_comerceRegisterFragment_to_loginFragment)
            }

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?){
        Toast.makeText(activity, "No se seleccionó una categoría", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        if (parent.getItemAtPosition(position).equals("Seleccionar categoría")) {

        } else {
            categorySelected = parent.getItemAtPosition(position).toString();
        }

    }

}