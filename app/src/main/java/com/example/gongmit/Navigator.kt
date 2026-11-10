package com.example.gongmit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gongmit.page.home.HomeScreen
import com.example.gongmit.page.login.LoginScreen
import com.example.gongmit.page.profile_setting.Profile_Setting_Screen
import com.example.gongmit.ui.theme.Pretendard

// 앱의 모든 화면 주소. 화면을 새로 만들면 여기에 먼저 추가한다.
sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object ProfileSetting : Screen("profile_setting")
    data object Home : Screen("home")
    data object Ranking : Screen("ranking")
    data object Statistics : Screen("statistics")
    data object MyData : Screen("my_data")
}

private data class BottomTab(
    val screen: Screen,
    val label: String,
    @param:DrawableRes val icon: Int,
)

// 하단 탭 목록. 여기 있는 화면에서만 하단 바가 보인다.
private val bottomTabs = listOf(
    BottomTab(Screen.Home, "홈", R.drawable.ic_nav_home),
    BottomTab(Screen.Ranking, "랭킹", R.drawable.ic_nav_ranking),
    BottomTab(Screen.Statistics, "통계", R.drawable.ic_nav_statistics),
    BottomTab(Screen.MyData, "내 정보", R.drawable.ic_nav_my_data),
)

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF2F4EC),
        bottomBar = {
            if (bottomTabs.any { it.screen.route == currentRoute }) {
                BottomNavigator(
                    currentRoute = currentRoute,
                    onTabClick = { screen ->
                        navController.navigate(screen.route) {
                            // 탭을 오가도 뒤로 가기 기록이 쌓이지 않게 홈까지만 남긴다.
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screen.Login.route,
        ) {
            composable(Screen.Login.route) {
                LoginScreen(onGoogleLoginClick = {
                    navController.navigate(Screen.ProfileSetting.route)
                })
            }
            composable(Screen.ProfileSetting.route) {
                Profile_Setting_Screen(onStartClick = {
                    navController.navigate(Screen.Home.route) {
                        // 홈에서 뒤로 가기로 로그인/프로필 설정에 돌아가지 않게 지운다.
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                })
            }
            composable(Screen.Home.route) { HomeScreen() }

            // 아직 화면이 없는 탭. 화면을 만들면 PlaceholderScreen을 교체한다.
            composable(Screen.Ranking.route) { PlaceholderScreen("랭킹") }
            composable(Screen.Statistics.route) { PlaceholderScreen("통계") }
            composable(Screen.MyData.route) { PlaceholderScreen("내 정보") }
        }
    }
}

@Composable
private fun BottomNavigator(
    currentRoute: String?,
    onTabClick: (Screen) -> Unit,
) {
    NavigationBar(containerColor = Color.White) {
        bottomTabs.forEach { tab ->
            val isSelected = currentRoute == tab.screen.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onTabClick(tab.screen) },
                icon = {
                    Icon(
                        painter = painterResource(tab.icon),
                        contentDescription = null, // 아래 label이 이름을 대신 읽어 준다.
                    )
                },
                label = {
                    Text(
                        text = tab.label,
                        fontFamily = Pretendard,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 12.sp,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF17201A),
                    selectedTextColor = Color(0xFF17201A),
                    indicatorColor = Color(0xFFDCEBBF),
                    unselectedIconColor = Color(0xFF4F5B52),
                    unselectedTextColor = Color(0xFF4F5B52),
                ),
            )
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = title, fontFamily = Pretendard, color = Color(0xFF17201A))
    }
}
