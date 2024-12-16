pipeline {
    agent any
    stages {
        pipelineConfig.stages.each { stageName ->
            stage(stageName) {
                steps {
                    myStep("Executing ${stageName}")
                }
            }
        }
    }
}
