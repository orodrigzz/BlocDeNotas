package com.blocdenotes.oscarrodriguez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(
    private val noteClickDeleteInterface: NoteClickDeleteInterface,
    private val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Vinculem variables amb el layout
        val noteTV: TextView = itemView.findViewById(R.id.nomNotaTV)
        val dateTV: TextView = itemView.findViewById(R.id.dataNota)
        val deleteIV: ImageView = itemView.findViewById(R.id.borrarNotaBttn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTV.text = allNotes[position].noteTitle
        holder.dateTV.text = "Ultima actualització : "+ allNotes[position].timeStamp
        holder.deleteIV.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    //funció per a actualitzar la llista
    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

//funció per a borrar la nota de la llista
interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}

//funció per quan cliquem la nota
interface NoteClickInterface {
    fun onNoteClick(note: Note)
}