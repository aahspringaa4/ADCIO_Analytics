package com.corca.adcio_analytics.api.error

import kotlin.Exception

abstract class Error: Exception()

class NotInitializedException: Error()

class FileNotFoundException: Error()

class EmptyEnvFileException: Error()

