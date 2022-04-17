pipeline {
 
  agent any
 
 environment {
   MY_VARIABLE = "TEST"
 }
 
 parameters {
  choice(name: 'Setup', choices: ['DEV', 'TEST', 'PROD'])
  booleanParam(name: 'RunTest', defaultValue: true, description: 'Should run the test?')
  string(name: "author", defaultValue: 'GitHub Admin', description: 'Author of the code changes')
 }
 
  stages {
   stage ("Print variables") {
    steps {
     echo "MY_VARIABLE = ${env.MY_VARIABLE}"
    }
   }
   
    stage ("Build") {
        when {
          expression {
            env.MY_VARIABLE == "TEST"
      }
     }
      steps {
        echo "Building the application"
       echo "Author = ${params.author}"
      }
    }
    stage ("Test") {
     when {
      expression {
       params.RunTest == true
      }
     }
      steps {
        echo "Testing the application"
      }
    }
    stage ("Deploy") {
      steps {
       echo "Setup: ${params.Setup}"
       echo "Deploying the application"
       echo "BUILD_ID = ${env.BUILD_ID}"
       echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
      }
    }
  }
 
 post {
  always {
   echo "This step is Always executed"
  }
  success {
   echo "This step is executed only on Success"
  }
  failure {
   echo "This step is executed only on Failure"
  }
 
  }
}
