package org.example

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExampleTemplateTest extends BasePipelineTest {

    @BeforeEach
    void setUp() {
        super.setUp()
        binding.setVariable('pipelineConfig', [
            stages: ['Build', 'Test']
        ])
        helper.registerAllowedMethod('echo', [String], { message ->
            println "Mocked echo: $message"
        })
    }

    @Test
    void testPipelineExecution() {
        // def template = loadScript('jte/pipeline_templates/exampleTemplate.groovy')
        // template.run()

        // assertCallStackContains("Executing Build")
        // assertCallStackContains("Executing Test")
    }
}
