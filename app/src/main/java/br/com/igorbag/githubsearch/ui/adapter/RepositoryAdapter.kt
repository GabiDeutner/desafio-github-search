package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repositoryItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Exemplo de Bind
        holder.nomeRepositorio.text = repositories[position].name

        holder.card.setOnClickListener {
            repositoryItemLister(repositories[position])
        }

        holder.imageCompartilhar.setOnClickListener {
            btnShareLister(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int {
        return repositories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView
        val nomeRepositorio: TextView
        val imageCompartilhar: ImageView

        init {
            view.apply {
                card = findViewById(R.id.cv_car)
                nomeRepositorio = findViewById(R.id.tv_preco)
                imageCompartilhar = findViewById(R.id.iv_favorite)
            }

        }
    }
}