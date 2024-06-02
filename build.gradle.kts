plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android.library).apply(false)
    id("org.jetbrains.compose").version("1.6.10")
    id("org.jetbrains.kotlin.plugin.compose").version("2.0.0")
}
