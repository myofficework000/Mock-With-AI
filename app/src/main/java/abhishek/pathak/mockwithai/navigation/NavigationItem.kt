package abhishek.pathak.mockwithai.navigation

sealed class NavigationItem(val route: String) {

    data object HOME_SCREEN: NavigationItem(Screen.HOME_SCREEN.name)

    data object SEARCH_SCREEN: NavigationItem(Screen.SEARCH_SCREEN.name)

    data object BOOK_MARK_SCREEN: NavigationItem(Screen.BOOK_MARK_SCREEN.name)

    data object USER_ACCOUNT_SCREEN: NavigationItem(Screen.USER_ACCOUNT_SCREEN.name)
}