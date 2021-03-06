/*
 * Gretty
 *
 * Copyright (C) 2013-2015 Andrey Hihlovskiy and contributors.
 *
 * See the file "LICENSE" for copying and usage permission.
 * See the file "CONTRIBUTORS" for complete list of contributors.
 */
package org.akhikhl.gretty

/**
 *
 * @author akhikhl
 */
class GrettyExtension extends GrettyConfig {

  int debugPort = 5005
  boolean debugSuspend = true

  protected List overlays = []

  String integrationTestTask = 'integrationTest'

  protected afterEvaluate = []

  Closure webappCopy = {}

  boolean autoConfigureRepositories = false

  void afterEvaluate(Closure closure) {
    afterEvaluate.add(closure)
  }

  void overlay(def newValue) {
    if(!(newValue instanceof String))
      throw new Exception("Overlay ${newValue?.toString()} should be a string")
    overlays.add newValue
  }
}
