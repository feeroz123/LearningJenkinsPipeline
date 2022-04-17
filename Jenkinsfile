pipeline {
 
  agent any
 
 environment {
   MY_VARIABLE = "TEST"
 }
 
  stages {
   stage ("Print variables") {
    steps {
     echo "BUILD_ID = ${env.BUILD_ID}"
     echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
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
      }
    }
    stage ("Test") {
      steps {
        echo "Testing the application"
      }
    }
    stage ("Deploy") {
      steps {
        echo "Deploying the application"
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
