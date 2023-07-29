package com.meongmoryteam.presentation.base

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.DialogBackground
import com.meongmoryteam.presentation.ui.theme.DialogStroke
import com.meongmoryteam.presentation.ui.theme.DialogTextBlue


@Composable
fun SecessionAlertDialog(
    openDialogCustom: MutableState<Boolean>
) {
    Dialog(
        onDismissRequest = { openDialogCustom.value = false }
    ) {
        CustomDialogUI(
            textTitle = stringResource(R.string.dialog_secession),
            textDetail = stringResource(R.string.dialog_secession_detail),
            leftButton = stringResource(R.string.dialog_secession_no),
            rightButton = stringResource(R.string.dialog_secession_yes),
            dialogCustom = openDialogCustom
        )
    }

}


@Composable
private fun CustomDialogUI(
    textTitle: String? = null,
    textDetail: String? = null,
    leftButton: String? = null,
    rightButton: String? = null,
    dialogCustom: MutableState<Boolean>
) {
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, Color.Black),
        // modifier = modifier.size(280.dp, 240.dp)
        modifier = Modifier.padding(5.dp, 10.dp),
    ) {
        Column(
            Modifier
                .background(DialogBackground.copy(0.8f))
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                if (textTitle != null) {
                    Text(
                        text = textTitle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                        fontSize = 16.sp,
                        color = Color.Black,
                        maxLines = 2,
                    )
                }
                if (textDetail != null) {
                    Text(
                        text = textDetail,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                    )
                }
            }

            Divider(
                modifier = Modifier
                    .background(DialogStroke)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(IntrinsicSize.Min),
                Arrangement.SpaceEvenly

            ) {

                TextButton(onClick = {
                    dialogCustom.value = false
                }) {
                    if (leftButton != null) {
                        Text(
                            leftButton,
                            color = DialogTextBlue,
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                        )
                    }

                }

                Divider(
                    modifier = Modifier.fillMaxHeight().width(1.dp),
                    color = DialogStroke.copy(0.36f)
                )
                TextButton(onClick = {
                    dialogCustom.value = true
                }) {
                    if (rightButton != null) {
                        Text(
                            rightButton,
                            color = DialogTextBlue,
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            }
        }
    }
}

