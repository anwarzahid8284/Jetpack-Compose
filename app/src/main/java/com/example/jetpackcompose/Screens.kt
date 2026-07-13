package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(heightDp = 500, widthDp = 300)
@Composable
fun PreviewItem() {
    // its like a recyclerview in xml
    LazyColumn {
        items(getBlogList()) {
            BlogCategory(it.img, it.title, it.description)
        }
    }

    // its like a listview in xml
    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getBlogList().forEach {
            BlogCategory(it.img, it.title, it.description)
        }
    }*/
}


@Composable
fun BlogCategory(img: Int, title: String, description: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(img),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, description, Modifier.weight(.8f))
        }
    }
}

@Composable
private fun ItemDescription(
    title: String,
    description: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Thin
        )
    }
}

data class BlogItem(
    val img: Int,
    val title: String,
    val description: String
)

fun getBlogList(): List<BlogItem> {
    return listOf(
        BlogItem(R.drawable.ic_person, "Programming", "Learn programming languages"),
        BlogItem(R.drawable.ic_person, "Design", "Learn design principles"),
        BlogItem(R.drawable.ic_person, "Marketing", "Learn marketing strategies"),
        BlogItem(R.drawable.ic_person, "Business", "Learn business management"),
        BlogItem(R.drawable.ic_person, "Photography", "Learn photography skills"),
        BlogItem(R.drawable.ic_person, "Programming", "Learn programming languages"),
        BlogItem(R.drawable.ic_person, "Design", "Learn design principles"),
        BlogItem(R.drawable.ic_person, "Marketing", "Learn marketing strategies"),
        BlogItem(R.drawable.ic_person, "Business", "Learn business management"),
        BlogItem(R.drawable.ic_person, "Photography", "Learn photography skills")
    )
}