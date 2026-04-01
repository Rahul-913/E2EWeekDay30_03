pipeline {
agent any
tools {
    maven 'Maven'
    jdk 'JDK17'
}

parameters {
    string(name: 'suiteXmlFile', defaultValue: 'testng.xml')
    choice(name: 'browser', choices: ['chrome', 'firefox', 'edge'])
    booleanParam(name: 'headless', defaultValue: true)
    booleanParam(name: 'incognito', defaultValue: true)
    string(name: 'testUrl', defaultValue: 'https://demowebshop.tricentis.com/')
}

stages {

    stage('Clean Workspace') {
        steps {
            cleanWs()
        }
    }

    stage('Checkout Code') {
        steps {
            git branch: 'master', url: 'https://github.com/Rahul-913/E2EWeekDay30_03.git'
        }
    }

    stage('Build Project') {
        steps {
            bat 'mvn clean compile'
        }
    }

    stage('Execute UI Tests') {
        steps {
            bat """
            mvn test ^
            -DsuiteXmlFile=%suiteXmlFile% ^
            -Dbrowser=%browser% ^
            -Dheadless=%headless% ^
            -Dincognito=%incognito% ^
            -DtestUrl=%testUrl%
            """
        }
    }

    stage('Re-run Failed Tests') {
        steps {
            script {
                def failedSuitePath = 'test-output/testng-failed.xml'

                if (!fileExists(failedSuitePath)) {
                    failedSuitePath = 'target/surefire-reports/testng-failed.xml'
                }

                if (fileExists(failedSuitePath)) {
                    echo "Re-running failed tests from: ${failedSuitePath}"

                    bat """
                    mvn test ^
                    -DsuiteXmlFile=${failedSuitePath} ^
                    -Dbrowser=%browser% ^
                    -Dheadless=%headless% ^
                    -Dincognito=%incognito% ^
                    -DtestUrl=%testUrl%
                    """
                } else {
                    echo "No failed tests found"
                }
            }
        }
    }

    stage('Archive Reports') {
        steps {
            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
        }
    }
}

post {
    always {
        echo 'Execution Completed'
    }
    success {
        echo 'All Tests Passed'
    }
    failure {
        echo 'Some Tests Failed'
    }
}
}
