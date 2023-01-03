package com.apronet.getart.di


import com.apro.getart.metmuseum.DefaultMetMuseum
import com.apro.getart.metmuseum.MetMuseum
import com.apronet.getart.BuildConfig
import com.apronet.getart.data.DefaultMetMuseumRepository
import com.apronet.getart.data.MetMuseumRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {


  @Binds
  abstract fun bindsMetMuseumRepository(impl: DefaultMetMuseumRepository): MetMuseumRepository

  companion object {
    @Provides
    @Singleton
    fun providesMetMuseum(): MetMuseum {
      return DefaultMetMuseum.Builder()
        .baseUrl("https://collectionapi.metmuseum.org/public/collection/v1/")
        .logLevel(if (BuildConfig.DEBUG) LogLevel.ALL else LogLevel.NONE)
        .build()
    }

    @Provides
    @DispatchersIO
    fun providesCoroutineDispatcherIo(): CoroutineDispatcher = Dispatchers.IO
  }
}