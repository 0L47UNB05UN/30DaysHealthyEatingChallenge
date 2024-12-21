package com.example.a30dayshealthyeatingchallenge

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import com.example.a30dayshealthyeatingchallenge.ui.theme.Shapes
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a30dayshealthyeatingchallenge.data.theData
import com.example.a30dayshealthyeatingchallenge.model.Day

@Composable
fun DayCard(day: Day, modifier: Modifier = Modifier){
    var expand: Boolean by remember{ mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.padding(start=8.dp, end=8.dp, bottom=8.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(8.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ){
            Image(
                painter=painterResource(day.img),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(200.dp)
                    .clip(Shapes.medium),
                contentScale = ContentScale.FillBounds,
                contentDescription=null
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Text(
                    stringResource(day.desc),
                    modifier = modifier.weight(1f)
                )
                IconButton(
                    onClick = {expand = !expand},
                ) {
                    Icon(
                        imageVector = if (expand) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                        contentDescription=null,
                    )
                }
            }
            if (expand){
                Text(
                    stringResource(day.tip),
                    modifier = modifier.padding(8.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyEatingChallengeAppTopBar(changed: Boolean, onClick: ()->Unit, modifier: Modifier=Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
                IconButton(
                    onClick = onClick,
                    modifier = modifier.padding(start=8.dp)
                ) {
                    Image(
                        painter = painterResource(if (changed) R.drawable.sun else R.drawable.moon),
                        modifier = modifier.size(25.dp),
                        contentDescription = null,
                    )
                }
            }
        }
    )
}
@Composable
fun HealthyEatingChallengeApp(contentPadding: PaddingValues, modifier: Modifier = Modifier){
    LazyColumn(
        contentPadding=contentPadding,
    ){
        items(theData, key={it.id}){ itm ->
            DayCard(itm, modifier)
        }
    }
}