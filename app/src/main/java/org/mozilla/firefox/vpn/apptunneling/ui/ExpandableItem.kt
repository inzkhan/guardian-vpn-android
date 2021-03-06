package org.mozilla.firefox.vpn.apptunneling.ui

import android.content.pm.ApplicationInfo
import org.mozilla.firefox.vpn.R

const val APP_GROUP = 0
const val APP_ITEM = 1

enum class AppGroupType {
    PROTECTED, UNPROTECTED
}

sealed class ExpandableItem(
    val itemType: Int,
    var isEnabled: Boolean = true
) {
    data class AppGroup(
        val groupType: AppGroupType,
        var appItems: List<AppItem> = listOf(),
        var isExpanded: Boolean = true
    ) : ExpandableItem(APP_GROUP)

    data class AppItem(
        val groupType: AppGroupType,
        val applicationInfo: ApplicationInfo
    ) : ExpandableItem(APP_ITEM)
}

sealed class AppGroupConfig(
    val arrowDrawableId: Int,
    val titleResId: Int,
    val descriptionResId: Int,
    val actionResId: Int,
    val infoResId: Int
) {
    object ProtectedGroupExpanded : AppGroupConfig(
        R.drawable.ic_arrow_open,
        R.string.app_tunneling_protected_title_expand,
        R.string.app_tunneling_protected_description,
        R.string.app_tunneling_unprotected_action_text,
        R.string.app_tunneling_protected_info
    )
    object ProtectedGroupCollapse : AppGroupConfig(
        R.drawable.ic_arrow_close,
        R.string.app_tunneling_protected_title_collapse,
        R.string.app_tunneling_protected_description,
        R.string.app_tunneling_unprotected_action_text,
        R.string.app_tunneling_protected_info
    )
    object UnprotectedGroupExpanded : AppGroupConfig(
        R.drawable.ic_arrow_open,
        R.string.app_tunneling_unprotected_title_expand,
        R.string.app_tunneling_unprotected_description,
        R.string.app_tunneling_protected_action_text,
        R.string.app_tunneling_unprotected_info
    )
    object UnprotectedGroupCollapse : AppGroupConfig(
        R.drawable.ic_arrow_close,
        R.string.app_tunneling_unprotected_title_collapse,
        R.string.app_tunneling_unprotected_description,
        R.string.app_tunneling_protected_action_text,
        R.string.app_tunneling_unprotected_info
    )
}
