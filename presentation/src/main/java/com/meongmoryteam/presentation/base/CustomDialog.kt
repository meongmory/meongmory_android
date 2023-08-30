package com.meongmoryteam.presentation.base


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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.myPage.MyPageContract
import com.meongmoryteam.presentation.ui.myPage.MyPageViewModel
import com.meongmoryteam.presentation.ui.theme.DialogBackground
import com.meongmoryteam.presentation.ui.theme.DialogStroke
import com.meongmoryteam.presentation.ui.theme.DialogTextBlue


@Composable
private fun CustomDialogUI(
    textTitle: String? = null,
    textDetail: String? = null,
    leftButton: String? = null,
    rightButton: String? = null,
    dialogCustom: MutableState<Boolean>,
    onRightButtonClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier.padding(5.dp, 10.dp),
    ) {
        Column(
            Modifier
                .background(DialogBackground.copy(0.8f))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                textTitle?.let {
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
                textDetail?.let {
                    Text(
                        text = textDetail,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .background(DialogStroke.copy(0.36f))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                Arrangement.SpaceEvenly
            ) {

                TextButton(
                    onClick = {
                        dialogCustom.value = false
                    }) {
                    leftButton?.let {
                        Text(
                            leftButton,
                            color = DialogTextBlue,
                            fontSize = 17.sp,
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(DialogStroke.copy(0.36f))
                )
                TextButton(
                    onClick = {
                        dialogCustom.value = true
                        onRightButtonClick()
                    }
                ) {
                    rightButton?.let {
                        Text(
                            rightButton,
                            color = DialogTextBlue,
                            fontSize = 17.sp,
                        )
                    }
                }
            }
        }
    }
}


// 로그아웃 다이어로그
@Composable
fun LogoutAlertDialog(
    openDialogCustom: MutableState<Boolean>,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    Dialog(
        onDismissRequest = { openDialogCustom.value = false }
    ) {
        CustomDialogUI(
            textTitle = stringResource(R.string.dialog_logout),
            textDetail = stringResource(R.string.dialog_logout_detail),
            leftButton = stringResource(R.string.dialog_cancel),
            rightButton = stringResource(R.string.dialog_logout),
            dialogCustom = openDialogCustom,
            onRightButtonClick = {
                // 오른쪽 버튼 클릭 시 viewModel 호출
                viewModel.setEvent(MyPageContract.MyPageEvent.OnClickLogoutButtonClicked)
                openDialogCustom.value = false  // 다이얼로그 닫기
            }
        )
    }
}


// 탈퇴 다이어로그
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
            leftButton = stringResource(R.string.dialog_cancel),
            rightButton = stringResource(R.string.dialog_secession_yes),
            dialogCustom = openDialogCustom,
            onRightButtonClick = { }
        )
    }
}
