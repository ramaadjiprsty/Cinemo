## Add project specific ProGuard rules here.
## You can control the set of applied configuration files using the
## proguardFiles setting in build.gradle.
##
## For more details, see
##   http://developer.android.com/guide/developing/tools/proguard.html
#
## If your project uses WebView with JS, uncomment the following
## and specify the fully qualified class name to the JavaScript interface
## class:
##-keepclassmembers class fqcn.of.javascript.interface.for.webview {
##   public *;
##}
#
## Uncomment this to preserve the line number information for
## debugging stack traces.
##-keepattributes SourceFile,LineNumberTable
#
## If you keep the line number information, uncomment this to
## hide the original source file name.
##-renamesourcefileattribute SourceFile
## Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn com.example.cinemo.core.data.source.MoviesRepository
-dontwarn com.example.cinemo.core.data.source.Resource$Error
-dontwarn com.example.cinemo.core.data.source.Resource$Loading
-dontwarn com.example.cinemo.core.data.source.Resource$Success
-dontwarn com.example.cinemo.core.data.source.Resource
-dontwarn com.example.cinemo.core.data.source.local.LocalDataSource
-dontwarn com.example.cinemo.core.data.source.remote.RemoteDataSource
-dontwarn com.example.cinemo.core.data.source.remote.network.ApiService
-dontwarn com.example.cinemo.core.di.DatabaseModule
-dontwarn com.example.cinemo.core.di.DatabaseModule_ProvideDatabaseFactory
-dontwarn com.example.cinemo.core.di.DatabaseModule_ProvideMoviesDaoFactory
-dontwarn com.example.cinemo.core.di.NetworkModule
-dontwarn com.example.cinemo.core.di.NetworkModule_ProvideApiServiceFactory
-dontwarn com.example.cinemo.core.di.NetworkModule_ProvideOkHttpClientFactory
-dontwarn com.example.cinemo.core.di.RepositoryModule
-dontwarn com.example.cinemo.core.domain.model.Movie
-dontwarn com.example.cinemo.core.domain.repository.IMoviesRepository
-dontwarn com.example.cinemo.core.domain.usecase.MoviesInteractor
-dontwarn com.example.cinemo.core.domain.usecase.MoviesUseCase
-dontwarn com.example.cinemo.core.ui.MoviesAdapter
-dontwarn com.example.cinemo.core.utils.AppExecutors
-dontwarn hilt_aggregated_deps._com_example_cinemo_core_di_DatabaseModule
-dontwarn hilt_aggregated_deps._com_example_cinemo_core_di_NetworkModule
-dontwarn hilt_aggregated_deps._com_example_cinemo_core_di_RepositoryModule