package com.example.myapplication.representation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.remote.models.Result

@Composable
fun ShowRow(title:String,movies:List<Result>) {
//    val posters = listOf(
//        R.drawable.s1,
//        R.drawable.s2,
//        R.drawable.s3,
//        R.drawable.s4,
//        R.drawable.s5,
//        R.drawable.s6,
//        R.drawable.s2,
//        R.drawable.s1,
//        R.drawable.s3,
//        R.drawable.s4,
//        R.drawable.s5,
//        R.drawable.s6
//    )

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 5.dp, top = 8.dp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(movies.size) {
                    val movie = movies[it]
                    val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

                    Image(
                        painter = rememberAsyncImagePainter(model = posterUrl),
                        contentDescription = movie.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 140.dp, height = 200.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
            }
        }

    }
}


@Composable
fun ShowRowUpcoming(title:String,movies:List<Result>) {
//    val posters = listOf(
//        R.drawable.s1,
//        R.drawable.s2,
//        R.drawable.s3,
//        R.drawable.s4,
//        R.drawable.s5,
//        R.drawable.s6,
//        R.drawable.s2,
//        R.drawable.s1,
//        R.drawable.s3,
//        R.drawable.s4,
//        R.drawable.s5,
//        R.drawable.s6
//    )

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 5.dp, top = 8.dp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(movies.size) {
                    val movie = movies[it]
                    val posterUrl = movie.poster_path?.let { "https://image.tmdb.org/t/p/w500$it" }

                    Image(
                        painter = rememberAsyncImagePainter(
                            model = posterUrl ?: R.drawable.picture
                        ),
                        contentDescription = movie.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 140.dp, height = 200.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                }
            }
        }

    }
}