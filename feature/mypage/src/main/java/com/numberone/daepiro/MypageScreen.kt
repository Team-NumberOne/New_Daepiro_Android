package com.numberone.daepiro

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MypageScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Text(text = "마이페이지")
}