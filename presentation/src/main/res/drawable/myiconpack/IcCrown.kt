package myiconpack

import MyIconPack
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val MyIconPack.IcCrown: ImageVector
    get() {
        if (_icCrown != null) {
            return _icCrown!!
        }
        _icCrown = Builder(name = "IcCrown", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = null, stroke = null, strokeLineWidth = 0.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(20.0f)
                verticalLineToRelative(20.0f)
                horizontalLineToRelative(-20.0f)
                close()
            }
        }
        .build()
        return _icCrown!!
    }

private var _icCrown: ImageVector? = null
