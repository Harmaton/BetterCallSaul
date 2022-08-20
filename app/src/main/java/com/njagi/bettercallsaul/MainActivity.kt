package com.njagi.bettercallsaul

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.njagi.bettercallsaul.ui.theme.BetterCallSaulTheme
import com.njagi.bettercallsaul.viewmodels.CharacterState
import com.njagi.bettercallsaul.viewmodels.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterCallSaulTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    TopAppBar()
                    FetchData()
                }
            }
        }

    }
}

@Composable
fun TopAppBar() {
    Row( modifier = Modifier.fillMaxSize(),
    verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Refresh, contentDescription ="Search characters")
        }

        Text(text = "Better Call Saul", color = Color.Black,
            style = MaterialTheme.typography.h4)

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription ="Search characters")
        }
    }
}
@Composable
fun FetchData(characterViewModel: CharacterViewModel = viewModel()){
    Column {
        when(val state = characterViewModel.characterstate.collectAsState().value){
            is CharacterState.Empty -> Text(text = "Data is Empty")
            is CharacterState.Loading -> Text(text = "Loading")
            is CharacterState.Success -> Text(text = "Successful")
            is CharacterState.Error -> Text(state.message)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BetterCallSaulTheme {
       TopAppBar()
    }
}