# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-keep class com.example.cinemo.core.di.DatabaseModule

#-keep class * extends android.app.Application
#
#-keepclasseswithmembers class * {
#    @dagger.hilt.android.AndroidEntryPoint *;
#}
#
#-keep class com.example.cinemo.core.di.** { *; }
#
#-keep @dagger.Module class * { *; }


# Keep MovieRepository and its members
-keep class com.example.cinemo.core.data.source.MoviesRepository { *; }
-keep class com.example.core.** { *; }

# Keep Resource classes and their members
-keep class com.example.cinemo.core.data.source.Resource$Error { *; }
-keep class com.example.cinemo.core.data.source.Resource$Loading { *; }
-keep class com.example.cinemo.core.data.source.Resource$Success { *; }
-keep class com.example.cinemo.core.data.source.Resource { *; }

# Keep DataSource classes and their members
-keep class com.example.cinemo.core.data.source.local.LocalDataSource { *; }
-keep class com.example.cinemo.core.data.source.remote.RemoteDataSource { *; }
-keep class com.example.cinemo.core.data.source.remote.network.ApiService { *; }

# Keep DI modules and their providers
-keep class com.example.core.di.** { *; }
-keep class com.example.cinemo.core.di.DatabaseModule { *; }
-keep class com.example.cinemo.core.di.DatabaseModule_ProvideDatabaseFactory { *; }
-keep class com.example.cinemo.core.di.DatabaseModule_ProvideMoviesDaoFactory { *; }
-keep class com.example.cinemo.core.di.NetworkModule { *; }
-keep class com.example.cinemo.core.di.NetworkModule_ProvideApiServiceFactory { *; }
-keep class com.example.cinemo.core.di.NetworkModule_ProvideOkHttpClientFactory { *; }

# Keep domain classes and their members
-keep class com.example.cinemo.core.domain.model.Movie { *; }
-keep class com.example.cinemo.core.domain.repository.IMoviesRepository { *; }
-keep class com.example.cinemo.core.domain.usecase.MoviesInteractor { *; }
-keep class com.example.cinemo.core.domain.usecase.MoviesUseCase { *; }

# Keep UI classes and their members
-keep class com.example.cinemo.core.ui.MoviesAdapter { *; }

# Keep utility classes
-keep class com.example.cinemo.core.utils.AppExecutors { *; }

#-keep class com.example.cinemo.core.di.DatabaseModule { *; }

#-keep com.example.core.di.**
#
#-keepnames com.example.core.di.**

# Keep Hilt components
-keep class * implements dagger.hilt.internal.GeneratedComponent { *; }
-keep class * implements dagger.hilt.internal.GeneratedComponentManager { *; }
-keep class * implements dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper { *; }

# Keep classes with @Inject constructors
-keepclasseswithmembernames class * {
    @javax.inject.Inject <init>(...);
}

# Keep Hilt Android classes (for projects using Hilt with Android)
-keep class dagger.hilt.android.** { *; }
-keep interface dagger.hilt.android.** { *; }

# Keep classes annotated with @HiltAndroidApp, @AndroidEntryPoint, etc.
-keep @dagger.hilt.android.HiltAndroidApp class *
-keep @dagger.hilt.android.AndroidEntryPoint class *
-keep @dagger.hilt.InstallIn class *
-keep @dagger.Module class *
-keep @dagger.hilt.components.SingletonComponent class *
-keep @dagger.hilt.android.components.ActivityComponent class *
-keep @dagger.hilt.android.components.FragmentComponent class *

# Keep classes with @Module annotations
-keep @dagger.Module class * { *; }

# Keep classes with @Provides annotations
-keep class * {
    @dagger.Provides <methods>;
}

-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel

# Keep annotations
-keepattributes *Annotation*



