package com.qa

import org.scalatest.{FlatSpec, Inside, Inspectors, MustMatchers, OptionValues}

/**
 * Base test class to be inherited by all other test classes.
 * @author cboucher
 */
abstract class TestBase extends FlatSpec
with MustMatchers with OptionValues
with Inside with Inspectors
