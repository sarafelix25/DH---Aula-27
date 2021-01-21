package com.example.snackbar.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class DetailGastosFragment : Fragment() {
    private var msg = 1

    private var listGastos = getListGastos()
    private val adapter = DetailsGastosAdapter(listGastos)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_detail_gastos, container, false)

        view.rcListaGastos.adapter = adapter
        view.rcListaGastos.layoutManager = LinearLayoutManager(context)
        view.rcListaGastos.setHasFixedSize(true)

        view.btn_adicionar.setOnClickListener(){
            insetGasto()
        }

        view.btn_remover.setOnClickListener(){
            removeGasto()
        }





        return  view



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
            arguments?.getInt("key")?.let {
                msg = it
        }
    }

    companion object{
        fun newInstance() = DetailGastosFragment()
    }


    fun getListGastos (): ArrayList<Gasto> {


        val gasto1 = Gasto("Aluguel", "ALuguel","12/10", 1000.0)
        val gasto2 = Gasto("Mercado", "Alimentação","12/10", 1000.0)

        val listGastos = arrayListOf(gasto1, gasto2)

        return listGastos
    }

    fun insetGasto (){
        val gasto3 = Gasto( "Almoço", "fixo", "13/10/2020", 15.0 )
        listGastos.add(gasto3)
        adapter.notifyItemInserted(listGastos.size)
    }

    fun removeGasto (){
        listGastos.removeAt( listGastos.size - 1 )
        adapter.notifyItemRemoved( listGastos.size - 1 )
    }
}