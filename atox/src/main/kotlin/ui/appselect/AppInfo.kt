package ltd.evilcorp.atox.ui.appselect

import android.graphics.drawable.Drawable

data class AppInfo(
    val appName: String,
    val packageName: String,
    var isSelected: Boolean,
    var icon: Drawable? = null
)
