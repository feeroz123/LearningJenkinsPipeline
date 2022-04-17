def gv

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
   
   stage ("Initialize") {
    steps {
     script {
      gv = load "script.groovy"
     }
    }
   }
   
    stage ("Build") {
        when {
          expression {
            env.MY_VARIABLE == "TEST"
      }
     }
      steps {
       script {
        gv.buildApp()
       }
      }
    }
    stage ("Test") {
     when {
      expression {
       params.RunTest == true
      }
     }
      steps {
        script {
        gv.testApp()
       }
      }
    }
    stage ("Deploy") {
      steps {
       script {
        gv.deployApp() 
       }
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
