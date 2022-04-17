pipeline {
 
  agent any
 
 environment {
   MY_VARIABLE = "TEST"
 }
 
  stages {
   stage ("Print variables") {
    steps {
     echo "CODE_CHANGES = ${env.CODE_CHANGES}"
     echo "BRANCH_NAME = ${env.BRANCH_NAME}"
     echo "MY_VARIABLE = ${MY_VARIABLE}"
    }
   }
   
    stage ("Build") {
        when {
          expression {
            env.CODE_CHANGES == true
      }
     }
      steps {
        echo "Building the application"
      }
    }
    stage ("Test") {
     
     when {
      expression {
        env.BRANCH_NAME == 'main'
      }
     }
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
