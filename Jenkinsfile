pipeline {
 
  agent any
 
  stages {
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
        BRANCH_NAME == 'main'
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
