// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.warmup.util

import com.intellij.ide.environment.impl.EnvironmentKeyStubGenerator
import com.intellij.platform.util.ArgsParser
import org.jetbrains.annotations.ApiStatus
import java.nio.file.Path

@ApiStatus.Internal
interface HeadlessConfigurableArgs {
  val pathToConfigurationFile: Path?
}

@ApiStatus.Internal
open class HeadlessConfigurableArgsImpl(parser: ArgsParser) : HeadlessConfigurableArgs {
  override val pathToConfigurationFile: Path? by
  parser.arg("environment-keys-file",
             """Path to a file with configured environment keys. 
               |This file can be generated by '${EnvironmentKeyStubGenerator.COMMAND_NAME}'""".trimMargin()).fileOrNull()
}