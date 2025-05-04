package com.example.profileactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            Scaffold { innerPadding->
                ProfileBody(innerPadding = innerPadding)

            }


        }
    }
}
@Composable
fun ProfileBody(innerPadding: PaddingValues){
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown,
                tint = Color.Black,
                contentDescription = null, modifier = Modifier
                    .height(28.dp)
                    .width(28.dp)
            )
            Text(text = "Andrew", style = TextStyle(
                fontSize = 15.sp,
                //textDecoration = TextDecoration.Underline,
                fontWeight =  FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            )
            )
            Icon(
                painterResource(R.drawable.baseline_more_horiz_24),
                tint = Color.Black,
                contentDescription = null, modifier = Modifier
                    .height(28.dp)
                    .width(28.dp).clickable{
                        //TO-DO
                    }

            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                // tint = Color.Black,

                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp).clip(shape = RoundedCornerShape(100.dp)),
            )
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "174")
                Text(text = "post")
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text="772K")
                Text(text = "Followers")
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "774")
                Text(text = "Following")
            }
        }
        Column ( modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)){
            Text(text =  "Andrew Queo",
                style = TextStyle(color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Artist",
                modifier = Modifier.alpha(alpha = 0.5f))

            Text(text = "DESIGNER")
            Text(text = "andrew@gmail.com")
            Text(text = "Followed by sandis prajapati and sumit jha")
        }

        Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button (onClick = {
                //TODO when button clicked
            },
                shape = RoundedCornerShape(10.dp),
            ){ Text(text = "Follow")
            }
            OutlinedButton (
                onClick = {

                }, shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp,Color.Gray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Message")
            }
            OutlinedButton(onClick = {

            },shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Gray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                )){
                Text(text = "E-mail")
            }
            OutlinedButton(onClick = {

            },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Gray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black)) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    ProfileBody(innerPadding = PaddingValues(0.dp))
}