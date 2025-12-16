package com.github.replkmm

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class AnotherClass {
    data object Class1 : AnotherClass()
    data object Class2 : AnotherClass()
    data object Class3 : AnotherClass()
    data object Class4 : AnotherClass()
}

@Serializable
sealed class Destination {
    @Serializable data object Destination1 : Destination()
    @Serializable data object Destination2 : Destination()
    @Serializable data object Destination3 : Destination()
    @Serializable data object Destination4 : Destination()

    companion object {
        private val map = mapOf(
            AnotherClass.Class1 to Destination1,
            AnotherClass.Class2 to Destination2,
            AnotherClass.Class3 to Destination3,
            AnotherClass.Class4 to Destination4
        )

        fun of(obj: Any): Destination {
            return map[obj]!!
        }
    }
}

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Destination1
    ) {
        composable<Destination.Destination1> {}
        composable<Destination.Destination2> {}
        composable<Destination.Destination3> {}
        composable<Destination.Destination4> {}
    }

    Destination.of(AnotherClass.Class1)
}