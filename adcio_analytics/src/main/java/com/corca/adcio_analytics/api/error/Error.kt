package com.corca.adcio_analytics.api.error

abstract class Error

class NotInitializedError: Error()

class FileNotFoundError: Error()

class EmptyEnvFileError: Error()
