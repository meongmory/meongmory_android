package com.meongmoryteam.presentation.base

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.DialogBackground


@Composable
fun CustomAlertDialog(
    openDialogCustom: MutableState<Boolean>
) {
    Dialog(
        onDismissRequest = { openDialogCustom.value = false }
    ) {
        CustomDialogUI(textDetail = stringResource(R.string.dialog_secession), dialogCustom = openDialogCustom)
    }

}



@Composable
private fun CustomDialogUI(
    textTitle: String? = null,
    textDetail: String? = null,
    dialogCustom: MutableState<Boolean>
) {
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(10.dp),
        // modifier = modifier.size(280.dp, 240.dp)
        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
    ) {
        Column(
            Modifier
                .background(Color.White)) {


            Column(modifier = Modifier.padding(16.dp)) {
                if (textTitle != null) {
                    androidx.compose.material3.Text(
                        text = textTitle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                        maxLines = 2,
                    )
                }
                if (textDetail != null) {
                    androidx.compose.material3.Text(
                        text = textDetail,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth(),
                    )
                }
                Row() {


                    androidx.compose.material3.TextButton(onClick = {
                        dialogCustom.value = false
                    }) {
                        androidx.compose.material3.Text(
                            "Allow",
                            color = Color.Black,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                    }
                    androidx.compose.material3.TextButton(onClick = {
                        dialogCustom.value = true
                    }) {
                        androidx.compose.material3.Text(
                            "No",
                            color = Color.Black,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            }
        }
    }
}
