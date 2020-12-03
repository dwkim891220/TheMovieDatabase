package pr.dwkim.themoviedatabase.model

import pr.dwkim.themoviedatabase.repository.remote.model.Genre
import pr.dwkim.themoviedatabase.repository.remote.model.Movie

class MovieDetail(data: Movie): BaseMovie(data) {
    val genres: List<CGenre> = data.genres?.map { genre -> CGenre(genre) } ?: emptyList()
}

class CGenre(data: Genre?){
    val id: Int = data?.id ?: 0
    val name: String = data?.name ?: ""
}