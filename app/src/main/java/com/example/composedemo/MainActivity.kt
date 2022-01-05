package com.example.composedemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme

data class Message(val author:String,val body:String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MessageCard(msg = Message("Android","jetpack Compose"))
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg:Message){
    Row(modifier = Modifier.padding(8.dp)){
        Image(painter = painterResource(id =R.drawable.profile_picture), contentDescription = "Contact profile picture", modifier = Modifier
            .size(40.dp)
            .clip(
                CircleShape
            )
            .border(1.5.dp,MaterialTheme.colors.secondary, CircleShape))

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author, color = MaterialTheme.colors.secondaryVariant, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(text = msg.body, style = MaterialTheme.typography.body2, modifier = Modifier.padding(all = 4.dp))
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        MessageCard(msg = Message("Colleague","Hey, take a look at Jetpack Compose."))
    }
}