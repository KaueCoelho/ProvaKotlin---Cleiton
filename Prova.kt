package com.example.prova03

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViagemAdapter(private val viagens: List<Viagem>) : RecyclerView.Adapter<ViagemAdapter.ViagemViewHolder>() {

        data class Viagem(val destino: String, val data: String, val valorGasto: Double)
        class ViagemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
             val destino: TextView = itemView.findViewById(R.id.tvDestino)
            val data: TextView = itemView.findViewById(R.id.tvData)
             val valor: TextView = itemView.findViewById(R.id.tvValor)
             }

         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViagemViewHolder {
             val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viagem, parent, false)
             return ViagemViewHolder(view)
             }

         @SuppressLint("SetTextI18n")
         override fun onBindViewHolder(holder: ViagemViewHolder, position: Int) {
             val viagem = viagens[position]
            holder.destino.text = viagem.destino
             holder.data.text = viagem.data.toString()
             holder.valor.text = "R$ ${viagem.valorGasto}"
             }

         override fun getItemCount(): Int = viagens.size
    }

////////////////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#000002"
        android:orientation="vertical"
        android:padding="16dp"
        tools:ignore="RedundantNamespace">

        <EditText
            android:id="@+id/etDestino"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Destino da Viagem"
            android:textColorHint="#073175"
            tools:ignore="Autofill,HardcodedText,TextFields,TextContrastCheck,TouchTargetSizeCheck,VisualLintTextFieldSize" />

        <EditText
            android:id="@+id/etData"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Data da Viagem"
            android:textColorHint="#073175"
            tools:ignore="Autofill,HardcodedText,TextFields,TouchTargetSizeCheck,TextContrastCheck,VisualLintTextFieldSize" />

        <EditText
            android:id="@+id/etValor"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Valor Gasto"
            android:inputType="numberDecimal"
            android:textColorHint="#073175"
            tools:ignore="Autofill,HardcodedText,TouchTargetSizeCheck,VisualLintTextFieldSize" />

        <Button
            android:id="@+id/btnAdicionar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:backgroundTint="#073176"
            android:text="Adicionar Viagem"
            tools:ignore="HardcodedText" />

        <TextView
            android:id="@+id/tvTotalGasto"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="Total Gasto: R$ 0.00"
            android:textColor="#073175"
            android:textSize="18sp"
            tools:ignore="HardcodedText" />

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginTop="16dp"
            android:layout_weight="1" />

    </LinearLayout>
