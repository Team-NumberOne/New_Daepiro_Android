package components.modals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import com.numberone.daepiro.designsystem.theme.Dimmed
import com.numberone.daepiro.designsystem.theme.On_Dmmed
import shadow.DimmedShadow
//rememberModalBottomSheetState가 material3에서 실험용
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    modifier : Modifier = Modifier,
    borderRadius : Dp = 12.dp,
    sheetState : SheetState = rememberModalBottomSheetState(),
    onDismissRequest: () -> Unit,
    sheetContent: @Composable ColumnScope.() -> Unit
){
    ModalBottomSheet(
        modifier = modifier.fillMaxWidth(),
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        dragHandle = null,
        shape = RoundedCornerShape(topStart = borderRadius, topEnd = borderRadius),
        //bottomsheet 내부 색상
        containerColor = On_Dmmed,
        //bottomsheet 뒤의 배경색상
        scrimColor = Dimmed
    ){
        Box(
            modifier = Modifier
                .DimmedShadow(borderRadius = borderRadius)
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)).fillMaxWidth()
            ){
                sheetContent()
            }
        }
    }
}