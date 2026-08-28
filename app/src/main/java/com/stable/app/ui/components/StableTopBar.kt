package com.stable.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StableTopBar() {

    CenterAlignedTopAppBar(

        title = {

            Text(

                text = "S.T.A.B.L.E.",

                style = MaterialTheme.typography.headlineSmall

            )

        },

        modifier = Modifier.fillMaxWidth()

    )

}