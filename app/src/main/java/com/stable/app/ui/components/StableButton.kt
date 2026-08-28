package com.stable.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stable.app.ui.theme.StableOrange
import com.stable.app.ui.theme.StableWhite

@Composable
fun StableButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

    val haptic = LocalHapticFeedback.current

    var pressed by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.96f else 1f,
        label = "buttonScale"
    )

    Button(

        onClick = {

            pressed = true

            haptic.performHapticFeedback(
                HapticFeedbackType.LongPress
            )

            onClick()

            pressed = false

        },

        enabled = enabled,

        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .scale(scale),

        shape = RoundedCornerShape(18.dp),

        colors = ButtonDefaults.buttonColors(

            containerColor = StableOrange,

            contentColor = StableWhite,

            disabledContainerColor = Color.DarkGray

        )

    ) {

        Text(

            text = text,

            fontSize = 20.sp,

            fontWeight = FontWeight.Bold

        )

    }

}