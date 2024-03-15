package components.modals

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import shadow.DimmedShadow

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    borderRadius: Dp = 12.dp,
    showDialog: MutableState<Boolean>,
    popupContent: @Composable () -> Unit,
    onConfirmRequest: () -> Unit = {},
    onDismissRequest: () -> Unit = {}
){
    if(showDialog.value){
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
                showDialog.value = false
            },
            properties = DialogProperties(
                //기능명세서에 따라 바뀔 수 있는 부분
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),

        ) {
            Box(){
                Column(
                    modifier = Modifier
                        .DimmedShadow(borderRadius = borderRadius)
                        .background(color = DaepiroTheme.colors.On_Dmmed, shape = RoundedCornerShape(borderRadius))
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp)
                ) {
                    popupContent()
                }
            }
        }
    }
}