package com.stable.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stable.app.ui.theme.StableGrey
import com.stable.app.ui.theme.StableOrange

@Composable
fun ScoreGauge(

    score: Int,

    modifier: Modifier = Modifier

) {

    val animation = remember {

        Animatable(0f)

    }

    LaunchedEffect(score) {

        animation.animateTo(

            targetValue = score / 100f,

            animationSpec = tween(1200)

        )

    }

    Box(

        modifier = modifier.size(220.dp),

        contentAlignment = Alignment.Center

    ) {

        Canvas(

            modifier = Modifier.matchParentSize()

        ) {

            drawArc(

                color = StableGrey,

                startAngle = 135f,

                sweepAngle = 270f,

                useCenter = false,

                topLeft = Offset.Zero,

                size = Size(size.width, size.height),

                style = Stroke(

                    width = 22f,

                    cap = StrokeCap.Round

                )

            )

            drawArc(

                color = StableOrange,

                startAngle = 135f,

                sweepAngle = 270f * animation.value,

                useCenter = false,

                topLeft = Offset.Zero,

                size = Size(size.width, size.height),

                style = Stroke(

                    width = 22f,

                    cap = StrokeCap.Round

                )

            )

        }

        Text(

            text = "$score",

            style = MaterialTheme.typography.displayLarge,

            fontSize = 54.sp

        )

    }

}