// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.largeFilesEditor.actions;

import com.intellij.largeFilesEditor.editor.LargeFileEditor;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Utils {

  static @Nullable LargeFileEditor tryGetLargeFileEditorManager(AnActionEvent e) {
    FileEditor fileEditor = getFileEditor(e);
    if (fileEditor instanceof LargeFileEditor) {
      return (LargeFileEditor)fileEditor;
    }

    Editor editor = getEditor(e);
    return editor == null ? null : tryGetLargeFileEditorManagerFromEditor(editor);
  }

  static @Nullable LargeFileEditor tryGetLargeFileEditorManagerFromEditor(@NotNull Editor editor) {
    return editor.getUserData(LargeFileEditor.LARGE_FILE_EDITOR_KEY);
  }

  private static FileEditor getFileEditor(AnActionEvent e) {
    return e.getData(PlatformCoreDataKeys.FILE_EDITOR);
  }

  private static Editor getEditor(AnActionEvent e) {
    return e.getData(CommonDataKeys.EDITOR);
  }
}