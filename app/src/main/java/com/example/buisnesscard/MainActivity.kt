package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuisnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardImage( getString(R.string.name), getString(R.string.title),
                        getString(R.string.phone),
                        getString(R.string.telegram), getString(R.string.email))
                }
            }
        }
    }
}

@Composable
private fun Description(text: String, image: Painter, modifier: Modifier){
    Row (
        modifier = Modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, fontSize = 28.sp, lineHeight = 30.sp)
    }
}


@Composable
fun Card(name: String, title: String, phone: String, telegram: String,
         email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(125.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(text = name, fontSize = 48.sp, lineHeight = 50.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Box{
                val image = painterResource(R.drawable._031_tatarstan_med)
                Image(
                    painter = image,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(115.dp))
            Text(
                text = title,
                fontSize = 48.sp,
                lineHeight = 50.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ){
            val phoneImage = painterResource(R.drawable.baseline_local_phone_black_24dp)
            val telegramImage = painterResource(R.drawable.baseline_send_black_24dp)
            val emailImage = painterResource(R.drawable.baseline_email_black_24dp)
            Description(phone, phoneImage, modifier)
            Description(telegram, telegramImage, modifier)
            Description(email, emailImage, modifier)
        }

    }
}


@Composable
fun CardImage(name: String, title: String, phone: String, telegram: String,
              email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.background)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8f
        )
        Card(name, title, phone, telegram, email, modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuisnessCardTheme {
        CardImage(
            stringResource(R.string.name), stringResource(R.string.title),
            stringResource(R.string.phone),
            stringResource(R.string.telegram), stringResource(R.string.email)
        )
    }
}