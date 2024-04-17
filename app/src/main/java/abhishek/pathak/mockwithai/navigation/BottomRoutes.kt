package abhishek.pathak.mockwithai.navigation

enum class BottomRoutes {
    HOME,
    SEARCH,
    BOOKMARK,
    ACCOUNT,
    SETTINGS
}

sealed class BottomNaviItems(val route: String) {
    data object HOME : BottomNaviItems(BottomRoutes.HOME.name)
    data object SEARCH : BottomNaviItems(BottomRoutes.SEARCH.name)
    data object BOOKMARK : BottomNaviItems(BottomRoutes.BOOKMARK.name)
    data object ACCOUNT : BottomNaviItems(BottomRoutes.ACCOUNT.name)
    data object SETTINGS : BottomNaviItems(BottomRoutes.SETTINGS.name)
}