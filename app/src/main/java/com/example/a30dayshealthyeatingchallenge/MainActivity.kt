package com.example.a30dayshealthyeatingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30dayshealthyeatingchallenge.ui.theme._30DaysHealthyEatingChallengeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var dkMd: Boolean by remember{mutableStateOf(false)}
            _30DaysHealthyEatingChallengeTheme(darkTheme=dkMd) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        topBar = {
                            HealthyEatingChallengeAppTopBar(dkMd, { dkMd = !dkMd })
                        }
                    ) { innerpadding ->
                        HealthyEatingChallengeApp(innerpadding)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun HealthyEatingAppPreview(){
    var dkMd: Boolean by remember{mutableStateOf(false)}
    _30DaysHealthyEatingChallengeTheme(darkTheme=dkMd) {
        Scaffold(
            topBar = {
                HealthyEatingChallengeAppTopBar(dkMd, {dkMd=!dkMd})
            },
            modifier = Modifier.fillMaxSize()
        ){innerpadding ->
            HealthyEatingChallengeApp(innerpadding)
        }
    }
}
