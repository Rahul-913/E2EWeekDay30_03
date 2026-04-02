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
                script {
                    try {
                        bat """
                        mvn test ^
                        -DsuiteXmlFile=${params.suiteXmlFile} ^
                        -Dbrowser=${params.browser} ^
                        -Dheadless=${params.headless} ^
                        -Dincognito=${params.incognito} ^
                        -DtestUrl=${params.testUrl}
                        """
                    } catch (Exception e) {
                        echo "Tests failed but continuing..."
                    }
                }
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
                        -Dbrowser=${params.browser} ^
                        -Dheadless=${params.headless} ^
                        -Dincognito=${params.incognito} ^
                        -DtestUrl=${params.testUrl}
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

            junit 'target/surefire-reports/*.xml'

            allure includeProperties: false,
                   jdk: '',
                   results: [[path: 'target/allure-results']]
        }

        success {
            echo 'All Tests Passed'
        }

        failure {
            echo 'Some Tests Failed'
        }
    }
}