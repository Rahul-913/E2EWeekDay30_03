pipeline {
	agent { label 'windows' }   // Ensures it runs on Windows
	tools {
    	maven 'Maven'
    	jdk 'JDK17'
		  }
parameters {
    	string(name: 'suiteXmlFile', defaultValue: 'testng.xml', description: 'TestNG suite file name')
    	choice(name: 'browser', choices: ['chrome', 'firefox', 'edge'], description: 'Select browser')
    	booleanParam(name: 'headless', defaultValue: true, description: 'Run in headless mode')
    	booleanParam(name: 'incognito', defaultValue: true, description: 'Run in incognito/private mode')
    	string(name: 'testUrl', defaultValue: 'https://demowebshop.tricentis.com/', description: 'Environment URL')
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
            mvn test -DsuiteXmlFile=%suiteXmlFile% -Dbrowser=%browser% -Dheadless=%headless% -Dincognito=%incognito% -DtestUrl=%testUrl%
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
	    stage('Allure Report') {
    	    steps {
        	    allure includeProperties: false,
                   jdk: '',
                   results: [[path: 'target/allure-results']]
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
        	echo 'All Tests Passed ✅'
    	}
    	failure {
        	echo 'Some Tests Failed ❌'
    	}
	}
}