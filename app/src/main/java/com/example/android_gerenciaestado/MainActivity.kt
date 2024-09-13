package com.example.android_gerenciaestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_gerenciaestado.ui.theme.Android_GerenciaEstadoTheme
import com.example.android_gerenciaestado.ui.viewmodels.ContadorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_GerenciaEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel by viewModels<ContadorViewModel>()
                    val contador by viewModel.contador.collectAsState()

                    ContadorStateless(
                        contador = contador,
                        onIncrementContador = { viewModel.incrementar() },
                        onDecrementContador = { viewModel.decrementar() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContadorStateless(
    contador: Int,
    onIncrementContador: () -> Unit,
    onDecrementContador: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Contador: $contador")

        // Botão para incrementar
        Button(onClick = onIncrementContador) {
            Text("Incremente aqui")
        }

        // Botão para decrementar
        Button(onClick = onDecrementContador) {
            Text("Decrementar aqui")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_GerenciaEstadoTheme {
        ContadorStateless(
            contador = 0,
            onIncrementContador = {},
            onDecrementContador = {}
        )
    }
}
