def buildApp() {
  echo "Building the application"
  echo "Author = ${params.author}"
}

def testApp() {
  echo "Testing the application: Groovy script"
}

def deployApp() {
  echo "Setup: ${params.Setup}"
  echo "Deploying the application"
  echo "BUILD_ID = ${env.BUILD_ID}"
  echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
}

return this
