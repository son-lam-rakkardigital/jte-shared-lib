# JTE Shared Lib Structure including unitest

## Q: **[JTE - POC - Unitest - JTESharedLib - testing - Snippets] - How to build a structure for using jte plugin including unitest?**

### Structure

```js
.
├── README.md
├── build.gradle
├── gradle
│	 └── wrapper
├── jte
│	 ├── demo-template
│	 │	 ├── Jenkinsfile
│	 │	 └── pipeline_config.groovy
│	 ├── pipeline_config.groovy
│	 └── pipeline_templates
│	     └── exampleTemplate.groovy
├── libraries
│	 └── jte_shared_lib
│	     ├── src
│	     │	 └── org
│	     │	     └── example
│	     │	         └── MyLibrary.groovy
│	     └── steps
│	         └── myStep.groovy
├── settings.gradle
└── src
    └── test
        ├── groovy
        │	 └── org
        │	     └── example
        │	         ├── ExampleTemplateTest.groovy
        │	         └── MyLibraryTest.groovy
        └── resources
            └── pipeline_config_test.groovy

```
### How to run unitest
* Running unitest

```bash
gradle test
gradle build
```

* When you get error, you will see the link to check the report to see which testcase is failed

### How to create jenkins jobs

* using jekins cli with action `create-job`

```bash
ssh -l admin -p 2222 localhost create-job jenkins-pipelines/multi-branch-pipeline-jte < config/pipelines/multi-branch-pipeline.xml
```

* job xml file


```xml
<?xml version='1.1' encoding='UTF-8'?>
<org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject plugin="workflow-multibranch@795.ve0cb_1f45ca_9a_">
  <actions/>
  <description>Testing multi-branch-pipeline</description>
  <displayName>Testing multi-branch-pipeline</displayName>
  <properties>
    <org.boozallen.plugins.jte.init.governance.TemplateConfigFolderProperty plugin="templating-engine@2.5.3">
      <tier>
        <configurationProvider class="org.boozallen.plugins.jte.init.governance.config.ScmPipelineConfigurationProvider">
          <baseDir>jte/demo-template</baseDir>
          <scm class="hudson.plugins.git.GitSCM" plugin="git@5.6.0">
            <configVersion>2</configVersion>
            <userRemoteConfigs>
              <hudson.plugins.git.UserRemoteConfig>
                <url>https://github.com/son-lam-rakkardigital/jte-shared-lib.git</url>
              </hudson.plugins.git.UserRemoteConfig>
            </userRemoteConfigs>
            <branches>
              <hudson.plugins.git.BranchSpec>
                <name>*/main</name>
              </hudson.plugins.git.BranchSpec>
            </branches>
            <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
            <submoduleCfg class="empty-list"/>
            <extensions/>
          </scm>
        </configurationProvider>
        <librarySources>
          <org.boozallen.plugins.jte.init.governance.libs.LibrarySource>
            <libraryProvider class="org.boozallen.plugins.jte.init.governance.libs.ScmLibraryProvider">
              <scm class="hudson.plugins.git.GitSCM" plugin="git@5.6.0">
                <configVersion>2</configVersion>
                <userRemoteConfigs>
                  <hudson.plugins.git.UserRemoteConfig>
                    <url>https://github.com/son-lam-rakkardigital/jte-shared-lib.git</url>
                  </hudson.plugins.git.UserRemoteConfig>
                </userRemoteConfigs>
                <branches>
                  <hudson.plugins.git.BranchSpec>
                    <name>*/main</name>
                  </hudson.plugins.git.BranchSpec>
                </branches>
                <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
                <submoduleCfg class="empty-list"/>
                <extensions/>
              </scm>
              <baseDir>libraries</baseDir>
            </libraryProvider>
          </org.boozallen.plugins.jte.init.governance.libs.LibrarySource>
        </librarySources>
      </tier>
    </org.boozallen.plugins.jte.init.governance.TemplateConfigFolderProperty>
  </properties>
  <folderViews class="jenkins.branch.MultiBranchProjectViewHolder" plugin="branch-api@2.1200.v4b_a_3da_2eb_db_4">
    <owner class="org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject" reference="../.."/>
  </folderViews>
  <healthMetrics/>
  <icon class="jenkins.branch.MetadataActionFolderIcon" plugin="branch-api@2.1200.v4b_a_3da_2eb_db_4">
    <owner class="org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject" reference="../.."/>
  </icon>
  <orphanedItemStrategy class="com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy" plugin="cloudbees-folder@6.973.vc9b_85a_61e4fc">
    <pruneDeadBranches>true</pruneDeadBranches>
    <daysToKeep>-1</daysToKeep>
    <numToKeep>-1</numToKeep>
    <abortBuilds>false</abortBuilds>
  </orphanedItemStrategy>
  <triggers/>
  <disabled>false</disabled>
  <sources class="jenkins.branch.MultiBranchProject$BranchSourceList" plugin="branch-api@2.1200.v4b_a_3da_2eb_db_4">
    <data>
      <jenkins.branch.BranchSource>
        <source class="org.jenkinsci.plugins.github_branch_source.GitHubSCMSource" plugin="github-branch-source@1807.v50351eb_7dd13">
          <id>87cca7c7-7103-4e70-80da-59c87b572480</id>
          <apiUri>https://api.github.com</apiUri>
          <credentialsId>github</credentialsId>
          <repoOwner>son-lam-rakkardigital</repoOwner>
          <repository>jte-shared-lib</repository>
          <repositoryUrl>https://github.com/son-lam-rakkardigital/jte-shared-lib</repositoryUrl>
          <traits>
            <org.jenkinsci.plugins.github__branch__source.BranchDiscoveryTrait>
              <strategyId>3</strategyId>
            </org.jenkinsci.plugins.github__branch__source.BranchDiscoveryTrait>
            <org.jenkinsci.plugins.github__branch__source.OriginPullRequestDiscoveryTrait>
              <strategyId>2</strategyId>
            </org.jenkinsci.plugins.github__branch__source.OriginPullRequestDiscoveryTrait>
            <org.jenkinsci.plugins.github__branch__source.ForkPullRequestDiscoveryTrait>
              <strategyId>2</strategyId>
              <trust class="org.jenkinsci.plugins.github_branch_source.ForkPullRequestDiscoveryTrait$TrustPermission"/>
            </org.jenkinsci.plugins.github__branch__source.ForkPullRequestDiscoveryTrait>
          </traits>
        </source>
        <strategy class="jenkins.branch.DefaultBranchPropertyStrategy">
          <properties class="empty-list"/>
        </strategy>
      </jenkins.branch.BranchSource>
    </data>
    <owner class="org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject" reference="../.."/>
  </sources>
  <factory class="org.boozallen.plugins.jte.job.TemplateBranchProjectFactory" plugin="templating-engine@2.5.3">
    <owner class="org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject" reference="../.."/>
    <scriptPath>Jenkinsfile</scriptPath>
    <configurationPath>pipeline_config.groovy</configurationPath>
    <filterBranches>false</filterBranches>
  </factory>
</org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject>
```

## Q: **[JTE - POC - Unitest - JTESharedLib - testing - Snippets] - How to write a unitest?**
Here’s a step-by-step instruction for adding a **unit test** for a new function in the `org.example.DemoLibrary` class in the given structure.

---

### **Steps to Add Unit Test for a New Function**

#### **1. Add the `DemoLibrary` Class**

Create a new Groovy class `DemoLibrary.groovy` under `libraries/jte_shared_lib/src/org/example/`.

**File: `libraries/jte_shared_lib/src/org/example/DemoLibrary.groovy`**
```groovy
package org.example

class DemoLibrary {
    static String greet(String name) {
        return "Hello, ${name}!"
    }

    static int addNumbers(int a, int b) {
        return a + b
    }
}
```

---

#### **2. Add a Unit Test for `DemoLibrary`**

Create a test file named `DemoLibraryTest.groovy` in the `src/test/groovy/org/example/` directory.

**File: `src/test/groovy/org/example/DemoLibraryTest.groovy`**
```js
package org.example

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class DemoLibraryTest {

    @Test
    void testGreet() {
        // Arrange
        String name = "Jenkins"

        // Act
        String result = DemoLibrary.greet(name)

        // Assert
        assertEquals("Hello, Jenkins!", result)
    }

    @Test
    void testAddNumbers() {
        // Arrange
        int a = 5
        int b = 10

        // Act
        int result = DemoLibrary.addNumbers(a, b)

        // Assert
        assertEquals(15, result)
    }
}
```

---

<!-- #### **3. Update `build.gradle`**

Ensure your `build.gradle` file includes the required dependencies for testing. Add **JUnit 5** and make sure the test classes are recognized.

**Update in `build.gradle`**:
```groovy
plugins {
    id 'groovy'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.codehaus.groovy:groovy-all:4.0.15'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}

tasks.withType(Test).configureEach {
    useJUnitPlatform()
    testLogging {
        events 'PASSED', 'FAILED', 'SKIPPED'
    }
}
```

--- -->

#### **3. Run the Tests**

Execute the unit tests using Gradle:

```bash
./gradle test
```

The output should show the results of the tests for `DemoLibrary`:

**Example Output**:
```
> Task :test

DemoLibraryTest > testGreet PASSED
DemoLibraryTest > testAddNumbers PASSED
```

---

<!-- #### **5. Add a Resource-Specific Test Configuration (Optional)**

If your library or function relies on additional configuration, you can define a test-specific pipeline configuration file.

**File: `src/test/resources/pipeline_config_test.groovy`**
```groovy
libraries {
    jte_shared_lib
}
pipelineConfig {
    greetingMessage = "Hello, Jenkins!"
}
```

Modify your tests to use the configurations if needed. -->

---

### **Instruction Summary**

1. **Add the New Class**:
   - Create or update `DemoLibrary.groovy` in `libraries/jte_shared_lib/src/org/example/`.

2. **Add the Unit Test**:
   - Create `DemoLibraryTest.groovy` under `src/test/groovy/org/example/`.

3. **Ensure Dependencies**:
   - Add **JUnit 5** and other necessary dependencies in `build.gradle`.

4. **Run the Tests**:
   - Execute `gradle test` to verify the implementation.

<!-- 5. **Optional Configurations**:
   - Add custom test pipeline configurations in `src/test/resources/pipeline_config_test.groovy` if required. -->



