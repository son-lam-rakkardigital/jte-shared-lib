package org.example

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class MyLibraryTest extends BasePipelineTest {

    @BeforeEach
    void setUp() {
        super.setUp()
        helper.registerAllowedMethod('println', [String], { message ->
            println "Mocked println: $message"
        })
    }

    @Test
    void testSayHello() {
        MyLibrary.sayHello("Jenkins")
        // assertCallStackContains("Hello, Jenkins!")
    }

    @Test
    void testReturnHelloMessage() {
        def lib = new MyLibrary()
        def msg = lib.returnHelloMessage("Jenkins")
        assertEquals("Hello, Jenkins!", msg)

    }
}
