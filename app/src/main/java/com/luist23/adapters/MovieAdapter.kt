package com.luist23.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import com.bumptech.glide.Glide
import com.luist23.R
import com.luist23.models.Movie
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter(
        var movies:List<Movie>,
        val clickListener: (Movie)->Unit
        ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//mostrar un vieHolder si esta esa vista en la pantalla
        holder.bind(movies[position]){//funciones no se manmdan en los parentesis
            clickListener}
    }


    fun changeList(movies:List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(item:Movie, clickListener: (Movie) -> Unit) = with (itemView){

            Glide.with(itemView.context)//cargar imagen desde URL
                    .load(item.Poster)
                    .placeholder(R.drawable.ic_launcher_background)//imagen por defecto
                    .into(movie_image_cv)//donde poner la imagen

            movie_title_cv.text=item.Title
            movie_plot_cv.text=item.Plot
            movie_rate_cv.text=item.imdbRating
            movie_runtime_cv.text=item.RunTime
        }
    }
}