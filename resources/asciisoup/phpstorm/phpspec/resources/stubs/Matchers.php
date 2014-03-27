<?php

class Matchers {

    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldBe($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldReturn($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldEqual($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldBeEqualTo($expected) {}
    /**
     * Comparison, equivalent to "=="
     * @param mixed $expected
     */
    public function shouldBeLike($expected) {}

    /**
     * For testing exceptions
     * @param \Exception $exception
     */
    public function shouldThrow($exception) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldBeAnInstanceOf($type) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldReturnAnInstanceOf($type) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldHaveType($type) {}



    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldNotBe($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldNotReturn($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldNotEqual($expected) {}
    /**
     * Identity, equivalent to "==="
     * @param mixed $expected
     */
    public function shouldNotBeEqualTo($expected) {}
    /**
     * Comparison, equivalent to "=="
     * @param mixed $expected
     */
    public function shouldNotBeLike($expected) {}

    /**
     * For testing exceptions
     * @param \Exception $exception
     */
    public function shouldNotThrow($exception) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldNotBeAnInstanceOf($type) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldNotReturnAnInstanceOf($type) {}
    /**
     * Type
     * @param string $type
     */
    public function shouldNotHaveType($type) {}
} 
