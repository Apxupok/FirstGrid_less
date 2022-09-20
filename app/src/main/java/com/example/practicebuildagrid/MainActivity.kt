@file:OptIn(ExperimentalFoundationApi::class)

package com.example.practicebuildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicebuildagrid.Data.Datasource
import com.example.practicebuildagrid.Data.Datasource.topics
import com.example.practicebuildagrid.model.Topic
import com.example.practicebuildagrid.ui.theme.PracticeBuildAGridTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridApp()
        }
    }
}
@Composable
fun GridCard(topic:Topic){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp ) {
        Row {

            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
                    .aspectRatio(1f),

                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier.padding()) {


                Text(
                    modifier = Modifier.padding(start = 16.dp,
                        bottom = 8.dp,
                        end = 16.dp,
                        top = 16.dp

                    ),
                    text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.body2
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(12.dp)
                    )
                    Text(
                        text = topic.count.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
                    )
                }


            }


        }
    }
}

@Composable
fun GridApp(){
    PracticeBuildAGridTheme {
        GridList (topicsList = Datasource.topics)
    }
}


@Composable
fun GridList(topicsList: List<Topic> ) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(topicsList){
            topic -> GridCard(topic)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticeBuildAGridTheme {
        GridCard(topic = Topic(R.string.architecture,58,R.drawable.architecture))

    }
}