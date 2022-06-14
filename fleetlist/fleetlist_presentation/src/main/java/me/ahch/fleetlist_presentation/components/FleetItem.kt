package me.ahch.fleetlist_presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.ahch.core.model.Fleet
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.ahch.fleetlist_presentation.R

@Composable
fun FleetItem(fleet: Fleet, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (fleet.fleetType == "TAXI") {
                    Image(
                        modifier = Modifier.width(60.dp),
                        painter = painterResource(R.drawable.ic_taxi),
                        contentDescription = stringResource(R.string.taxi_icon_content_description)
                    )
                } else {
                    Image(
                        modifier = Modifier.width(60.dp),
                        painter = painterResource(R.drawable.ic_car),
                        contentDescription = stringResource(R.string.pooling_icon_content_description)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))
                Text(text = fleet.fleetType, style = MaterialTheme.typography.h6)

            }

            Button(onClick = onClick) {
                Text(stringResource(R.string.check_on_the_map))
            }

        }
    }


}