package com.apronet.getart.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.PopUpToBuilder

sealed class NavRoute(
  val route: String,
  val pattern: String = route,
  val arguments: List<NamedNavArgument> = emptyList(),
) {

  object Departments : NavRoute("departments")

  object About : NavRoute("about")
}

fun NavController.navigateTo(route: NavRoute, builder: NavOptionsBuilder.() -> Unit = {}) {
  navigate(route.route, builder)
}

fun NavOptionsBuilder.popUpTo(route: NavRoute, popUpToBuilder: PopUpToBuilder.() -> Unit = {}) {
  popUpTo(route.route, popUpToBuilder)
}